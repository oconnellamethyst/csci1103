// Represent data associated with an omelet and the non-static methods
// that operate on it. This version has private fields and additional
// methods to access those private fields.
public class OOOmelet{
  // FIELDS are private: cannot be accessed outside this file
  private int eggs;              // How many eggs in the omelet
  private int cheese;            // How many ounces of cheese
  private double cookedFor;      // How long the omelet has cooked
  private String extras;         // Extra ingredients added

  // NON-STATIC METHODS

  // Constructor to initialize fields to given values. cookedFor is
  // always initialized to 0.0.
  public OOOmelet(int eggs, int cheese, String extras){
    this.eggs = eggs;
    this.cheese = cheese;
    this.extras = extras;
    this.cookedFor = 0.0;
  }

  // ACCESSORS

  // Retrieve number of eggs
  public int getEggs(){
    return this.eggs;
  }
  // Retrieve amount of cheese
  public int getCheese(){
    return this.cheese;
  }
  // Retrieve amount of time cooked
  public double getCookTime(){
    return this.cookedFor;
  }
  // Retrieve extra ingredients
  public String getExtras(){
    return this.extras;
  }

  // MUTATORS

  // Cook the omelet for given time
  public void cookFor(double time){
    this.cookedFor += time;
  }

  // Add an egg to the omelet
  public void addEgg(){
    if(this.cookedFor > 0){
      System.out.println("Yuck");
    }
    else{
      this.eggs++;
    }
  }

  // OTHER METHODS

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


  // Return true if this omelet has more eggs than the parameter
  // omelet
  public boolean moreEggsThan(OOOmelet that){
    if(this.eggs > that.eggs){
      return true;
    }
    else{
      return false;
    }
  }
    
}
