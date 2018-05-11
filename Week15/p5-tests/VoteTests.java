import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class VoteTests extends KTests {
  // Main method runs tests in this file
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("VoteTests");
  } 

  @Test public void vote_constructor_empty() {
    String cands [] = {  };
    int ranks[]     = {  };
    Vote v = new Vote(cands, ranks);
  }
  @Test public void vote_constructor_1() {
    String cands [] = {"Viktor"};
    int ranks[]     = {0  };
    Vote v = new Vote(cands, ranks);
  }
  @Test public void vote_constructor_2() {
    String cands [] = {"Francis","Claire","Heather","Viktor"};
    int ranks[]     = {0,        1,       2,        3      };
    Vote v = new Vote(cands, ranks);
  }
  @Test public void vote_constructor_3() {
    String cands [] = {"Francis","Claire","Heather","Viktor"};
    int ranks[]     = {2,        0,       3,        1      };
    Vote v = new Vote(cands, ranks);
  }
  @Test public void vote_constructor_4() {
    String cands [] = {"A","B","C","D","E","F","G","H"};
    int ranks[]     = { 6,  4,  7,  3,  5,  0,  2,  1 };
    Vote v = new Vote(cands, ranks);
  }

  public void check_toString(String cands[], int ranks[], String expect){
    Vote v = new Vote(cands, ranks);
    String actual = v.toString();
    String msg = "";
    msg += String.format("Vote toString incorrect\n");
    msg += String.format("candidates[]: %s\n",Arrays.toString(cands));
    msg += String.format("ranks[]:      %s\n",Arrays.toString(ranks));
    msg += String.format("EXPECT: %s\n",expect);
    msg += String.format("ACTUAL: %s\n",actual);
    assertEquals(msg,expect,actual);    
  }

  @Test public void vote_toString_empty() {
    String cands [] = {  };
    int ranks[]     = {  };
    String expect = "Vote{}";
    check_toString(cands,ranks,expect);
  }
  @Test public void vote_toString_1() {
    String cands [] = {"Viktor"};
    int ranks[]     = {0  };
    String expect = "Vote{Viktor}";
    check_toString(cands,ranks,expect);
  }
  @Test public void vote_toString_2() {
    String cands [] = {"Francis","Claire","Heather","Viktor"};
    int ranks[]     = {0,        1,       2,        3      };
    String expect = "Vote{Francis, Claire, Heather, Viktor}";
    check_toString(cands,ranks,expect);
  }
  @Test public void vote_toString_3() {
    String cands [] = {"Francis","Claire","Heather","Viktor"};
    int ranks[]     = {2,        0,       3,        1      };
    String expect = "Vote{Claire, Viktor, Francis, Heather}";
    check_toString(cands,ranks,expect);
  }
  @Test public void vote_toString_4() {
    String cands [] = {"A","B","C","D","E","F","G","H"};
    int ranks[]     = { 6,  4,  7,  3,  5,  0,  2,  1 };
    String expect = "Vote{F, H, G, D, B, E, A, C}";
    check_toString(cands,ranks,expect);
  }

  // @Test public void vote_deepCopy() {
  //   String cands [] = {"Francis","Claire","Heather","Viktor"};
  //   int ranks[]     = {0,        1,       2,        3      };
  //   String candsOriginal = Arrays.toString(cands);
  //   String expect = "Vote{Francis, Claire, Heather, Viktor}";
  //   Vote vote = new Vote(cands,ranks);
  //   String voteOriginal = vote.toString();
  //   cands[0] = "A"; cands[1]="B"; cands[2]="C"; cands[3]="D"; // Modify array to see if things change in vote
  //   String candsAfter = Arrays.toString(cands);
  //   String voteAfter = vote.toString();
  //   String msg = "";
  //   msg += String.format("Vote toString incorrect\n");
  //   msg += String.format("Likely cause is shallow copy of candidates array\n");
  //   msg += String.format("Original cands[]: %s\n",candsOriginal);
  //   msg += String.format("vote.toString():  %s\n",voteOriginal);
  //   msg += String.format("Changed cands:    %s\n",candsAfter);
  //   msg += String.format("vote.toString():  %s\n",voteAfter);
  //   msg += String.format("EXPECT:           %s\n",expect);
  //   assertEquals(msg,expect,voteAfter);
  // }


  public void check_getBest(String vcands[], int vranks[],
                            String tcands[], String expect)
  {
    Vote vote = new Vote(vcands, vranks);
    Tally tally = new Tally(tcands);
    String actual = vote.getBest(tally);
    String msg = "";
    msg += String.format("Vote getBest() incorrect\n");
    msg += String.format("vote cands[]:  %s\n",Arrays.toString(vcands));
    msg += String.format("vote ranks[]:  %s\n",Arrays.toString(vranks));
    msg += String.format("tally cands[]: %s\n",Arrays.toString(tcands));
    msg += String.format("Vote:  %s\n",vote.toString());
    msg += String.format("Tally: %s\n",tally.toString());
    msg += String.format("EXPECT: %s\n",expect);
    msg += String.format("ACTUAL: %s\n",actual);
    assertEquals(msg,expect,actual);    
  }


  @Test public void vote_getBest_empty1() {
    String vcands [] = {  };
    int vranks[]     = {  };
    String tcands [] = {"Francis","Heather"};
    String expect = null;
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_empty2() {
    String vcands [] = {  };
    int vranks[]     = {  };
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String expect = null;
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_single1() {
    String vcands [] = {"Viktor"};
    int vranks[]     = { 0 };
    String tcands [] = {"Francis","Heather"};
    String expect = null;
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_single2() {
    String vcands [] = {"Viktor"};
    int vranks[]     = { 0 };
    String tcands [] = {"Viktor"};
    String expect = "Viktor";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_single3() {
    String vcands [] = {"Viktor"};
    int vranks[]     = { 0 };
    String tcands [] = {"Francis","Viktor"};
    String expect = "Viktor";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_mult1() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 0,        1,       2,       3,     };
    String tcands [] = {"Francis","Viktor"};
    String expect = "Francis";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_mult2() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 0,        1,       2,       3,     };
    String tcands [] = {"Viktor","Francis"};
    String expect = "Francis";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_mult3() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 0,        1,       2,       3,     };
    String tcands [] = {"Viktor","Heather","Claire"};
    String expect = "Claire";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_mult4() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 0,        1,       2,       3,     };
    String tcands [] = {"Viktor","Heather","Francis","Claire"};
    String expect = "Francis";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_ranks1() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 2,        1,       0,       3,     };
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String expect = "Heather";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_ranks2() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 2,        1,       0,       3,     };
    String tcands [] = {"Francis","Viktor"};
    String expect = "Francis";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_ranks3() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 1,        3,       2,       0,     };
    String tcands [] = {"Francis","Viktor"};
    String expect = "Viktor";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_ranks4() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 1,        3,       2,       0,     };
    String tcands [] = {"Francis","Claire","Heather","Viktor"};
    String expect = "Viktor";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_ranks5() {
    String vcands [] = {"Francis","Claire","Heather","Viktor"};
    int vranks[]     = { 1,        3,       2,       0,     };
    String tcands [] = {"Claire","Heather",};
    String expect = "Heather";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_large1() {
    String vcands [] = {"A","B","C","D","E","F","G","H"};
    int vranks[]     = { 6,  4,  7,  3,  5,  0,  2,  1 };
    String tcands [] = {"A","B","C","D","E","F","G","H"};
    String expect = "F";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_large2() {
    String vcands [] = {"A","B","C","D","E","F","G","H"};
    int vranks[]     = { 6,  4,  7,  3,  5,  0,  2,  1 };
    String tcands [] = {"A","B","C","D","E"};
    String expect = "D";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_large3() {
    String vcands [] = {"A","B","C","D","E","F","G","H"};
    int vranks[]     = { 6,  4,  7,  3,  5,  0,  2,  1 };
    String tcands [] = {"D","A","F","E","C","H","G","B"};
    String expect = "F";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_large4() {
    String vcands [] = {"A","B","C","D","E","F","G","H"};
    int vranks[]     = { 6,  4,  7,  3,  5,  0,  2,  1 };
    String tcands [] = {"D","E","C","G","B"};
    String expect = "G";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_large5() {
    String vcands [] = {"A","B","C","D","E","F","G","H"};
    int vranks[]     = { 6,  4,  7,  3,  5,  0,  2,  1 };
    String tcands [] = {"C","B","E"};
    String expect = "B";
    check_getBest(vcands,vranks,tcands,expect);
  }
  @Test public void vote_getBest_large6() {
    String vcands [] = {"A","B","C","D","E","F","G","H"};
    int vranks[]     = { 6,  4,  7,  3,  5,  0,  2,  1 };
    String tcands [] = {"C"};
    String expect = "C";
    check_getBest(vcands,vranks,tcands,expect);
  }
  

}
