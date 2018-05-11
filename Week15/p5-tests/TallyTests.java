import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class TallyTests extends KTests {
  // Main method runs tests in this file
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("TallyTests");
  } 

  @Test public void tally_constructor_empty() {
    String cands [] = {  };
    Tally t = new Tally(cands);
    assertEquals(cands.length, t.size());
  }

  @Test public void tally_constructor_1() {
    String cands [] = {"Viktor"};
    Tally t = new Tally(cands);
    assertEquals(cands.length, t.size());
  }
  @Test public void tally_constructor_2() {
    String cands [] = {"Francis","Claire","Heather","Viktor"};
    Tally t = new Tally(cands);
    assertEquals(cands.length, t.size());
  }
  @Test public void tally_constructor_3() {
    String cands [] = {"Claire","Francis","Heather"};
    Tally t = new Tally(cands);
    assertEquals(cands.length, t.size());
  }
  @Test public void tally_constructor_4() {
    String cands [] = {"A","B","C","D","E","F","G","H"};
    Tally t = new Tally(cands);
    assertEquals(cands.length, t.size());
  }

  public void check_toString_zero_counts(String cands[], String expect){
    Tally tally = new Tally(cands);
    assertEquals(cands.length, tally.size());
    String actual = tally.toString();
    String msg = "";
    msg += String.format("Tally toString incorrect\n");
    msg += String.format("candidates[]: %s\n",Arrays.toString(cands));
    msg += String.format("EXPECT: %s\n",expect);
    msg += String.format("ACTUAL: %s\n",actual);
    assertEquals(msg,expect,actual);    
  }

  @Test public void tally_zero_counts_toString_empty() {
    String cands [] = {  };
    String expect = "Tally{}";
    check_toString_zero_counts(cands,expect);
  }
  @Test public void tally_zero_counts_toString_1() {
    String cands [] = {"Viktor"};
    String expect = "Tally{Viktor:0}";
    check_toString_zero_counts(cands,expect);
  }
  @Test public void tally_zero_counts_toString_2() {
    String cands [] = {"Francis","Claire","Heather","Viktor"};
    String expect = "Tally{Francis:0, Claire:0, Heather:0, Viktor:0}";
    check_toString_zero_counts(cands,expect);
  }
  @Test public void tally_zero_counts_toString_3() {
    String cands [] = {"Francis","Claire","Heather","Viktor"};
    String expect = "Tally{Francis:0, Claire:0, Heather:0, Viktor:0}";
    check_toString_zero_counts(cands,expect);
  }
  @Test public void tally_zero_counts_toString_4() {
    String cands [] = {"A","B","C","D","E","F","G","H"};
    String expect = "Tally{A:0, B:0, C:0, D:0, E:0, F:0, G:0, H:0}";
    check_toString_zero_counts(cands,expect);
  }


  @Test public void tally_contains_1() {
    String cands [] = {"Viktor"};
    Tally tally = new Tally(cands);
    assertTrue(  tally.contains(new String("Viktor")  ));
    assertFalse( tally.contains(new String("Francis") ));
    assertFalse( tally.contains(new String("Claire")  ));
    assertFalse( tally.contains(new String("Heather") ));
    assertFalse( tally.contains(new String("Freddy")  ));
    assertFalse( tally.contains(new String("Zoe")     ));
  }
  @Test public void tally_contains_2() {
    String cands [] = {"Francis","Claire","Heather","Viktor"};
    Tally tally = new Tally(cands);
    assertTrue(  tally.contains(new String("Francis") ));
    assertTrue(  tally.contains(new String("Claire")  ));
    assertTrue(  tally.contains(new String("Heather") ));
    assertTrue(  tally.contains(new String("Viktor")  ));
    assertFalse( tally.contains(new String("Freddy")  ));
    assertFalse( tally.contains(new String("Zoe")     ));
  }
  @Test public void tally_contains_3() {
    String cands [] = {"Francis","Claire","Heather","Viktor","Zoe","Freddy"};
    Tally tally = new Tally(cands);
    assertTrue( tally.contains( new String("Francis") ));
    assertTrue( tally.contains( new String("Claire")  ));
    assertTrue( tally.contains( new String("Heather") ));
    assertTrue( tally.contains( new String("Viktor")  ));
    assertTrue( tally.contains( new String("Freddy")  ));
    assertTrue( tally.contains( new String("Zoe")     ));
  }
  @Test public void tally_contains_4() {
    String cands [] = {"A","B","C","D","E","F","G","H"};
    Tally tally = new Tally(cands);
    for(String cand : cands){
      assertTrue( tally.contains(new String(cand)) );
    }
    String nots [] = {"Z","Y","X","W"};
    for(String not : nots){
      assertFalse( tally.contains(new String(not)) );
    }
  }

  
  public void check_countVote(String tcands[], String voteStrs[],
                              String expectString, int expectTotal)
  {
    Tally tally = new Tally(tcands);
    for(String voteStr : voteStrs){
      tally.countVote(voteStr);
    }
    String actualString = tally.toString();
    int actualTotal  = tally.totalVotes();
    String msg = "";
    msg += String.format("Tally countVote() wrong\n"); 
    msg += String.format("tally cands[]: %s\n",Arrays.toString(tcands));
    msg += String.format("voteStrs[]:    %s\n",Arrays.toString(voteStrs));
    msg += String.format("EXPECT toString(): %s\n",expectString);
    msg += String.format("ACTUAL toString(): %s\n",actualString);
    msg += String.format("EXPECT totalVotes(): %s\n",expectTotal);
    msg += String.format("ACTUAL totalVotes(): %s\n",actualTotal);
    assertEquals(msg,expectString,actualString);    
    assertEquals(msg,expectTotal,actualTotal);    
  }


  @Test public void tally_countVote1() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Heather",
    };
    String expectString = "Tally{Francis:0, Heather:1}";
    int expectTotal = voteStrs.length;
    check_countVote(tcands,voteStrs,expectString,expectTotal);
  }
  @Test public void tally_countVote2() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Francis",
    };
    String expectString = "Tally{Francis:1, Heather:0}";
    int expectTotal = voteStrs.length;
    check_countVote(tcands,voteStrs,expectString,expectTotal);
  }
  @Test public void tally_countVote3() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Francis",
      "Francis",
      "Heather",
      "Francis",
    };
    String expectString = "Tally{Francis:3, Heather:1}";
    int expectTotal = voteStrs.length;
    check_countVote(tcands,voteStrs,expectString,expectTotal);
  }
  @Test public void tally_countVote4() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStrs[] = {
      "Francis",
      "Francis",
      "Heather",
      "Francis",
      "Viktor",
    };
    String expectString = "Tally{Francis:3, Claire:0, Heather:1, Viktor:1}";
    int expectTotal = voteStrs.length;
    check_countVote(tcands,voteStrs,expectString,expectTotal);
  }
  @Test public void tally_countVote5() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStrs[] = {
      "Viktor",
      "Viktor",
      "Francis",
      "Francis",
      "Claire",
      "Heather",
      "Francis",
      "Heather",
      "Viktor",
      "Heather",
      "Claire",
      "Viktor",
      "Heather",
      "Heather",
    };
    String expectString = "Tally{Francis:3, Claire:2, Heather:5, Viktor:4}";
    int expectTotal = voteStrs.length;
    check_countVote(tcands,voteStrs,expectString,expectTotal);
  }
  @Test public void tally_countVote6() {
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String voteStrs[] = {
      "F","B","D","F","H","A","G","C","H","H","H","G","F","F","H","F","C","E","C",
      "A","E","A","D","C","H","B","B","B","D","F","B","F","H","G","D","D","B","F",
      "G","B","H","D","F","C","D","D","F","C","G","C",
    };
    String expectString = "Tally{A:3, B:7, C:7, D:8, E:2, F:10, G:5, H:8}";
    int expectTotal = voteStrs.length;
    check_countVote(tcands,voteStrs,expectString,expectTotal);
  }
  @Test public void tally_countVote_exception1() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStr = "Freddie";
    String expectMsg = "'Freddie' not in Tally{Francis:0, Claire:0, Heather:0, Viktor:0}";
      
    Tally tally = new Tally(tcands);
    try{
      tally.countVote(voteStr);
    }
    catch(RuntimeException e){
      String actualMsg = e.getMessage();
      String msg = "";
      msg += String.format("Exception message wrong\n");
      msg += String.format("expect: %s\n",expectMsg);
      msg += String.format("actual: %s\n",actualMsg);
      assertEquals(msg, expectMsg, actualMsg);
      assertEquals(0,tally.totalVotes());
    }
    String msg = "";
    msg += String.format("Should have thrown exception with message:\n");
    msg += String.format("%s\n",expectMsg);
  }
  @Test public void tally_countVote_exception2() {
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String voteStr = "Z";
    String expectMsg = "'Z' not in Tally{A:0, B:0, C:0, D:0, E:0, F:0, G:0, H:0}";
      
    Tally tally = new Tally(tcands);
    try{
      tally.countVote(voteStr);
    }
    catch(RuntimeException e){
      String actualMsg = e.getMessage();
      String msg = "";
      msg += String.format("Exception message wrong\n");
      msg += String.format("expect: %s\n",expectMsg);
      msg += String.format("actual: %s\n",actualMsg);
      assertEquals(msg, expectMsg, actualMsg);
      assertEquals(0,tally.totalVotes());
    }
    String msg = "";
    msg += String.format("Should have thrown exception with message:\n");
    msg += String.format("%s\n",expectMsg);
  }

  public void check_outputString(String tcands[], String voteStrs[],
                                 String expectString)
  {
    Tally tally = new Tally(tcands);
    for(String voteStr : voteStrs){
      tally.countVote(voteStr);
    }
    String actualString = tally.outputString();
    String msg = "";
    msg += String.format("Tally outputString() wrong\n"); 
    msg += String.format("tally cands[]: %s\n",Arrays.toString(tcands));
    msg += String.format("voteStrs[]:    %s\n",Arrays.toString(voteStrs));
    msg += String.format("EXPECT outputString():\n------------\n%s------------\n",expectString);
    msg += String.format("ACTUAL outputString():\n------------\n%s------------\n",actualString);
    assertEquals(msg,expectString,actualString);    
  }

  @Test public void tally_outputString1() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Heather",
    };
    String expectString =
      "CNT     % NAME\n"+
      "  0   0.0 Francis\n"+
      "  1 100.0 Heather\n"+
      "";
    check_outputString(tcands,voteStrs,expectString);
  }
  @Test public void tally_outputString2() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Francis",
    };
    String expectString =
      "CNT     % NAME\n"+
      "  1 100.0 Francis\n"+
      "  0   0.0 Heather\n"+
      "";
    check_outputString(tcands,voteStrs,expectString);
  }
  @Test public void tally_outputString3() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Francis",
      "Francis",
      "Heather",
      "Francis",
    };
    String expectString =
      "CNT     % NAME\n"+
      "  3  75.0 Francis\n"+
      "  1  25.0 Heather\n"+
      "";
    check_outputString(tcands,voteStrs,expectString);
  }
  @Test public void tally_outputString4() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStrs[] = {
      "Francis",
      "Francis",
      "Heather",
      "Francis",
      "Viktor",
    };
    String expectString =
      "CNT     % NAME\n"+
      "  3  60.0 Francis\n"+
      "  0   0.0 Claire\n"+
      "  1  20.0 Heather\n"+
      "  1  20.0 Viktor\n"+
      "";
    check_outputString(tcands,voteStrs,expectString);
  }
  @Test public void tally_outputString5() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStrs[] = {
      "Viktor",
      "Viktor",
      "Francis",
      "Francis",
      "Claire",
      "Heather",
      "Francis",
      "Heather",
      "Viktor",
      "Heather",
      "Claire",
      "Viktor",
      "Heather",
      "Heather",
    };
    String expectString =
      "CNT     % NAME\n"+
      "  3  21.4 Francis\n"+
      "  2  14.3 Claire\n"+
      "  5  35.7 Heather\n"+
      "  4  28.6 Viktor\n"+
      "";
    check_outputString(tcands,voteStrs,expectString);
  }
  @Test public void tally_outputString6() {
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String voteStrs[] = {
      "F","B","D","F","H","A","G","C","H","H","H","G","F","F","H","F","C","E","C",
      "A","E","A","D","C","H","B","B","B","D","F","B","F","H","G","D","D","B","F",
      "G","B","H","D","F","C","D","D","F","C","G","C",
    };
    String expectString =
      "CNT     % NAME\n"+
      "  3   6.0 A\n"+
      "  7  14.0 B\n"+
      "  7  14.0 C\n"+
      "  8  16.0 D\n"+
      "  2   4.0 E\n"+
      " 10  20.0 F\n"+
      "  5  10.0 G\n"+
      "  8  16.0 H\n"+
      "";
    check_outputString(tcands,voteStrs,expectString);
  }
  @Test public void tally_outputString7() {
    String tcands [] = {"A","B","C","D","E","F","G"};
    String voteStrs[] = {
      "F","B","D","F","A","G","C","G","F","F","F","C","E","C",
      "A","E","A","D","C","B","B","B","D","F","B","F","G","D","D","B","F",
      "G","B","D","F","C","D","D","F","C","G","C",
    };
    String expectString =
      "CNT     % NAME\n"+
      "  3   7.1 A\n"+
      "  7  16.7 B\n"+
      "  7  16.7 C\n"+
      "  8  19.0 D\n"+
      "  2   4.8 E\n"+
      " 10  23.8 F\n"+
      "  5  11.9 G\n"+
      "";
    check_outputString(tcands,voteStrs,expectString);
  }


  public void check_getWinner(String tcands[], String voteStrs[],
                              String expectString)
  {
    Tally tally = new Tally(tcands);
    for(String voteStr : voteStrs){
      tally.countVote(voteStr);
    }
    String actualString = tally.getWinner();
    String msg = "";
    msg += String.format("Tally getWinner() wrong\n"); 
    msg += String.format("tally cands[]: %s\n",Arrays.toString(tcands));
    msg += String.format("voteStrs[]:    %s\n",Arrays.toString(voteStrs));
    msg += String.format("EXPECT getWinner(): %s\n",expectString);
    msg += String.format("ACTUAL getWinner(): %s\n",actualString);
    msg += String.format("outputString(): %s\n",tally.outputString());
    assertEquals(msg,expectString,actualString);    
  }

  @Test public void tally_getWinner1() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Heather",
    };
    String expectString = "Heather";
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner2() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Francis",
    };
    String expectString = "Francis";
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner3() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Francis",
      "Francis",
      "Heather",
      "Francis",
    };
    String expectString = "Francis";
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner4() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStrs[] = {
      "Francis",
      "Francis",
      "Heather",
      "Francis",
      "Viktor",
    };
    String expectString = "Francis";
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner5() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStrs[] = {
      "Viktor",
      "Viktor",
      "Francis",
      "Francis",
      "Claire",
      "Heather",
      "Francis",
      "Heather",
      "Viktor",
      "Heather",
      "Claire",
      "Viktor",
      "Heather",
      "Heather",
    };
    String expectString = null;
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner6() {
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String voteStrs[] = {
      "F","B","D","F","H","A","G","C","H","H","H","G","F","F","H","F","C","E","C",
      "A","E","A","D","C","H","B","B","B","D","F","B","F","H","G","D","D","B","F",
      "G","B","H","D","F","C","D","D","F","C","G","C",
    };
    String expectString = null;
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner7() {
    String tcands [] = {"A","B","C","D","E","F","G"};
    String voteStrs[] = {
      "F","B","D","F","A","G","C","G","F","F","F","C","E","C",
      "A","E","A","D","C","B","B","B","D","F","B","F","G","D","D","B","F",
      "G","B","D","F","C","D","D","F","C","G","C",
    };
    String expectString = null;
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner8() {
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String voteStrs[] = {
      "F","B","D","F","H","A","G","C","H","H","H","G","F","F","H","F","C","E","C",
      "A","E","A","D","C","H","B","B","B","D","F","B","F","H","G","D","D","B","F",
      "G","B","H","D","F","C","D","D","F","C","G","C",
      "F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F",
      "F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F",
    };
    String expectString = "F";
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner9() {
    String tcands [] = {"A","B","C","D"};
    String voteStrs[] = {
      "A","B","A","B","A","B","A","B",
      "C","C",
    };
    String expectString = null;
    check_getWinner(tcands,voteStrs,expectString);
  }
  @Test public void tally_getWinner10() {
    String tcands [] = {"A","B","C","D"};
    String voteStrs[] = {
      "A","B","A","B","A","B","A","B",
      "C","C","C","C",
    };
    String expectString = null;
    check_getWinner(tcands,voteStrs,expectString);
  }

  public void check_getMinCandidates(String tcands[], String voteStrs[],
                                     String expectString)
  {
    Tally tally = new Tally(tcands);
    for(String voteStr : voteStrs){
      tally.countVote(voteStr);
    }
    String actual[] = tally.getMinCandidates();
    String actualString = Arrays.toString(actual);
    String msg = "";
    msg += String.format("Tally getMinCandidates() wrong\n"); 
    msg += String.format("tally cands[]: %s\n",Arrays.toString(tcands));
    msg += String.format("voteStrs[]:    %s\n",Arrays.toString(voteStrs));
    msg += String.format("EXPECT getMinCandidates(): %s\n",expectString);
    msg += String.format("ACTUAL getMinCandidates(): %s\n",actualString);
    msg += String.format("outputString(): %s\n",tally.outputString());
    assertEquals(msg,expectString,actualString);    
  }

  @Test public void tally_getMinCandidates01() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Heather",
    };
    String expectString = "[Francis]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates02() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Francis",
    };
    String expectString = "[Heather]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates03() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Francis",
      "Francis",
      "Heather",
      "Francis",
    };
    String expectString = "[Heather]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates04() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStrs[] = {
      "Francis",
      "Francis",
      "Heather",
      "Francis",
      "Viktor",
    };
    String expectString = "[Claire]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates05() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String voteStrs[] = {
      "Viktor",
      "Viktor",
      "Francis",
      "Francis",
      "Claire",
      "Heather",
      "Francis",
      "Heather",
      "Viktor",
      "Heather",
      "Claire",
      "Viktor",
      "Heather",
      "Heather",
    };
    String expectString = "[Claire]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates06() {
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String voteStrs[] = {
      "F","B","D","F","H","A","G","C","H","H","H","G","F","F","H","F","C","E","C",
      "A","E","A","D","C","H","B","B","B","D","F","B","F","H","G","D","D","B","F",
      "G","B","H","D","F","C","D","D","F","C","G","C","E",
    };
    String expectString = "[A, E]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates07() {
    String tcands [] = {"A","B","C","D","E","F","G"};
    String voteStrs[] = {
      "F","B","D","F","A","G","C","G","F","F","F","C","E","C",
      "A","E","A","D","C","B","B","B","D","F","B","F","G","D","D","B","F",
      "G","B","D","F","C","D","D","F","C","G","C","E","A","A","E","E",
    };
    String expectString = "[A, E, G]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates08() {
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String voteStrs[] = {
      "F","B","D","F","H","A","G","C","H","H","H","G","F","F","H","F","C","E","C",
      "A","E","A","D","C","H","B","B","B","D","F","B","F","H","G","D","D","B","F",
      "G","B","H","D","F","C","D","D","F","C","G","C",
      "A","A","A","A","E","E","E","E","E","E","G","G",
      "F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F",
      "F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F",
    };
    String expectString = "[A, B, C, G]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates09() {
    String tcands [] = {"A","B","C"};
    String voteStrs[] = {
      "A","B","A","B","A","B","A","B",
      "C","C",
    };
    String expectString = "[C]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }
  @Test public void tally_getMinCandidates10() {
    String tcands [] = {"A","B","C"};
    String voteStrs[] = {
      "A","B","A","B","A","B","A","B",
      "C","C","C","C",
    };
    String expectString = "[A, B, C]";
    check_getMinCandidates(tcands,voteStrs,expectString);
  }


  public void check_allWayTie(String tcands[], String voteStrs[],
                              boolean expect)
  {
    Tally tally = new Tally(tcands);
    for(String voteStr : voteStrs){
      tally.countVote(voteStr);
    }
    boolean actual = tally.allWayTie();
    String msg = "";
    msg += String.format("Tally allWayTie() wrong\n"); 
    msg += String.format("tally cands[]: %s\n",Arrays.toString(tcands));
    msg += String.format("voteStrs[]:    %s\n",Arrays.toString(voteStrs));
    msg += String.format("EXPECT allWayTie(): %s\n",expect);
    msg += String.format("ACTUAL allWayTie(): %s\n",actual);
    msg += String.format("outputString(): %s\n",tally.outputString());
    assertEquals(msg,expect,actual);    
  }


  @Test public void tally_allWayTie01() {
    String tcands [] = {"A","B","C"};
    String voteStrs[] = {
      "A","B","A","B","A","B","A","B",
      "C","C",
    };
    boolean expect = false;
    check_allWayTie(tcands,voteStrs,expect);
  }
  @Test public void tally_allWayTie02() {
    String tcands [] = {"A","B","C"};
    String voteStrs[] = {
      "A","B","A","B","A","B","A","B",
      "C","C","C","C",
    };
    boolean expect = true;
    check_allWayTie(tcands,voteStrs,expect);
  }
  @Test public void tally_allWayTie03() {
    String tcands [] = {"A","B","C","D"};
    String voteStrs[] = {
      "A","B","A","B","A","B","A","B",
      "C","C","C","C",
    };
    boolean expect = false;
    check_allWayTie(tcands,voteStrs,expect);
  }
  @Test public void tally_allWayTie04() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Heather",
    };
    boolean expect = false;
    check_allWayTie(tcands,voteStrs,expect);
  }
  @Test public void tally_allWayTie05() {
    String tcands [] = {"Francis","Heather"};
    String voteStrs[] = {
      "Heather", "Francis", "Heather", "Francis",
      "Heather", "Francis", "Heather", "Francis",
    };
    boolean expect = true;
    check_allWayTie(tcands,voteStrs,expect);
  }
  @Test public void tally_allWayTie06() {
    String tcands [] = {"Francis","Heather","Claire","Viktor"};
    String voteStrs[] = {
      "Heather", "Francis", "Heather", "Francis",
      "Heather", "Francis", "Heather", "Francis",
    };
    boolean expect = false;
    check_allWayTie(tcands,voteStrs,expect);
  }
  @Test public void tally_allWayTie07() {
    String tcands [] = {"Francis","Heather","Claire","Viktor"};
    String voteStrs[] = {
      "Heather", "Francis", "Heather", "Francis",
      "Claire","Viktor", "Claire","Viktor",
      "Heather", "Francis", "Heather", "Francis",
      "Claire","Viktor", "Claire","Viktor",
    };
    boolean expect = true;
    check_allWayTie(tcands,voteStrs,expect);
  }


  public void check_eliminate(String tcands[], String origVotes[],
                              String elim, String elimVotes[],
                              String expectOrig, String expectElim)
  {
    Tally origTally = new Tally(tcands);
    for(String vote : origVotes){
      origTally.countVote(vote);
    }
    Tally elimTally = origTally.eliminate(elim);
    for(String vote : elimVotes){
      elimTally.countVote(vote);
    }
    String actualOrig = origTally.toString();
    String actualElim = elimTally.toString();
    String msg = "";
    msg += String.format("Tally eliminate() problems\n");
    msg += String.format("EXPECT original:   %s\n",expectOrig);
    msg += String.format("ACTUAL original:   %s\n",actualOrig);
    msg += String.format("EXPECT eliminated: %s\n",expectElim);
    msg += String.format("ACTUAL eliminated: %s\n",actualElim);
    assertEquals(msg,expectOrig,actualOrig);    
    assertEquals(msg,expectElim,actualElim);    
  }

  @Test public void tally_eliminate01() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String origVotes[] = {
    };
    String elim = "Heather";
    String elimVotes[] = {
    };
    String expectOrig = "Tally{Francis:0, Claire:0, Heather:0, Viktor:0}";
    String expectElim = "Tally{Francis:0, Claire:0, Viktor:0}";
    check_eliminate(tcands, origVotes, elim, elimVotes, expectOrig, expectElim);
  }
  @Test public void tally_eliminate02() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String origVotes[] = {
      "Francis","Claire",
    };
    String elim = "Heather";
    String elimVotes[] = {
    };
    String expectOrig = "Tally{Francis:1, Claire:1, Heather:0, Viktor:0}";
    String expectElim = "Tally{Francis:0, Claire:0, Viktor:0}";
    check_eliminate(tcands, origVotes, elim, elimVotes, expectOrig, expectElim);
  }
  @Test public void tally_eliminate03() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String origVotes[] = {
      "Francis","Claire","Heather","Heather",
    };
    String elim = "Heather";
    String elimVotes[] = {
    };
    String expectOrig = "Tally{Francis:1, Claire:1, Heather:2, Viktor:0}";
    String expectElim = "Tally{Francis:0, Claire:0, Viktor:0}";
    check_eliminate(tcands, origVotes, elim, elimVotes, expectOrig, expectElim);
  }
  @Test public void tally_eliminate04() {
    String tcands [] = {"Viktor"};
    String origVotes[] = {
      "Viktor",
    };
    String elim = "Viktor";
    String elimVotes[] = {
    };
    String expectOrig = "Tally{Viktor:1}";
    String expectElim = "Tally{}";
    check_eliminate(tcands, origVotes, elim, elimVotes, expectOrig, expectElim);
  }
  @Test public void tally_eliminate05() {
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String origVotes[] = {
      "Francis","Claire","Heather","Viktor","Francis","Claire","Viktor",
    };
    String elim = "Viktor";
    String elimVotes[] = {
      "Francis","Claire","Heather","Francis","Francis","Claire","Francis",
    };
    String expectOrig = "Tally{Francis:2, Claire:2, Heather:1, Viktor:2}";
    String expectElim = "Tally{Francis:4, Claire:2, Heather:1}";
    check_eliminate(tcands, origVotes, elim, elimVotes, expectOrig, expectElim);
  }

  @Test public void tally_eliminate_multiple01() {
    String tcands [] = {"Francis","Claire","Freddie","Heather","Viktor"};
    Tally orig = new Tally(tcands);
    Tally elim1 = orig.eliminate("Claire");
    assertEquals("Tally{Francis:0, Freddie:0, Heather:0, Viktor:0}",elim1.toString());
    Tally elim2 = elim1.eliminate("Francis");
    assertEquals("Tally{Freddie:0, Heather:0, Viktor:0}",elim2.toString());
    Tally elim3 = elim2.eliminate("Viktor");
    assertEquals("Tally{Freddie:0, Heather:0}",elim3.toString());
    Tally elim4 = elim3.eliminate("Heather");
    assertEquals("Tally{Freddie:0}",elim4.toString());
    Tally elim5 = elim4.eliminate("Freddie");
    assertEquals("Tally{}",elim5.toString());
  }

  public void check_readTallyFromFile(String fname, String expectString) throws Exception
  {
    Tally tally = Tally.readTallyFromFile(fname);
    String actualString = tally.toString();
    String msg = "";
    msg += String.format("Tally.readTallyFromFile() incorrect\n");
    msg += String.format("File Name: %s\n",fname);
    msg += String.format("EXPECT: %s\n",expectString);
    msg += String.format("ACTUAL: %s\n",actualString);
    assertEquals(msg,expectString,actualString);    
  }
  
  @Test public void tally_readTallyFromFile01() throws Exception {  
    String filename = "votes-standard.txt";
    String expectString = "Tally{Francis:0, Claire:0, Heather:0, Viktor:0}";
    check_readTallyFromFile(filename,expectString);    
  }
  @Test public void tally_readTallyFromFile02() throws Exception {  
    String filename = "votes-drop2.txt";
    String expectString = "Tally{Francis:0, Claire:0, Heather:0, Viktor:0}";
    check_readTallyFromFile(filename,expectString);    
  }
  @Test public void tally_readTallyFromFile03() throws Exception {  
    String filename = "votes-many.txt";
    String expectString = "Tally{A:0, B:0, C:0, D:0, E:0, F:0, G:0, H:0}";
    check_readTallyFromFile(filename,expectString);    
  }
  @Test public void tally_readTallyFromFile04() throws Exception {  
    String filename = "votes-5cands.txt";
    String expectString = "Tally{A:0, B:0, C:0, D:0, E:0}";
    check_readTallyFromFile(filename,expectString);    
  }
  @Test public void tally_readTallyFromFile05() throws Exception {  
    String filename = "votes-3cands.txt";
    String expectString = "Tally{Francis:0, Freddie:0, Edmond:0}";
    check_readTallyFromFile(filename,expectString);    
  }

}
