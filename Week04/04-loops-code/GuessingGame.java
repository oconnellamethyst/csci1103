// Demonstrate how user input can affect loops
public class GuessingGame{
  public static
  void main(String args[]) {
    int secret = 42;
    int nGuesses = 0;
    int guess = -1;
    System.out.println("Guess between 1 and 100:");
    while(guess != secret){
      guess = TextIO.getInt();
      nGuesses++;
      if(guess > secret +10){
        System.out.println("Way too big");
      }
      else if(guess > secret){
        System.out.println("A little too big");
      }
      else if(guess < secret-10){
        System.out.println("Way too small");
      }
      else if(guess < secret){
        System.out.println("A little too small");
      }
    }
    System.out.println("Correct! The secret number is "+secret);
    System.out.printf("It took you %d guesses\n",nGuesses);
  }
}
