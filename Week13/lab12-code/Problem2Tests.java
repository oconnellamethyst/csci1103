import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class Problem2Tests extends KTests {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem2Tests");
  } 

  // Test whether reading from string version is available
  public static void testSumReals_String(double expect, String parseString){
    double actual = ScannerPractice.sumReals(parseString);
    double tolerance = 1e-3;
    String msg = String.format("Wrong sum\nString:\n%s\nExpect: %s\nActual: %s\n",
                               parseString,expect,actual);
    assertEquals(msg,expect,actual,tolerance);
  }    
  @Test public void sumReals_String_0() {
    testSumReals_String(0.0,"");
  }
  @Test public void sumReals_String_1() {
    testSumReals_String(-2.1," 0.5 1.2   -3.8");
  }
  @Test public void sumReals_String_2() {
    testSumReals_String(4.2,"  word 1.0 3.2  ");
  }
  @Test public void sumReals_String_3() {
    testSumReals_String(5.45," 13 doh! 4 7.65 -22.34\nbarf stuff  3.14  nada");
  }
  @Test public void sumReals_String_4() {
    testSumReals_String(10.9,"line\n9.9\ndon't\t\t1.0");
  }
  @Test public void sumReals_String_5() {
    testSumReals_String(201.2,"Punctuation like ! and && as well as 123 or 78.2 are words.  ");
  }

}
