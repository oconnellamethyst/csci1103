import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class D2BTests extends KTests{

  // Main method runs this file's tests
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("D2BTests");
  } 

  ////////////////////////////////////////////////////////////////////////////////
  // Tests

  public static void check_decimal2Binary(int input, String expect) {
    String actual = D2B.decimal2Binary(input);
    String msg =
      String.format("\nD2B.binary2Decimal(\"%s\")\n", input) +
      String.format("EXPECT: %s\n", expect) +
      String.format("ACTUAL: %s\n", actual) +
      "";
    assertEquals(msg,expect,actual);
  }

  // Tests for decimal2Binary()
  @Test public void D2B_binary2Decimal1() {
    check_decimal2Binary(5,"101");
  }
  @Test public void D2B_binary2Decimal2() {
    check_decimal2Binary(7,"111");
  }
  @Test public void D2B_binary2Decimal3() {
    check_decimal2Binary(0,"0");
  }
  @Test public void D2B_binary2Decimal4() {
    check_decimal2Binary(301,"100101101");
  }
  @Test public void D2B_binary2Decimal5() {
    check_decimal2Binary(65535,"1111111111111111");
  }
  @Test public void D2B_binary2Decimal6() {
    check_decimal2Binary(1024,"10000000000");
  }
  @Test public void D2B_binary2Decimal7() {
    check_decimal2Binary(19,"10011");
  }
  @Test public void D2B_binary2Decimal_fail1() {
    check_decimal2Binary(-5,null);
  }
  @Test public void D2B_binary2Decimal_fail2() {
    check_decimal2Binary(-2,null);
  }
  @Test public void D2B_binary2Decimal_fail3() {
    check_decimal2Binary(-7,null);
  }

  // Tests for main method
  @Test public void D2B_main1() {
    String input = "124";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a decimal number: (ex: 546723)\n"+
      "Binary value: 1111100\n"+
      "";
    D2B.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void D2B_main2() {
    String input = "1024";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a decimal number: (ex: 546723)\n"+
      "Binary value: 10000000000\n"+
      "";
    D2B.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void D2B_main3() {
    String input = "65535";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a decimal number: (ex: 546723)\n"+
      "Binary value: 1111111111111111\n"+
      "";
    D2B.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void D2B_main4() {
    String input = "-65535";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a decimal number: (ex: 546723)\n"+
      "Can't convert decimals less than 0\n"+
      "";
    D2B.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void D2B_main5() {
    String input = "-10";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a decimal number: (ex: 546723)\n"+
      "Can't convert decimals less than 0\n"+
      "";
    D2B.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
