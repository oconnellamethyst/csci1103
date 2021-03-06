// Demonstrate use of OmMeth methods for omelets
// Show output at the commented lines
public class OmeletOps{
  public static void main(String args[]){
    Omelet standard = new Omelet();
    standard.eggs = 2;
    standard.cheese = 4;
    standard.cookedFor = 0.0;
    standard.extras = "ham";

    OmMeth.addEgg(standard);
    OmMeth.cookFor(standard, 2.5);

    int calories = OmMeth.getCalories(standard);
    boolean safe = OmMeth.foodPoisoningIminent(standard);
    
    System.out.printf("Has %d eggs\n",     standard.eggs);  // 1
    System.out.printf("Has %d calories\n", calories);       // 2
    System.out.printf("Safe to eat? %b\n", safe);           // 3

    Omelet coronary = new Omelet();
    coronary.eggs = 6;
    coronary.cheese = 10;

    Omelet richer = OmMeth.richerOmelet(standard, coronary);
    System.out.printf("Richer has %d eggs\n", richer.eggs); // 4
  }
}
