public class SimpleWhile{
  public static void main(String args[]){
    System.out.println("Loop for 10 iterations");
    int i = 0;
    while(i < 10){
      System.out.printf("i is %d\n",i);
      i = i+1;
      // or i += 1;
      // or i++;
    }
    System.out.println("Done with loop");
  }
}
