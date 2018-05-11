import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class MultTableTests extends KTests{

  // Main method runs this file's tests
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("MultTableTests");
  } 

  ////////////////////////////////////////////////////////////////////////////////
  // Tests

  @Test public void MultTable_main1() {
    String input = "2 3";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter max rows and columns: (ex: 4 6)\n"+
      "        1   2   3 \n"+
      "    +-------------\n"+
      "  1 |   1   2   3 \n"+
      "  2 |   2   4   6 \n"+
      "";
    MultTable.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MultTable_main2() {
    String input = "1 5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter max rows and columns: (ex: 4 6)\n"+
      "        1   2   3   4   5 \n"+
      "    +---------------------\n"+
      "  1 |   1   2   3   4   5 \n"+
      "";
    MultTable.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MultTable_main3() {
    String input = "11 1";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter max rows and columns: (ex: 4 6)\n"+
      "        1 \n"+
      "    +-----\n"+
      "  1 |   1 \n"+
      "  2 |   2 \n"+
      "  3 |   3 \n"+
      "  4 |   4 \n"+
      "  5 |   5 \n"+
      "  6 |   6 \n"+
      "  7 |   7 \n"+
      "  8 |   8 \n"+
      "  9 |   9 \n"+
      " 10 |  10 \n"+
      " 11 |  11 \n"+
      "";
    MultTable.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MultTable_main4() {
    String input = "9 3";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter max rows and columns: (ex: 4 6)\n"+
      "        1   2   3 \n"+
      "    +-------------\n"+
      "  1 |   1   2   3 \n"+
      "  2 |   2   4   6 \n"+
      "  3 |   3   6   9 \n"+
      "  4 |   4   8  12 \n"+
      "  5 |   5  10  15 \n"+
      "  6 |   6  12  18 \n"+
      "  7 |   7  14  21 \n"+
      "  8 |   8  16  24 \n"+
      "  9 |   9  18  27 \n"+
      "";
    MultTable.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MultTable_main5() {
    String input = "12 14";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter max rows and columns: (ex: 4 6)\n"+
      "        1   2   3   4   5   6   7   8   9  10  11  12  13  14 \n"+
      "    +---------------------------------------------------------\n"+
      "  1 |   1   2   3   4   5   6   7   8   9  10  11  12  13  14 \n"+
      "  2 |   2   4   6   8  10  12  14  16  18  20  22  24  26  28 \n"+
      "  3 |   3   6   9  12  15  18  21  24  27  30  33  36  39  42 \n"+
      "  4 |   4   8  12  16  20  24  28  32  36  40  44  48  52  56 \n"+
      "  5 |   5  10  15  20  25  30  35  40  45  50  55  60  65  70 \n"+
      "  6 |   6  12  18  24  30  36  42  48  54  60  66  72  78  84 \n"+
      "  7 |   7  14  21  28  35  42  49  56  63  70  77  84  91  98 \n"+
      "  8 |   8  16  24  32  40  48  56  64  72  80  88  96 104 112 \n"+
      "  9 |   9  18  27  36  45  54  63  72  81  90  99 108 117 126 \n"+
      " 10 |  10  20  30  40  50  60  70  80  90 100 110 120 130 140 \n"+
      " 11 |  11  22  33  44  55  66  77  88  99 110 121 132 143 154 \n"+
      " 12 |  12  24  36  48  60  72  84  96 108 120 132 144 156 168 \n"+
      "";
    MultTable.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void MultTable_main6() {
    String input = "4 4";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "Enter max rows and columns: (ex: 4 6)\n"+
      "        1   2   3   4 \n"+
      "    +-----------------\n"+
      "  1 |   1   2   3   4 \n"+
      "  2 |   2   4   6   8 \n"+
      "  3 |   3   6   9  12 \n"+
      "  4 |   4   8  12  16 \n"+
      "";
    MultTable.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
}
