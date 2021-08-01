package cli;

public class CommandLine {
  private final String fileName;

  private CommandLine(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void displayOutput(Output output) {
    // TODO: Implement.
  }
}
