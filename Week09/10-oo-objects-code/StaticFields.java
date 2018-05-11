class OnlyStatic{
  public static int a;       // both static
  public static String b;
}
class OnlyNon{
  public int c;              // both non-static
  public String d;
}
class Mixed{
  public static int e;       // one static
  public String f;           // one non-static
}

public class StaticFields{
  public static void main(String args[]){
    OnlyStatic.a = 5;  OnlyStatic.b = "bb";

    // OnlyNon.c = 4;      // ERROR: non-static field
    // OnlyNon.d = "ddd";  // ERROR: non-static field
    OnlyNon x = new OnlyNon();
    x.c = 10;   x.d = "dd";
    OnlyNon y = new OnlyNon();
    y.c = 15;   y.d = "dddd";
    
    Mixed.e = 20;
    // Mixed.f = "ff";     // ERROR: non-static field

    Mixed z = new Mixed();
    z.f = "ff";
    Mixed w = new Mixed();
    w.f = "ffff";
  }
}
