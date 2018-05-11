import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class Problem4Tests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem4Tests");
  } 

  // Tests of Collatz.steps() method
  public static void check_verify(boolean expect, int [] input) {
    boolean actual = Collatz.verify(input);
    String inputS = Arrays.toString(input);
    String msg =
      String.format("Collatz.verify(%s)\n", inputS) +
      String.format("EXPECT: %s\n", expect) +
      String.format("ACTUAL: %s\n", actual) +
      "";
    assertEquals(msg,expect,actual);
  }

  @Test public void Problem4_verify1() {
    boolean expect = true;
    int [] arr = {1};
    check_verify(expect,arr);
  }
  @Test public void Problem4_verify2() {
    boolean expect = true;
    int [] arr = {5, 16, 8, 4, 2, 1};
    check_verify(expect,arr);
  }
  @Test public void Problem4_verify3() {
    boolean expect = true;
    int [] arr = {45, 136, 68, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1};
    check_verify(expect,arr);
  }
  @Test public void Problem4_verify4() {
    boolean expect = false;
    int [] arr = {5, 16, 8, 3, 2, 1};
    check_verify(expect,arr);
  }
  @Test public void Problem4_verify5() {
    boolean expect = false;
    int [] arr = {45, 136, 68, 34, 17, 52};
    check_verify(expect,arr);
  }
  @Test public void Problem4_verify6() {
    boolean expect = false;
    int [] arr = {};
    check_verify(expect,arr);
  }

  // Tests of main methods
  @Test public void Problem4_Verify1() {
    String input =
      "4  8 4 2 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Collatz sequence length:\n"+
      "Enter Collatz sequence elements:\n"+
      "This is a Collatz sequence\n"+
      "";
    Verify.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Problem4_Verify2() {
    String input =
      "17   45 136 68 34 17 52 26 13 40 20 10 5 16 8 4 2 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Collatz sequence length:\n"+
      "Enter Collatz sequence elements:\n"+
      "This is a Collatz sequence\n"+
      "";
    Verify.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Problem4_Verify3() {
    String input =
      "5  3 16 8 4 2 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Collatz sequence length:\n"+
      "Enter Collatz sequence elements:\n"+
      "This is NOT a Collatz sequence\n"+
      "The actual sequence should be:\n"+
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
      Verify.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Problem4_Verify4() {
    String input =
      "14   45 136 68 34 17 52 26 13 40 20 10 5 16 8";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Collatz sequence length:\n"+
      "Enter Collatz sequence elements:\n"+
      "This is NOT a Collatz sequence\n"+
      "The actual sequence should be:\n"+
      "  STEP  VALUE\n"+
      "     0     45\n"+
      "     1    136\n"+
      "     2     68\n"+
      "     3     34\n"+
      "     4     17\n"+
      "     5     52\n"+
      "     6     26\n"+
      "     7     13\n"+
      "     8     40\n"+
      "     9     20\n"+
      "    10     10\n"+
      "    11      5\n"+
      "    12     16\n"+
      "    13      8\n"+
      "    14      4\n"+
      "    15      2\n"+
      "    16      1\n"+
      "";
    Verify.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
