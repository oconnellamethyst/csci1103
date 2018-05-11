// Ask for a starting number and use methods to generate the Collatz
// sequence from there. Print it on the screen using a method.
public class Generate {
  public static void main(String args[]){
    System.out.println("Enter starting number:");
    int n = TextIO.getInt();
    int arr[] = Collatz.collatzArray(n);
    if(arr == null){
      System.out.printf("Invalid input: %d\n",n);
    }
    else{
      Collatz.printArray("STEP","VALUE",arr);
    }
  }
}
