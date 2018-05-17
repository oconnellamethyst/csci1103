public class PrintFormatted {
      
    /** A program that formats
      *  x = 1.0331559932390235
      *  to 1.03316
      *  and q = 748.8384692277563
      *  to $748.84
      */
    
    public static void main(String[] args) {
       double x = 1.0331559932390235;
       double q = 748.8384692277563;
       System.out.printf("x: %.5f and q: $%.2f\n", x,q);
       
    }

}