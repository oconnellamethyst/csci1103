public class CritCompare{
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
