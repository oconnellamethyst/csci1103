public class ArrayAlias{
  public static
  void main(String args[]) {
    int arrA[] = new int[]{15, 25, 35};
    int arrB[] = arrA;          // !!!
    
    arrA[0] = 65;
    arrB[2] = 90;
    
    for(int i=0; i<arrA.length; i++){
      System.out.printf("%d ",arrA[i]);
    }
    System.out.println();
    for(int i=0; i<arrB.length; i++){
      System.out.printf("%d ",arrB[i]);
    }
    System.out.println();

    boolean arrsEqual = arrA == arrB;
    System.out.println(arrsEqual);
  }
}
