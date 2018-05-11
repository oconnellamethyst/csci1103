// Print all command line arguments using a loop
public class CommandLine{
  public static void main(String args[]){
    System.out.printf("There are %d arguments\n",
		      args.length);
    for(int i=0; i<args.length; i++){
      System.out.printf("Argument %d is %s\n",
			i, args[i]);
    }
  }
}
