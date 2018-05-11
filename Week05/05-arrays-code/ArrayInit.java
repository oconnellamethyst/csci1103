// All these create roughly equivalent
// arrays with 3 elements: 15, 25, 35
public class ArrayInit{
  public static
  void main(String args[]) {
    int arrA[];
    arrA = new int[3];
    arrA[0] = 15;
    arrA[1] = 25;
    arrA[2] = 35;

    int arrB[] = new int[3];
    arrB[0] = 15;
    arrB[1] = 25;
    arrB[2] = 35;
    
    int arrC[] = {15, 25, 35};

    int arrD[];
    arrD = new int[]{15, 25, 35};

    int arrE[];
    // DOESN'T WORK
    // arrE = {15, 25, 35};
  }
}
