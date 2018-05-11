// Solution to in-class exercises on using Math.sqrt() and Math.pow()
public class DoMath{
  public static void main(String args[]){
    double a = 3.5;
    double b = -4.1;
    double c = 0.5;
    double numerator   = -b + Math.sqrt(b*b - 4*a*c);
    double denominator = 2*a;
    double x = numerator / denominator;
    System.out.println(x);

    double q = 25.0;
    double e = 2.718;
    double r = 2.0;
    double t = 1.7;
    double p = q * Math.pow(e, r*t);
    System.out.println(p);
  }
}
