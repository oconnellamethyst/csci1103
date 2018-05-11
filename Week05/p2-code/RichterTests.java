import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class RichterTests extends KTests{

  // Main method runs this file's tests
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("RichterTests");
  } 

  ////////////////////////////////////////////////////////////////////////////////
  // Tests

  @Test public void Richter_main1() {
    String input = "-1.45";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter magnitude of earthquake (ex 5.8):\n"+
      "-1.5 : Invalid magnitude, must be > 0.0\n"+
      "";
    Richter.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Richter_main2() {
    String input = "0.0";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter magnitude of earthquake (ex 5.8):\n"+
      "0.0 : Not felt by most people\n"+
      "";
    Richter.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Richter_main3() {
    String input = "1.4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter magnitude of earthquake (ex 5.8):\n"+
      "1.4 : Not felt by most people\n"+
      "";
    Richter.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Richter_main4() {
    String input = "5.76";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter magnitude of earthquake (ex 5.8):\n"+
      "5.8 : Felt by everyone. None to slight damage.\n"+
      "";
    Richter.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Richter_main5() {
    String input = "3.2";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter magnitude of earthquake (ex 5.8):\n"+
      "3.2 : Often felt by people, but very rarely causes damage.\n"+
      "";
    Richter.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Richter_main6() {
    String input = "6.5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter magnitude of earthquake (ex 5.8):\n"+
      "6.5 : Damage to a moderate number of buildings, poorly constructed buildings may collapse.\n"+
      "";
    Richter.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Richter_main7() {
    String input = "7.0";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter magnitude of earthquake (ex 5.8):\n"+
      "7.0 : Major damage to buildings, structures likely to be destroyed.\n"+
      "";
    Richter.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void Richter_main8() {
    String input = "9.78";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter magnitude of earthquake (ex 5.8):\n"+
      "9.8 : At or near total destruction - severe damage or collapse to all buildings.\n"+
      "";
    Richter.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }


}
