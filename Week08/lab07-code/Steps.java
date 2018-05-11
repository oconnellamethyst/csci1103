// Prompt for a starting number and print out how many steps it would
// take from the starting to to converge to 1 in a Collatz sequence.
public class Steps {
  public static void main(String args[]){
    System.out.println("Enter starting number:");
    int n = TextIO.getInt();
    int steps = Collatz.steps(n);
    if(steps==-1){
      System.out.printf("Invalid input: %d\n",n);
    }
    else{
      System.out.printf("%d converges to 1 in %d steps\n",
                        n, steps);
    }
  }
}
