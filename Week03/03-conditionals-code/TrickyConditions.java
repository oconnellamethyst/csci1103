public class TrickyConditions{
  public static void main(String args[]){
    int sum = 0, a=5, b=7;
    boolean addA = true;
    boolean addB = false;
    boolean div2 = true;

    if(addA){
      sum = sum + a;
      addB = true;
      div2 = false;
    }
    if(addB){
      sum = sum + b;
    }
    else{
      sum = sum - b;
    }      
    if(div2){
      sum = sum / 2;
      addA = false;
    }
    else{
      sum = sum*2;
    }
    System.out.printf("sum: %d\n",sum); 
    System.out.printf("addA: %s\n",addA);
    System.out.printf("addB: %s\n",addB);
    System.out.printf("div2: %s\n",div2);
  }
}
