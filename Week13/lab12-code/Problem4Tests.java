import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class Problem4Tests extends KTests {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("Problem4Tests");
  } 

  // Write strings to file named after test then ask user code to read
  // them in and some existing numbers
  public void test_readNamesFromFile(String expect[]){
    try{
      String filename = String.format("%s_input.txt",this.name.getMethodName());
      PrintWriter out = new PrintWriter(filename);
      for(String s : expect){
        out.println(s);
      }
      out.close();
      String actual[] = ScannerPractice.readNamesFromFile(filename);
      String msg = "";
      msg += String.format("\nnames read from %s incorrect\n",filename);
      msg += String.format("Expect: %s\n",Arrays.toString(expect));
      msg += String.format("Actual: %s\n",Arrays.toString(actual));
      assertEquals(msg,expect, actual);
    }
    catch(Exception e){
      fail(e.getMessage());
    }
  }    
  @Test public void test_readNamesFromFile_single() {
    String names[] = {
      "Lily",
    };
    test_readNamesFromFile(names);
  }
  @Test public void test_readNamesFromFile_simple() {
    String names[] = {
      "Nicole",
      "Tyler",
      "Devon",
    };
    test_readNamesFromFile(names);
  }
  @Test public void test_readNamesFromFile_mutipart() {
    String names[] = {
      "Revolio Clockberg Jr.",
    };
    test_readNamesFromFile(names);
  }
  @Test public void test_readNamesFromFile_many() {
    String names[] = {
      "Luke Cage",
      "Jessica Jones",
      "Matt Murdock",
      "Danny Iron Fist Rand",
      "Elektra Nachios",
      "Alexandra",
      "Madame Gao",
      "Wilson Grant Fisk",
    };
    test_readNamesFromFile(names);
  }

  @Test public void test_readNamesFromFile_empty() {
    String names[] = {
    };
    test_readNamesFromFile(names);
  }

}
