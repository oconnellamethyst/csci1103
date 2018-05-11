import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class MakeChangeTests extends P1Tests {

  // Main method runs this file's tests
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("MakeChangeTests");
  } 

  ////////////////////////////////////////////////////////////////////////////////
  // Tests

  @Test public void MakeChange_main1() {
    String input = "167";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter required change in pennies (ex: 167): \n"+
      "Dollars: 1\n"+
      "Quarter: 2\n"+
      "Dimes  : 1\n"+
      "Nickels: 1\n"+
      "Pennies: 2\n"+
      "";
    MakeChange.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MakeChange_main2() {
    String input = " 234 ";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter required change in pennies (ex: 167): \n"+
      "Dollars: 2\n"+
      "Quarter: 1\n"+
      "Dimes  : 0\n"+
      "Nickels: 1\n"+
      "Pennies: 4\n"+
      "";
    MakeChange.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MakeChange_main3() {
    String input = " \n99\n ";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter required change in pennies (ex: 167): \n"+
      "Dollars: 0\n"+
      "Quarter: 3\n"+
      "Dimes  : 2\n"+
      "Nickels: 0\n"+
      "Pennies: 4\n"+
      "";
    MakeChange.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MakeChange_main4() {
    String input = "42";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter required change in pennies (ex: 167): \n"+
      "Dollars: 0\n"+
      "Quarter: 1\n"+
      "Dimes  : 1\n"+
      "Nickels: 1\n"+
      "Pennies: 2\n"+
      "";
    MakeChange.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MakeChange_main5() {
    String input = "435 ";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter required change in pennies (ex: 167): \n"+
      "Dollars: 4\n"+
      "Quarter: 1\n"+
      "Dimes  : 1\n"+
      "Nickels: 0\n"+
      "Pennies: 0\n"+
      "";
    MakeChange.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
