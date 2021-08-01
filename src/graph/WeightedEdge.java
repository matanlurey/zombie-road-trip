package graph;

import java.util.Objects;

public final class WeightedEdge<T> {
  private final T a;
  private final T b;
  private final int weight;

  public WeightedEdge(T a, T b, int weight) {
    this.a = a;
    this.b = b;
    this.weight = weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WeightedEdge<?> that = (WeightedEdge<?>) o;
    return getWeight() == that.getWeight() && getA().equals(that.getA()) && getB().equals(that.getB());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getA(), getB(), getWeight());
  }

  @Override
  public String toString() {
    return "WeightedEdge{" +
        "a=" + a +
        ", b=" + b +
        ", weight=" + weight +
        '}';
  }

  /**
   * The a vertex.
   */
  T getA() {
    return this.a;
  }

  /**
   * The b vertex.
   */
  T getB() {
    return this.b;
  }

  /**
   * The cost of traversing from a to the b vertex.
   */
  int getWeight() {
    return this.weight;
  }

  /**
   * Returns a new copy of this edge, with "a" and "b" reversed.
   */
  WeightedEdge<T> flip() {
    return new WeightedEdge<>(b, a, weight);
  }
}
