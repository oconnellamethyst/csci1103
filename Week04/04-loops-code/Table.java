// Prints a small table of numbers
public class Table{
  public static void main(String args[]){
    int rows=5, cols=7;
    System.out.printf("%d by %d table\n",
                      rows,cols);

    // OUTER LOOP: print a whole
    // row per iteration
    for(int i=0; i<rows; i++){
      // Print at beginning of row
      System.out.printf("Row %d : ",i);

      // INNER LOOP: Print rest of row,
      // 1 iteration per column
      for(int j=0; j<cols; j++){
        System.out.printf("%d%d ",i,j);
      }

      // Print end of row
      System.out.printf(" : done\n");
    }
  }
}
