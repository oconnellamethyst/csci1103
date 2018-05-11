// Demonstrates a couple common patterns in simple methods: error
// check before proceeding with main algorithm and returning in the
// middle of a loop.

public class MethodPatterns{
  // Sum elements in arr[] between start and stop-1. Returns 0 if
  // either start or stop are beyond array bounds.
  public static int sumRange(int arr[], int start, int stop){
    // Check for range of start and stop 
    if(start < 0 || stop > arr.length){
      return 0;
    }
    // Range okay, sum elements
    int sum = 0;
    for(int i=start; i<stop; i++){
      sum += arr[i];
    }
    return sum;
  }

  // Return first index of c in String s. If c is not present in s,
  // return -1.
  public static int containsChar(String s, char c){
    // Search for character c
    for(int i=0; i<s.length(); i++){
      if(s.charAt(i) == c){
        return i;            // found, return
      }
    }
    // all chars checked, none matched c
    return -1;               
  }

  public static void main(String args[]){
    int arr[] = {5, 10, 15, 20, 25, 30};
    System.out.printf("sumRange(arr, 1, 4): %d\n",
                      sumRange(arr, 1, 4));
    System.out.printf("sumRange(arr, 0, 11): %d\n",
                      sumRange(arr, 0, 11));
    System.out.printf("sumRange(arr, -4, 1): %d\n",
                      sumRange(arr, -4, 1));
    
    System.out.printf("containsChar(\"Hello\", 'o'): %d\n",
                      containsChar("Hello",'o'));
    System.out.printf("containsChar(\"Hello\", 'l'): %d\n",
                      containsChar("Hello",'l'));
    System.out.printf("containsChar(\"Hello\", 'z'): %d\n",
                      containsChar("Hello",'z'));


  }
}
