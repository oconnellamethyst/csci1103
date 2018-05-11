// Enter 4 numbers, check for ascending order
public class Ascending{
  public static void main(String args[]){
    System.out.println("Enter 4 integers:");
    int a = TextIO.getInt();
    int b = TextIO.getInt();
    int c = TextIO.getInt();
    int d = TextIO.getInt();

    if(a<=b && b<=c && c<=d){
      System.out.println("Numbers are ascending");
    }
    else{
      System.out.println("Out of order");
    }
  }
}
