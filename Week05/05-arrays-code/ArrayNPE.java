// Throws a NullPointerException
public class ArrayNPE{
  public static void main(String args[]) {
    int arrA[] = new int[]{15, 25, 35};
    arrA = null;
    System.out.printf("arrA[0] = %d\n",arrA[0]);
  }
}
