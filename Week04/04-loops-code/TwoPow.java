// Shows two equivalent loops: while and for do the same thing
public class TwoPow{
  public static void main(String args[]){
    int twoPow, exponent; 
    {
      System.out.println("WHILE LOOP VERSION");
      twoPow=1;
      exponent=0;
      while(exponent < 10){
        System.out.printf("2^%d = %d\n",
                          exponent,twoPow);
        twoPow *= 2;
        exponent++;
      }
    }

    System.out.println();

    {
      System.out.println("FOR LOOP VERSION");     
      twoPow=1;
      for(exponent=0; exponent < 10; exponent++){
        System.out.printf("2^%d = %d\n",
                          exponent,twoPow);
        twoPow *= 2;
      }
    }
  }
}
