import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class Problem3Tests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem3Tests");
  } 

  // Tests of Collatz.steps() method
  public static void check_collatzArray(int input, String expectS) {
    int [] actual = Collatz.collatzArray(input);
    String actualS = actual==null ? null : Arrays.toString(actual);
    String msg =
      String.format("Collatz.collatzArray(%s)\n", input) +
      String.format("EXPECT: %s\n", expectS) +
      String.format("ACTUAL: %s\n", actualS) +
      "";
    assertEquals(msg,expectS,actualS);
  }

  @Test public void Problem3_collatzArray1() {
    check_collatzArray(1, "[1]");
  }
  @Test public void Problem3_collatzArray2() {
    check_collatzArray(5, "[5, 16, 8, 4, 2, 1]");
  }
  @Test public void Problem3_collatzArray3() {
    check_collatzArray(2048, "[2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1]");
  }
  @Test public void Problem3_collatzArray4() {
    check_collatzArray(45, "[45, 136, 68, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1]");
  }
  @Test public void Problem3_collatzArray5() {
    check_collatzArray(0, null);
  }
  @Test public void Problem3_collatzArray6() {
    check_collatzArray(-3, null);
  }

  // Tests of main methods
  @Test public void Problem3_Generate1() {
    String input =
      "8";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter starting number:\n"+
      "  STEP  VALUE\n"+
      "     0      8\n"+
      "     1      4\n"+
      "     2      2\n"+
      "     3      1\n"+
      "";
    Generate.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Problem3_Generate2() {
    String input =
      "3";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter starting number:\n"+
      "  STEP  VALUE\n"+
      "     0      3\n"+
      "     1     10\n"+
      "     2      5\n"+
      "     3     16\n"+
      "     4      8\n"+
      "     5      4\n"+
      "     6      2\n"+
      "     7      1\n"+
      "";
    Generate.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Problem3_Generate3() {
    String input =
      "19";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter starting number:\n"+
      "  STEP  VALUE\n"+
      "     0     19\n"+
      "     1     58\n"+
      "     2     29\n"+
      "     3     88\n"+
      "     4     44\n"+
      "     5     22\n"+
      "     6     11\n"+
      "     7     34\n"+
      "     8     17\n"+
      "     9     52\n"+
      "    10     26\n"+
      "    11     13\n"+
      "    12     40\n"+
      "    13     20\n"+
      "    14     10\n"+
      "    15      5\n"+
      "    16     16\n"+
      "    17      8\n"+
      "    18      4\n"+
      "    19      2\n"+
      "    20      1\n"+
      "";
    Generate.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Problem3_Generate4() {
    String input =
      "-4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter starting number:\n"+
      "Invalid input: -4\n"+
      "";
    Generate.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
