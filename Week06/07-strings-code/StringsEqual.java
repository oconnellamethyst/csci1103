public class StringsEqual{
  public static void main(String args[]){
    String a = "hi";
    String b = a;
    String c = new String("hi");
    String d = "hi";

    System.out.printf("a == b : %b\n", a==b);
    System.out.printf("a == c : %b\n", a==c);
    System.out.printf("a == d : %b\n", a==d);

    System.out.printf("a.equals( b ) : %b\n", a.equals(b));
    System.out.printf("a.equals( c ) : %b\n", a.equals(c));
    System.out.printf("a.equals( d ) : %b\n", a.equals(d));
  }
}
