// Short demo of the scanner class which reads an integer, double, and
// string from the user

import java.util.Scanner;    // notify compiler of Scanner use

public class ScannerDemo{
  public static void main(String args[]){
    System.out.println("Enter int double string:");
    Scanner input = new Scanner(System.in); // scan from keyboard
    int i = input.nextInt();                // read an int
    double d = input.nextDouble();          // read a double
    String s = input.next();                // read a string
    String s2 = input.next();                // read a string
    System.out.printf("%d %f %s %s\n",i,d,s,s2);
  }
}
