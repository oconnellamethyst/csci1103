// Typical loop to print all elements of an array
public class ArrayPrintingVariants{
  public static
  void main(String args[]) {
    int arr[] = {15, 25, 35, 45, 55, 65};
    // int arr[] = {15, 25, 35, 22, 55, 65, 17};                         // ALL INDICES  
                                                                         // [0] = 15     
    System.out.printf("Length of array is %d\n",arr.length);             // [1] = 25     
                                                                         // [2] = 35     
    System.out.printf("ALL INDICES\n");             // Print everything  // [3] = 45     
    for(int i=0; i<arr.length; i++){                                     // [4] = 55     
      System.out.printf("[%d] = %d\n",i,arr[i]);                         // [5] = 65     
    }                                                                    // [6] = 13     
                                                                         
    System.out.printf("ODD INDICES\n");
    for(int i=1; i<arr.length; i+=2){               // Print only odd indices
      System.out.printf("[%d] = %d\n",i,arr[i]);
    }

    System.out.printf("ELEMENTS > 30\n");
    for(int i=0; i<arr.length; i++){                // Print elements > 30
      if(arr[i] > 30){
        System.out.printf("[%d] = %d\n",i,arr[i]);
      }
    }

    System.out.printf("EVEN INDICES IN REVERSE\n");
    int start = arr.length-1;                       // Find starting point
    if(arr.length % 2 == 0){                        // odd/even length differences
      start--;
    }
    for(int i=start; i>=0; i-=2){                   // Print even indices in reverse
      System.out.printf("[%d] = %d\n",i,arr[i]);
    }
  }
}
