// First program shows how to variables can be swapped using a third
// variable then printed to the screen
public class Swap{
  public static void main(String args[]){
    int x = 19;
    int y = 31;
    int temp = -1;
    temp = x;
    x = y;
    y = temp;
    System.out.println("first " + x);
    System.out.println("second " + y);
  }
}
