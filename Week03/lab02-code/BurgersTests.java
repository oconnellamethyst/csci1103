import org.junit.*;
import static org.junit.Assert.*;
// import org.junit.BeforeClass;
// import org.junit.Before;
// import org.junit.After;
// import org.junit.Test;
// import org.junit.Assert;

import java.io.*;
import java.util.*;


public class BurgersTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("BurgersTests");
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

  @Test public void Burgers_main1() {
    String input = "5 3";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Welcome to Good Burger,\n"+
      "Home of the Good Burger\n"+
      "May I take your order?\n"+
      "----------------------\n"+
      "Burgers: $2.55\n"+
      "Fries:   $0.99\n"+
      "Tax:      7.2%\n"+
      "----------------------\n"+
      "Number of burgers: \n"+
      //      "5\n"+
      "Number of fries: \n"+
      //      "3\n"+
      "Total: $15.719999999999999\n"+
      "Tax: $1.13184\n"+
      "Grand Total: $16.85184\n"+
      "";
    Burgers.main(empty);
    String actual = localOut.toString();
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = String.format("Output mismatch\nINPUT: %s\n",input);
    msg += String.format("EXPECT OUTPUT:\n%s\nACTUAL OUTPUT:\n%s\n",expect,actual);
    assertEquals(msg,expect,actualNewline);
  }
  @Test public void Burgers_main2() {
    String input = "9 4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Welcome to Good Burger,\n"+
      "Home of the Good Burger\n"+
      "May I take your order?\n"+
      "----------------------\n"+
      "Burgers: $2.55\n"+
      "Fries:   $0.99\n"+
      "Tax:      7.2%\n"+
      "----------------------\n"+
      "Number of burgers: \n"+
      //      "9\n"+
      "Number of fries: \n"+
      //      "5\n"+
      "Total: $26.91\n"+
      "Tax: $1.9375200000000001\n"+
      "Grand Total: $28.84752\n"+
      "";
    Burgers.main(empty);
    String actual = localOut.toString();
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = String.format("Output mismatch\nINPUT: %s\n",input);
    msg += String.format("EXPECT OUTPUT:\n%s\nACTUAL OUTPUT:\n%s\n",expect,actual);
    assertEquals(msg,expect,actualNewline);
  }
  @Test public void Burgers_main3() {
    String input = "0 10";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Welcome to Good Burger,\n"+
      "Home of the Good Burger\n"+
      "May I take your order?\n"+
      "----------------------\n"+
      "Burgers: $2.55\n"+
      "Fries:   $0.99\n"+
      "Tax:      7.2%\n"+
      "----------------------\n"+
      "Number of burgers: \n"+
      //      "0\n"+
      "Number of fries: \n"+
      //      "10\n"+
      "Total: $9.9\n"+
      "Tax: $0.7128000000000001\n"+
      "Grand Total: $10.6128\n"+
      "";
    Burgers.main(empty);
    String actual = localOut.toString();
    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String msg = String.format("Output mismatch\nINPUT: %s\n",input);
    msg += String.format("EXPECT OUTPUT:\n%s\nACTUAL OUTPUT:\n%s\n",expect,actual);
    assertEquals(msg,expect,actualNewline);
  }

  // // Test the CSWisdom class
  // @Test public void CSWisdom_main() {
  //   String expect = 
  //     "If in physics there's something you don't understand, you can always\n" +
  //     "hide behind the uncharted depths of nature. You can always blame\n" +
  //     "God. You didn't make it so complex yourself. But if your program\n" +
  //     "doesn't work, there is no one to hide behind. You cannot hide behind\n" +
  //     "an obstinate nature. If it doesn't work, you've messed up.\n" +
  //     "\n" +
  //     "- Edsger Dijkstra\n";
  //   CSWisdom.main(empty);
  //   String actual = localOut.toString();
  //   String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
  //   String msg = String.format("Output mismatch\nEXPECTED:\n%s\nACTUAL:\n%s\n",expect,actual);
  //   assertTrue(msg,expect.equals(actualNewline));
  // }

}
