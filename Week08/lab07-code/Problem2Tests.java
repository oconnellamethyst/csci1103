import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class Problem2Tests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem2Tests");
  } 
  
  // Tests for printArray()
  public void check_printArray(String expectS,
                               String iLabel, String vLabel, int [] arr)
  {
    Collatz.printArray(iLabel,vLabel,arr);
    String actualS = localOut.toString();
    String msg =
      String.format("Collatz.printArray(\"%s\",\"%s\",%s)\n",iLabel,vLabel,Arrays.toString(arr)) +
      String.format("EXPECT:\n%s\n", expectS) +
      String.format("ACTUAL:\n%s\n", actualS) +
      "";
    assertEquals(msg,expectS,actualS);
  }    

  @Test public void Problem2_printArray1() {
    String iLabel = "I";
    String vLabel = "STUFF";
    int [] arr = {1, 2, 3, 4, 5};
    String expect =
      "     I  STUFF\n"+
      "     0      1\n"+
      "     1      2\n"+
      "     2      3\n"+
      "     3      4\n"+
      "     4      5\n"+
      "";
    check_printArray(expect,iLabel,vLabel,arr);
  }
  @Test public void Problem2_printArray2() {
    String iLabel = "STEP";
    String vLabel = "VALUE";
    int [] arr = {5, 16, 8, 4, 2, 1};
    String expect =
      "  STEP  VALUE\n"+
      "     0      5\n"+
      "     1     16\n"+
      "     2      8\n"+
      "     3      4\n"+
      "     4      2\n"+
      "     5      1\n"+
      "";
    check_printArray(expect,iLabel,vLabel,arr);
  }
  @Test public void Problem2_printArray3() {
    String iLabel = "INDEX";
    String vLabel = "VALUE";
    int [] arr = {2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    String expect =
      " INDEX  VALUE\n"+
      "     0   2048\n"+
      "     1   1024\n"+
      "     2    512\n"+
      "     3    256\n"+
      "     4    128\n"+
      "     5     64\n"+
      "     6     32\n"+
      "     7     16\n"+
      "     8      8\n"+
      "     9      4\n"+
      "    10      2\n"+
      "    11      1\n"+
      "";
    check_printArray(expect,iLabel,vLabel,arr);
  }
  @Test public void Problem2_printArray4() {
    String iLabel = "AAA";
    String vLabel = "BBBBB";
    int [] arr = {99, 98, 97, 96, 123456, 92, 91, 90};
    String expect =
      "   AAA  BBBBB\n"+
      "     0     99\n"+
      "     1     98\n"+
      "     2     97\n"+
      "     3     96\n"+
      "     4 123456\n"+
      "     5     92\n"+
      "     6     91\n"+
      "     7     90\n"+
      "";
    check_printArray(expect,iLabel,vLabel,arr);
  }
  @Test public void Problem2_printArray5() {
    String iLabel = "EXP";
    String vLabel = "POW3";
    int [] arr = {1,3,9,27,81,243,729};
    String expect =
      "   EXP   POW3\n"+
      "     0      1\n"+
      "     1      3\n"+
      "     2      9\n"+
      "     3     27\n"+
      "     4     81\n"+
      "     5    243\n"+
      "     6    729\n"+
      "";
    check_printArray(expect,iLabel,vLabel,arr);
  }

}
