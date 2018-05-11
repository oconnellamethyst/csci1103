public class SwapMethods{

  // Swap two ints?
  public static void swapIntsP(int x, int y){
    int tmp = x;
    x = y;
    y = tmp;
  }

  // Swap 0th element of two int arrays?
  public static void swapIntsR(int x[], int y[]){
    int tmp = x[0];
    x[0] = y[0];
    y[0] = tmp;
  }

  public static void main(String args[]){
    int a=3, b=5;
    swapIntsP(a,b);
    System.out.printf("a: %d  b: %d\n",
                      a,b);

    int aarr[] = {4}, barr[] = {6};
    swapIntsR(aarr,barr);
    System.out.printf("aarr[0]: %d  barr[0]: %d\n",
                      aarr[0],barr[0]);

    
  }
}
