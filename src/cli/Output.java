package cli;

import java.util.List;

public final class Output {
  private final List<Integer> path;
  private final int processingTime;
  private final int totalZombiesEncountered;

  public Output(List<Integer> path, int processingTime, int totalZombiesEncountered) {
    this.path = path;
    this.processingTime = processingTime;
    this.totalZombiesEncountered = totalZombiesEncountered;
  }

  public List<Integer> getPath() {
    return path;
  }

  public int getProcessingTime() {
    return processingTime;
  }

  public int getTotalZombiesEncountered() {
    return totalZombiesEncountered;
  }
}
