public class PositiveRoot {
      
    /** A program that computes the positive root of
      *  3.5x^2 -4.1x + 0.5
      */
    
    public static void main(String[] args) {
       double a = 3.5;
       double b = -4.1;
       double c = 0.5;
       double numerator = -b + Math.sqrt(Math.pow( b , 2 ) - 4 * a * c);
       double denominator = 2 * a;
       double x = numerator / denominator;
       System.out.println("The positive root of 3.5x^2 -4.1x + 0.5 is " + x );
       
    }

}