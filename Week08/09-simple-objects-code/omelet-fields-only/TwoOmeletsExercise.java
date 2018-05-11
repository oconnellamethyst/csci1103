public class TwoOmeletsExercise{
  public static void main(String args[]){
    Omelet om = new Omelet();
    om.eggs = 3;
    om.cheese = 4;
    om.cookedFor = 4.5;
    om.extras = "ham";

    Omelet coronary = new Omelet();
    coronary.eggs = 6;
    coronary.cheese = 10;
    coronary.cookedFor = 6.25;
    coronary.extras = "bacon";

    om.cookedFor += 0.75;           // 1
    coronary.eggs++;                // 2
    om.extras = "turkey";           // 3
    coronary.extras =               // 4
      coronary.extras + " sausage";
    Omelet x = coronary;            // 5
    x.cookedFor += 1.0;             // 6
    om = new Omelet();              // 7
  }
}
