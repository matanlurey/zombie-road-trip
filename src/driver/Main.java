package driver;

import data.DataReader;
import data.Path;
import graph.SimpleListWeightedGraph;
import graph.WeightedGraph;
import solver.BruteForceSolver;
import solver.Solution;
import solver.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class Main {
  public static void main(String[] args) {
    String simple = load("data/simple.txt");
    String challenge1 = load("data/challenge-1.txt");
    String challenge2 = load("data/challenge-2.txt");
    String challenge3 = load("data/challenge-3.txt");

    DataReader reader = new DataReader();
    Solver<Integer> solver = new BruteForceSolver<>();

    for (String text : List.of(simple, challenge1, challenge2, challenge3)) {
      long startTime = System.currentTimeMillis();
      List<Path> paths = reader.readPaths(text);
      WeightedGraph<Integer> graph = new SimpleListWeightedGraph<>();

      for (Path path : paths) {
        graph.addEdge(path.getA(), path.getB(), path.getWeight());
      }

      int start = paths.get(0).getA();
      int end = paths.get(paths.size() - 1).getB();
      Solution<Integer> solution = solver.solve(graph, start, end);

      long endTime = System.currentTimeMillis();
      long timeInMs = endTime - startTime;

      System.out.println("Solved a " + (paths.size()) + " path graph in " + timeInMs + "ms:");
      System.out.println("SHORTEST PATH: ");
      for (int node : solution.getPath()) {
        System.out.println("  " + node);
      }
      System.out.println("TOTAL ZOMBIES: " + solution.getTotalZombies());
    }
  }

  private static String load(String fileName) {
    try {
      return new String(Files.readAllBytes(Paths.get(fileName)));
    } catch (IOException e) {
      return "";
    }
  }

  private Main() {}
}
