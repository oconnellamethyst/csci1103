import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class SequenceTypeTests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("SequenceTypeTests");
  } 
  @Test public void SequenceType_main1() {
    String input = "1 2 3 4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 1 2 3 4 is: Strictly Increasing\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main2() {
    String input = "4 4 4 4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 4 4 4 4 is: All Equal\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main3() {
    String input = "1 2 4 8";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 1 2 4 8 is: Strictly Increasing\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main4() {
    String input = "1 4 5 5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 1 4 5 5 is: Non-Decreasing\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main5() {
    String input = "3 -1 -1 -4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 3 -1 -1 -4 is: Non-Increasing\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main6() {
    String input = "10 7 2 -1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 10 7 2 -1 is: Strictly Decreasing\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main7() {
    String input = "2 4 1 9";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 2 4 1 9 is: No particular order\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main8() {
    String input = "9 4 2 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 9 4 2 1 is: Strictly Decreasing\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main9() {
    String input = "1 3 4 4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 1 3 4 4 is: Non-Decreasing\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SequenceType_main10() {
    String input = "1129 316 316 -12315";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter 4 integers (ex: 1 3 2 5):\n"+
      "Sequence 1129 316 316 -12315 is: Non-Increasing\n"+
      "";
    SequenceType.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
