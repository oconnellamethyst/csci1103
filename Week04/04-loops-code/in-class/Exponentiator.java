public class Exponentiator{
  public static void main(String args[]){
    System.out.println("Enter base (int):");
    int base = TextIO.getInt();
    System.out.println("Enter power (int):");
    int power = TextIO.getInt();
    
    int i = 0; // counter variable
    int total = 1;
    while(i < power){
      total = total * base;
      i++;
    }
    
//    //Alternative: no good
//    int total = base;
//    while( i <= power){
//      total = Math.pow(base,i);
//      i++;
//    }
//      
    
    
    System.out.printf("%d^%d is %d\n",base,power,total);
  }
}
