import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class Problem1Tests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem1Tests");
  } 

  @Test public void stock_exists() {
    Stock stock = new Stock();
  }

  @Test public void stock_defaults() {
    Stock stock = new Stock();
    assertEquals(stock.symbol, null);
    assertEquals(stock.price, 0.0, 1e-8);
    assertEquals(stock.numShares, 0);
    assertEquals(stock.name, null);
  }

  @Test public void stock_fields1() {
    Stock stock = new Stock();
    stock.symbol = "GOOGL";
    stock.price = 1000.62;
    stock.numShares = 500;
    stock.name = "Alphabet Inc Class A";
  }

  @Test public void stock_fields2() {
    Stock stock = new Stock();
    stock.symbol = "AAPL";
    stock.price = 163.05;
    stock.numShares = 800;
    stock.name = "Apple Inc.";
  }

  public void check_printInfo(String symbol, double price,
                              int numShares, String name,
                              String expectS)
  {
    Stock stock = new Stock();
    stock.symbol = symbol;
    stock.price = price;
    stock.numShares = numShares;
    stock.name = name;
    Stock.printInfo(stock);
    String actualS = localOut.toString();
    String msg =
      String.format("Stock.printStock(stock)")+
      String.format("symbol: %s  price: %f  numShares: %d  name: %s\n",
                    symbol, price, numShares, name) +
      String.format("EXPECT:\n%s\n", expectS) +
      String.format("ACTUAL:\n%s\n", actualS) +
      "";
    assertEquals(msg,expectS,actualS);
  }
  
  @Test public void stock_printInfo() {
    String symbol = "GOOGL";
    double price = 1000.62;
    int numShares = 500;
    String name = "Alphabet Inc Class A";
    String expect = "Alphabet Inc Class A (GOOGL): price: $1000.62 shares: 500\n";
    check_printInfo(symbol,price,numShares,name,expect);
  }
  @Test public void stock_printInfo2() {
    String symbol = "AAPL";
    double price = 163.05;
    int numShares = 800;
    String name = "Apple Inc.";
    String expect = "Apple Inc. (AAPL): price: $163.05 shares: 800\n";
    check_printInfo(symbol,price,numShares,name,expect);
  }
}
