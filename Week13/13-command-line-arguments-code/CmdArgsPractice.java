public class CmdArgsPractice{
  public static void main(String args[]){
    boolean verboseMode = false;
    boolean exitImmediately = false;
    for(int i=0; i<args.length; i++){
      System.out.printf("args[%d] is %s\n",i,args[i]);
      if(args[i].equals("-verbose")){
        verboseMode = true;
      }
      else if(args[i].equals("-exit")){
        exitImmediately = true;
      }
    }
    if(exitImmediately){
      //System.exit(10);
      return;
    }
    
    System.out.println(verboseMode);
    
    if(verboseMode){
      System.out.println("Extra information");
    }
  }
}