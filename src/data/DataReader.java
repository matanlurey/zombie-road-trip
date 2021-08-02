package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {
  /**
   * Returns a sequence of paths by parsing the provided text.
   *
   * @param textContents Text in the format of {@code (0, 1, 100), (1, 3, 200)}.
   */
  public List<Path> readPaths(String textContents) {
    List<Path> result = new ArrayList<>();
    String regex = "\\d*, \\d*, \\d*";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(textContents);

    while(matcher.find()) {
      String match = matcher.group();
      Scanner scanner = new Scanner(match);
      scanner.useDelimiter(", ");
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int weight = scanner.nextInt();
      Path path = new Path(a, b, weight);
      result.add(path);
    }
    return result;
  }

}
