// Demonstrate interactive loop with a "quit" value which causes the
// loop to terminate
public class InteractiveSum2{
  public static
  void main(String args[]) {
    int i = 0;
    int sum = 0;
    int value = -1;             // Must declare before loop
    while(value != 0){          // Check for quit value
      System.out.println("Enter an integer (0 to quit):");
      value = TextIO.getInt();
      if(value != 0){           // Don't do anything with
        sum += value;           // quit value
      }
    }
    System.out.printf("Sum is %d\n",sum); // After loop
  }
}
