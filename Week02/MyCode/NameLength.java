public class NameLength {
      
    /** A program that asks for the name
      * and gives back the length of the name
      * Uses TextIO
      */
    
    public static void main(String[] args) {
       System.out.println("What's your name?");
       String name = TextIO.getWord();
       int length = name.length();
       System.out.println("The name " + name + " has " + length + " characters!");
       
    }

}