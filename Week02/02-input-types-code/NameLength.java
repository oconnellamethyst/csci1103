// Solution to name length exercise
public class NameLength{
  public static void main(String args[]){
    System.out.println("What's your name?");
    String name = TextIO.getWord();
    int length = name.length();
    System.out.println(name+": did you know your name has "+
                       length+" characters?");

// ALTERNATIVE: print with printf()
// System.out.printf("%s: did you know your name is %d characters?\n",
//                   name, length);
  }
}
