import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class Problem3Tests extends KTests {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem3Tests");
  } 

  // Write parseString to a file then ask user code to read them in
  // and some existing numbers
  public void testSumReals_File(double expect, String parseString){
    double actual = -1.0;
    try{
      String filename = String.format("%s_input.txt",this.name.getMethodName());
      PrintWriter out = new PrintWriter(filename);
      out.print(parseString);
      out.close();
      actual = ScannerPractice.sumRealsInFile(filename);
      String msg = String.format("Wrong sum\nFile %s contents:\n%s\nExpect: %s\nActual: %s\n",
                                 filename,parseString,expect,actual);
      double tolerance = 1e-3;
      assertEquals(msg,expect,actual,tolerance);
    } catch(Exception e){
      fail(e.getMessage());
    }
  }    
  @Test public void test_sumReals_File_0() {
    testSumReals_File(0.0,"");
         
  }
  @Test public void test_sumReals_File_1() {
    testSumReals_File(-2.1," 0.5 1.2   -3.8");
  }
  @Test public void test_sumReals_File_2() {
    testSumReals_File(4.2,"  word 1.0 3.2  ");
  }
  @Test public void test_sumReals_File_3() {
    testSumReals_File(5.45," 13 doh! 4 7.65 -22.34\nbarf stuff  3.14  nada");
  }
  @Test public void test_sumReals_File_4() {
    testSumReals_File(10.9,"line\n9.9\ndon't\t\t1.0");
  }
  @Test public void test_sumReals_File_5() {
    testSumReals_File(201.2,"Punctuation like ! and && as well as 123 or 78.2 are words.  ");
  }

}
