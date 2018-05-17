public class Swap{
 public static void main(String args[]){
  int x;
  int y;
  int temp;

  x = 19;
  y = 31;
  temp = x;
  x = y;
  y = temp;
  System.out.println("first " + x);
  System.out.println("second " + y);
 }
}