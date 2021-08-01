package solver;

import java.util.List;

/**
 * Result of solving the shortest path problem for a given weighted graph.
 */
public final class Solution<T> {
  private final List<T> paths;
  private final int totalZombies;

  public Solution(List<T> paths, int totalZombies) {
    this.paths = paths;
    this.totalZombies = totalZombies;
  }

  /**
   * The resulting path.
   */
  public Iterable<T> getPath() {
    return this.paths;
  }

  /**
   * The total number of zombies encountered.
   */
  public int getTotalZombies() {
    return this.totalZombies;
  }
}
