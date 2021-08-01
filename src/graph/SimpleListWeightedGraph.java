package graph;

import java.util.ArrayList;
import java.util.List;

public final class SimpleListWeightedGraph<T> implements WeightedGraph<T> {
  private final List<WeightedEdge<T>> edges = new ArrayList<>();

  @Override
  public boolean addEdge(T a, T b, int weight) {
    // TODO:
    // One note here is that inputs of (1, 1, 100) and (1, 1, 100) will be treated as separate edges.
    // We should ideally make a decision on how we treat these and be uniform down the line, such as:
    // * Throw an exception
    // * Return false
    // * Silently merge
    // * Allow multiple distinct edges
    WeightedEdge<T> edge = new WeightedEdge<>(a, b, weight);
    return edges.add(edge);
  }

  @Override
  public Iterable<WeightedEdge<T>> getEdges(T a) {
    List<WeightedEdge<T>> result = new ArrayList<>();
    for (WeightedEdge<T> edge : edges) {
      if (edge.getA().equals(a)) {
        result.add(edge);
      } else if (edge.getB().equals(a)) {
        result.add(edge.flip());
      }
    }
    return result;
  }
}
