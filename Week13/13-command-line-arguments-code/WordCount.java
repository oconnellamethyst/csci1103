// Count all words in all files named on the command line

import java.util.Scanner;
import java.io.File;

public class WordCount{
  public static void main(String args[]) throws Exception{
    for(int i=0; i<args.length; i++){
      String filename = args[i];
      Scanner input = new Scanner(new File(filename));
      int wc = 0;
      while(input.hasNext()){
        input.next();
        wc++;
      }
      input.close();
      System.out.printf("%s has %d words\n",
                        filename,wc);
    }
  }
}
    
