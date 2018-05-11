import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class PalMethodsTests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("PalMethodsTests");
  } 

  // Tests of printReverse(word) method
  @Test public void PalMethods_printBackwards1() {
    String input =
      "professor";
    String expect = 
      "rosseforp\n"+
      "";
    String call = String.format("PalMethods.printBackwards(\"%s\")",
                                input);
    PalMethods.printBackwards(input);
    String actual = localOut.toString();
    checkOutput(call,expect,actual);
  }
  @Test public void PalMethods_printBackwards2() {
    String input =
      "racecar";
    String expect = 
      "racecar\n"+
      "";
    String call = String.format("PalMethods.printBackwards(\"%s\")",
                                input);
    PalMethods.printBackwards(input);
    String actual = localOut.toString();
    checkOutput(call,expect,actual);
  }
  @Test public void PalMethods_printBackwards3() {
    String input =
      "computer";
    String expect = 
      "retupmoc\n"+
      "";
    String call = String.format("PalMethods.printBackwards(\"%s\")",
                                input);
    PalMethods.printBackwards(input);
    String actual = localOut.toString();
    checkOutput(call,expect,actual);
  }
  @Test public void PalMethods_printBackwards4() {
    String input =
      "tenet";
    String expect = 
      "tenet\n"+
      "";
    String call = String.format("PalMethods.printBackwards(\"%s\")",
                                input);
    PalMethods.printBackwards(input);
    String actual = localOut.toString();
    checkOutput(call,expect,actual);
  }
  @Test public void PalMethods_printBackwards5() {
    String input =
      "amanaplanacanalpanama";
    String expect = 
      "amanaplanacanalpanama\n"+
      "";
    String call = String.format("PalMethods.printBackwards(\"%s\")",
                                input);
    PalMethods.printBackwards(input);
    String actual = localOut.toString();
    checkOutput(call,expect,actual);
  }

  public static void check_isPalindrome(String input, boolean expect) {
    boolean actual = PalMethods.isPalindrome(input);
    String msg =
      String.format("PalMethods.isPalindrome(\"%s\")\n", input) +
      String.format("EXPECT: %s\n", expect) +
      String.format("ACTUAL: %s\n", expect) +
      "";
    assertEquals(msg,expect,actual);
  }

  // Tests of isPalindrome(word) method
  @Test public void PalMethods_isPalindrome1() {
    check_isPalindrome("professor",false);
  }
  @Test public void PalMethods_isPalindrome2() {
    check_isPalindrome("racecar",true);
  }
  @Test public void PalMethods_isPalindrome3() {
    check_isPalindrome("madam",true);
  }
  @Test public void PalMethods_isPalindrome4() {
    check_isPalindrome("tenet",true);
  }
  @Test public void PalMethods_isPalindrome5() {
    check_isPalindrome("science",false);
  }

  // Tests of main methods
  @Test public void PalMethods_main1() {
    String input =
      "professor\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: rosseforp\n"+
      "NOT a palindrome\n"+
      "";
    PalMethods.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void PalMethods_main2() {
    String input =
      "racecar\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: racecar\n"+
      "IS a palindrome\n"+
      "";
    PalMethods.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void PalMethods_main3() {
    String input =
      "computer\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: retupmoc\n"+
      "NOT a palindrome\n"+
      "";
    PalMethods.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void PalMethods_main4() {
    String input =
      "tenet\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: tenet\n"+
      "IS a palindrome\n"+
      "";
    PalMethods.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void PalMethods_main5() {
    String input =
      "amanaplanacanalpanama\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: amanaplanacanalpanama\n"+
      "IS a palindrome\n"+
      "";
    PalMethods.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
