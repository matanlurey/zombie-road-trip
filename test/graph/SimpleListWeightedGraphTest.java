package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleListWeightedGraphTest {
  private WeightedGraph<String> graph;

  @BeforeEach
  void setUp() {
    graph = new SimpleListWeightedGraph<String>();
  }

  @Test
  void getNeighbors() {
    graph.addEdge("San Jose", "Cupertino", 1000);
    graph.addEdge("San Jose", "Santa Cruz", 2000);
    graph.addEdge("Cupertino", "Santa Cruz", 5000);
    graph.addEdge("Santa Cruz", "Monterey", 500);

    assertIterableEquals(List.of(
        new WeightedEdge<>("San Jose", "Cupertino", 1000),
        new WeightedEdge<>("San Jose", "Santa Cruz", 2000)
    ), graph.getEdges("San Jose"));

    assertIterableEquals(List.of(
        new WeightedEdge<>("Cupertino", "San Jose", 1000),
        new WeightedEdge<>("Cupertino", "Santa Cruz", 5000)
    ), graph.getEdges("Cupertino"));
  }
}
