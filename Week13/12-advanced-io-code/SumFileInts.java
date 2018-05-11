// Demo to sum integers from a file 
import java.util.Scanner;
import java.io.File;  // using File class

public class SumFileInts{
  public static void main(String args[]){
    try{
      String filename = "numbers.txt";
      Scanner input =
        new Scanner(new File(filename));
      int total = 0;
      while(input.hasNext()){
        int num = input.nextInt();
        total += num;
      }
      System.out.printf("Total: %d\n",
                        total);
      input.close(); // for file scanning
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
