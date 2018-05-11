// Demo to sum integers from a file that is read from the user
import java.util.Scanner;
import java.io.File;

public class SumPickFile{
  // Sum all integers in the given Scanner's stream. Assumes all tokens are integers
  public static int sumAll(Scanner input){
    int total = 0;
    while(input.hasNext()){
      int num = input.nextInt();
      total += num;
    }
    return total;
  }

  public static void main(String args[]){
    try{
      Scanner userInput = new Scanner(System.in);          // to read typed input
      System.out.println("Enter a filename:");
      String filename = userInput.next();                  // get filename
      Scanner fileInput = new Scanner(new File(filename)); // to read file input
      int total = sumAll(fileInput);                       // method to sum all 
      fileInput.close();
      System.out.printf("Total: %d\n", total);
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
