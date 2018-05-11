public class CompareSequences{
  public static void main(String args[]) {
    System.out.println("Enter sequence length:");
    int seqLength = TextIO.getInt();          // get size from user
    int seq1[] = new int[seqLength];          // allocate space for seq 1

    System.out.printf("Enter First %d integers:\n", seqLength);
    for(int i=0; i<seqLength; i++){           // input loop: read seq 1
      seq1[i] = TextIO.getInt();              // integers from user
    }

    int seq2[] = new int[seqLength];          // allocate space for sequence 2
    System.out.printf("Enter Second %d integers:\n",seqLength);
    for(int i=0; i<seqLength; i++){           // input loop: read all
      seq2[i] = TextIO.getInt();              // integers from user
    }

    System.out.printf("%2s %4s %4s\n",        // print table header
                      "#","seq1","seq2");

    for(int i=0; i<seqLength; i++){           // print out sequence table
      System.out.printf("%2d %4d %4d\n",
                        i,seq1[i],seq2[i]);
    }

    // Check for equality of all elements
    boolean areEqual = true;                  // assume equal
    for(int i=0; i<seqLength; i++){
      if(seq1[i] != seq2[i]){                 // detect differences
        areEqual = false;                     // change equal to not
      }
    }
    System.out.printf("Sequences equal: %b\n",areEqual);
  }
}
