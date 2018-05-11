public class CallStackDemo{
  
  public static int combine(int a, int b){
    int mult = a * b;
    int sum = mult + a+b;
    return sum;
  }

  public static String info(int x){
    String xInfo = "Number is "+x;
    return xInfo;
  }

  public static void main(String args[]){ 
    int x=2, y=1;
    int ans = combine(x,y);

    int a=6;
    ans = combine(a,a);

    String ansInfo = info(ansx);
    ansInfo = info( combine(5,ans) );

  }
}
