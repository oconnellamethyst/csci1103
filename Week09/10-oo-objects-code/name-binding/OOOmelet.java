// In-class exercise to match use of bare names (LETTERS) to
// declarations (NUMBERS)
public class OOOmelet{
  private int eggs;                  // 1
  private int cheese;                // 2
  private double cookedFor;          // 3
  private String extras;             // 4

  public int getEggs(){              // 5
    return eggs; //// A
  }

  public void cookFor(double time){ 
    double cookedFor =               // 6
      this.cookedFor;  //// B
    cookedFor += time; //// C
  }

  public void addCheese(int cheese){ // 7
    cheese += cheese;
    //// D   and   E
  }

  public boolean foodPoisoningIminent(){
    return cookedFor < (1.0 * getEggs());
    ////       F                G 
  }
}
