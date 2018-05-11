// Find the max of 5 numbers given by
// user using a loop
// 
// This program has fixed the scope
// problem of ScopeProblem.java
public class Max5Loop{
  public static void main(String args[]){
    System.out.println("Enter 5 numbers:");
    int max = TextIO.getInt();
    for(int i=1; i<5; i++){
      int value = TextIO.getInt();
      if( value > max ){
        max = value;
      }
    }
    System.out.printf("max is %d\n",max);
  }
}
