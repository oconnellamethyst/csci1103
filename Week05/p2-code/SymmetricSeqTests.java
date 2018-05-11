import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class SymmetricSeqTests extends KTests{

  // Main method runs this file's tests
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("SymmetricSeqTests");
  } 

  ////////////////////////////////////////////////////////////////////////////////
  // Tests

  @Test public void SymmetricSeq_main1() {
    String input = "3  1 2 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 3 integers:\n"+
      "Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main2() {
    String input = "3  1 2 2";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 3 integers:\n"+
      "seq[0] != seq[2]\n"+
      "NOT Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main3() {
    String input = "4  -1 5 5 -1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 4 integers:\n"+
      "Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main4() {
    String input = "4  1 5 5 -1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 4 integers:\n"+
      "seq[0] != seq[3]\n"+
      "NOT Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main5() {
    String input = "5  2 2 2 2 2";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 5 integers:\n"+
      "Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main6() {
    String input = "5  1 2 3 2 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 5 integers:\n"+
      "Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main7() {
    String input = "5  1 3 3 2 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 5 integers:\n"+
      "seq[1] != seq[3]\n"+
      "NOT Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main8() {
    String input = "5  1 2 3 4 5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 5 integers:\n"+
      "seq[0] != seq[4]\n"+
      "seq[1] != seq[3]\n"+
      "NOT Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main9() {
    String input = "10  -1 2 -3 4 5 5 4 -3 2 -1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 10 integers:\n"+
      "Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main10() {
    String input = "10  -1 2 -3 -4 5 5 4 -3 2 -1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 10 integers:\n"+
      "seq[3] != seq[6]\n"+
      "NOT Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void SymmetricSeq_main11() {
    String input = "25  74 86 83 88 96 87 11 60 46 1 84 55 42 55 84 1 46 60 11 87 96 88 83 86 74";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter length of sequence (ex: 7): \n"+
      "Enter 25 integers:\n"+
      "Symmetric\n"+
      "";
    SymmetricSeq.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
