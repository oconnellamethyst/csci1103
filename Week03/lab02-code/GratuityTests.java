import org.junit.*;
import static org.junit.Assert.*;
// import org.junit.BeforeClass;
// import org.junit.Before;
// import org.junit.After;
// import org.junit.Test;
// import org.junit.Assert;

import java.io.*;
import java.util.*;


public class GratuityTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("GratuityTests");
  } 

  static ByteArrayOutputStream localOut, localErr;
  static PrintStream sysOut, sysErr;
  static String [] empty = {};

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

  // Determine what the newline is on the running system
  String newline = System.getProperty("line.separator");

  @Test public void Gratuity_main1() {
    String input = "34.56 15.5 4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Total bill (ex: 34.56):\n"+
      // 34.56
      "Tip percentage (ex: 15.5):\n"+
      // 15.5
      "Number of people (ex: 4):\n"+
      // 4
      "Total with tip: $39.9168\n"+
      "Each person pays: $9.9792\n"+
      "";
    Gratuity.main(empty);
    String actual = localOut.toString();
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = String.format("Output mismatch\nINPUT: %s\n",input);
    msg += String.format("EXPECT OUTPUT:\n%s\nACTUAL OUTPUT:\n%s\n",expect,actual);
    assertEquals(msg,expect,actualNewline);
  }

  @Test public void Gratuity_main2() {
    String input = "12.34 10.1 6";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Total bill (ex: 34.56):\n"+
      "Tip percentage (ex: 15.5):\n"+
      "Number of people (ex: 4):\n"+
      "Total with tip: $13.58634\n"+
      "Each person pays: $2.26439\n"+
      "";
    Gratuity.main(empty);
    String actual = localOut.toString();
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = String.format("Output mismatch\nINPUT: %s\n",input);
    msg += String.format("EXPECT OUTPUT:\n%s\nACTUAL OUTPUT:\n%s\n",expect,actual);
    assertEquals(msg,expect,actualNewline);
  }

  @Test public void Gratuity_main3() {
    String input = "242.99 20 8";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Total bill (ex: 34.56):\n"+
      "Tip percentage (ex: 15.5):\n"+
      "Number of people (ex: 4):\n"+
      "Total with tip: $291.588\n"+
      "Each person pays: $36.4485\n"+
      "";
    Gratuity.main(empty);
    String actual = localOut.toString();
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = String.format("Output mismatch\nINPUT: %s\n",input);
    msg += String.format("EXPECT OUTPUT:\n%s\nACTUAL OUTPUT:\n%s\n",expect,actual);
    assertEquals(msg,expect,actualNewline);
  }

}
