public class SampleMethods{               // Class demonstrating a non-main() method

  public static void printCatchphrase(){  // a method which returns nothing (void)
    String msg = "Wubalubadubdub!!";      // variable that is local to method
    System.out.println(msg);              // print something
    return;                               // optional return, no needed due to void type
  }

  public static int multiplyAdd(int a, int b, int c){
    int mult = a * b;
    int sum = mult + c;
    return sum;                           // must return an integer
  }

  public static void main(String args[]){ // main() method: execution starts here
    int ans = multiplyAdd(3,4,5);         // call the multiplyAdd() method
    System.out.println(ans);              // print the answer produced
    printCatchphrase();                   // run the printCatchphrase() method
    int x=2, y=1, z=7;                    // local variables
    int ans2 = multiplyAdd(x,y,z);        // call the multiplyAdd() method again
    System.out.println(ans2);             // print the answer produced
  }
}
