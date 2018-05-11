import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class CollatzTests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("CollatzTests");
  } 
  @Test public void Collatz_main1() {
    String input = "5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Start Collatz seq at: (ex: 18)\n"+
      "STEP OPERATION        N\n"+
      "   1 odd: triple+1   16\n"+
      "   2 even: halve      8\n"+
      "   3 even: halve      4\n"+
      "   4 even: halve      2\n"+
      "   5 even: halve      1\n"+
      "5 steps for 5 to converge\n"+
      "";
    Collatz.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Collatz_main2() {
    String input = "10";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Start Collatz seq at: (ex: 18)\n"+
      "STEP OPERATION        N\n"+
      "   1 even: halve      5\n"+
      "   2 odd: triple+1   16\n"+
      "   3 even: halve      8\n"+
      "   4 even: halve      4\n"+
      "   5 even: halve      2\n"+
      "   6 even: halve      1\n"+
      "6 steps for 10 to converge\n"+
      "";
    Collatz.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Collatz_main3() {
    String input = "20";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Start Collatz seq at: (ex: 18)\n"+
      "STEP OPERATION        N\n"+
      "   1 even: halve     10\n"+
      "   2 even: halve      5\n"+
      "   3 odd: triple+1   16\n"+
      "   4 even: halve      8\n"+
      "   5 even: halve      4\n"+
      "   6 even: halve      2\n"+
      "   7 even: halve      1\n"+
      "7 steps for 20 to converge\n"+
      "";
    Collatz.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Collatz_main4() {
    String input = "25";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Start Collatz seq at: (ex: 18)\n"+
      "STEP OPERATION        N\n"+
      "   1 odd: triple+1   76\n"+
      "   2 even: halve     38\n"+
      "   3 even: halve     19\n"+
      "   4 odd: triple+1   58\n"+
      "   5 even: halve     29\n"+
      "   6 odd: triple+1   88\n"+
      "   7 even: halve     44\n"+
      "   8 even: halve     22\n"+
      "   9 even: halve     11\n"+
      "  10 odd: triple+1   34\n"+
      "  11 even: halve     17\n"+
      "  12 odd: triple+1   52\n"+
      "  13 even: halve     26\n"+
      "  14 even: halve     13\n"+
      "  15 odd: triple+1   40\n"+
      "  16 even: halve     20\n"+
      "  17 even: halve     10\n"+
      "  18 even: halve      5\n"+
      "  19 odd: triple+1   16\n"+
      "  20 even: halve      8\n"+
      "  21 even: halve      4\n"+
      "  22 even: halve      2\n"+
      "  23 even: halve      1\n"+
      "23 steps for 25 to converge\n"+
      "";
    Collatz.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Collatz_main5() {
    String input = "2048";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Start Collatz seq at: (ex: 18)\n"+
      "STEP OPERATION        N\n"+
      "   1 even: halve    1024\n"+
      "   2 even: halve    512\n"+
      "   3 even: halve    256\n"+
      "   4 even: halve    128\n"+
      "   5 even: halve     64\n"+
      "   6 even: halve     32\n"+
      "   7 even: halve     16\n"+
      "   8 even: halve      8\n"+
      "   9 even: halve      4\n"+
      "  10 even: halve      2\n"+
      "  11 even: halve      1\n"+
      "11 steps for 2048 to converge\n"+
      "";
    Collatz.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
