package graph;

public interface WeightedEdge<T> {
  /**
   * The starting vertex.
   */
  T getOrigin();

  /**
   * The ending vertex.
   */
  T getDestination();

  /**
   * The cost of traversing from the origin to the destination vertex.
   */
  int getWeight();
}
