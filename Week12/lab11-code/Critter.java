// Represent a creature of some kind
public class Critter{
  private String kind;
  private String eats;
  private double ferocity;

  public Critter(String kind, double ferocity){
    this.kind = kind;
    ferocity = ferocity;
  }

  public String getEats(){
    return this.eats;
  }

  public void addToMenu(String kind){
    this.eats += kind + " ";
  }

  public static void encounter(Critter a, Critter b){
    if(a.ferocity > b.ferocity){
      System.out.printf("%s would beat %s\n",
                        a.kind,b.kind);
    }
    else if(a.ferocity < b.ferocity){
      System.out.printf("%s would beat %s\n",
                        b.kind,a.kind);
    }
    else{
      System.out.printf("%s and %s grab falafel together\n",
                        b.kind,a.kind);
      
    }
  }
}
