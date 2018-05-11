public class ReverseSequence{
  public static void main(String args[]) {
    System.out.println("Enter sequence length:");
    int seqLength = TextIO.getInt();          // get size from user
    int sequence[] = new int[seqLength];      // allocate space for sequence
    System.out.printf("Enter %d integers: (ex: 13)\n",
                      seqLength);

    for(int i=0; i<seqLength; i++){           // input loop: read all
      sequence[i] = TextIO.getInt();          // integers from user
    }

    System.out.println("Sequence in reverse:");
    for(int i=seqLength-1; i>=0; i--){        // print out sequence in
      System.out.printf("%d ",sequence[i]);   // reverse order
    }
    System.out.println();
  }
}
