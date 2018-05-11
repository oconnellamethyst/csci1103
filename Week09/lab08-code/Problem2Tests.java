import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class Problem2Tests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem2Tests");
  } 
  
  // Tests for the buyMore() method
  public void check_buyMore(String symbol, double price,
                            int numShares, String name,
                            int buyQuant)
  {
    Stock stock = new Stock();
    stock.symbol = symbol;
    stock.price = price;
    stock.numShares = numShares;
    stock.name = name;
    int expectNumShares = buyQuant + numShares;
    double actualCost = Stock.buyMore(stock, buyQuant);
    assertEquals("stock.numShares wrong", expectNumShares, stock.numShares);
    double expectCost = -buyQuant * price;
    assertEquals("returned cost wrong",expectCost,actualCost, 1e-4);
    assertEquals("price changed",price,stock.price, 1e-4);
    assertEquals("symbol changed",symbol,stock.symbol);
    assertEquals("name changed",name,stock.name);
  }

  @Test public void buyMore1() {
    String symbol = "GOOGL";
    double price = 1000.62;
    int numShares = 500;
    String name = "Alphabet Inc Class A";
    int buyQuant = 100;
    check_buyMore(symbol,price,numShares,name,buyQuant);
  }
  @Test public void buyMore2() {
    String symbol = "GOOGL";
    double price = 1000.62;
    int numShares = 500;
    String name = "Alphabet Inc Class A";
    int buyQuant = 256;
    check_buyMore(symbol,price,numShares,name,buyQuant);
  }
  @Test public void buyMore3() {
    String symbol = "GOOGL";
    double price = 1000.62;
    int numShares = 500;
    String name = "Alphabet Inc Class A";
    int buyQuant = 256;
    check_buyMore(symbol,price,numShares,name,buyQuant);
  }
  @Test public void buyMore4() {
    String symbol = "AAPL";
    double price = 163.05;
    int numShares = 800;
    String name = "Apple Inc.";
    int buyQuant = 5;
    check_buyMore(symbol,price,numShares,name,buyQuant);
  }

  // Tests for the sellOff() method
  public void check_sellOff(String symbol, double price,
                            int numShares, String name,
                            int sellQuant)
  {
    Stock stock = new Stock();
    stock.symbol = symbol;
    stock.price = price;
    stock.numShares = numShares;
    stock.name = name;
    int expectNumShares = numShares < sellQuant ? numShares : numShares - sellQuant;
    double actualProfit = Stock.sellOff(stock, sellQuant);
    assertEquals("stock.numShares wrong", expectNumShares, stock.numShares);
    double expectProfit = numShares < sellQuant ? 0.0 : sellQuant * price;
    assertEquals("returned cost wrong",expectProfit, actualProfit, 1e-4);
    assertEquals("price changed",price,stock.price, 1e-4);
    assertEquals("symbol changed",symbol,stock.symbol);
    assertEquals("name changed",name,stock.name);
  }

  @Test public void sellOff1() {
    String symbol = "GOOGL";
    double price = 1000.62;
    int numShares = 500;
    String name = "Alphabet Inc Class A";
    int sellQuant = 100;
    check_sellOff(symbol,price,numShares,name,sellQuant);
  }
  @Test public void sellOff2() {
    String symbol = "GOOGL";
    double price = 1000.62;
    int numShares = 500;
    String name = "Alphabet Inc Class A";
    int sellQuant = 250;
    check_sellOff(symbol,price,numShares,name,sellQuant);
  }
  @Test public void sellOff3() {
    String symbol = "AAPL";
    double price = 163.05;
    int numShares = 800;
    String name = "Apple Inc.";
    int sellQuant = 800;
    check_sellOff(symbol,price,numShares,name,sellQuant);
  }
  // Check for attempts to sell too much
  @Test public void sellOff4() {
    String symbol = "AAPL";
    double price = 163.05;
    int numShares = 800;
    String name = "Apple Inc.";
    int sellQuant = 801;
    check_sellOff(symbol,price,numShares,name,sellQuant);
  }
  @Test public void sellOff5() {
    String symbol = "GOOGL";
    double price = 1000.62;
    int numShares = 250;
    String name = "Alphabet Inc Class A";
    int sellQuant = 500;
    check_sellOff(symbol,price,numShares,name,sellQuant);
  }


}
