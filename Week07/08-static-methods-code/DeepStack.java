public class DeepStack{
  
  public static boolean checkLength(String word){
    if(word.length() < 10){
      return true;
    }
    else{
      return false;
    }
  }

  public static boolean inRange(double z){
    return 25.5 <= z && z < 65.0;
  }

  public static boolean doChecks(String name, double x) {
    boolean nameOK = checkLength(name);
    boolean xOK = inRange(x);
    return nameOK || xOK;
  }

  public static void main(String args[]){
    String candA = "Morty";
    double iqA = 47.3;
    boolean validA = doChecks(candA,iqA);

    String candB = "Jerry Smith";
    double iqB = 27.8;
    boolean validB = doChecks(candB,iqA);
  }
}
