// Program that determines the maximum of three numbers using
// conditionals
public class Max3{
  public static void main(String args[]){
    System.out.println("Enter 3 integers:");
    int a = TextIO.getInt();
    int b = TextIO.getInt();
    int c = TextIO.getInt();

    int max = a;
    if(b > max){
      max = b;
    }
    if(c > max){
      max = c;
    }
    System.out.println("Max is "+max);
  }
}
