// Count characters in a word using an array
public class CountCharArray{
  public static void main(String args[]){
    System.out.println("Enter word length:");
    int len = TextIO.getInt();
    char word[] = new char[len];

    System.out.println("Enter a whole word:");
    for(int i=0; i<word.length; i++){
      word[i] = TextIO.getChar();
    }

    System.out.println("Enter a character to count:");
    char letter = TextIO.getChar();

    int count = 0;
    for(int i=0; i<word.length; i++){
      if(letter == word[i]){
        count++;
      }
    }

    System.out.printf("'%c' appears %d times in '%s'\n",
                      letter, count,word);
  }
}
