// Demonstrates a NullPointerException with Omelets
public class NullOmelet{
  public static void main(String args[]){
    Omelet anOm = new Omelet();
    anOm.eggs = 2;
    anOm.cheese = 4;
    Omelet noOm = null;

    Omelet richer = Omelet.richerOmelet(anOm, noOm);
    System.out.printf("Richer has %d eggs\n", richer.eggs);
  }
}
