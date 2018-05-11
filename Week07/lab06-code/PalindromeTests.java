import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class PalindromeTests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("PalindromeTests");
  } 
  @Test public void Palindrome_main1() {
    String input =
      "professor\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: rosseforp\n"+
      "NOT a palindrome\n"+
      "";
    Palindrome.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Palindrome_main2() {
    String input =
      "racecar\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: racecar\n"+
      "IS a palindrome\n"+
      "";
    Palindrome.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Palindrome_main3() {
    String input =
      "computer\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: retupmoc\n"+
      "NOT a palindrome\n"+
      "";
    Palindrome.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Palindrome_main4() {
    String input =
      "tenet\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: tenet\n"+
      "IS a palindrome\n"+
      "";
    Palindrome.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Palindrome_main5() {
    String input =
      "amanaplanacanalpanama\n"+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter a word:\n"+
      "The word backwards is: amanaplanacanalpanama\n"+
      "IS a palindrome\n"+
      "";
    Palindrome.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
