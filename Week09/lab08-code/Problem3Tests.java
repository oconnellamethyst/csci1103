import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class Problem3Tests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem3Tests");
  } 

  @Test public void test_StockMain() {
    String input = "";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Initial position: funds=$100000.00\n"+
      "Alphabet Inc Class A (GOOGL): price: $1000.62 shares: 500\n"+
      "Microsoft Corporation (MSFT): price: $79.12 shares: 350\n"+
      "\n"+
      "Transaction 1\n"+
      "Buying 300 shares of MSFT: funds=$76264.00\n"+
      "Alphabet Inc Class A (GOOGL): price: $1000.62 shares: 500\n"+
      "Microsoft Corporation (MSFT): price: $79.12 shares: 650\n"+
      "\n"+
      "Transaction 2\n"+
      "Selling 400 shares of GOOGL: funds=$476512.00\n"+
      "Alphabet Inc Class A (GOOGL): price: $1000.62 shares: 100\n"+
      "Microsoft Corporation (MSFT): price: $79.12 shares: 650\n"+
      "\n"+
      "Transaction 3\n"+
      "Selling 200 shares of GOOGL: funds=$476512.00\n"+
      "Alphabet Inc Class A (GOOGL): price: $1000.62 shares: 100\n"+
      "Microsoft Corporation (MSFT): price: $79.12 shares: 650\n"+
      "";
    StockMain.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
