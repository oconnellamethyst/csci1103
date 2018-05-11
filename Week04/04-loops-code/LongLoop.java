public class LongLoop{
  public static void main(String args[]){

    int twoPow = 1;
    int exponent = 0;
    while(exponent < 10){
      System.out.printf("2^%d = %d\n",
                        exponent,twoPow);
      twoPow *= 2;
    }
  }
}
