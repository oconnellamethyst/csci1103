public class OmeletMain{
  public static void main(String args[]){
    Omelet om = new Omelet();
    om.eggs = 3;
    om.cheese = 4;
    om.cookedFor = 4.5;
    om.extras = "ham";
    System.out.printf("Omelet has %d eggs\n",om.eggs);
    System.out.printf("Omelet has %d oz cheese\n",om.cheese);
    System.out.printf("Omelet cooked for %.1f minutes\n",om.cookedFor);
    System.out.printf("Omelet has these extras: %s\n",om.extras);
  }
}
