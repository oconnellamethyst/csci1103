public class OOOmeletMain{
  public static void main(String args[]){
    OOOmelet small = new OOOmelet(2,5,"ham");
    
    small.addEgg();
    small.cookFor(1.5);

    System.out.println(small);

    OOOmelet large = new OOOmelet(5,8,"bacon");

    int cals = large.getCalories();

    boolean moreEggs = small.moreEggsThan(large);

  }
}
