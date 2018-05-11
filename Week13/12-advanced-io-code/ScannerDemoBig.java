// ScannerDemo.java: Demonstrate the Scanner class

// Notify the java compiler that classes from the standard library
// will be used
import java.util.Scanner;	
import java.io.File;

public class ScannerDemoBig{
  public static void main(String args[])
    throws Exception // Something could go wrong
  {
    // Create a new Scanner object which reads user input from the
    // terminal where the program is run
    Scanner input = new Scanner(System.in);

    System.out.print("Input an integer: ");
    // Read an integer from the user and store it in the variable i
    int i = input.nextInt();

    System.out.print("Input a real: ");
    // Read a real number from the user and store it in the variable d
    double d = input.nextDouble();

    System.out.print("Input a string: ");
    // Read a string (single word) and store it in the variable s
    String s = input.next();
    System.out.println("" + i + " " + d + " " +s);


    // Change the input to read from a file instead of the terminal
    input = new Scanner(new File("data.txt"));
    // Scanner methods work the same regardless of the source of input
    s = input.next();
    i = input.nextInt();
    d = input.nextDouble();
    String s2 = input.next();
    System.out.printf("%s %d %.3f %s\n",s,i,d,s2);
    // Make sure to close Scanners that use files
    input.close();

    // Reset back to the beginning of the file by allocating a new
    // Scanner
    input = new Scanner(new File("data.txt"));
    // Loop while the data has another token to read
    i = 1;
    while(input.hasNext()){
      s = input.nextLine();		    // Read a whole line
      System.out.printf("Line %d: %s\n",i,s); // Print it
      i++;
    }
    input.close();
  }
}
