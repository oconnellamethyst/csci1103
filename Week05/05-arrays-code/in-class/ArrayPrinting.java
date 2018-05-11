// Typical loop to print all elements of an array
public class ArrayPrinting{
  public static
    void main(String args[]) {
    int arr[] = {15, 25, 35, 45, 55, 65};
    
    System.out.printf("Length of array is %d\n",arr.length);
    for(int i=0; i<arr.length; i++){
      System.out.printf("[%d] = %d\n",i,arr[i]);
      System.out.println(arr[i]);
    }
    
    // odd indices
    for(int i=1; i<arr.length; i+=2){
      System.out.printf("[%d] = %d\n",i,arr[i]);
    }
    
    // bigger than 30
    for(int i=0; i<arr.length; i++){
      if(arr[i] > 30){
        System.out.printf("[%d] = %d\n",i,arr[i]);
      }
    }
    
    // reverse
    for(int i=arr.length-1; i>=0; i--){
      System.out.printf("[%d] = %d\n",i,arr[i]);
    }
    
  }
}
