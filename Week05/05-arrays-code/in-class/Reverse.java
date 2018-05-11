public class Reverse{
  public static void main(String args[]){
    System.out.println("Enter seq len:");
    int inputSize = TextIO.getInt();
    int sequence[] = new int[inputSize];
    System.out.println("Enter sequence:");

   for(int i=0; i<inputSize; i++){ 
//     for(int i=sequence.length-1; i>=0; i--){
//      sequence[i] = TextIO.getInt();
    }

   for(int i=0; i<sequence.length/2; i++){
     int tmp = sequence[i];
     sequence[i] = sequence[sequence.length -i -1];
     sequence[sequence.length -i -1] = tmp;
   }
   
   System.out.println("Sequence in reverse:");
    for(int i=0; i<inputSize; i++){ 
      System.out.printf("%d ",sequence[i]);
    }
    System.out.println();
  }
}
      