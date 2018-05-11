// Demonstrate the hasNext() method of Scanner
import java.util.Scanner;

public class EndOfInput{
  public static void main(String args[]){
    System.out.println("To end input");
    System.out.println("- Mac/Unix: press Ctrl-D"); 
    System.out.println("- Windows:  press Ctrl-Z");
    Scanner input = new Scanner(System.in);
    int count = 0;
    String allStrings = "";

//    System.out.println("Enter a string:");
    while(input.hasNext()){           // loop while input
      System.out.println("Enter a string:");
      String str = input.next();      // get a string
      count++;                        // increment
      allStrings += str + "\n";       // tack on to all
      //System.out.println("Enter a string:");
    }

    System.out.printf("End of input reached\n");
    System.out.printf("%d total strings typed\n",count);
    System.out.printf("All strings:\n%s\n",allStrings);
  }
}
