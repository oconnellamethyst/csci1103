public class StockMain{

  public static void main(String args[]){
    Stock google = new Stock();
    google.symbol = "GOOGL";
    google.price = 1000.62;
    google.numShares = 500;
    google.name = "Alphabet Inc Class A";

    Stock microsoft = new Stock();
    microsoft.symbol = "MSFT";
    microsoft.price = 79.12;
    microsoft.numShares = 350;
    microsoft.name = "Microsoft Corporation";

    double funds = 100000.00;
    System.out.printf("Initial position: funds=$%.2f\n",funds);
    Stock.printInfo(google);
    Stock.printInfo(microsoft);

    Stock transStock;
    int transShares;
    double fundChange;

    System.out.println();
    System.out.println("Transaction 1");
    transStock = microsoft;
    transShares = 300;
    fundChange = Stock.buyMore(transStock, transShares);
    funds += fundChange;
    System.out.printf("Buying %d shares of %s: funds=$%.2f\n",
                      transShares, transStock.symbol, funds);
    Stock.printInfo(google);
    Stock.printInfo(microsoft);
    
    System.out.println();
    System.out.println("Transaction 2");
    transStock = google;
    transShares = 400;
    fundChange = Stock.sellOff(transStock, transShares);
    funds += fundChange;
    System.out.printf("Selling %d shares of %s: funds=$%.2f\n",
                      transShares, transStock.symbol, funds);
    Stock.printInfo(google);
    Stock.printInfo(microsoft);

    System.out.println();
    System.out.println("Transaction 3");
    transStock = google;
    transShares = 200;
    fundChange = Stock.sellOff(transStock, transShares);
    funds += fundChange;
    System.out.printf("Selling %d shares of %s: funds=$%.2f\n",
                      transShares, transStock.symbol, funds);
    Stock.printInfo(google);
    Stock.printInfo(microsoft);

  }
}
    
