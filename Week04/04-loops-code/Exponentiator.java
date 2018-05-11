public class Exponentiator{
  public static void main(String args[]){
    System.out.println("Enter base (int):");
    int base = TextIO.getInt();
    System.out.println("Enter power (int):");
    int power = TextIO.getInt();

    int curVal = 1;
    int curPow = 0;

    while(curPow < power){
      curVal *= base; //curVal = curVal * base;
      curPow++;
    }
    System.out.printf("%d^%d is %d\n",
                      base,power,curVal);
  }
}
