public class ForLoops{
  public static void main(String args[]){

    int count = 20;
    for(int i=0; i<count; i++){
      System.out.println("Looping");
      System.out.printf("i is %d\n",i);
    }

    System.out.println();

    for(int twoPow=1; twoPow<1024; twoPow*=2){
      System.out.printf("%d ",twoPow);
    }
    System.out.println();
  }
}
