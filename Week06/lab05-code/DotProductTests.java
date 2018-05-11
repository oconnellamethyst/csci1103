import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class DotProductTests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("HankelTests");
  } 
  @Test public void DotProduct_main1() {
    String input =
      "3  1 2 3  "+
      "3  3 2 1  "+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence 1: (ex 4)\n"+
      "Enter 3 integers: (ex 19)\n"+
      "Enter length of sequence 2: (ex 4)\n"+
      "Enter 3 integers: (ex 19)\n"+
      "Dot Product is: 10\n"+
      "";
    DotProduct.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void DotProduct_main2() {
    String input =
      "5  1 3 2 4 7  "+
      "5  5 6 8 0 9  "+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence 1: (ex 4)\n"+
      "Enter 5 integers: (ex 19)\n"+
      "Enter length of sequence 2: (ex 4)\n"+
      "Enter 5 integers: (ex 19)\n"+
      "Dot Product is: 102\n"+
      "";
    DotProduct.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void DotProduct_main3() {
    String input =
      "4  2 9 1 3  "+
      "4  4 5 7 5  "+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence 1: (ex 4)\n"+
      "Enter 4 integers: (ex 19)\n"+
      "Enter length of sequence 2: (ex 4)\n"+
      "Enter 4 integers: (ex 19)\n"+
      "Dot Product is: 75\n"+
      "";
    DotProduct.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void DotProduct_main4() {
    String input =
      "1  9  "+
      "1  4  "+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence 1: (ex 4)\n"+
      "Enter 1 integers: (ex 19)\n"+
      "Enter length of sequence 2: (ex 4)\n"+
      "Enter 1 integers: (ex 19)\n"+
      "Dot Product is: 36\n"+
      "";
    DotProduct.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void DotProduct_main5() {
    String input =
      "3  7 1 4  "+
      "4  2 3 5 6  "+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence 1: (ex 4)\n"+
      "Enter 3 integers: (ex 19)\n"+
      "Enter length of sequence 2: (ex 4)\n"+
      "Enter 4 integers: (ex 19)\n"+
      "INVALID: seq1 length 3, seq2 length 4\n"+
      "";
    DotProduct.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void DotProduct_main6() {
    String input =
      "12  3 2 5 7 6 4 1 0 9 6 6 1  "+
      "8   2 3 5 6 7 1 4 0  "+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence 1: (ex 4)\n"+
      "Enter 12 integers: (ex 19)\n"+
      "Enter length of sequence 2: (ex 4)\n"+
      "Enter 8 integers: (ex 19)\n"+
      "INVALID: seq1 length 12, seq2 length 8\n"+
      "";
    DotProduct.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void DotProduct_main7() {
    String input =
      "12  3 2 5 7 6 4 1 0 9 6 6 1  "+
      "12  1 1 9 4 2 3 5 6 7 1 4 0  "+
      "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence 1: (ex 4)\n"+
      "Enter 12 integers: (ex 19)\n"+
      "Enter length of sequence 2: (ex 4)\n"+
      "Enter 12 integers: (ex 19)\n"+
      "Dot Product is: 200\n"+
      "";
    DotProduct.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
