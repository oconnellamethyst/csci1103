// Simple demonstration of command line args.  Compile and run as
// > java CmdArgs.java
// > java CmdArgs here are 4 args
public class CmdArgs {
  public static void main(String args[]){
    if(args.length >= 4 &&
       args[0].equals("here") &&
       args[1].equals("are") &&
       args[2].equals("4") &&
       args[3].equals("args")){
      System.out.println("Hurray!");
    }
  }
}
