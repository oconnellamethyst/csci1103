import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class Problem1Tests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem1Tests");
  } 

  // Tests of Collatz.steps() method
  public static void check_steps(int input, int expect) {
    int actual = Collatz.steps(input);
    String msg =
      String.format("Collatz.steps(%s)\n", input) +
      String.format("EXPECT: %s\n", expect) +
      String.format("ACTUAL: %s\n", actual) +
      "";
    assertEquals(msg,expect,actual);
  }

  @Test public void Problem1_steps1() {
    check_steps(1, 0);
  }
  @Test public void Problem1_steps2() {
    check_steps(2, 1);
  }
  @Test public void Problem1_steps3() {
    check_steps(17, 12);
  }
  @Test public void Problem1_steps4() {
    check_steps(1024, 10);
  }
  @Test public void Problem1_steps5() {
    check_steps(1023, 62);
  }
  @Test public void Problem1_steps6() {
    check_steps(0, -1);
  }
  @Test public void Problem1_steps7() {
    check_steps(-20, -1);
  }

  // Tests of main methods
  @Test public void Problem1_Steps1() {
    String input =
      "24";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter starting number:\n"+
      "24 converges to 1 in 10 steps\n"+
      "";
    Steps.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Problem1_Steps2() {
    String input =
      "45";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter starting number:\n"+
      "45 converges to 1 in 16 steps\n"+
      "";
    Steps.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Problem1_Steps3() {
    String input =
      "-7";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter starting number:\n"+
      "Invalid input: -7\n"+
      "";
    Steps.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
