// Ask for an input sequence and verify that it is indeed a Collatz
// sequence.
public class Verify {
  public static void main(String args[]){
    System.out.println("Enter Collatz sequence length:");
    int len = TextIO.getInt();
    int testSeq[] = new int[len];
    System.out.println("Enter Collatz sequence elements:");
    for(int i=0; i<len; i++){
      testSeq[i] = TextIO.getInt();
    }
    if(Collatz.verify(testSeq) == true){
      System.out.println("This is a Collatz sequence");
    }
    else{
      System.out.println("This is NOT a Collatz sequence");
      System.out.println("The actual sequence should be:");
      int arr[] = Collatz.collatzArray(testSeq[0]);
      Collatz.printArray("STEP","VALUE",arr);
    }
  }
}
