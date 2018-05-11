public class LoopExercises{
  public static void main(String args[]){

    // LOOP A
    int n = 18;
    int mf = n-1;
    while(n % mf != 0){
      mf--;
    }
    System.out.printf("n: %d  mf: %d\n",
                      n,mf);

    // LOOP B
    int p = 1;
    int e = 0;
    while(e < 10){
      System.out.printf("2^%d = %d\n",e,p);
      p *= 2;
      e++;
    }

  }
}
