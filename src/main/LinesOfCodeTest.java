package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class LinesOfCodeTest {

  private LinesOfCode linesOfCode;

  @BeforeEach
  void setUp() {
    linesOfCode = new LinesOfCode();
  }

  @Test
  void testEmptyLine(){
    String emptyLine = "";

    assertEquals(0, linesOfCode.countLinesOfCode(emptyLine), "Hat leere Zeile nicht als leer erkannt.");
  }

  @Test
  void testOneLine(){
    String oneLine = "Hello World!";

    assertEquals(1, linesOfCode.countLinesOfCode(oneLine), "Hat eine Zeile nicht als eins erkannt.");

  }

  @Test
  void testTwoLines(){
    String twoLines = "Hello World!\n Hi";

    assertEquals(2, linesOfCode.countLinesOfCode(twoLines), "Hat zwei Zeilen nicht als zwei erkannt.");
  }

  @Test
  void testTwoLinesAndAWhitespace(){
    String twoLines = "Hello World!\n \n hi";

    assertEquals(2, linesOfCode.countLinesOfCode(twoLines), "Hat zwei Zeilen mit leerer Zeile nicht als zwei erkannt.");
  }

  @Test
  void testOneWord(){
    String oneWord = "H";

    assertEquals(1, linesOfCode.countLinesOfCode(oneWord), "Hat Zeile mit leerer Zeile nicht als eine erkannt.");

  }

  @Test
  void testOneLineAndAWhitespace(){
    String twoLines = "Hello World!\n \n";

    assertEquals(1, linesOfCode.countLinesOfCode(twoLines), "Hat Zeile mit leerer Zeile nicht als eine erkannt.");
  }

  @Test
  void testOneLineOfComments(){
    String comment = "//Das ist ein Kommentar";

    assertEquals(0, linesOfCode.countLinesOfCode(comment), "Hat Kommentar nicht erkannt");
  }

  @Test
  void testOneLineAndThreeLinesOfComments(){
    String comment = "Hello World!\n//Kommentar\n/*Hello World\nHello*/";

    assertEquals(1, linesOfCode.countLinesOfCode(comment), "Hat Zeile mit einem Kommentar und einem mehrzeiligen Kommentar nicht erkannt.");
  }


}