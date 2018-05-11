import java.util.Scanner;

public class SumInts{
  
  public static void main(String args[]){
    System.out.println("Give me ints, ctrl-d to quit!");
    Scanner input = new Scanner(System.in);
    //int count = 0;
    int all = 0;
    System.out.println("Enter an int:");
    while(input.hasNext()){
      all += input.nextInt();
      //all = all + count;
      System.out.println("Enter an int:");
    }
    System.out.println("End of input");
    System.out.println("all: "+all);
    
  }
}