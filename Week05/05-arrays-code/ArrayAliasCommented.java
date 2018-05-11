// Demonstrate array aliases: two variables refer to the same array
public class ArrayAliasCommented{
  public static
  void main(String args[]) {
    int arrA[] = new int[]{15, 25, 35};
    int arrB[] = arrA;          // alias for arrA

    arrA[0] = 65;               // changes both
    arrB[2] = 90;               // changes both

    // Both arrays are now point at same memory with
    //  {65, 25, 90};
    for(int i=0; i<arrA.length; i++){
      System.out.printf("%d ",arrA[i]);
    }
    System.out.println();
    for(int i=0; i<arrB.length; i++){
      System.out.printf("%d ",arrB[i]);
    }
    System.out.println();

    boolean arrsEqual = arrA == arrB; // point to same location
    System.out.println(arrsEqual);    // true
  }
}
