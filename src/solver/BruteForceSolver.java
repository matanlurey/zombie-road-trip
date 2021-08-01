package solver;

import graph.WeightedEdge;
import graph.WeightedGraph;

import java.util.ArrayList;
import java.util.List;

public final class BruteForceSolver<T> implements Solver<T> {
  @Override
  public Solution<T> solve(WeightedGraph<T> graph, T start, T end) {
    List<List<WeightedEdge<T>>> allPossiblePaths = findAllPossiblePaths(graph, start, end);
    List<List<WeightedEdge<T>>> allPossibleSolutions = filterIncompletePaths(allPossiblePaths, end);
    List<WeightedEdge<T>> shortestPath = findShortestPath(allPossibleSolutions);
    int totalZombies = 0;
    List<T> path = new ArrayList<>();
    for (WeightedEdge<T> edge : shortestPath) {
      path.add(edge.getA());
      totalZombies += edge.getWeight();
    }
    path.add(end);
    return new Solution<>(path, totalZombies);
  }

  // Find all possible paths from start -> end, including ones that go nowhere.
  // Only rule: We won't try to traverse the same node twice in a given path.
  private List<List<WeightedEdge<T>>> findAllPossiblePaths(WeightedGraph<T> graph, T start, T end) {
    List<List<WeightedEdge<T>>> results = new ArrayList<>();
    for (WeightedEdge<T> edge : graph.getEdges(start)) {
      // A --> B
      // branch(List.of("A"), "B", "<END LOCATION">)
      results.addAll(branch(List.of(edge), graph, edge.getB(), end));
    }
    return results;
  }

  // Filter out paths that don't ever make it to the end point.
  private List<List<WeightedEdge<T>>> filterIncompletePaths(List<List<WeightedEdge<T>>> paths, T end) {
    List<List<WeightedEdge<T>>> results = new ArrayList<>();
    for (List<WeightedEdge<T>> path : paths) {
      if (!path.isEmpty() && path.get(path.size() - 1).getB().equals(end)) {
        results.add(path);
      }
    }
    return results;
  }

  // Make one step forward in the possible path solutions.
  private List<List<WeightedEdge<T>>> branch(List<WeightedEdge<T>> pathSoFar, WeightedGraph<T> graph, T current, T end) {
    // Terminal.
    // We have found a path that makes it to the endpoint, so return that path specifically.
    if (current.equals(end)) {
      return List.of(pathSoFar);
    }
    // Go through neighbors/edges and find new branches.
    List<List<WeightedEdge<T>>> results = new ArrayList<>();
    // A --> B
    for (WeightedEdge<T> edge : graph.getEdges(current)) {
      if (!pathSoFar.contains(edge)) {
        List<WeightedEdge<T>> newPath = new ArrayList<>(pathSoFar);
        newPath.add(edge);
        results.addAll(branch(newPath, graph, edge.getB(), end));
      }
    }
    return results;
  }

  // Finds the path with the smallest total weight (i.e. "shortest path").
  private List<WeightedEdge<T>> findShortestPath(List<List<WeightedEdge<T>>> paths) {
    if (paths.isEmpty()) {
      throw new IllegalArgumentException("No paths found");
    }
    List<WeightedEdge<T>> result = null;
    int lowestWeightSoFar = Integer.MAX_VALUE;
    for (List<WeightedEdge<T>> path : paths) {
      int totalWeight = getTotalWeight(path);
      if (totalWeight < lowestWeightSoFar) {
        lowestWeightSoFar = totalWeight;
        result = path;
      }
    }
    if (result == null) {
      throw new IllegalArgumentException("No possible path");
    }
    return result;
  }

  private int getTotalWeight(List<WeightedEdge<T>> edges) {
    int total = 0;
    for (WeightedEdge<T> edge : edges) {
      total += edge.getWeight();
    }
    return total;
  }
}
