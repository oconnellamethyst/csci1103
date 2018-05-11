// Exercise to sum numbers
import java.util.Scanner;

public class SumIntegers{
  public static void main(String args[]){
    System.out.println("Stop with Ctrl-D (Mac/Unix) or Ctrl-Z (Windows)"); 

    Scanner input = new Scanner(System.in);
    int total = 0;
    System.out.println("Enter an integer:");
    while(input.hasNext()){           // loop while input
      int num = input.nextInt();      // get a number
      total += num;                   // increment
      System.out.println("Enter an integer:");
    }
    System.out.printf("End of input\n");
    System.out.printf("Total: %d\n",total);
  }
}
