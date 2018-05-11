import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class ConversionsTests extends KTests{

  // Main method runs this file's tests
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("ConversionsTests");
  } 

  ////////////////////////////////////////////////////////////////////////////////
  // Tests

  // Tests for main method
  @Test public void Conversions_main1() {
    String input = "binary 101";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Enter a binary number: (ex: 011010101)\n"+
      "Decimal value: 5\n"+
      "Back to binary: 101\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main2() {
    String input = "binary 10000101";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Enter a binary number: (ex: 011010101)\n"+
      "Decimal value: 133\n"+
      "Back to binary: 10000101\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main3() {
    String input = "decimal 133";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Enter a decimal number: (ex: 546723)\n"+
      "Binary value: 10000101\n"+
      "Back to decimal: 133\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main4() {
    String input = "decimal 514";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Enter a decimal number: (ex: 546723)\n"+
      "Binary value: 1000000010\n"+
      "Back to decimal: 514\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main51() {
    String input = "decimal -17";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Enter a decimal number: (ex: 546723)\n"+
      "Failed to convert\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main52() {
    String input = "decimal -2";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Enter a decimal number: (ex: 546723)\n"+
      "Failed to convert\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main61() {
    String input = "binary 101a125";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Enter a binary number: (ex: 011010101)\n"+
      "Failed to convert\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main62() {
    String input = "binary 1011!011";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Enter a binary number: (ex: 011010101)\n"+
      "Failed to convert\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main7() {
    String input = "flurbo 126";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Unknown choice 'flurbo'\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Conversions_main8() {
    String input = "Morty 100011011";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Choose 'binary' or 'decimal' number:\n"+
      "Unknown choice 'Morty'\n"+
      "";
    Conversions.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
