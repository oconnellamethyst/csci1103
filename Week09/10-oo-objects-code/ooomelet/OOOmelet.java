// Represent data associated with an omelet and the non-static methods
// that operate on it.
public class OOOmelet{
  // FIELDS
  public int eggs;              // How many eggs in the omelet
  public int cheese;            // How many ounces of cheese
  public double cookedFor;      // How long the omelet has cooked
  public String extras;         // Extra ingredients added

  // NON-STATIC METHODS

  // Constructor to initialize fields to given values. cookedFor is
  // always initialized to 0.0.
  public OOOmelet(int eggs, int cheese, String extras){
    this.eggs = eggs;
    this.cheese = cheese;
    this.extras = extras;
    this.cookedFor = 0.0;
  }


  // Cook the omelet for given time
  public void cookFor(double time){
    this.cookedFor += time;
  }
  // Add an egg to the omelet
  public void addEgg(){
    this.eggs++;
  }

  // Calculate the calorie count of the basic omelet ingredients.
  public int getCalories(){
    int EGG_CALORIES = 94;
    int CHEESE_OZ_CALORIES = 114;
    return this.eggs     * EGG_CALORIES +
           this.cheese   * CHEESE_OZ_CALORIES;
  }
  // Determine if consumption of the given omelet is risky
  public boolean foodPoisoningIminent(){
    return this.cookedFor < (1.0 * this.eggs);
  }

  // Return a reference to the omelet x or y that has more calories 
  public static OOOmelet richerOOOmelet(OOOmelet x, OOOmelet y){
    int xCal = x.getCalories();
    int yCal = y.getCalories();
    if(xCal > yCal){
      return x;
    }
    else{
      return y;
    }
  }
  
  // Create a pretty string version of the OOOmelet.
  public String toString(){
    return
      String.format("%d eggs, %d oz cheese, cooked for %.1f mins, extras: %s",
                    this.eggs, this.cheese, this.cookedFor, this.extras);
  }
}
