// Utility routines for tests: open individual problem test files in
// DrJava to run them. Doing
// 
// > java -cp junit-1103.jar:. KTests
//
// will run all tests on the command line.
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;

import java.io.*;
import java.util.*;


public class KTests {
  // Run all tests for this project from the command line
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("VoteTests","TallyTests","ElectionTests");
  } 

  // Default timeout for all testss = 1 second
  @Rule public Timeout globalTimeout = Timeout.seconds(2);

  // Black magic to enable access to name of running test via
  // name.getMethodName(). Useful for creating input/output files
  // based on the name of the test.
  @Rule public TestName name = new TestName();

  // Controls whether actual output is printed on its own
  static boolean SHOW_ACTUAL = true; // false;

  // Used by each test to capture output
  static ByteArrayOutputStream localOut, localErr;
  static PrintStream sysOut, sysErr;

  // Passed to main methods for no arguments
  static String [] empty = {};

  // Save the stdin and stderr as we'll be messing with them for tests
  @BeforeClass
  public static void setUp() throws Exception {
    sysOut = System.out;
    sysErr = System.err;
  }

  // Before every test is run, reset the streams to capture
  // stdout/stderr
  @Before
  public void setUpStreams() {
    localOut = new ByteArrayOutputStream();
    localErr = new ByteArrayOutputStream();
    System.setOut(new PrintStream(localOut));
    System.setErr(new PrintStream(localErr));
  }

  // After every test, restore stdout/stderr
  @After
  public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
    System.setOut(sysOut);
    System.setErr(sysErr);
  }

  // Create a side-by-side diff of two strings compared line by
  // line. Allows multiline headers for both arguments but both
  // headers must have the same number of lines. x and y may differ in
  // number of lines.
  public static String simpleDiff2(String xhead, String x,
                                   String yhead, String y,
                                   String tail)
  {
    String firstDiff = null;
    String xheads[] = xhead.split("\n");
    String yheads[] = yhead.split("\n");
    String xs[] = x.split("\n",-1);
    String ys[] = y.split("\n",-1);
    String sep = "      ";
    String dif = " **** ";
    
    // Calculate the maximum width of all fields
    int maxWidth = 0;
    for(String s : xheads){
      maxWidth = s.length() > maxWidth ? s.length() : maxWidth;
    }
    for(String s : yheads){
      maxWidth = s.length() > maxWidth ? s.length() : maxWidth;
    }
    for(String s : xs){
      maxWidth = s.length() > maxWidth ? s.length() : maxWidth;
    }
    for(String s : ys){
      maxWidth = s.length() > maxWidth ? s.length() : maxWidth;
    }
    maxWidth = tail.length() > maxWidth ? tail.length() : maxWidth;
    // Max width format
    String fmt = String.format("%%-%ds",maxWidth);
    
    // Contents of entire diff
    StringBuilder sb = new StringBuilder();

    // Add on headers
    for(int i = 0; i<xheads.length; i++){
      sb.append(String.format(fmt,xheads[i]));
      sb.append(sep);
      sb.append(String.format(fmt,yheads[i]));
      sb.append("\n");
    }

    // Construct the side-by-side diff
    for(int i = 0; i<xs.length || i<ys.length; i++){
      if(i<xs.length && i<ys.length){ // both exist, compare
        String diffLine = diffLine(xs[i],ys[i],xheads[0],yheads[0]);
        if(diffLine!=null && firstDiff==null){
          firstDiff = String.format("Difference at line %d\n%s",
                                    i,diffLine);
          sb.insert(0,firstDiff);
        }
        sb.append(String.format(fmt,xs[i]));
        String mid = xs[i].equals(ys[i]) ? sep : dif;
        sb.append(mid);
        sb.append(String.format(fmt,ys[i]));
        sb.append("\n");
      }
      else if(i<xs.length){     // only x left
        sb.append(String.format(fmt,xs[i]));
        sb.append(dif);
        sb.append(String.format(fmt,tail));
        sb.append("\n");
      }
      else if(i<ys.length){     // only y left
        sb.append(String.format(fmt,tail));
        sb.append(dif);
        sb.append(String.format(fmt,ys[i]));
        sb.append("\n");
      }
      else{
        throw new RuntimeException("Something fishy's going on here...");
      }
    }
    // Add on tail
    sb.append(String.format(fmt,tail));
    String mid = sep;
    sb.append(mid);
    sb.append(String.format(fmt,tail));
    sb.append("\n");

    return sb.toString();
  }
  
  // Check that the expected and actual output match. If not, show an
  // error message that indicates which lines don't match.
  public static String checkOutput(String args[], String expect, String actual){
    //    String actualNewline = actual.replaceAll("\\r?\\n","\n"); // Eliminate windows linebreaks
    String actualWS = normalizeWhitespace(actual); // eliminate whitespace differences
    String expectWS = normalizeWhitespace(expect); // eliminate whitespace differences
    String msg = "";
    msg += String.format("Output mismatch\n");
    msg += String.format("ARGS[]:\n  %s\n",Arrays.toString(args));
    msg += String.format("OUTPUT:\n  Lines marked with *** differ\n");
    msg += simpleDiff2("EXPECT\n------\n",expectWS,
                       "ACTUAL\n------\n",actualWS,
                       "------");
    if(SHOW_ACTUAL){
      msg += "\n";
      msg += "ACTUAL\n";
      msg += actual;
      msg += "\n";
    }

    assertEquals(msg,expectWS,actualWS);
    return msg;
  }

  private static String slurp(String fname) throws Exception{
    return new Scanner(new File(fname), "UTF-8").useDelimiter("\\Z").next();
  }

  // 
  public static String normalizeWhitespace(String str){
    str = str.replaceAll("\r","");         // eliminate carriage returns for windows
    str = str.replaceAll(" *\n","\n");     // whitespace endings to newline
    str = str.replaceAll("\n{2,}","\n");   // multiple empty lines to none
    str = str.replaceAll("\n{2,}$","\n");  // multiple ending newlines to single
    return str;
  }

  public static String charString(char c){
    if(33 <= c && c <= 126){
      return String.format("%c",c);
    }
    else if(c == ' ') {  return " "; }
    else if(c == '\n'){  return "\\n"; }
    else if(c == '\n'){  return "\\r"; }
    else if(c == '\t'){  return "\\t"; }
    else{
      return String.format("??",c);
    }
  }

  public static String charLongString(char c){
    if(33 <= c && c <= 126){
      return String.format("'%c'",c);
    }
    else if(c == ' ') {  return "' ' (space)"; }
    else if(c == '\n'){  return "'\\n' (newline)"; }
    else if(c == '\n'){  return "'\\r' (carriage return)"; }
    else if(c == '\t'){  return "'\\t' (tab)"; }
    else{
      return String.format("Control Char %d",c);
    }
  }

  public static void append3(String x, StringBuilder xStr,
                             String y, StringBuilder yStr,
                             StringBuilder diff, int i)
  {
    String xs = "", ys = "", ds = "";;
    if(i < x.length()){
      xs = charString(x.charAt(i));
    }
    if(i < y.length()){
      ys = charString(y.charAt(i));
    }
    if(!xs.equals(ys)){
      ds = "^";
    }
    int len = xs.length() > ys.length() ? xs.length() : ys.length();
    String fmt = "%-"+len+"s";
    xStr.append( String.format(fmt,xs) );
    yStr.append( String.format(fmt,ys) );
    if(diff != null){
      diff.append( String.format(fmt,ds) );
    }
  }
    

  public static String diffLine(String x, String y,
                                String xhead, String yhead)
  {
    StringBuilder diff = new StringBuilder();
    StringBuilder xStr = new StringBuilder();
    StringBuilder yStr = new StringBuilder();

    String firstDiff = null;
    int i;
    for(i=0; i<x.length() || i<y.length(); i++){
      append3(x,xStr,y,yStr,diff,i);
      if(i<x.length() && i<y.length()){
        char xc = x.charAt(i);
        char yc = y.charAt(i);
        if(xc != yc){
          firstDiff = "";
          firstDiff += String.format("char %d different\n",i);
          firstDiff += String.format("%s: %s\n",xhead, charLongString(xc));
          firstDiff += String.format("%s: %s\n",yhead, charLongString(yc));
          break;
        }
      }
      else if(i<x.length()){
        firstDiff = "";
        firstDiff += String.format("length different\n",i);
        firstDiff += String.format("%s longer than %s\n",xhead,yhead);
        break;
      }
      else if(i<y.length()){
        firstDiff = "";
        firstDiff += String.format("length different\n",i);
        firstDiff += String.format("%s longer than %s\n",yhead,xhead);
        break;
      }
    }

    if(firstDiff == null){
      return null;
    }

    for(i=i+1; i<x.length(); i++){
      append3(x,xStr,y,yStr,null,i);
    }
    for(; i<y.length(); i++){
      append3(x,xStr,y,yStr,null,i);
    }

    String result = "";
    result += String.format("%s\n",xStr.toString());
    result += String.format("%s\n",yStr.toString());
    result += String.format("%s\n",diff.toString());
    result += String.format("%s\n",firstDiff);
    return result;
  }
      
    

}
