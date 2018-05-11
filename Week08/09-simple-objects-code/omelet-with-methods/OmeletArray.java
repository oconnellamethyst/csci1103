// Demonstrate assigning objects (Omelets) to an 
// array of objects. This program has a bug.
public class OmeletArray{
  public static void main(String args[]){
    Omelet omArray[] = new Omelet[5];
    omArray[0] = new Omelet();
    omArray[0].eggs = 2;
    omArray[0].cheese = 4;
    omArray[0].extras = "ham mushroom";

    omArray[1] = new Omelet();
    for(int i=0; i<4; i++){
      Omelet.addEgg(omArray[1]);
    }
    omArray[1].cheese = 3;
    omArray[1].cookedFor = 1.0;

    for(int i=3; i<omArray.length; i++){
      omArray[i] = new Omelet();
      omArray[i].eggs = i;
      omArray[i].cheese = i/2;
      omArray[i].extras = "";
    }

    for(int i=0; i<omArray.length; i++){
      System.out.printf("Om: %d eggs, %d cheese,",
                omArray[i].eggs, omArray[i].cheese);

      System.out.printf("%.1f cooked, %s extras\n",
            omArray[i].cookedFor, omArray[i].extras);
    }      
  }
}
