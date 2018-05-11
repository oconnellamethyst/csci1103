// Babylonian algorithm to compute square root.  Uses squared error
// tolerance.  Not particularly readable.
// http://en.wikipedia.org/wiki/Babylonian_method#Babylonian_method
public class Sqrt{
  public static void main(String args[]){

    System.out.println("Enter S to get sqrt(S): (ex: 45.2)");
    double S = TextIO.getDouble();

    double tol = 1e-4;
    double x = S/2.0;
    double err = (S - x*x)*(S - x*x);
    int iter = 0;

    System.out.printf("Calculating Square root of %f\n",S);
    System.out.printf("%4s %10s %15s\n","Iter","Estimate","Error");
    while(err > tol){
      x = (x + S/x) / 2.0;
      err = (S - x*x)*(S - x*x);
      iter++;
      System.out.printf("%4d %10.4f %15.6f\n",
                        iter,     x,   err);
    }
    System.out.printf("Final Estimate: %f\nErr: %f\n",x,err);
  }
}
