// Count characters in a word using Strings only
public class CountCharString{
  public static void main(String args[]){
    // No need to get length ahead of time if using strings



    System.out.println("Enter a whole word:");
    String word = TextIO.getWord();



    System.out.println("Enter a character to count:");
    char letter = TextIO.getChar();

    int count = 0;
    for(int i=0; i<word.length(); i++){
      if(letter == word.charAt(i)){
        count++;
      }
    }

    System.out.printf("'%c' appears %d times in '%s'\n",
                      letter, count,word);
  }
}
