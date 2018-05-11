public class Concat{
  public static void main(String args[]){
    String a = "hi";
    String b = "gh";
    String c = a+b;             // high
    String d = a.concat(b);     // high

    int count = 5;
    String req = "I want "+count+" apples";

    String ans = "";
    for(int i=0; i<10; i++){
      ans = ans + i + " ";
    }
    System.out.println(ans);
  }
}
