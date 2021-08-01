package solver;

import graph.SimpleListWeightedGraph;
import graph.WeightedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BruteForceSolverTest {
  private static final Solver<String> solver = new BruteForceSolver<>();

  WeightedGraph<String> graph;

  @BeforeEach
  void setUp() {
    graph = new SimpleListWeightedGraph<>();
  }

  @Test
  void simple4NodeSolved() {
    graph.addEdge("San Jose", "Cupertino", 1000);
    graph.addEdge("San Jose", "Santa Cruz", 5000);
    graph.addEdge("Cupertino", "Santa Cruz", 2000);
    graph.addEdge("Santa Cruz", "Monterey", 200);
    graph.addEdge("San Jose", "Monterey", 10000);

    Solution<String> solution = solver.solve(graph, "San Jose", "Monterey");
    assertEquals(List.of("San Jose", "Cupertino", "Santa Cruz", "Monterey"), solution.getPath());
    assertEquals(3200, solution.getTotalZombies());
  }
}
