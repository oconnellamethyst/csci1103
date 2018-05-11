// Guessing game with history staored in an array
public class GuessingHistory{
  public static void main(String args[]) {
    int secret = 42;                            // secret num for guessing
    int maxGuesses = 5;                         // limit guesses
    int history[] = new int[maxGuesses];        // array for history
    int nGuesses = 0;                           // current total guesses
    int guess = -1;                             // current guess
    System.out.printf("Guess between 1 and 100: (Max %d guesses)\n", maxGuesses);

    // Get guesses from user, store in array, break out on correct guess
    for(int i=0; i<maxGuesses; i++){
      guess = TextIO.getInt();
      history[nGuesses] = guess;                // Update history
      nGuesses++;
      if(guess == secret){                      // Check for correct guess
        break;                                  // break from loop
      }
      else if(guess > secret){                  // Hint if not correct
        System.out.println("Too big");
      }
      else if(guess < secret){
        System.out.println("Too small");
      }
    }

    // Could end loop with either a correct guess or running out of
    // guesses, need to figure out which it is
    if(guess == secret){                        // Correct guess
      System.out.printf("Correct! It took you %d guesses which were:\n", nGuesses);
      for(int i=0; i<nGuesses; i++){            // Print history
        System.out.printf("%d ",history[i]);
      }
      System.out.println();
    }
    else{                                       // Ran out of guesses
      System.out.println("Loser!");
    }
  }
}
