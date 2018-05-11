public class FirstMethod{                 // Class demonstrating a non-main() method

  public static void printCatchphrase(){  // a method which returns nothing (void)
    String msg = "Wubalubadubdub!!";      // variable that is local to method
    System.out.println(msg);              // print something
    return;                               // optional return, no needed due to void type
  }

  public static void main(String args[]){ // main() method: execution starts here
    System.out.println("Insert catchphrase");
    printCatchphrase();                   // run the printCatchphrase() method
    System.out.println("and again...");   // print something additional
    printCatchphrase();                   // run printCatchphrase() again
  }
}
