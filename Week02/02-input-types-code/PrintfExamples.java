// Demonstrate the printf() function for printing numbers with
// different levels of precision.
public class PrintfExamples{
  public static void main(String args[]){
    double x = 1.23456789;
    double y = 4.95;
    double z = 0.00789;

    // print only x with 2 digits 
    System.out.printf("x is %.2f\n",x); 
    // x is 1.23

    // print x,y,z with 2 digits 
    System.out.printf("all are %.2f %.2f %.2f\n",x,y,z); 
    // all are 1.23 4.95 0.01

    // print x,y,z with 3 digits 
    System.out.printf("3 digs %.3f %.3f %.3f\n",x,y,z); 
    // 3 digs 1.235 4.950 0.008

    // mixed precision
    System.out.printf("x: %.5f... y: $%.3f z: %.0f\n",x,y,z); 
    // x: 1.23457... y: $4.950 z: 0

  }
}
