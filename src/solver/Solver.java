package solver;

import graph.WeightedGraph;

/**
 * Given a {@link WeightedGraph}, produces the shortest path result.
 */
public interface Solver<T> {
  /**
   * Finds the shortest path from @param start to @param end.
   *
   * @param graph Graph being traversed.
   */
  Solution<T> solve(WeightedGraph<T> graph, T start, T end);
}
