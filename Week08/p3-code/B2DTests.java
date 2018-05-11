import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class B2DTests extends KTests{

  // Main method runs this file's tests
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("B2DTests");
  } 

  ////////////////////////////////////////////////////////////////////////////////
  // Tests

  public static void check_binary2Decimal(String input, int expect) {
    int actual = B2D.binary2Decimal(input);
    String msg =
      String.format("\nB2D.binary2Decimal(\"%s\")\n", input) +
      String.format("EXPECT: %s\n", expect) +
      String.format("ACTUAL: %s\n", actual) +
      "";
    assertEquals(msg,expect,actual);
  }

  // Tests for binary2Decimal()
  @Test public void B2D_binary2Decimal1() {
    check_binary2Decimal("101",5);
  }
  @Test public void B2D_binary2Decimal2() {
    check_binary2Decimal("111",7);
  }
  @Test public void B2D_binary2Decimal3() {
    check_binary2Decimal("",0);
  }
  @Test public void B2D_binary2Decimal4() {
    check_binary2Decimal("100101101",301);
  }
  @Test public void B2D_binary2Decimal5() {
    check_binary2Decimal("1111111111111111",65535);
  }
  @Test public void B2D_binary2Decimal6() {
    check_binary2Decimal("000",0);
  }
  @Test public void B2D_binary2Decimal_fail1() {
    check_binary2Decimal("abc",-1);
  }
  @Test public void B2D_binary2Decimal_fail2() {
    check_binary2Decimal("1001h101",-1);
  }
  @Test public void B2D_binary2Decimal_fail3() {
    check_binary2Decimal("111111111111!",-1);
  }
  @Test public void B2D_binary2Decimal_fail4() {
    check_binary2Decimal("102103",-1);
  }

  // Tests for main method
  @Test public void B2D_main1() {
    String input = "101";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a binary number: (ex: 011010101)\n"+
      "Decimal value: 5\n"+
      "";
    B2D.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void B2D_main2() {
    String input = "110101";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a binary number: (ex: 011010101)\n"+
      "Decimal value: 53\n"+
      "";
    B2D.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void B2D_main3() {
    String input = "1111111111111111";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a binary number: (ex: 011010101)\n"+
      "Decimal value: 65535\n"+
      "";
    B2D.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void B2D_main4() {
    String input = "103721";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a binary number: (ex: 011010101)\n"+
      "Failed to convert\n"+
      "invalid character '3'\n"+
      "invalid character '7'\n"+
      "invalid character '2'\n"+
      "";
    B2D.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void B2D_main5() {
    String input = "0x1A2B79";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a binary number: (ex: 011010101)\n"+
      "Failed to convert\n"+
      "invalid character 'x'\n"+
      "invalid character 'A'\n"+
      "invalid character '2'\n"+
      "invalid character 'B'\n"+
      "invalid character '7'\n"+
      "invalid character '9'\n"+
      "";
    B2D.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
