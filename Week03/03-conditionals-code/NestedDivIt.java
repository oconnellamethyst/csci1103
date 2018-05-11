// Use nested if-elses to print whether a given number is divisible
// by 8, 4, 2, but only the largest of these.
// NOTE: this is MUCH harder to read than the chained if/else version
public class NestedDivIt{
  public static void main(String args[]){
    System.out.println("Enter an in (ex: 22):");
    int num = TextIO.getInt();
    if(num % 2 == 0){
      if(num % 4 == 0){
        if(num % 8 == 0){
          System.out.printf("%d divisible by 8\n",num);
        }
        else{
          System.out.printf("%d divisible by 4\n",num);
        }
      }
      else{
        System.out.printf("%d divisible by 2\n",num);
      }
    }
    else{
      System.out.printf("%d sucks\n",num);
    }
  }
}
