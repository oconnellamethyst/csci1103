import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class LoanCalcTests extends P1Tests{

  // Main method runs this file's tests
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("LoanCalcTests");
  } 

  ////////////////////////////////////////////////////////////////////////////////
  // Tests

  @Test public void LoanCalc_main1() {
    String input = "225000.00 7.8 30";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Loan Amount:\n"+
      "Enter Yearly Interest Rate (percent):\n"+
      "Enter Years for Loan:\n"+
      "Monthly Payment is $1619.71\n"+
      "Total Cost for loan is $583095.11\n"+
      "Total Interest for loan is $358095.11\n"+
      "";
    LoanCalc.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void LoanCalc_main2() {
    String input = "1000 10 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Loan Amount:\n"+
      "Enter Yearly Interest Rate (percent):\n"+
      "Enter Years for Loan:\n"+
      "Monthly Payment is $87.92\n"+
      "Total Cost for loan is $1054.99\n"+
      "Total Interest for loan is $54.99\n"+
      "";
    LoanCalc.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void LoanCalc_main3() {
    String input = "4251.95 12.7 5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Loan Amount:\n"+
      "Enter Yearly Interest Rate (percent):\n"+
      "Enter Years for Loan:\n"+
      "Monthly Payment is $96.09\n"+
      "Total Cost for loan is $5765.59\n"+
      "Total Interest for loan is $1513.64\n"+
      "";
    LoanCalc.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void LoanCalc_main4() {
    String input = "12000.00 5.678 2";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Loan Amount:\n"+
      "Enter Yearly Interest Rate (percent):\n"+
      "Enter Years for Loan:\n"+
      "Monthly Payment is $530.11\n"+
      "Total Cost for loan is $12722.59\n"+
      "Total Interest for loan is $722.59\n"+
      "";
    LoanCalc.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void LoanCalc_main5() {
    String input = "1.00 25.0 10";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter Loan Amount:\n"+
      "Enter Yearly Interest Rate (percent):\n"+
      "Enter Years for Loan:\n"+
      "Monthly Payment is $0.02\n"+
      "Total Cost for loan is $2.73\n"+
      "Total Interest for loan is $1.73\n"+
      "";
    LoanCalc.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }


}
