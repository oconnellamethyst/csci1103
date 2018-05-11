// Methods have their own scope for variables and can't share variable
// declarations
public class MethodScoping{     

  public static void printCatchphrase(){  // a method which returns nothing (void)
    String msg = "Wubalubadubdub!!";      // variable that is local to method
    System.out.println(msg);              // print something
    return;                               // optional return, no needed due to void type
  }

  public static void main(String args[]){ // main() method: execution starts here
    System.out.println(msg);              // msg not found: local to printCatchphrase()
                                          // so not visible in main()
  }
}
