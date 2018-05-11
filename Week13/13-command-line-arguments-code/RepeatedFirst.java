public class RepeatedFirst{
  public static void main(String args[]){
    if(args.length == 0){
      System.out.println("No words given");
      return;
    }
    String first = args[0];
    for(int i=1; i<args.length; i++){
      if(first.equals(args[i])){
        System.out.printf("%s repeated at position %d\n",
                          first,i);
        return;
      }
    }
    System.out.printf("%s not repeated\n",first);
  }
}
    
