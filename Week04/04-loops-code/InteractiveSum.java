// Demonstrate how user input can affect loops
public class InteractiveSum{
  public static
  void main(String args[]) {
    System.out.println("How many integers?");
    int count = TextIO.getInt();// number of iterations
    int i = 0;
    int sum = 0;
    while(i < count){           // loop until reach count
      System.out.println("Enter an integer:");
      int value = TextIO.getInt();
      sum += value;             // update sum
      i++;
    }
    System.out.printf("Sum is %d\n",sum);
  }
}
