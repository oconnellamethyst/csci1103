// Demonstration of what happens if full method bodies are substituted
// in where the method invocation happens. Code gets complex very
// quickly. Portions marked with !!! are method invocations that are
// not substituted in but would need to be.
//
// This code does not compile and is for demonstration purpose only.
public class ComplexSqrt{
  public static void main(String args[]){
    String prompt = "Enter a number:";
    // System.out.println(prompt);
    for(int i=0; i<prompt.length(); i++){
      LoweLevel.outputBuffer.addChar(prompt.characters[i]);
      if(LowLevel.outputBuffer.isFull()){
        LowLevel.outputBuffer.flush();
      }
    }

    // !!!
    double x = TexttIO.getDouble();

    // double rootX = Math.sqrt(x);
    double rootX = x/2.0;
    double tol = 1e-4;
    double err = (x - rootX*rootX)*(x - rootX*rootX);
    while(err > tol){
      rootX = (rootX + x/rootX) / 2.0;
      err = (x - rootX*rootX)*(x - rootX*rootX);
    }

    // String result = String.concat("Square root is: ",rootX);
    String first = "Square root is:";
    String second = Double.toString(rootX); // !!!
    char [] combined = new char[first.length + second.length];
    for(int i=0; i<first.length; i++){
      combined[i] = first.characters[i];
    }
    for(int i=first.length; i<first.length+second.length; i++){
      combined[i] = second.characters[i];
    }
    String result = new String(combined);

    // System.out.println(result);
    for(int i=0; i<result.length(); i++){
      LoweLevel.outputBuffer.addChar(result.characters[i]);
      if(LowLevel.outputBuffer.isFull()){
        LowLevel.outputBuffer.flush();
      }
    }

  }
}
