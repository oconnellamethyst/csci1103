// Static methods to work on Omelet objects
public class OmMeth{
  // Cook the omelet for given time
  public static void cookFor(Omelet om, double time){
    om.cookedFor += time;
  }
  // Add an egg to the omelet
  public static void addEgg(Omelet om){
    om.eggs++;
  }
  // Calculate the calorie count of the basic omelet ingredients.
  public static int getCalories(Omelet om){
    int EGG_CALORIES = 94;
    int CHEESE_OZ_CALORIES = 114;
    return om.eggs     * EGG_CALORIES +
           om.cheese   * CHEESE_OZ_CALORIES;
  }
  // Determine if consumption of the given omelet is risky
  public static boolean foodPoisoningIminent(Omelet om){
    return om.cookedFor < (1.0 * om.eggs);
  }
  // Return a reference to the omelet x or y that has more calories 
  public static Omelet richerOmelet(Omelet x, Omelet y){
    int xCal = getCalories(x);
    int yCal = getCalories(y);
    if(xCal > yCal){
      return x;
    }
    else{
      return y;
    }
  }
}
