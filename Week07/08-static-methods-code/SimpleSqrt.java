// Simple program that makes use of method invocations to calculate a
// square root. Contrast with ComplexSqrt.java where full-ish method
// bodies are substituted in.
public class SimpleSqrt{
  public static void main(String args[]){
    String prompt = "Enter a number:";
    System.out.println(prompt);
    double x = TextIO.getDouble();
    double rootX = Math.sqrt(x);
    String result = "Square root is: "+rootX;
    System.out.println(result);
  }
}
