import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;


public class P1Tests {
  // Run all tests for this project
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("LoanCalcTests","MakeChangeTests");
  } 

  // Used by each test to capture output
  static ByteArrayOutputStream localOut, localErr;
  static PrintStream sysOut, sysErr;

  // Passed to main methods for no arguments
  static String [] empty = {};

  // Save the stdin and stderr as we'll be messing with them for tests
  @BeforeClass
  public static void setUp() throws Exception {
    sysOut = System.out;
    sysErr = System.err;
  }

  // Before every test is run, reset the streams to capture
  // stdout/stderr
  @Before
  public void setUpStreams() {
    localOut = new ByteArrayOutputStream();
    localErr = new ByteArrayOutputStream();
    System.setOut(new PrintStream(localOut));
    System.setErr(new PrintStream(localErr));
  }

  // After every test, restore stdout/stderr
  @After
  public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
    System.setOut(sysOut);
    System.setErr(sysErr);
  }

  // Create a side-by-side diff of two strings compared line by
  // line. Allows multiline headers for both arguments but both
  // headers must have the same number of lines. x and y may differ in
  // number of lines.
  public static String simpleDiff2(String xhead, String x,
                                   String yhead, String y)
  {
    String xheads[] = xhead.split("\n");
    String yheads[] = yhead.split("\n");
    String xs[] = x.split("\n");
    String ys[] = y.split("\n");
    String sep = "      ";
    String dif = " **** ";
    StringBuilder sb = new StringBuilder();
    
    int maxWidth = 0;
    for(String s : xheads){
      maxWidth = s.length() > maxWidth ? s.length() : maxWidth;
    }
    for(String s : yheads){
      maxWidth = s.length() > maxWidth ? s.length() : maxWidth;
    }
    for(String s : xs){
      maxWidth = s.length() > maxWidth ? s.length() : maxWidth;
    }
    for(String s : ys){
      maxWidth = s.length() > maxWidth ? s.length() : maxWidth;
    }
    // Max width format
    String fmt = String.format("%%-%ds",maxWidth);
    
    for(int i = 0; i<xheads.length; i++){
      sb.append(String.format(fmt,xheads[i]));
      sb.append(sep);
      sb.append(String.format(fmt,yheads[i]));
      sb.append("\n");
    }

    // Construct the side-by-side diff
    for(int i = 0; i<xs.length || i<ys.length; i++){
      if(i<xs.length && i<ys.length){ // both exist, compare
        sb.append(String.format(fmt,xs[i]));
        String mid = xs[i].equals(ys[i]) ? sep : dif;
        sb.append(mid);
        sb.append(String.format(fmt,ys[i]));
        sb.append("\n");
      }
      else if(i<xs.length){     // only x left
        sb.append(String.format(fmt,xs[i]));
        sb.append(dif);
        sb.append(String.format(fmt,""));
        sb.append("\n");
      }
      else if(i<ys.length){     // only y left
        sb.append(String.format(fmt,""));
        sb.append(dif);
        sb.append(String.format(fmt,ys[i]));
        sb.append("\n");
      }
      else{
        throw new RuntimeException("Something fishy's going on here...");
      }
    }
    return sb.toString();
  }
  
  // Check that the expected and actual output match. If not, show an
  // error message that indicates which lines don't match.
  public static String checkOutput(String input, String expect, String actual){
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = "";
    msg += String.format("Output mismatch\n");
    msg += String.format("INPUT:\n  %s\n",input);
    msg += String.format("OUTPUT:\n  Lines marked with *** differ\n");
    msg += simpleDiff2("EXPECT\n------\n",expect,
                       "ACTUAL\n------\n",actual);
    msg += "\n";
    msg += "ACTUAL\n";
    msg += actual;
    msg += "\n";

    assertEquals(msg,expect,actualNewline);
    return msg;
  }


}
