// Demo of scanning errors
import java.util.Scanner;

public class ScanError{
  public static void main(String args[]){
    String nums = "5 4 three 2 1";
    Scanner input = new Scanner(nums);
    int total = 0;
    while(input.hasNext()){
      int num = input.nextInt();
      System.out.printf("read %d\n",num);
      total += num;
    }
    System.out.printf("Total: %d\n", total);
  }
}
