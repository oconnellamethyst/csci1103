public class FruitStand{
  public static void main(String args[]){
    System.out.println("How many apples?");
    int apples = TextIO.getInt();
    System.out.println("How many oranges?");
    int oranges = TextIO.getInt();
 //   int oranges = 5;
    System.out.println("apples "+apples);
    System.out.println("oranges "+oranges);
    System.out.println("total "+(apples+oranges));    
    
  } 
}