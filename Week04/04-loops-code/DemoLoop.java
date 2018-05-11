public class DemoLoop{
  public static
  void main(String args[])
  {
    int x = 0;
    int a = 5;
    while(x != a){
      x++;
      a = a/2 + 1;
    }
    System.out.println("x: "+x);
    System.out.println("a: "+a);
  }
}
