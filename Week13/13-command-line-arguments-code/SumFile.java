import java.io.*;
import java.util.*;

public class SumFile{
  public static void main(String args[]) throws Exception{
    String filename = args[0];
    Scanner input = new Scanner(new File(filename));
    double sum = 0;
    while(input.hasNext()){
      double val = input.nextDouble();
      sum += val;
    }
    input.close();
    System.out.printf("sum of file %s: %.1f\n",filename,sum);
  }
}
