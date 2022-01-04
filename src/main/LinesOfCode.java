package main;

import java.util.Scanner;

public class LinesOfCode {

  private Scanner scanner;

  public int countLinesOfCode(String code){
    String emptyLines = "(?m)^[ \t]*\r?\n";
    String commentLines = "(?s:/\\*.*?\\*/)|//.*";

    String adjustedCode = code.replaceAll(emptyLines, "");
    adjustedCode = adjustedCode.replaceAll(commentLines, "");

    scanner = new Scanner(adjustedCode);

    int numberOfLines = 0;
    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      if(!line.isEmpty())
        numberOfLines++;
    }
    scanner.close();

    return numberOfLines;
  }
}
