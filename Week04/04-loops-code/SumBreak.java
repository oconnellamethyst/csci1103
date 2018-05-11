// Demonstrate interactive loop with a "quit" value which causes the
// loop to terminate; a break statement is used for this
public class SumBreak{
  public static
  void main(String args[]) {
    int i = 0;
    int sum = 0;
    int quitVal = -1;
    while(true){                // Apparently loop forever...
      System.out.printf("Enter an integer (%d to quit):\n",
                        quitVal);
      int value = TextIO.getInt();
      if(value == quitVal){           // Check for quit val
        break;                        // jump out of loop
      }
      sum += value;
    }
    System.out.printf("Sum is %d\n",sum); // After loop
  }
}
