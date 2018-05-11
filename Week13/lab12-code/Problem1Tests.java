import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class Problem1Tests extends KTests {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem1Tests");
  } 

  // Test whether real numbers in space-separated strings can be read;
  // opens the scanner and passes it on to user function
  public static void testSumReals_Scanner(double expect, String parseString){
    Scanner input = new Scanner(parseString);
    double actual = ScannerPractice.sumReals(input);
    double tolerance = 1e-3;
    String msg = String.format("Wrong sum\nString:\n%s\nExpect: %s\nActual: %s\n",
                               parseString,expect,actual);
    assertEquals(msg,expect,actual,tolerance);
  }    
  @Test public void sumReals_Scanner_0() {
    testSumReals_Scanner(0.0,"");
  }
  @Test public void sumReals_Scanner_1() {
    testSumReals_Scanner(-2.1," 0.5 1.2   -3.8");
  }
  @Test public void sumReals_Scanner_2() {
    testSumReals_Scanner(4.2,"  word 1.0 3.2  ");
  }
  @Test public void sumReals_Scanner_3() {
    testSumReals_Scanner(5.45," 13 doh! 4 7.65 -22.34\nbarf stuff  3.14  nada");
  }
  @Test public void sumReals_Scanner_4() {
    testSumReals_Scanner(10.9,"line\n9.9\ndon't\t\t1.0");
  }
  @Test public void sumReals_Scanner_5() {
    testSumReals_Scanner(201.2,"Punctuation like ! and && as well as 123 or 78.2 are words.  ");
  }

}
