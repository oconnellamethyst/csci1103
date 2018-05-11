public class Tricky{
  public static void main(String args[]){
    boolean b = false;
    
    if(b == true){
      System.out.println("It's true");
    }
    
    if(b){
      System.out.println("It's true?");
    }
    
    int i = 1;
    
    if(i == 2){
      System.out.println("It's true");
    }
    
    if(i = 2){
      System.out.println("It's true?");
    }
  }
}
