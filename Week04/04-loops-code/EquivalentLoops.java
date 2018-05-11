// Illustrate equivalent for and while loops for two semi-complex
// algorithms: primality test and sqrt calculation.

public class EquivalentLoops{
  public static void main(String args[]){
    // Test for prime numbers
    // 
    // Shows the equivalence of a for and a while loop

    { // for loop version
      int x = 48;
      int f = -1;
      boolean foundFactor = false;

      System.out.printf("Prime Test for %d\n",x);
      for(int i=x-1;
          i>1 && !foundFactor;
          i--)
        {
          if(x % i == 0){
            f = i;
            foundFactor = true;
          }
        }

      if(foundFactor){
        System.out.printf("%d not prime: a factor is %d\n",x,f);
      }
      else{
        System.out.printf("%d is prime\n");
      }
    }
    { // while loop version
      int x = 48;
      int f = -1;
      boolean foundFactor = false;

      System.out.printf("Prime Test for %d\n",x);
      int i=x-1;
      while(i>1 && !foundFactor){
        if(x % i == 0){
          f = i;
          foundFactor = true;
        }
        i--;
      }

      if(foundFactor){
        System.out.printf("%d not prime: a factor is %d\n",x,f);
      }
      else{
        System.out.printf("%d is prime\n");
      }

    }

    // Babylonian algorithm to compute square root.  Uses squared error
    // tolerance.  Not particularly readable.
    // http://en.wikipedia.org/wiki/Babylonian_method#Babylonian_method
    { // while loop version
      double tol = 1e-4;
      double S = 45.0;
      double x = 45.0/2;
      double err;

      System.out.printf("Calculating Square root of %f\n",S);
      System.out.printf("%10s %15s\n","Estimate","Error");
      err = (S - x*x)*(S - x*x);
      while(err > tol){
        System.out.printf("%10.4f %15.6f\n",
                          x, err);
        x = (x + S/x) / 2.0;
        err = (S - x*x)*(S - x*x);
      }
      System.out.printf("Final Estimate: %f\nErr: %f\n",x,err);
    }

    System.out.println();

    { // for loop version
      double tol = 1e-4;
      double S = 45.0;
      double x = 45.0/2;
      double err;

      System.out.printf("Calculating Square root of %f\n",S);
      System.out.printf("%10s %15s\n","Estimate","Error");
      for(err = (S - x*x)*(S - x*x);
          err > tol;
          err = (S - x*x)*(S - x*x))
        {
          System.out.printf("%10.4f %15.6f\n",
                            x, err);
          x = (x + S/x) / 2.0;

        }
      System.out.printf("Final Estimate: %f\nErr: %f\n",x,err);
    }
    
  }
}

