import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class WCTests extends KTests {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("WCTests");
  } 

  @Test public void WC_main1() throws Exception {
    String cmdargs = "names1.txt";
    String expect = 
      "names1.txt : 3 lines, 3 words, 19 chars\n"+
      "";
    String args[] = cmdargs.split(" ");
    WC.main(args);
    String actual = localOut.toString();
    checkOutput(cmdargs,expect,actual);
  }

  @Test public void WC_main2() throws Exception {
    String cmdargs = "names1.txt names2.txt";
    String expect = 
      "names1.txt : 3 lines, 3 words, 19 chars\n"+
      "names2.txt : 8 lines, 18 words, 113 chars\n"+
      "";
    String args[] = cmdargs.split(" ");
    WC.main(args);
    String actual = localOut.toString();
    checkOutput(cmdargs,expect,actual);
  }
  @Test public void WC_main3() throws Exception {
    String cmdargs = "names2.txt names1.txt";
    String expect = 
      "names2.txt : 8 lines, 18 words, 113 chars\n"+
      "names1.txt : 3 lines, 3 words, 19 chars\n"+
      "";
    String args[] = cmdargs.split(" ");
    WC.main(args);
    String actual = localOut.toString();
    checkOutput(cmdargs,expect,actual);
  }
  @Test public void WC_main4() throws Exception {
    String cmdargs = "gettysburg.txt";
    String expect = 
      "gettysburg.txt : 25 lines, 283 words, 1511 chars\n"+
      "";
    String args[] = cmdargs.split(" ");
    WC.main(args);
    String actual = localOut.toString();
    checkOutput(cmdargs,expect,actual);
  }
  @Test public void WC_main5() throws Exception {
    String cmdargs = "gettysburg.txt names1.txt names2.txt gettysburg.txt";
    String expect = 
      "gettysburg.txt : 25 lines, 283 words, 1511 chars\n"+
      "names1.txt : 3 lines, 3 words, 19 chars\n"+
      "names2.txt : 8 lines, 18 words, 113 chars\n"+
      "gettysburg.txt : 25 lines, 283 words, 1511 chars\n"+
      "";
    String args[] = cmdargs.split(" ");
    WC.main(args);
    String actual = localOut.toString();
    checkOutput(cmdargs,expect,actual);
  }
  @Test public void WC_main6() throws Exception {
    String cmdargs = "wordsNumbers1.txt gettysburg.txt wordsNumbers2.txt names1.txt names2.txt";
    String expect = 
      "wordsNumbers1.txt : 1 lines, 3 words, 19 chars\n"+
      "gettysburg.txt : 25 lines, 283 words, 1511 chars\n"+
      "wordsNumbers2.txt : 3 lines, 20 words, 102 chars\n"+
      "names1.txt : 3 lines, 3 words, 19 chars\n"+
      "names2.txt : 8 lines, 18 words, 113 chars\n"+
      "";
    String args[] = cmdargs.split(" ");
    WC.main(args);
    String actual = localOut.toString();
    checkOutput(cmdargs,expect,actual);
  }


  // // Test whether real numbers in space-separated strings can be read;
  // // opens the scanner and passes it on to user function


  // public static void testWC(double expect, String parseString){
  //   Scanner input = new Scanner(parseString);
  //   double actual = ScannerPractice.sumReals(input);
  //   double tolerance = 1e-3;
  //   String msg = String.format("Wrong sum\nString:\n%s\nExpect: %s\nActual: %s\n",
  //                              parseString,expect,actual);
  //   assertEquals(msg,expect,actual,tolerance);
  // }    
  // @Test public void sumReals_Scanner_0() {
  //   testSumReals_Scanner(0.0,"");
  // }
  // @Test public void sumReals_Scanner_1() {
  //   testSumReals_Scanner(-2.1," 0.5 1.2   -3.8");
  // }
  // @Test public void sumReals_Scanner_2() {
  //   testSumReals_Scanner(4.2,"  word 1.0 3.2  ");
  // }
  // @Test public void sumReals_Scanner_3() {
  //   testSumReals_Scanner(5.45," 13 doh! 4 7.65 -22.34\nbarf stuff  3.14  nada");
  // }
  // @Test public void sumReals_Scanner_4() {
  //   testSumReals_Scanner(10.9,"line\n9.9\ndon't\t\t1.0");
  // }
  // @Test public void sumReals_Scanner_5() {
  //   testSumReals_Scanner(201.2,"Punctuation like ! and && as well as 123 or 78.2 are words.  ");
  // }

}
