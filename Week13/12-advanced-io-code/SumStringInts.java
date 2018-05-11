// Demo to sum integers from
// different strings
import java.util.Scanner;

public class SumStringInts{
  public static void main(String args[]){
    Scanner input;
    int total;

    String nums1 = "1 2 3 4";
    input = new Scanner(nums1);
    total = 0;
    while(input.hasNext()){
      int num = input.nextInt();
      total += num;
    }
    System.out.printf("Total: %d\n",
                      total);

    String nums2 = "10 30 50 70 90";
    input = new Scanner(nums2);
    total = 0;
    while(input.hasNext()){
      int num = input.nextInt();
      total += num;
    }
    System.out.printf("Total: %d\n",
                      total);
  }
}
