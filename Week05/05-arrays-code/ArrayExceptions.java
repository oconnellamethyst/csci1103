public class ArraysDistinct{
  public static void main(String args[]) {
    int arrA[] = new int[]{15, 25, 35};
    int arrB[] = new int[arrA.length];   // same size as arrA
    for(int i=0; i<arrA.length; i++){    // copy arrA elements 
      arrB[i] = arrA[i];                 // to arrB
    }
    
    arrA[0] = 65;                        // only arrA changed
    arrB[2] = 90;                        // only arrB changed
    
    // arrA is {65, 25, 35}
    // arrB is {15, 25, 90}
    for(int i=0; i<arrA.length; i++){
      System.out.printf("%d ",arrA[i]);
    }
    System.out.println();
    for(int i=0; i<arrB.length; i++){
      System.out.printf("%d ",arrB[i]);
    }
    System.out.println();

    boolean arrsEqual = arrA == arrB;    // different locations
    System.out.println(arrsEqual);       // false
  }
}
