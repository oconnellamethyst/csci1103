public class InteractiveSum2{
  public static
  void main(String args[]) {
    
    // quit value is -1
    boolean keepGoing = true;
    int sum = 0;
    while(keepGoing){           // loop until reach count
      System.out.println("Enter an integer:");
      int value = TextIO.getInt();
      if(value == -1){
        keepGoing = false;
      }
      else{
        sum += value;             // update sum
      }
    }
    

    
//    int sum = 0;
//    int value = 1;
//    while(value != 0){
//      System.out.println("Enter an integer:");
//      value = TextIO.getInt(); 
//      sum += value;             // update sum
//    }
//   
//    
      
      
    
    System.out.printf("Sum is %d\n",sum);
  }
}
