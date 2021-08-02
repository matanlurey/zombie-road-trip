package data;

import java.util.Objects;

/**
 * A parsed 3-value tuple that has "A", "B", and a weight.
 */
public final class Path {
  private final int a;
  private final int b;
  private final int weight;

  public Path(int a, int b, int weight) {
    this.a = a;
    this.b = b;
    this.weight = weight;
  }

  public int getA() {
    return this.a;
  }

  public int getB() {
    return this.b;
  }

  public int getWeight() {
    return this.weight;
  }

  @Override
  public String toString() {
    return "Path{" +
        "a=" + a +
        ", b=" + b +
        ", weight=" + weight +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Path path = (Path) o;
    return getA() == path.getA() && getB() == path.getB() && getWeight() == path.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getA(), getB(), getWeight());
  }
}
