// Demonstrate constructors, first two with name binding problems,
// second two correctly specified
public class OOOmelet{
  public int eggs;
  public int cheese;
  public double cookedFor;
  public String extras;
  
  // NON-STATIC METHODS

  // BAD CONSTRUCTOR 1
  // Names of parameters shadow fields
  public OOOmelet(int eggs, int cheese, String extras){
    eggs = eggs;
    cheese = cheese;
    extras = extras;
    cookedFor = 0.0;
  }

  // // BAD CONSTRUCTOR 2
  // // Local variables shadow field names
  // public OOOmelet(int eg, int ch, String ex) {
  //   int eggs = eg;
  //   int cheese = ch;
  //   String extras = ex;
  //   doulbe cookedFor = 0.0;
  // }

  // // CORRECT CONSTRUCTOR 1
  // // Use this.field to specify field initialization
  // public OOOmelet(int eggs, int cheese, String extras){
  //   this.eggs = eggs;
  //   this.cheese = cheese;
  //   this.extras = extras;
  //   this.cookedFor = 0.0;
  // }

  // // CORRECT CONSTRUCTOR 2
  // // Vary names of parameters to avoid conflicts
  // public OOOmelet(int eg, int ch, String ex){
  //   eggs = eg;
  //   cheese = ch;
  //   extras = ex;
  //   cookedFor = 0.0;
  // }

  public String toString(){
    return
      String.format("%d eggs, %d oz cheese, cooked for %.1f mins, extras: %s",
                    this.eggs, this.cheese, this.cookedFor, this.extras);
  }

  public static void main(String args[]){
    OOOmelet omA = new OOOmelet(3,4,"ham");
    System.out.println(omA.toString());

    OOOmelet omB = new OOOmelet(5,3,"bacon");
    System.out.println(omB.toString());
  }
}
