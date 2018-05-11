import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class ElectionTests extends KTests {
  // Main method runs tests in this file
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("ElectionTests");
  } 

  @Test public void election_usage() throws Exception{
    String args[] = {};
    String expect =
      "usage: java Election <votes.txt>\n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }

  @Test public void election_standard() throws Exception{
    String args[] = {"votes-standard.txt"};
    String expect =
      "votes-standard.txt : 12 votes read\n"+
      "Round 1 : 4 candidates Tally{Francis:0, Claire:0, Heather:0, Viktor:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Viktor, Heather, Claire} Tally{Francis:1, Claire:0, Heather:0, Viktor:0}\n"+
      " 1 : Claire     Vote{Claire, Francis, Heather, Viktor} Tally{Francis:1, Claire:1, Heather:0, Viktor:0}\n"+
      " 2 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:1, Claire:1, Heather:1, Viktor:0}\n"+
      " 3 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:1, Claire:1, Heather:2, Viktor:0}\n"+
      " 4 : Claire     Vote{Claire, Francis, Heather, Viktor} Tally{Francis:1, Claire:2, Heather:2, Viktor:0}\n"+
      " 5 : Francis    Vote{Francis, Heather, Claire, Viktor} Tally{Francis:2, Claire:2, Heather:2, Viktor:0}\n"+
      " 6 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:3, Claire:2, Heather:2, Viktor:0}\n"+
      " 7 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:3, Claire:2, Heather:3, Viktor:0}\n"+
      " 8 : Heather    Vote{Heather, Francis, Claire, Viktor} Tally{Francis:3, Claire:2, Heather:4, Viktor:0}\n"+
      " 9 : Viktor     Vote{Viktor, Francis, Heather, Claire} Tally{Francis:3, Claire:2, Heather:4, Viktor:1}\n"+
      "10 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:4, Claire:2, Heather:4, Viktor:1}\n"+
      "11 : Heather    Vote{Heather, Francis, Claire, Viktor} Tally{Francis:4, Claire:2, Heather:5, Viktor:1}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  4  33.3 Francis\n"+
      "  2  16.7 Claire\n"+
      "  5  41.7 Heather\n"+
      "  1   8.3 Viktor\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: Viktor\n"+
      "\n"+
      "Round 2 : 3 candidates Tally{Francis:0, Claire:0, Heather:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Viktor, Heather, Claire} Tally{Francis:1, Claire:0, Heather:0}\n"+
      " 1 : Claire     Vote{Claire, Francis, Heather, Viktor} Tally{Francis:1, Claire:1, Heather:0}\n"+
      " 2 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:1, Claire:1, Heather:1}\n"+
      " 3 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:1, Claire:1, Heather:2}\n"+
      " 4 : Claire     Vote{Claire, Francis, Heather, Viktor} Tally{Francis:1, Claire:2, Heather:2}\n"+
      " 5 : Francis    Vote{Francis, Heather, Claire, Viktor} Tally{Francis:2, Claire:2, Heather:2}\n"+
      " 6 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:3, Claire:2, Heather:2}\n"+
      " 7 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:3, Claire:2, Heather:3}\n"+
      " 8 : Heather    Vote{Heather, Francis, Claire, Viktor} Tally{Francis:3, Claire:2, Heather:4}\n"+
      " 9 : Francis    Vote{Viktor, Francis, Heather, Claire} Tally{Francis:4, Claire:2, Heather:4}\n"+
      "10 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:5, Claire:2, Heather:4}\n"+
      "11 : Heather    Vote{Heather, Francis, Claire, Viktor} Tally{Francis:5, Claire:2, Heather:5}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  5  41.7 Francis\n"+
      "  2  16.7 Claire\n"+
      "  5  41.7 Heather\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: Claire\n"+
      "\n"+
      "Round 3 : 2 candidates Tally{Francis:0, Heather:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Viktor, Heather, Claire} Tally{Francis:1, Heather:0}\n"+
      " 1 : Francis    Vote{Claire, Francis, Heather, Viktor} Tally{Francis:2, Heather:0}\n"+
      " 2 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:2, Heather:1}\n"+
      " 3 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:2, Heather:2}\n"+
      " 4 : Francis    Vote{Claire, Francis, Heather, Viktor} Tally{Francis:3, Heather:2}\n"+
      " 5 : Francis    Vote{Francis, Heather, Claire, Viktor} Tally{Francis:4, Heather:2}\n"+
      " 6 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:5, Heather:2}\n"+
      " 7 : Heather    Vote{Heather, Claire, Francis, Viktor} Tally{Francis:5, Heather:3}\n"+
      " 8 : Heather    Vote{Heather, Francis, Claire, Viktor} Tally{Francis:5, Heather:4}\n"+
      " 9 : Francis    Vote{Viktor, Francis, Heather, Claire} Tally{Francis:6, Heather:4}\n"+
      "10 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:7, Heather:4}\n"+
      "11 : Heather    Vote{Heather, Francis, Claire, Viktor} Tally{Francis:7, Heather:5}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  7  58.3 Francis\n"+
      "  5  41.7 Heather\n"+
      "\n"+
      "WINNER: Francis  \n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }

  @Test public void election_1round() throws Exception{
    String args[] = {"votes-1round.txt"};
    String expect =
      "votes-1round.txt : 7 votes read\n"+
      "Round 1 : 4 candidates Tally{Francis:0, Claire:0, Heather:0, Viktor:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:1, Claire:0, Heather:0, Viktor:0}\n"+
      " 1 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:2, Claire:0, Heather:0, Viktor:0}\n"+
      " 2 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:3, Claire:0, Heather:0, Viktor:0}\n"+
      " 3 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:4, Claire:0, Heather:0, Viktor:0}\n"+
      " 4 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:4, Claire:0, Heather:0, Viktor:1}\n"+
      " 5 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:4, Claire:0, Heather:0, Viktor:2}\n"+
      " 6 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Francis:4, Claire:1, Heather:0, Viktor:2}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  4  57.1 Francis\n"+
      "  1  14.3 Claire\n"+
      "  0   0.0 Heather\n"+
      "  2  28.6 Viktor\n"+
      "\n"+
      "WINNER: Francis\n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }
  
  @Test public void election_2waytie() throws Exception{
    String args[] = {"votes-2waytie.txt"};
    String expect =
      "votes-2waytie.txt : 6 votes read\n"+
      "Round 1 : 4 candidates Tally{Francis:0, Claire:0, Heather:0, Viktor:0}\n"+
      "Transcript:\n"+
      " 0 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:0, Claire:0, Heather:0, Viktor:1}\n"+
      " 1 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:0, Claire:0, Heather:0, Viktor:2}\n"+
      " 2 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:0, Claire:0, Heather:0, Viktor:3}\n"+
      " 3 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Francis:0, Claire:1, Heather:0, Viktor:3}\n"+
      " 4 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Francis:0, Claire:2, Heather:0, Viktor:3}\n"+
      " 5 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Francis:0, Claire:3, Heather:0, Viktor:3}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  0   0.0 Francis\n"+
      "  3  50.0 Claire\n"+
      "  0   0.0 Heather\n"+
      "  3  50.0 Viktor\n"+
      "\n"+
      "2 minimum vote candidates\n"+
      "Eliminating: Francis\n"+
      "Eliminating: Heather\n"+
      "\n"+
      "Round 2 : 2 candidates Tally{Claire:0, Viktor:0}\n"+
      "Transcript:\n"+
      " 0 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Claire:0, Viktor:1}\n"+
      " 1 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Claire:0, Viktor:2}\n"+
      " 2 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Claire:0, Viktor:3}\n"+
      " 3 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Claire:1, Viktor:3}\n"+
      " 4 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Claire:2, Viktor:3}\n"+
      " 5 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Claire:3, Viktor:3}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  3  50.0 Claire\n"+
      "  3  50.0 Viktor\n"+
      "\n"+
      "ALL WAY TIE BETWEEN:\n"+
      "Claire\n"+
      "Viktor\n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }
  @Test public void election_3cands() throws Exception{
    String args[] = {"votes-3cands.txt"};
    String expect =
      "votes-3cands.txt : 13 votes read\n"+
      "Round 1 : 3 candidates Tally{Francis:0, Freddie:0, Edmond:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Edmond, Freddie} Tally{Francis:1, Freddie:0, Edmond:0}\n"+
      " 1 : Edmond     Vote{Edmond, Freddie, Francis} Tally{Francis:1, Freddie:0, Edmond:1}\n"+
      " 2 : Francis    Vote{Francis, Freddie, Edmond} Tally{Francis:2, Freddie:0, Edmond:1}\n"+
      " 3 : Francis    Vote{Francis, Freddie, Edmond} Tally{Francis:3, Freddie:0, Edmond:1}\n"+
      " 4 : Edmond     Vote{Edmond, Freddie, Francis} Tally{Francis:3, Freddie:0, Edmond:2}\n"+
      " 5 : Edmond     Vote{Edmond, Francis, Freddie} Tally{Francis:3, Freddie:0, Edmond:3}\n"+
      " 6 : Edmond     Vote{Edmond, Freddie, Francis} Tally{Francis:3, Freddie:0, Edmond:4}\n"+
      " 7 : Francis    Vote{Francis, Freddie, Edmond} Tally{Francis:4, Freddie:0, Edmond:4}\n"+
      " 8 : Edmond     Vote{Edmond, Freddie, Francis} Tally{Francis:4, Freddie:0, Edmond:5}\n"+
      " 9 : Edmond     Vote{Edmond, Francis, Freddie} Tally{Francis:4, Freddie:0, Edmond:6}\n"+
      "10 : Edmond     Vote{Edmond, Freddie, Francis} Tally{Francis:4, Freddie:0, Edmond:7}\n"+
      "11 : Freddie    Vote{Freddie, Edmond, Francis} Tally{Francis:4, Freddie:1, Edmond:7}\n"+
      "12 : Freddie    Vote{Freddie, Edmond, Francis} Tally{Francis:4, Freddie:2, Edmond:7}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  4  30.8 Francis\n"+
      "  2  15.4 Freddie\n"+
      "  7  53.8 Edmond\n"+
      "\n"+
      "WINNER: Edmond\n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }
  @Test public void election_3waytie() throws Exception{
    String args[] = {"votes-3waytie.txt"};
    String expect =
      "votes-3waytie.txt : 6 votes read\n"+
      "Round 1 : 4 candidates Tally{Francis:0, Claire:0, Heather:0, Viktor:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:1, Claire:0, Heather:0, Viktor:0}\n"+
      " 1 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:2, Claire:0, Heather:0, Viktor:0}\n"+
      " 2 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:2, Claire:0, Heather:0, Viktor:1}\n"+
      " 3 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:2, Claire:0, Heather:0, Viktor:2}\n"+
      " 4 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Francis:2, Claire:1, Heather:0, Viktor:2}\n"+
      " 5 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Francis:2, Claire:2, Heather:0, Viktor:2}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  2  33.3 Francis\n"+
      "  2  33.3 Claire\n"+
      "  0   0.0 Heather\n"+
      "  2  33.3 Viktor\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: Heather\n"+
      "\n"+
      "Round 2 : 3 candidates Tally{Francis:0, Claire:0, Viktor:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:1, Claire:0, Viktor:0}\n"+
      " 1 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:2, Claire:0, Viktor:0}\n"+
      " 2 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:2, Claire:0, Viktor:1}\n"+
      " 3 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:2, Claire:0, Viktor:2}\n"+
      " 4 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Francis:2, Claire:1, Viktor:2}\n"+
      " 5 : Claire     Vote{Claire, Heather, Viktor, Francis} Tally{Francis:2, Claire:2, Viktor:2}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  2  33.3 Francis\n"+
      "  2  33.3 Claire\n"+
      "  2  33.3 Viktor\n"+
      "\n"+
      "ALL WAY TIE BETWEEN:\n"+
      "Francis\n"+
      "Claire\n"+
      "Viktor\n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }
  @Test public void election_5cands() throws Exception{
    String args[] = {"votes-5cands.txt"};
    String expect =
      "votes-5cands.txt : 5 votes read\n"+
      "Round 1 : 5 candidates Tally{A:0, B:0, C:0, D:0, E:0}\n"+
      "Transcript:\n"+
      " 0 : C          Vote{C, A, B, D, E} Tally{A:0, B:0, C:1, D:0, E:0}\n"+
      " 1 : D          Vote{D, C, E, B, A} Tally{A:0, B:0, C:1, D:1, E:0}\n"+
      " 2 : C          Vote{C, B, A, D, E} Tally{A:0, B:0, C:2, D:1, E:0}\n"+
      " 3 : A          Vote{A, B, C, D, E} Tally{A:1, B:0, C:2, D:1, E:0}\n"+
      " 4 : A          Vote{A, B, D, C, E} Tally{A:2, B:0, C:2, D:1, E:0}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  2  40.0 A\n"+
      "  0   0.0 B\n"+
      "  2  40.0 C\n"+
      "  1  20.0 D\n"+
      "  0   0.0 E\n"+
      "\n"+
      "2 minimum vote candidates\n"+
      "Eliminating: B\n"+
      "Eliminating: E\n"+
      "\n"+
      "Round 2 : 3 candidates Tally{A:0, C:0, D:0}\n"+
      "Transcript:\n"+
      " 0 : C          Vote{C, A, B, D, E} Tally{A:0, C:1, D:0}\n"+
      " 1 : D          Vote{D, C, E, B, A} Tally{A:0, C:1, D:1}\n"+
      " 2 : C          Vote{C, B, A, D, E} Tally{A:0, C:2, D:1}\n"+
      " 3 : A          Vote{A, B, C, D, E} Tally{A:1, C:2, D:1}\n"+
      " 4 : A          Vote{A, B, D, C, E} Tally{A:2, C:2, D:1}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  2  40.0 A\n"+
      "  2  40.0 C\n"+
      "  1  20.0 D\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: D\n"+
      "\n"+
      "Round 3 : 2 candidates Tally{A:0, C:0}\n"+
      "Transcript:\n"+
      " 0 : C          Vote{C, A, B, D, E} Tally{A:0, C:1}\n"+
      " 1 : C          Vote{D, C, E, B, A} Tally{A:0, C:2}\n"+
      " 2 : C          Vote{C, B, A, D, E} Tally{A:0, C:3}\n"+
      " 3 : A          Vote{A, B, C, D, E} Tally{A:1, C:3}\n"+
      " 4 : A          Vote{A, B, D, C, E} Tally{A:2, C:3}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  2  40.0 A\n"+
      "  3  60.0 C\n"+
      "\n"+
      "WINNER: C\n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }
  @Test public void election_drop2() throws Exception{
    String args[] = {"votes-drop2.txt"};
    String expect =
      "votes-drop2.txt : 7 votes read\n"+
      "Round 1 : 4 candidates Tally{Francis:0, Claire:0, Heather:0, Viktor:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:1, Claire:0, Heather:0, Viktor:0}\n"+
      " 1 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:2, Claire:0, Heather:0, Viktor:0}\n"+
      " 2 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:3, Claire:0, Heather:0, Viktor:0}\n"+
      " 3 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:3, Claire:0, Heather:0, Viktor:1}\n"+
      " 4 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:3, Claire:0, Heather:0, Viktor:2}\n"+
      " 5 : Heather    Vote{Heather, Viktor, Claire, Francis} Tally{Francis:3, Claire:0, Heather:1, Viktor:2}\n"+
      " 6 : Heather    Vote{Heather, Viktor, Claire, Francis} Tally{Francis:3, Claire:0, Heather:2, Viktor:2}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  3  42.9 Francis\n"+
      "  0   0.0 Claire\n"+
      "  2  28.6 Heather\n"+
      "  2  28.6 Viktor\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: Claire\n"+
      "\n"+
      "Round 2 : 3 candidates Tally{Francis:0, Heather:0, Viktor:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:1, Heather:0, Viktor:0}\n"+
      " 1 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:2, Heather:0, Viktor:0}\n"+
      " 2 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:3, Heather:0, Viktor:0}\n"+
      " 3 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:3, Heather:0, Viktor:1}\n"+
      " 4 : Viktor     Vote{Viktor, Heather, Claire, Francis} Tally{Francis:3, Heather:0, Viktor:2}\n"+
      " 5 : Heather    Vote{Heather, Viktor, Claire, Francis} Tally{Francis:3, Heather:1, Viktor:2}\n"+
      " 6 : Heather    Vote{Heather, Viktor, Claire, Francis} Tally{Francis:3, Heather:2, Viktor:2}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  3  42.9 Francis\n"+
      "  2  28.6 Heather\n"+
      "  2  28.6 Viktor\n"+
      "\n"+
      "2 minimum vote candidates\n"+
      "Eliminating: Heather\n"+
      "Eliminating: Viktor\n"+
      "\n"+
      "Round 3 : 1 candidates Tally{Francis:0}\n"+
      "Transcript:\n"+
      " 0 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:1}\n"+
      " 1 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:2}\n"+
      " 2 : Francis    Vote{Francis, Claire, Heather, Viktor} Tally{Francis:3}\n"+
      " 3 : Francis    Vote{Viktor, Heather, Claire, Francis} Tally{Francis:4}\n"+
      " 4 : Francis    Vote{Viktor, Heather, Claire, Francis} Tally{Francis:5}\n"+
      " 5 : Francis    Vote{Heather, Viktor, Claire, Francis} Tally{Francis:6}\n"+
      " 6 : Francis    Vote{Heather, Viktor, Claire, Francis} Tally{Francis:7}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  7 100.0 Francis\n"+
      "\n"+
      "WINNER: Francis\n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }
  @Test public void election_many() throws Exception{
    String args[] = {"votes-many.txt"};
    String expect =
      "votes-many.txt : 20 votes read\n"+
      "Round 1 : 8 candidates Tally{A:0, B:0, C:0, D:0, E:0, F:0, G:0, H:0}\n"+
      "Transcript:\n"+
      " 0 : D          Vote{D, G, B, A, E, C, F, H} Tally{A:0, B:0, C:0, D:1, E:0, F:0, G:0, H:0}\n"+
      " 1 : H          Vote{H, D, C, B, A, G, F, E} Tally{A:0, B:0, C:0, D:1, E:0, F:0, G:0, H:1}\n"+
      " 2 : A          Vote{A, E, G, C, H, B, F, D} Tally{A:1, B:0, C:0, D:1, E:0, F:0, G:0, H:1}\n"+
      " 3 : E          Vote{E, A, D, G, C, B, H, F} Tally{A:1, B:0, C:0, D:1, E:1, F:0, G:0, H:1}\n"+
      " 4 : C          Vote{C, F, A, B, E, H, D, G} Tally{A:1, B:0, C:1, D:1, E:1, F:0, G:0, H:1}\n"+
      " 5 : H          Vote{H, A, G, D, E, F, B, C} Tally{A:1, B:0, C:1, D:1, E:1, F:0, G:0, H:2}\n"+
      " 6 : A          Vote{A, F, D, E, B, H, C, G} Tally{A:2, B:0, C:1, D:1, E:1, F:0, G:0, H:2}\n"+
      " 7 : D          Vote{D, E, A, H, G, C, F, B} Tally{A:2, B:0, C:1, D:2, E:1, F:0, G:0, H:2}\n"+
      " 8 : H          Vote{H, F, C, D, B, A, E, G} Tally{A:2, B:0, C:1, D:2, E:1, F:0, G:0, H:3}\n"+
      " 9 : B          Vote{B, G, F, C, D, E, H, A} Tally{A:2, B:1, C:1, D:2, E:1, F:0, G:0, H:3}\n"+
      "10 : C          Vote{C, A, D, H, B, F, G, E} Tally{A:2, B:1, C:2, D:2, E:1, F:0, G:0, H:3}\n"+
      "11 : C          Vote{C, B, E, G, H, A, F, D} Tally{A:2, B:1, C:3, D:2, E:1, F:0, G:0, H:3}\n"+
      "12 : F          Vote{F, A, E, D, B, G, C, H} Tally{A:2, B:1, C:3, D:2, E:1, F:1, G:0, H:3}\n"+
      "13 : E          Vote{E, B, D, F, C, G, H, A} Tally{A:2, B:1, C:3, D:2, E:2, F:1, G:0, H:3}\n"+
      "14 : A          Vote{A, B, D, E, G, F, H, C} Tally{A:3, B:1, C:3, D:2, E:2, F:1, G:0, H:3}\n"+
      "15 : H          Vote{H, F, C, B, D, G, E, A} Tally{A:3, B:1, C:3, D:2, E:2, F:1, G:0, H:4}\n"+
      "16 : H          Vote{H, F, B, D, C, A, G, E} Tally{A:3, B:1, C:3, D:2, E:2, F:1, G:0, H:5}\n"+
      "17 : D          Vote{D, A, C, G, H, E, F, B} Tally{A:3, B:1, C:3, D:3, E:2, F:1, G:0, H:5}\n"+
      "18 : D          Vote{D, G, H, E, B, A, C, F} Tally{A:3, B:1, C:3, D:4, E:2, F:1, G:0, H:5}\n"+
      "19 : E          Vote{E, C, D, A, G, B, F, H} Tally{A:3, B:1, C:3, D:4, E:3, F:1, G:0, H:5}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  3  15.0 A\n"+
      "  1   5.0 B\n"+
      "  3  15.0 C\n"+
      "  4  20.0 D\n"+
      "  3  15.0 E\n"+
      "  1   5.0 F\n"+
      "  0   0.0 G\n"+
      "  5  25.0 H\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: G\n"+
      "\n"+
      "Round 2 : 7 candidates Tally{A:0, B:0, C:0, D:0, E:0, F:0, H:0}\n"+
      "Transcript:\n"+
      " 0 : D          Vote{D, G, B, A, E, C, F, H} Tally{A:0, B:0, C:0, D:1, E:0, F:0, H:0}\n"+
      " 1 : H          Vote{H, D, C, B, A, G, F, E} Tally{A:0, B:0, C:0, D:1, E:0, F:0, H:1}\n"+
      " 2 : A          Vote{A, E, G, C, H, B, F, D} Tally{A:1, B:0, C:0, D:1, E:0, F:0, H:1}\n"+
      " 3 : E          Vote{E, A, D, G, C, B, H, F} Tally{A:1, B:0, C:0, D:1, E:1, F:0, H:1}\n"+
      " 4 : C          Vote{C, F, A, B, E, H, D, G} Tally{A:1, B:0, C:1, D:1, E:1, F:0, H:1}\n"+
      " 5 : H          Vote{H, A, G, D, E, F, B, C} Tally{A:1, B:0, C:1, D:1, E:1, F:0, H:2}\n"+
      " 6 : A          Vote{A, F, D, E, B, H, C, G} Tally{A:2, B:0, C:1, D:1, E:1, F:0, H:2}\n"+
      " 7 : D          Vote{D, E, A, H, G, C, F, B} Tally{A:2, B:0, C:1, D:2, E:1, F:0, H:2}\n"+
      " 8 : H          Vote{H, F, C, D, B, A, E, G} Tally{A:2, B:0, C:1, D:2, E:1, F:0, H:3}\n"+
      " 9 : B          Vote{B, G, F, C, D, E, H, A} Tally{A:2, B:1, C:1, D:2, E:1, F:0, H:3}\n"+
      "10 : C          Vote{C, A, D, H, B, F, G, E} Tally{A:2, B:1, C:2, D:2, E:1, F:0, H:3}\n"+
      "11 : C          Vote{C, B, E, G, H, A, F, D} Tally{A:2, B:1, C:3, D:2, E:1, F:0, H:3}\n"+
      "12 : F          Vote{F, A, E, D, B, G, C, H} Tally{A:2, B:1, C:3, D:2, E:1, F:1, H:3}\n"+
      "13 : E          Vote{E, B, D, F, C, G, H, A} Tally{A:2, B:1, C:3, D:2, E:2, F:1, H:3}\n"+
      "14 : A          Vote{A, B, D, E, G, F, H, C} Tally{A:3, B:1, C:3, D:2, E:2, F:1, H:3}\n"+
      "15 : H          Vote{H, F, C, B, D, G, E, A} Tally{A:3, B:1, C:3, D:2, E:2, F:1, H:4}\n"+
      "16 : H          Vote{H, F, B, D, C, A, G, E} Tally{A:3, B:1, C:3, D:2, E:2, F:1, H:5}\n"+
      "17 : D          Vote{D, A, C, G, H, E, F, B} Tally{A:3, B:1, C:3, D:3, E:2, F:1, H:5}\n"+
      "18 : D          Vote{D, G, H, E, B, A, C, F} Tally{A:3, B:1, C:3, D:4, E:2, F:1, H:5}\n"+
      "19 : E          Vote{E, C, D, A, G, B, F, H} Tally{A:3, B:1, C:3, D:4, E:3, F:1, H:5}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  3  15.0 A\n"+
      "  1   5.0 B\n"+
      "  3  15.0 C\n"+
      "  4  20.0 D\n"+
      "  3  15.0 E\n"+
      "  1   5.0 F\n"+
      "  5  25.0 H\n"+
      "\n"+
      "2 minimum vote candidates\n"+
      "Eliminating: B\n"+
      "Eliminating: F\n"+
      "\n"+
      "Round 3 : 5 candidates Tally{A:0, C:0, D:0, E:0, H:0}\n"+
      "Transcript:\n"+
      " 0 : D          Vote{D, G, B, A, E, C, F, H} Tally{A:0, C:0, D:1, E:0, H:0}\n"+
      " 1 : H          Vote{H, D, C, B, A, G, F, E} Tally{A:0, C:0, D:1, E:0, H:1}\n"+
      " 2 : A          Vote{A, E, G, C, H, B, F, D} Tally{A:1, C:0, D:1, E:0, H:1}\n"+
      " 3 : E          Vote{E, A, D, G, C, B, H, F} Tally{A:1, C:0, D:1, E:1, H:1}\n"+
      " 4 : C          Vote{C, F, A, B, E, H, D, G} Tally{A:1, C:1, D:1, E:1, H:1}\n"+
      " 5 : H          Vote{H, A, G, D, E, F, B, C} Tally{A:1, C:1, D:1, E:1, H:2}\n"+
      " 6 : A          Vote{A, F, D, E, B, H, C, G} Tally{A:2, C:1, D:1, E:1, H:2}\n"+
      " 7 : D          Vote{D, E, A, H, G, C, F, B} Tally{A:2, C:1, D:2, E:1, H:2}\n"+
      " 8 : H          Vote{H, F, C, D, B, A, E, G} Tally{A:2, C:1, D:2, E:1, H:3}\n"+
      " 9 : C          Vote{B, G, F, C, D, E, H, A} Tally{A:2, C:2, D:2, E:1, H:3}\n"+
      "10 : C          Vote{C, A, D, H, B, F, G, E} Tally{A:2, C:3, D:2, E:1, H:3}\n"+
      "11 : C          Vote{C, B, E, G, H, A, F, D} Tally{A:2, C:4, D:2, E:1, H:3}\n"+
      "12 : A          Vote{F, A, E, D, B, G, C, H} Tally{A:3, C:4, D:2, E:1, H:3}\n"+
      "13 : E          Vote{E, B, D, F, C, G, H, A} Tally{A:3, C:4, D:2, E:2, H:3}\n"+
      "14 : A          Vote{A, B, D, E, G, F, H, C} Tally{A:4, C:4, D:2, E:2, H:3}\n"+
      "15 : H          Vote{H, F, C, B, D, G, E, A} Tally{A:4, C:4, D:2, E:2, H:4}\n"+
      "16 : H          Vote{H, F, B, D, C, A, G, E} Tally{A:4, C:4, D:2, E:2, H:5}\n"+
      "17 : D          Vote{D, A, C, G, H, E, F, B} Tally{A:4, C:4, D:3, E:2, H:5}\n"+
      "18 : D          Vote{D, G, H, E, B, A, C, F} Tally{A:4, C:4, D:4, E:2, H:5}\n"+
      "19 : E          Vote{E, C, D, A, G, B, F, H} Tally{A:4, C:4, D:4, E:3, H:5}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  4  20.0 A\n"+
      "  4  20.0 C\n"+
      "  4  20.0 D\n"+
      "  3  15.0 E\n"+
      "  5  25.0 H\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: E\n"+
      "\n"+
      "Round 4 : 4 candidates Tally{A:0, C:0, D:0, H:0}\n"+
      "Transcript:\n"+
      " 0 : D          Vote{D, G, B, A, E, C, F, H} Tally{A:0, C:0, D:1, H:0}\n"+
      " 1 : H          Vote{H, D, C, B, A, G, F, E} Tally{A:0, C:0, D:1, H:1}\n"+
      " 2 : A          Vote{A, E, G, C, H, B, F, D} Tally{A:1, C:0, D:1, H:1}\n"+
      " 3 : A          Vote{E, A, D, G, C, B, H, F} Tally{A:2, C:0, D:1, H:1}\n"+
      " 4 : C          Vote{C, F, A, B, E, H, D, G} Tally{A:2, C:1, D:1, H:1}\n"+
      " 5 : H          Vote{H, A, G, D, E, F, B, C} Tally{A:2, C:1, D:1, H:2}\n"+
      " 6 : A          Vote{A, F, D, E, B, H, C, G} Tally{A:3, C:1, D:1, H:2}\n"+
      " 7 : D          Vote{D, E, A, H, G, C, F, B} Tally{A:3, C:1, D:2, H:2}\n"+
      " 8 : H          Vote{H, F, C, D, B, A, E, G} Tally{A:3, C:1, D:2, H:3}\n"+
      " 9 : C          Vote{B, G, F, C, D, E, H, A} Tally{A:3, C:2, D:2, H:3}\n"+
      "10 : C          Vote{C, A, D, H, B, F, G, E} Tally{A:3, C:3, D:2, H:3}\n"+
      "11 : C          Vote{C, B, E, G, H, A, F, D} Tally{A:3, C:4, D:2, H:3}\n"+
      "12 : A          Vote{F, A, E, D, B, G, C, H} Tally{A:4, C:4, D:2, H:3}\n"+
      "13 : D          Vote{E, B, D, F, C, G, H, A} Tally{A:4, C:4, D:3, H:3}\n"+
      "14 : A          Vote{A, B, D, E, G, F, H, C} Tally{A:5, C:4, D:3, H:3}\n"+
      "15 : H          Vote{H, F, C, B, D, G, E, A} Tally{A:5, C:4, D:3, H:4}\n"+
      "16 : H          Vote{H, F, B, D, C, A, G, E} Tally{A:5, C:4, D:3, H:5}\n"+
      "17 : D          Vote{D, A, C, G, H, E, F, B} Tally{A:5, C:4, D:4, H:5}\n"+
      "18 : D          Vote{D, G, H, E, B, A, C, F} Tally{A:5, C:4, D:5, H:5}\n"+
      "19 : C          Vote{E, C, D, A, G, B, F, H} Tally{A:5, C:5, D:5, H:5}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  5  25.0 A\n"+
      "  5  25.0 C\n"+
      "  5  25.0 D\n"+
      "  5  25.0 H\n"+
      "\n"+
      "ALL WAY TIE BETWEEN:\n"+
      "A\n"+
      "C\n"+
      "D\n"+
      "H\n"+
    "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }
  @Test public void election_stress() throws Exception{
    String args[] = {"votes-stress.txt"};
    String expect =
      "votes-stress.txt : 50 votes read\n"+
      "Round 1 : 9 candidates Tally{A:0, B:0, C:0, D:0, E:0, F:0, G:0, H:0, I:0}\n"+
      "Transcript:\n"+
      " 0 : F          Vote{F, I, B, G, D, A, C, E, H} Tally{A:0, B:0, C:0, D:0, E:0, F:1, G:0, H:0, I:0}\n"+
      " 1 : C          Vote{C, A, B, G, D, H, E, F, I} Tally{A:0, B:0, C:1, D:0, E:0, F:1, G:0, H:0, I:0}\n"+
      " 2 : B          Vote{B, C, H, F, I, G, A, E, D} Tally{A:0, B:1, C:1, D:0, E:0, F:1, G:0, H:0, I:0}\n"+
      " 3 : I          Vote{I, H, B, E, A, F, C, G, D} Tally{A:0, B:1, C:1, D:0, E:0, F:1, G:0, H:0, I:1}\n"+
      " 4 : B          Vote{B, G, E, C, H, A, I, D, F} Tally{A:0, B:2, C:1, D:0, E:0, F:1, G:0, H:0, I:1}\n"+
      " 5 : D          Vote{D, H, G, E, B, F, A, C, I} Tally{A:0, B:2, C:1, D:1, E:0, F:1, G:0, H:0, I:1}\n"+
      " 6 : G          Vote{G, I, B, H, A, F, D, C, E} Tally{A:0, B:2, C:1, D:1, E:0, F:1, G:1, H:0, I:1}\n"+
      " 7 : G          Vote{G, C, I, B, D, H, A, F, E} Tally{A:0, B:2, C:1, D:1, E:0, F:1, G:2, H:0, I:1}\n"+
      " 8 : F          Vote{F, H, A, I, D, B, G, C, E} Tally{A:0, B:2, C:1, D:1, E:0, F:2, G:2, H:0, I:1}\n"+
      " 9 : D          Vote{D, A, E, H, F, C, G, I, B} Tally{A:0, B:2, C:1, D:2, E:0, F:2, G:2, H:0, I:1}\n"+
      "10 : D          Vote{D, F, G, B, C, I, E, H, A} Tally{A:0, B:2, C:1, D:3, E:0, F:2, G:2, H:0, I:1}\n"+
      "11 : F          Vote{F, G, C, B, D, I, E, A, H} Tally{A:0, B:2, C:1, D:3, E:0, F:3, G:2, H:0, I:1}\n"+
      "12 : E          Vote{E, I, B, C, H, A, D, G, F} Tally{A:0, B:2, C:1, D:3, E:1, F:3, G:2, H:0, I:1}\n"+
      "13 : E          Vote{E, I, F, D, B, G, C, H, A} Tally{A:0, B:2, C:1, D:3, E:2, F:3, G:2, H:0, I:1}\n"+
      "14 : B          Vote{B, C, G, H, I, F, D, E, A} Tally{A:0, B:3, C:1, D:3, E:2, F:3, G:2, H:0, I:1}\n"+
      "15 : G          Vote{G, F, I, H, E, A, B, D, C} Tally{A:0, B:3, C:1, D:3, E:2, F:3, G:3, H:0, I:1}\n"+
      "16 : G          Vote{G, I, C, D, E, A, H, F, B} Tally{A:0, B:3, C:1, D:3, E:2, F:3, G:4, H:0, I:1}\n"+
      "17 : G          Vote{G, B, I, H, E, A, F, D, C} Tally{A:0, B:3, C:1, D:3, E:2, F:3, G:5, H:0, I:1}\n"+
      "18 : E          Vote{E, C, D, B, G, A, F, I, H} Tally{A:0, B:3, C:1, D:3, E:3, F:3, G:5, H:0, I:1}\n"+
      "19 : C          Vote{C, E, D, A, G, B, H, F, I} Tally{A:0, B:3, C:2, D:3, E:3, F:3, G:5, H:0, I:1}\n"+
      "20 : A          Vote{A, G, E, B, I, H, C, D, F} Tally{A:1, B:3, C:2, D:3, E:3, F:3, G:5, H:0, I:1}\n"+
      "21 : C          Vote{C, B, F, A, D, G, H, E, I} Tally{A:1, B:3, C:3, D:3, E:3, F:3, G:5, H:0, I:1}\n"+
      "22 : G          Vote{G, I, B, D, F, H, C, A, E} Tally{A:1, B:3, C:3, D:3, E:3, F:3, G:6, H:0, I:1}\n"+
      "23 : E          Vote{E, A, F, G, B, D, I, H, C} Tally{A:1, B:3, C:3, D:3, E:4, F:3, G:6, H:0, I:1}\n"+
      "24 : H          Vote{H, G, I, F, B, D, C, A, E} Tally{A:1, B:3, C:3, D:3, E:4, F:3, G:6, H:1, I:1}\n"+
      "25 : E          Vote{E, F, I, B, D, A, C, G, H} Tally{A:1, B:3, C:3, D:3, E:5, F:3, G:6, H:1, I:1}\n"+
      "26 : F          Vote{F, A, E, D, B, G, H, I, C} Tally{A:1, B:3, C:3, D:3, E:5, F:4, G:6, H:1, I:1}\n"+
      "27 : G          Vote{G, H, D, B, F, I, E, C, A} Tally{A:1, B:3, C:3, D:3, E:5, F:4, G:7, H:1, I:1}\n"+
      "28 : F          Vote{F, I, H, E, A, D, C, B, G} Tally{A:1, B:3, C:3, D:3, E:5, F:5, G:7, H:1, I:1}\n"+
      "29 : D          Vote{D, C, H, F, E, I, A, B, G} Tally{A:1, B:3, C:3, D:4, E:5, F:5, G:7, H:1, I:1}\n"+
      "30 : C          Vote{C, I, H, A, G, D, E, F, B} Tally{A:1, B:3, C:4, D:4, E:5, F:5, G:7, H:1, I:1}\n"+
      "31 : C          Vote{C, I, F, G, E, D, A, B, H} Tally{A:1, B:3, C:5, D:4, E:5, F:5, G:7, H:1, I:1}\n"+
      "32 : C          Vote{C, F, D, A, B, G, E, I, H} Tally{A:1, B:3, C:6, D:4, E:5, F:5, G:7, H:1, I:1}\n"+
      "33 : B          Vote{B, A, H, F, C, I, D, G, E} Tally{A:1, B:4, C:6, D:4, E:5, F:5, G:7, H:1, I:1}\n"+
      "34 : G          Vote{G, C, A, B, I, E, D, F, H} Tally{A:1, B:4, C:6, D:4, E:5, F:5, G:8, H:1, I:1}\n"+
      "35 : B          Vote{B, D, I, C, A, H, E, F, G} Tally{A:1, B:5, C:6, D:4, E:5, F:5, G:8, H:1, I:1}\n"+
      "36 : H          Vote{H, E, A, C, F, G, B, I, D} Tally{A:1, B:5, C:6, D:4, E:5, F:5, G:8, H:2, I:1}\n"+
      "37 : C          Vote{C, G, B, F, I, D, H, A, E} Tally{A:1, B:5, C:7, D:4, E:5, F:5, G:8, H:2, I:1}\n"+
      "38 : I          Vote{I, D, C, F, A, B, E, H, G} Tally{A:1, B:5, C:7, D:4, E:5, F:5, G:8, H:2, I:2}\n"+
      "39 : G          Vote{G, B, F, C, H, D, A, E, I} Tally{A:1, B:5, C:7, D:4, E:5, F:5, G:9, H:2, I:2}\n"+
      "40 : F          Vote{F, H, E, G, C, B, D, A, I} Tally{A:1, B:5, C:7, D:4, E:5, F:6, G:9, H:2, I:2}\n"+
      "41 : A          Vote{A, D, C, F, H, G, I, B, E} Tally{A:2, B:5, C:7, D:4, E:5, F:6, G:9, H:2, I:2}\n"+
      "42 : C          Vote{C, D, F, I, B, E, G, H, A} Tally{A:2, B:5, C:8, D:4, E:5, F:6, G:9, H:2, I:2}\n"+
      "43 : C          Vote{C, D, I, F, B, A, H, E, G} Tally{A:2, B:5, C:9, D:4, E:5, F:6, G:9, H:2, I:2}\n"+
      "44 : D          Vote{D, G, B, A, C, E, F, H, I} Tally{A:2, B:5, C:9, D:5, E:5, F:6, G:9, H:2, I:2}\n"+
      "45 : B          Vote{B, H, G, A, F, D, I, C, E} Tally{A:2, B:6, C:9, D:5, E:5, F:6, G:9, H:2, I:2}\n"+
      "46 : H          Vote{H, I, A, D, G, F, E, C, B} Tally{A:2, B:6, C:9, D:5, E:5, F:6, G:9, H:3, I:2}\n"+
      "47 : F          Vote{F, G, B, I, D, H, C, A, E} Tally{A:2, B:6, C:9, D:5, E:5, F:7, G:9, H:3, I:2}\n"+
      "48 : I          Vote{I, H, G, E, B, F, C, D, A} Tally{A:2, B:6, C:9, D:5, E:5, F:7, G:9, H:3, I:3}\n"+
      "49 : D          Vote{D, H, A, E, I, B, C, F, G} Tally{A:2, B:6, C:9, D:6, E:5, F:7, G:9, H:3, I:3}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  2   4.0 A\n"+
      "  6  12.0 B\n"+
      "  9  18.0 C\n"+
      "  6  12.0 D\n"+
      "  5  10.0 E\n"+
      "  7  14.0 F\n"+
      "  9  18.0 G\n"+
      "  3   6.0 H\n"+
      "  3   6.0 I\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: A\n"+
      "\n"+
      "Round 2 : 8 candidates Tally{B:0, C:0, D:0, E:0, F:0, G:0, H:0, I:0}\n"+
      "Transcript:\n"+
      " 0 : F          Vote{F, I, B, G, D, A, C, E, H} Tally{B:0, C:0, D:0, E:0, F:1, G:0, H:0, I:0}\n"+
      " 1 : C          Vote{C, A, B, G, D, H, E, F, I} Tally{B:0, C:1, D:0, E:0, F:1, G:0, H:0, I:0}\n"+
      " 2 : B          Vote{B, C, H, F, I, G, A, E, D} Tally{B:1, C:1, D:0, E:0, F:1, G:0, H:0, I:0}\n"+
      " 3 : I          Vote{I, H, B, E, A, F, C, G, D} Tally{B:1, C:1, D:0, E:0, F:1, G:0, H:0, I:1}\n"+
      " 4 : B          Vote{B, G, E, C, H, A, I, D, F} Tally{B:2, C:1, D:0, E:0, F:1, G:0, H:0, I:1}\n"+
      " 5 : D          Vote{D, H, G, E, B, F, A, C, I} Tally{B:2, C:1, D:1, E:0, F:1, G:0, H:0, I:1}\n"+
      " 6 : G          Vote{G, I, B, H, A, F, D, C, E} Tally{B:2, C:1, D:1, E:0, F:1, G:1, H:0, I:1}\n"+
      " 7 : G          Vote{G, C, I, B, D, H, A, F, E} Tally{B:2, C:1, D:1, E:0, F:1, G:2, H:0, I:1}\n"+
      " 8 : F          Vote{F, H, A, I, D, B, G, C, E} Tally{B:2, C:1, D:1, E:0, F:2, G:2, H:0, I:1}\n"+
      " 9 : D          Vote{D, A, E, H, F, C, G, I, B} Tally{B:2, C:1, D:2, E:0, F:2, G:2, H:0, I:1}\n"+
      "10 : D          Vote{D, F, G, B, C, I, E, H, A} Tally{B:2, C:1, D:3, E:0, F:2, G:2, H:0, I:1}\n"+
      "11 : F          Vote{F, G, C, B, D, I, E, A, H} Tally{B:2, C:1, D:3, E:0, F:3, G:2, H:0, I:1}\n"+
      "12 : E          Vote{E, I, B, C, H, A, D, G, F} Tally{B:2, C:1, D:3, E:1, F:3, G:2, H:0, I:1}\n"+
      "13 : E          Vote{E, I, F, D, B, G, C, H, A} Tally{B:2, C:1, D:3, E:2, F:3, G:2, H:0, I:1}\n"+
      "14 : B          Vote{B, C, G, H, I, F, D, E, A} Tally{B:3, C:1, D:3, E:2, F:3, G:2, H:0, I:1}\n"+
      "15 : G          Vote{G, F, I, H, E, A, B, D, C} Tally{B:3, C:1, D:3, E:2, F:3, G:3, H:0, I:1}\n"+
      "16 : G          Vote{G, I, C, D, E, A, H, F, B} Tally{B:3, C:1, D:3, E:2, F:3, G:4, H:0, I:1}\n"+
      "17 : G          Vote{G, B, I, H, E, A, F, D, C} Tally{B:3, C:1, D:3, E:2, F:3, G:5, H:0, I:1}\n"+
      "18 : E          Vote{E, C, D, B, G, A, F, I, H} Tally{B:3, C:1, D:3, E:3, F:3, G:5, H:0, I:1}\n"+
      "19 : C          Vote{C, E, D, A, G, B, H, F, I} Tally{B:3, C:2, D:3, E:3, F:3, G:5, H:0, I:1}\n"+
      "20 : G          Vote{A, G, E, B, I, H, C, D, F} Tally{B:3, C:2, D:3, E:3, F:3, G:6, H:0, I:1}\n"+
      "21 : C          Vote{C, B, F, A, D, G, H, E, I} Tally{B:3, C:3, D:3, E:3, F:3, G:6, H:0, I:1}\n"+
      "22 : G          Vote{G, I, B, D, F, H, C, A, E} Tally{B:3, C:3, D:3, E:3, F:3, G:7, H:0, I:1}\n"+
      "23 : E          Vote{E, A, F, G, B, D, I, H, C} Tally{B:3, C:3, D:3, E:4, F:3, G:7, H:0, I:1}\n"+
      "24 : H          Vote{H, G, I, F, B, D, C, A, E} Tally{B:3, C:3, D:3, E:4, F:3, G:7, H:1, I:1}\n"+
      "25 : E          Vote{E, F, I, B, D, A, C, G, H} Tally{B:3, C:3, D:3, E:5, F:3, G:7, H:1, I:1}\n"+
      "26 : F          Vote{F, A, E, D, B, G, H, I, C} Tally{B:3, C:3, D:3, E:5, F:4, G:7, H:1, I:1}\n"+
      "27 : G          Vote{G, H, D, B, F, I, E, C, A} Tally{B:3, C:3, D:3, E:5, F:4, G:8, H:1, I:1}\n"+
      "28 : F          Vote{F, I, H, E, A, D, C, B, G} Tally{B:3, C:3, D:3, E:5, F:5, G:8, H:1, I:1}\n"+
      "29 : D          Vote{D, C, H, F, E, I, A, B, G} Tally{B:3, C:3, D:4, E:5, F:5, G:8, H:1, I:1}\n"+
      "30 : C          Vote{C, I, H, A, G, D, E, F, B} Tally{B:3, C:4, D:4, E:5, F:5, G:8, H:1, I:1}\n"+
      "31 : C          Vote{C, I, F, G, E, D, A, B, H} Tally{B:3, C:5, D:4, E:5, F:5, G:8, H:1, I:1}\n"+
      "32 : C          Vote{C, F, D, A, B, G, E, I, H} Tally{B:3, C:6, D:4, E:5, F:5, G:8, H:1, I:1}\n"+
      "33 : B          Vote{B, A, H, F, C, I, D, G, E} Tally{B:4, C:6, D:4, E:5, F:5, G:8, H:1, I:1}\n"+
      "34 : G          Vote{G, C, A, B, I, E, D, F, H} Tally{B:4, C:6, D:4, E:5, F:5, G:9, H:1, I:1}\n"+
      "35 : B          Vote{B, D, I, C, A, H, E, F, G} Tally{B:5, C:6, D:4, E:5, F:5, G:9, H:1, I:1}\n"+
      "36 : H          Vote{H, E, A, C, F, G, B, I, D} Tally{B:5, C:6, D:4, E:5, F:5, G:9, H:2, I:1}\n"+
      "37 : C          Vote{C, G, B, F, I, D, H, A, E} Tally{B:5, C:7, D:4, E:5, F:5, G:9, H:2, I:1}\n"+
      "38 : I          Vote{I, D, C, F, A, B, E, H, G} Tally{B:5, C:7, D:4, E:5, F:5, G:9, H:2, I:2}\n"+
      "39 : G          Vote{G, B, F, C, H, D, A, E, I} Tally{B:5, C:7, D:4, E:5, F:5, G:10, H:2, I:2}\n"+
      "40 : F          Vote{F, H, E, G, C, B, D, A, I} Tally{B:5, C:7, D:4, E:5, F:6, G:10, H:2, I:2}\n"+
      "41 : D          Vote{A, D, C, F, H, G, I, B, E} Tally{B:5, C:7, D:5, E:5, F:6, G:10, H:2, I:2}\n"+
      "42 : C          Vote{C, D, F, I, B, E, G, H, A} Tally{B:5, C:8, D:5, E:5, F:6, G:10, H:2, I:2}\n"+
      "43 : C          Vote{C, D, I, F, B, A, H, E, G} Tally{B:5, C:9, D:5, E:5, F:6, G:10, H:2, I:2}\n"+
      "44 : D          Vote{D, G, B, A, C, E, F, H, I} Tally{B:5, C:9, D:6, E:5, F:6, G:10, H:2, I:2}\n"+
      "45 : B          Vote{B, H, G, A, F, D, I, C, E} Tally{B:6, C:9, D:6, E:5, F:6, G:10, H:2, I:2}\n"+
      "46 : H          Vote{H, I, A, D, G, F, E, C, B} Tally{B:6, C:9, D:6, E:5, F:6, G:10, H:3, I:2}\n"+
      "47 : F          Vote{F, G, B, I, D, H, C, A, E} Tally{B:6, C:9, D:6, E:5, F:7, G:10, H:3, I:2}\n"+
      "48 : I          Vote{I, H, G, E, B, F, C, D, A} Tally{B:6, C:9, D:6, E:5, F:7, G:10, H:3, I:3}\n"+
      "49 : D          Vote{D, H, A, E, I, B, C, F, G} Tally{B:6, C:9, D:7, E:5, F:7, G:10, H:3, I:3}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  6  12.0 B\n"+
      "  9  18.0 C\n"+
      "  7  14.0 D\n"+
      "  5  10.0 E\n"+
      "  7  14.0 F\n"+
      " 10  20.0 G\n"+
      "  3   6.0 H\n"+
      "  3   6.0 I\n"+
      "\n"+
      "2 minimum vote candidates\n"+
      "Eliminating: H\n"+
      "Eliminating: I\n"+
      "\n"+
      "Round 3 : 6 candidates Tally{B:0, C:0, D:0, E:0, F:0, G:0}\n"+
      "Transcript:\n"+
      " 0 : F          Vote{F, I, B, G, D, A, C, E, H} Tally{B:0, C:0, D:0, E:0, F:1, G:0}\n"+
      " 1 : C          Vote{C, A, B, G, D, H, E, F, I} Tally{B:0, C:1, D:0, E:0, F:1, G:0}\n"+
      " 2 : B          Vote{B, C, H, F, I, G, A, E, D} Tally{B:1, C:1, D:0, E:0, F:1, G:0}\n"+
      " 3 : B          Vote{I, H, B, E, A, F, C, G, D} Tally{B:2, C:1, D:0, E:0, F:1, G:0}\n"+
      " 4 : B          Vote{B, G, E, C, H, A, I, D, F} Tally{B:3, C:1, D:0, E:0, F:1, G:0}\n"+
      " 5 : D          Vote{D, H, G, E, B, F, A, C, I} Tally{B:3, C:1, D:1, E:0, F:1, G:0}\n"+
      " 6 : G          Vote{G, I, B, H, A, F, D, C, E} Tally{B:3, C:1, D:1, E:0, F:1, G:1}\n"+
      " 7 : G          Vote{G, C, I, B, D, H, A, F, E} Tally{B:3, C:1, D:1, E:0, F:1, G:2}\n"+
      " 8 : F          Vote{F, H, A, I, D, B, G, C, E} Tally{B:3, C:1, D:1, E:0, F:2, G:2}\n"+
      " 9 : D          Vote{D, A, E, H, F, C, G, I, B} Tally{B:3, C:1, D:2, E:0, F:2, G:2}\n"+
      "10 : D          Vote{D, F, G, B, C, I, E, H, A} Tally{B:3, C:1, D:3, E:0, F:2, G:2}\n"+
      "11 : F          Vote{F, G, C, B, D, I, E, A, H} Tally{B:3, C:1, D:3, E:0, F:3, G:2}\n"+
      "12 : E          Vote{E, I, B, C, H, A, D, G, F} Tally{B:3, C:1, D:3, E:1, F:3, G:2}\n"+
      "13 : E          Vote{E, I, F, D, B, G, C, H, A} Tally{B:3, C:1, D:3, E:2, F:3, G:2}\n"+
      "14 : B          Vote{B, C, G, H, I, F, D, E, A} Tally{B:4, C:1, D:3, E:2, F:3, G:2}\n"+
      "15 : G          Vote{G, F, I, H, E, A, B, D, C} Tally{B:4, C:1, D:3, E:2, F:3, G:3}\n"+
      "16 : G          Vote{G, I, C, D, E, A, H, F, B} Tally{B:4, C:1, D:3, E:2, F:3, G:4}\n"+
      "17 : G          Vote{G, B, I, H, E, A, F, D, C} Tally{B:4, C:1, D:3, E:2, F:3, G:5}\n"+
      "18 : E          Vote{E, C, D, B, G, A, F, I, H} Tally{B:4, C:1, D:3, E:3, F:3, G:5}\n"+
      "19 : C          Vote{C, E, D, A, G, B, H, F, I} Tally{B:4, C:2, D:3, E:3, F:3, G:5}\n"+
      "20 : G          Vote{A, G, E, B, I, H, C, D, F} Tally{B:4, C:2, D:3, E:3, F:3, G:6}\n"+
      "21 : C          Vote{C, B, F, A, D, G, H, E, I} Tally{B:4, C:3, D:3, E:3, F:3, G:6}\n"+
      "22 : G          Vote{G, I, B, D, F, H, C, A, E} Tally{B:4, C:3, D:3, E:3, F:3, G:7}\n"+
      "23 : E          Vote{E, A, F, G, B, D, I, H, C} Tally{B:4, C:3, D:3, E:4, F:3, G:7}\n"+
      "24 : G          Vote{H, G, I, F, B, D, C, A, E} Tally{B:4, C:3, D:3, E:4, F:3, G:8}\n"+
      "25 : E          Vote{E, F, I, B, D, A, C, G, H} Tally{B:4, C:3, D:3, E:5, F:3, G:8}\n"+
      "26 : F          Vote{F, A, E, D, B, G, H, I, C} Tally{B:4, C:3, D:3, E:5, F:4, G:8}\n"+
      "27 : G          Vote{G, H, D, B, F, I, E, C, A} Tally{B:4, C:3, D:3, E:5, F:4, G:9}\n"+
      "28 : F          Vote{F, I, H, E, A, D, C, B, G} Tally{B:4, C:3, D:3, E:5, F:5, G:9}\n"+
      "29 : D          Vote{D, C, H, F, E, I, A, B, G} Tally{B:4, C:3, D:4, E:5, F:5, G:9}\n"+
      "30 : C          Vote{C, I, H, A, G, D, E, F, B} Tally{B:4, C:4, D:4, E:5, F:5, G:9}\n"+
      "31 : C          Vote{C, I, F, G, E, D, A, B, H} Tally{B:4, C:5, D:4, E:5, F:5, G:9}\n"+
      "32 : C          Vote{C, F, D, A, B, G, E, I, H} Tally{B:4, C:6, D:4, E:5, F:5, G:9}\n"+
      "33 : B          Vote{B, A, H, F, C, I, D, G, E} Tally{B:5, C:6, D:4, E:5, F:5, G:9}\n"+
      "34 : G          Vote{G, C, A, B, I, E, D, F, H} Tally{B:5, C:6, D:4, E:5, F:5, G:10}\n"+
      "35 : B          Vote{B, D, I, C, A, H, E, F, G} Tally{B:6, C:6, D:4, E:5, F:5, G:10}\n"+
      "36 : E          Vote{H, E, A, C, F, G, B, I, D} Tally{B:6, C:6, D:4, E:6, F:5, G:10}\n"+
      "37 : C          Vote{C, G, B, F, I, D, H, A, E} Tally{B:6, C:7, D:4, E:6, F:5, G:10}\n"+
      "38 : D          Vote{I, D, C, F, A, B, E, H, G} Tally{B:6, C:7, D:5, E:6, F:5, G:10}\n"+
      "39 : G          Vote{G, B, F, C, H, D, A, E, I} Tally{B:6, C:7, D:5, E:6, F:5, G:11}\n"+
      "40 : F          Vote{F, H, E, G, C, B, D, A, I} Tally{B:6, C:7, D:5, E:6, F:6, G:11}\n"+
      "41 : D          Vote{A, D, C, F, H, G, I, B, E} Tally{B:6, C:7, D:6, E:6, F:6, G:11}\n"+
      "42 : C          Vote{C, D, F, I, B, E, G, H, A} Tally{B:6, C:8, D:6, E:6, F:6, G:11}\n"+
      "43 : C          Vote{C, D, I, F, B, A, H, E, G} Tally{B:6, C:9, D:6, E:6, F:6, G:11}\n"+
      "44 : D          Vote{D, G, B, A, C, E, F, H, I} Tally{B:6, C:9, D:7, E:6, F:6, G:11}\n"+
      "45 : B          Vote{B, H, G, A, F, D, I, C, E} Tally{B:7, C:9, D:7, E:6, F:6, G:11}\n"+
      "46 : D          Vote{H, I, A, D, G, F, E, C, B} Tally{B:7, C:9, D:8, E:6, F:6, G:11}\n"+
      "47 : F          Vote{F, G, B, I, D, H, C, A, E} Tally{B:7, C:9, D:8, E:6, F:7, G:11}\n"+
      "48 : G          Vote{I, H, G, E, B, F, C, D, A} Tally{B:7, C:9, D:8, E:6, F:7, G:12}\n"+
      "49 : D          Vote{D, H, A, E, I, B, C, F, G} Tally{B:7, C:9, D:9, E:6, F:7, G:12}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  7  14.0 B\n"+
      "  9  18.0 C\n"+
      "  9  18.0 D\n"+
      "  6  12.0 E\n"+
      "  7  14.0 F\n"+
      " 12  24.0 G\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: E\n"+
      "\n"+
      "Round 4 : 5 candidates Tally{B:0, C:0, D:0, F:0, G:0}\n"+
      "Transcript:\n"+
      " 0 : F          Vote{F, I, B, G, D, A, C, E, H} Tally{B:0, C:0, D:0, F:1, G:0}\n"+
      " 1 : C          Vote{C, A, B, G, D, H, E, F, I} Tally{B:0, C:1, D:0, F:1, G:0}\n"+
      " 2 : B          Vote{B, C, H, F, I, G, A, E, D} Tally{B:1, C:1, D:0, F:1, G:0}\n"+
      " 3 : B          Vote{I, H, B, E, A, F, C, G, D} Tally{B:2, C:1, D:0, F:1, G:0}\n"+
      " 4 : B          Vote{B, G, E, C, H, A, I, D, F} Tally{B:3, C:1, D:0, F:1, G:0}\n"+
      " 5 : D          Vote{D, H, G, E, B, F, A, C, I} Tally{B:3, C:1, D:1, F:1, G:0}\n"+
      " 6 : G          Vote{G, I, B, H, A, F, D, C, E} Tally{B:3, C:1, D:1, F:1, G:1}\n"+
      " 7 : G          Vote{G, C, I, B, D, H, A, F, E} Tally{B:3, C:1, D:1, F:1, G:2}\n"+
      " 8 : F          Vote{F, H, A, I, D, B, G, C, E} Tally{B:3, C:1, D:1, F:2, G:2}\n"+
      " 9 : D          Vote{D, A, E, H, F, C, G, I, B} Tally{B:3, C:1, D:2, F:2, G:2}\n"+
      "10 : D          Vote{D, F, G, B, C, I, E, H, A} Tally{B:3, C:1, D:3, F:2, G:2}\n"+
      "11 : F          Vote{F, G, C, B, D, I, E, A, H} Tally{B:3, C:1, D:3, F:3, G:2}\n"+
      "12 : B          Vote{E, I, B, C, H, A, D, G, F} Tally{B:4, C:1, D:3, F:3, G:2}\n"+
      "13 : F          Vote{E, I, F, D, B, G, C, H, A} Tally{B:4, C:1, D:3, F:4, G:2}\n"+
      "14 : B          Vote{B, C, G, H, I, F, D, E, A} Tally{B:5, C:1, D:3, F:4, G:2}\n"+
      "15 : G          Vote{G, F, I, H, E, A, B, D, C} Tally{B:5, C:1, D:3, F:4, G:3}\n"+
      "16 : G          Vote{G, I, C, D, E, A, H, F, B} Tally{B:5, C:1, D:3, F:4, G:4}\n"+
      "17 : G          Vote{G, B, I, H, E, A, F, D, C} Tally{B:5, C:1, D:3, F:4, G:5}\n"+
      "18 : C          Vote{E, C, D, B, G, A, F, I, H} Tally{B:5, C:2, D:3, F:4, G:5}\n"+
      "19 : C          Vote{C, E, D, A, G, B, H, F, I} Tally{B:5, C:3, D:3, F:4, G:5}\n"+
      "20 : G          Vote{A, G, E, B, I, H, C, D, F} Tally{B:5, C:3, D:3, F:4, G:6}\n"+
      "21 : C          Vote{C, B, F, A, D, G, H, E, I} Tally{B:5, C:4, D:3, F:4, G:6}\n"+
      "22 : G          Vote{G, I, B, D, F, H, C, A, E} Tally{B:5, C:4, D:3, F:4, G:7}\n"+
      "23 : F          Vote{E, A, F, G, B, D, I, H, C} Tally{B:5, C:4, D:3, F:5, G:7}\n"+
      "24 : G          Vote{H, G, I, F, B, D, C, A, E} Tally{B:5, C:4, D:3, F:5, G:8}\n"+
      "25 : F          Vote{E, F, I, B, D, A, C, G, H} Tally{B:5, C:4, D:3, F:6, G:8}\n"+
      "26 : F          Vote{F, A, E, D, B, G, H, I, C} Tally{B:5, C:4, D:3, F:7, G:8}\n"+
      "27 : G          Vote{G, H, D, B, F, I, E, C, A} Tally{B:5, C:4, D:3, F:7, G:9}\n"+
      "28 : F          Vote{F, I, H, E, A, D, C, B, G} Tally{B:5, C:4, D:3, F:8, G:9}\n"+
      "29 : D          Vote{D, C, H, F, E, I, A, B, G} Tally{B:5, C:4, D:4, F:8, G:9}\n"+
      "30 : C          Vote{C, I, H, A, G, D, E, F, B} Tally{B:5, C:5, D:4, F:8, G:9}\n"+
      "31 : C          Vote{C, I, F, G, E, D, A, B, H} Tally{B:5, C:6, D:4, F:8, G:9}\n"+
      "32 : C          Vote{C, F, D, A, B, G, E, I, H} Tally{B:5, C:7, D:4, F:8, G:9}\n"+
      "33 : B          Vote{B, A, H, F, C, I, D, G, E} Tally{B:6, C:7, D:4, F:8, G:9}\n"+
      "34 : G          Vote{G, C, A, B, I, E, D, F, H} Tally{B:6, C:7, D:4, F:8, G:10}\n"+
      "35 : B          Vote{B, D, I, C, A, H, E, F, G} Tally{B:7, C:7, D:4, F:8, G:10}\n"+
      "36 : C          Vote{H, E, A, C, F, G, B, I, D} Tally{B:7, C:8, D:4, F:8, G:10}\n"+
      "37 : C          Vote{C, G, B, F, I, D, H, A, E} Tally{B:7, C:9, D:4, F:8, G:10}\n"+
      "38 : D          Vote{I, D, C, F, A, B, E, H, G} Tally{B:7, C:9, D:5, F:8, G:10}\n"+
      "39 : G          Vote{G, B, F, C, H, D, A, E, I} Tally{B:7, C:9, D:5, F:8, G:11}\n"+
      "40 : F          Vote{F, H, E, G, C, B, D, A, I} Tally{B:7, C:9, D:5, F:9, G:11}\n"+
      "41 : D          Vote{A, D, C, F, H, G, I, B, E} Tally{B:7, C:9, D:6, F:9, G:11}\n"+
      "42 : C          Vote{C, D, F, I, B, E, G, H, A} Tally{B:7, C:10, D:6, F:9, G:11}\n"+
      "43 : C          Vote{C, D, I, F, B, A, H, E, G} Tally{B:7, C:11, D:6, F:9, G:11}\n"+
      "44 : D          Vote{D, G, B, A, C, E, F, H, I} Tally{B:7, C:11, D:7, F:9, G:11}\n"+
      "45 : B          Vote{B, H, G, A, F, D, I, C, E} Tally{B:8, C:11, D:7, F:9, G:11}\n"+
      "46 : D          Vote{H, I, A, D, G, F, E, C, B} Tally{B:8, C:11, D:8, F:9, G:11}\n"+
      "47 : F          Vote{F, G, B, I, D, H, C, A, E} Tally{B:8, C:11, D:8, F:10, G:11}\n"+
      "48 : G          Vote{I, H, G, E, B, F, C, D, A} Tally{B:8, C:11, D:8, F:10, G:12}\n"+
      "49 : D          Vote{D, H, A, E, I, B, C, F, G} Tally{B:8, C:11, D:9, F:10, G:12}\n"+
      "\n"+
      "CNT     % NAME\n"+
      "  8  16.0 B\n"+
      " 11  22.0 C\n"+
      "  9  18.0 D\n"+
      " 10  20.0 F\n"+
      " 12  24.0 G\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: B\n"+
      "\n"+
      "Round 5 : 4 candidates Tally{C:0, D:0, F:0, G:0}\n"+
      "Transcript:\n"+
      " 0 : F          Vote{F, I, B, G, D, A, C, E, H} Tally{C:0, D:0, F:1, G:0}\n"+
      " 1 : C          Vote{C, A, B, G, D, H, E, F, I} Tally{C:1, D:0, F:1, G:0}\n"+
      " 2 : C          Vote{B, C, H, F, I, G, A, E, D} Tally{C:2, D:0, F:1, G:0}\n"+
      " 3 : F          Vote{I, H, B, E, A, F, C, G, D} Tally{C:2, D:0, F:2, G:0}\n"+
      " 4 : G          Vote{B, G, E, C, H, A, I, D, F} Tally{C:2, D:0, F:2, G:1}\n"+
      " 5 : D          Vote{D, H, G, E, B, F, A, C, I} Tally{C:2, D:1, F:2, G:1}\n"+
      " 6 : G          Vote{G, I, B, H, A, F, D, C, E} Tally{C:2, D:1, F:2, G:2}\n"+
      " 7 : G          Vote{G, C, I, B, D, H, A, F, E} Tally{C:2, D:1, F:2, G:3}\n"+
      " 8 : F          Vote{F, H, A, I, D, B, G, C, E} Tally{C:2, D:1, F:3, G:3}\n"+
      " 9 : D          Vote{D, A, E, H, F, C, G, I, B} Tally{C:2, D:2, F:3, G:3}\n"+
      "10 : D          Vote{D, F, G, B, C, I, E, H, A} Tally{C:2, D:3, F:3, G:3}\n"+
      "11 : F          Vote{F, G, C, B, D, I, E, A, H} Tally{C:2, D:3, F:4, G:3}\n"+
      "12 : C          Vote{E, I, B, C, H, A, D, G, F} Tally{C:3, D:3, F:4, G:3}\n"+
      "13 : F          Vote{E, I, F, D, B, G, C, H, A} Tally{C:3, D:3, F:5, G:3}\n"+
      "14 : C          Vote{B, C, G, H, I, F, D, E, A} Tally{C:4, D:3, F:5, G:3}\n"+
      "15 : G          Vote{G, F, I, H, E, A, B, D, C} Tally{C:4, D:3, F:5, G:4}\n"+
      "16 : G          Vote{G, I, C, D, E, A, H, F, B} Tally{C:4, D:3, F:5, G:5}\n"+
      "17 : G          Vote{G, B, I, H, E, A, F, D, C} Tally{C:4, D:3, F:5, G:6}\n"+
      "18 : C          Vote{E, C, D, B, G, A, F, I, H} Tally{C:5, D:3, F:5, G:6}\n"+
      "19 : C          Vote{C, E, D, A, G, B, H, F, I} Tally{C:6, D:3, F:5, G:6}\n"+
      "20 : G          Vote{A, G, E, B, I, H, C, D, F} Tally{C:6, D:3, F:5, G:7}\n"+
      "21 : C          Vote{C, B, F, A, D, G, H, E, I} Tally{C:7, D:3, F:5, G:7}\n"+
      "22 : G          Vote{G, I, B, D, F, H, C, A, E} Tally{C:7, D:3, F:5, G:8}\n"+
      "23 : F          Vote{E, A, F, G, B, D, I, H, C} Tally{C:7, D:3, F:6, G:8}\n"+
      "24 : G          Vote{H, G, I, F, B, D, C, A, E} Tally{C:7, D:3, F:6, G:9}\n"+
      "25 : F          Vote{E, F, I, B, D, A, C, G, H} Tally{C:7, D:3, F:7, G:9}\n"+
      "26 : F          Vote{F, A, E, D, B, G, H, I, C} Tally{C:7, D:3, F:8, G:9}\n"+
      "27 : G          Vote{G, H, D, B, F, I, E, C, A} Tally{C:7, D:3, F:8, G:10}\n"+
      "28 : F          Vote{F, I, H, E, A, D, C, B, G} Tally{C:7, D:3, F:9, G:10}\n"+
      "29 : D          Vote{D, C, H, F, E, I, A, B, G} Tally{C:7, D:4, F:9, G:10}\n"+
      "30 : C          Vote{C, I, H, A, G, D, E, F, B} Tally{C:8, D:4, F:9, G:10}\n"+
      "31 : C          Vote{C, I, F, G, E, D, A, B, H} Tally{C:9, D:4, F:9, G:10}\n"+
      "32 : C          Vote{C, F, D, A, B, G, E, I, H} Tally{C:10, D:4, F:9, G:10}\n"+
      "33 : F          Vote{B, A, H, F, C, I, D, G, E} Tally{C:10, D:4, F:10, G:10}\n"+
      "34 : G          Vote{G, C, A, B, I, E, D, F, H} Tally{C:10, D:4, F:10, G:11}\n"+
      "35 : D          Vote{B, D, I, C, A, H, E, F, G} Tally{C:10, D:5, F:10, G:11}\n"+
      "36 : C          Vote{H, E, A, C, F, G, B, I, D} Tally{C:11, D:5, F:10, G:11}\n"+
      "37 : C          Vote{C, G, B, F, I, D, H, A, E} Tally{C:12, D:5, F:10, G:11}\n"+
      "38 : D          Vote{I, D, C, F, A, B, E, H, G} Tally{C:12, D:6, F:10, G:11}\n"+
      "39 : G          Vote{G, B, F, C, H, D, A, E, I} Tally{C:12, D:6, F:10, G:12}\n"+
      "40 : F          Vote{F, H, E, G, C, B, D, A, I} Tally{C:12, D:6, F:11, G:12}\n"+
      "41 : D          Vote{A, D, C, F, H, G, I, B, E} Tally{C:12, D:7, F:11, G:12}\n"+
      "42 : C          Vote{C, D, F, I, B, E, G, H, A} Tally{C:13, D:7, F:11, G:12}\n"+
      "43 : C          Vote{C, D, I, F, B, A, H, E, G} Tally{C:14, D:7, F:11, G:12}\n"+
      "44 : D          Vote{D, G, B, A, C, E, F, H, I} Tally{C:14, D:8, F:11, G:12}\n"+
      "45 : G          Vote{B, H, G, A, F, D, I, C, E} Tally{C:14, D:8, F:11, G:13}\n"+
      "46 : D          Vote{H, I, A, D, G, F, E, C, B} Tally{C:14, D:9, F:11, G:13}\n"+
      "47 : F          Vote{F, G, B, I, D, H, C, A, E} Tally{C:14, D:9, F:12, G:13}\n"+
      "48 : G          Vote{I, H, G, E, B, F, C, D, A} Tally{C:14, D:9, F:12, G:14}\n"+
      "49 : D          Vote{D, H, A, E, I, B, C, F, G} Tally{C:14, D:10, F:12, G:14}\n"+
      "\n"+
      "CNT     % NAME\n"+
      " 14  28.0 C\n"+
      " 10  20.0 D\n"+
      " 12  24.0 F\n"+
      " 14  28.0 G\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: D\n"+
      "\n"+
      "Round 6 : 3 candidates Tally{C:0, F:0, G:0}\n"+
      "Transcript:\n"+
      " 0 : F          Vote{F, I, B, G, D, A, C, E, H} Tally{C:0, F:1, G:0}\n"+
      " 1 : C          Vote{C, A, B, G, D, H, E, F, I} Tally{C:1, F:1, G:0}\n"+
      " 2 : C          Vote{B, C, H, F, I, G, A, E, D} Tally{C:2, F:1, G:0}\n"+
      " 3 : F          Vote{I, H, B, E, A, F, C, G, D} Tally{C:2, F:2, G:0}\n"+
      " 4 : G          Vote{B, G, E, C, H, A, I, D, F} Tally{C:2, F:2, G:1}\n"+
      " 5 : G          Vote{D, H, G, E, B, F, A, C, I} Tally{C:2, F:2, G:2}\n"+
      " 6 : G          Vote{G, I, B, H, A, F, D, C, E} Tally{C:2, F:2, G:3}\n"+
      " 7 : G          Vote{G, C, I, B, D, H, A, F, E} Tally{C:2, F:2, G:4}\n"+
      " 8 : F          Vote{F, H, A, I, D, B, G, C, E} Tally{C:2, F:3, G:4}\n"+
      " 9 : F          Vote{D, A, E, H, F, C, G, I, B} Tally{C:2, F:4, G:4}\n"+
      "10 : F          Vote{D, F, G, B, C, I, E, H, A} Tally{C:2, F:5, G:4}\n"+
      "11 : F          Vote{F, G, C, B, D, I, E, A, H} Tally{C:2, F:6, G:4}\n"+
      "12 : C          Vote{E, I, B, C, H, A, D, G, F} Tally{C:3, F:6, G:4}\n"+
      "13 : F          Vote{E, I, F, D, B, G, C, H, A} Tally{C:3, F:7, G:4}\n"+
      "14 : C          Vote{B, C, G, H, I, F, D, E, A} Tally{C:4, F:7, G:4}\n"+
      "15 : G          Vote{G, F, I, H, E, A, B, D, C} Tally{C:4, F:7, G:5}\n"+
      "16 : G          Vote{G, I, C, D, E, A, H, F, B} Tally{C:4, F:7, G:6}\n"+
      "17 : G          Vote{G, B, I, H, E, A, F, D, C} Tally{C:4, F:7, G:7}\n"+
      "18 : C          Vote{E, C, D, B, G, A, F, I, H} Tally{C:5, F:7, G:7}\n"+
      "19 : C          Vote{C, E, D, A, G, B, H, F, I} Tally{C:6, F:7, G:7}\n"+
      "20 : G          Vote{A, G, E, B, I, H, C, D, F} Tally{C:6, F:7, G:8}\n"+
      "21 : C          Vote{C, B, F, A, D, G, H, E, I} Tally{C:7, F:7, G:8}\n"+
      "22 : G          Vote{G, I, B, D, F, H, C, A, E} Tally{C:7, F:7, G:9}\n"+
      "23 : F          Vote{E, A, F, G, B, D, I, H, C} Tally{C:7, F:8, G:9}\n"+
      "24 : G          Vote{H, G, I, F, B, D, C, A, E} Tally{C:7, F:8, G:10}\n"+
      "25 : F          Vote{E, F, I, B, D, A, C, G, H} Tally{C:7, F:9, G:10}\n"+
      "26 : F          Vote{F, A, E, D, B, G, H, I, C} Tally{C:7, F:10, G:10}\n"+
      "27 : G          Vote{G, H, D, B, F, I, E, C, A} Tally{C:7, F:10, G:11}\n"+
      "28 : F          Vote{F, I, H, E, A, D, C, B, G} Tally{C:7, F:11, G:11}\n"+
      "29 : C          Vote{D, C, H, F, E, I, A, B, G} Tally{C:8, F:11, G:11}\n"+
      "30 : C          Vote{C, I, H, A, G, D, E, F, B} Tally{C:9, F:11, G:11}\n"+
      "31 : C          Vote{C, I, F, G, E, D, A, B, H} Tally{C:10, F:11, G:11}\n"+
      "32 : C          Vote{C, F, D, A, B, G, E, I, H} Tally{C:11, F:11, G:11}\n"+
      "33 : F          Vote{B, A, H, F, C, I, D, G, E} Tally{C:11, F:12, G:11}\n"+
      "34 : G          Vote{G, C, A, B, I, E, D, F, H} Tally{C:11, F:12, G:12}\n"+
      "35 : C          Vote{B, D, I, C, A, H, E, F, G} Tally{C:12, F:12, G:12}\n"+
      "36 : C          Vote{H, E, A, C, F, G, B, I, D} Tally{C:13, F:12, G:12}\n"+
      "37 : C          Vote{C, G, B, F, I, D, H, A, E} Tally{C:14, F:12, G:12}\n"+
      "38 : C          Vote{I, D, C, F, A, B, E, H, G} Tally{C:15, F:12, G:12}\n"+
      "39 : G          Vote{G, B, F, C, H, D, A, E, I} Tally{C:15, F:12, G:13}\n"+
      "40 : F          Vote{F, H, E, G, C, B, D, A, I} Tally{C:15, F:13, G:13}\n"+
      "41 : C          Vote{A, D, C, F, H, G, I, B, E} Tally{C:16, F:13, G:13}\n"+
      "42 : C          Vote{C, D, F, I, B, E, G, H, A} Tally{C:17, F:13, G:13}\n"+
      "43 : C          Vote{C, D, I, F, B, A, H, E, G} Tally{C:18, F:13, G:13}\n"+
      "44 : G          Vote{D, G, B, A, C, E, F, H, I} Tally{C:18, F:13, G:14}\n"+
      "45 : G          Vote{B, H, G, A, F, D, I, C, E} Tally{C:18, F:13, G:15}\n"+
      "46 : G          Vote{H, I, A, D, G, F, E, C, B} Tally{C:18, F:13, G:16}\n"+
      "47 : F          Vote{F, G, B, I, D, H, C, A, E} Tally{C:18, F:14, G:16}\n"+
      "48 : G          Vote{I, H, G, E, B, F, C, D, A} Tally{C:18, F:14, G:17}\n"+
      "49 : C          Vote{D, H, A, E, I, B, C, F, G} Tally{C:19, F:14, G:17}\n"+
      "\n"+
      "CNT     % NAME\n"+
      " 19  38.0 C\n"+
      " 14  28.0 F\n"+
      " 17  34.0 G\n"+
      "\n"+
      "1 minimum vote candidates\n"+
      "Eliminating: F\n"+
      "\n"+
      "Round 7 : 2 candidates Tally{C:0, G:0}\n"+
      "Transcript:\n"+
      " 0 : G          Vote{F, I, B, G, D, A, C, E, H} Tally{C:0, G:1}\n"+
      " 1 : C          Vote{C, A, B, G, D, H, E, F, I} Tally{C:1, G:1}\n"+
      " 2 : C          Vote{B, C, H, F, I, G, A, E, D} Tally{C:2, G:1}\n"+
      " 3 : C          Vote{I, H, B, E, A, F, C, G, D} Tally{C:3, G:1}\n"+
      " 4 : G          Vote{B, G, E, C, H, A, I, D, F} Tally{C:3, G:2}\n"+
      " 5 : G          Vote{D, H, G, E, B, F, A, C, I} Tally{C:3, G:3}\n"+
      " 6 : G          Vote{G, I, B, H, A, F, D, C, E} Tally{C:3, G:4}\n"+
      " 7 : G          Vote{G, C, I, B, D, H, A, F, E} Tally{C:3, G:5}\n"+
      " 8 : G          Vote{F, H, A, I, D, B, G, C, E} Tally{C:3, G:6}\n"+
      " 9 : C          Vote{D, A, E, H, F, C, G, I, B} Tally{C:4, G:6}\n"+
      "10 : G          Vote{D, F, G, B, C, I, E, H, A} Tally{C:4, G:7}\n"+
      "11 : G          Vote{F, G, C, B, D, I, E, A, H} Tally{C:4, G:8}\n"+
      "12 : C          Vote{E, I, B, C, H, A, D, G, F} Tally{C:5, G:8}\n"+
      "13 : G          Vote{E, I, F, D, B, G, C, H, A} Tally{C:5, G:9}\n"+
      "14 : C          Vote{B, C, G, H, I, F, D, E, A} Tally{C:6, G:9}\n"+
      "15 : G          Vote{G, F, I, H, E, A, B, D, C} Tally{C:6, G:10}\n"+
      "16 : G          Vote{G, I, C, D, E, A, H, F, B} Tally{C:6, G:11}\n"+
      "17 : G          Vote{G, B, I, H, E, A, F, D, C} Tally{C:6, G:12}\n"+
      "18 : C          Vote{E, C, D, B, G, A, F, I, H} Tally{C:7, G:12}\n"+
      "19 : C          Vote{C, E, D, A, G, B, H, F, I} Tally{C:8, G:12}\n"+
      "20 : G          Vote{A, G, E, B, I, H, C, D, F} Tally{C:8, G:13}\n"+
      "21 : C          Vote{C, B, F, A, D, G, H, E, I} Tally{C:9, G:13}\n"+
      "22 : G          Vote{G, I, B, D, F, H, C, A, E} Tally{C:9, G:14}\n"+
      "23 : G          Vote{E, A, F, G, B, D, I, H, C} Tally{C:9, G:15}\n"+
      "24 : G          Vote{H, G, I, F, B, D, C, A, E} Tally{C:9, G:16}\n"+
      "25 : C          Vote{E, F, I, B, D, A, C, G, H} Tally{C:10, G:16}\n"+
      "26 : G          Vote{F, A, E, D, B, G, H, I, C} Tally{C:10, G:17}\n"+
      "27 : G          Vote{G, H, D, B, F, I, E, C, A} Tally{C:10, G:18}\n"+
      "28 : C          Vote{F, I, H, E, A, D, C, B, G} Tally{C:11, G:18}\n"+
      "29 : C          Vote{D, C, H, F, E, I, A, B, G} Tally{C:12, G:18}\n"+
      "30 : C          Vote{C, I, H, A, G, D, E, F, B} Tally{C:13, G:18}\n"+
      "31 : C          Vote{C, I, F, G, E, D, A, B, H} Tally{C:14, G:18}\n"+
      "32 : C          Vote{C, F, D, A, B, G, E, I, H} Tally{C:15, G:18}\n"+
      "33 : C          Vote{B, A, H, F, C, I, D, G, E} Tally{C:16, G:18}\n"+
      "34 : G          Vote{G, C, A, B, I, E, D, F, H} Tally{C:16, G:19}\n"+
      "35 : C          Vote{B, D, I, C, A, H, E, F, G} Tally{C:17, G:19}\n"+
      "36 : C          Vote{H, E, A, C, F, G, B, I, D} Tally{C:18, G:19}\n"+
      "37 : C          Vote{C, G, B, F, I, D, H, A, E} Tally{C:19, G:19}\n"+
      "38 : C          Vote{I, D, C, F, A, B, E, H, G} Tally{C:20, G:19}\n"+
      "39 : G          Vote{G, B, F, C, H, D, A, E, I} Tally{C:20, G:20}\n"+
      "40 : G          Vote{F, H, E, G, C, B, D, A, I} Tally{C:20, G:21}\n"+
      "41 : C          Vote{A, D, C, F, H, G, I, B, E} Tally{C:21, G:21}\n"+
      "42 : C          Vote{C, D, F, I, B, E, G, H, A} Tally{C:22, G:21}\n"+
      "43 : C          Vote{C, D, I, F, B, A, H, E, G} Tally{C:23, G:21}\n"+
      "44 : G          Vote{D, G, B, A, C, E, F, H, I} Tally{C:23, G:22}\n"+
      "45 : G          Vote{B, H, G, A, F, D, I, C, E} Tally{C:23, G:23}\n"+
      "46 : G          Vote{H, I, A, D, G, F, E, C, B} Tally{C:23, G:24}\n"+
      "47 : G          Vote{F, G, B, I, D, H, C, A, E} Tally{C:23, G:25}\n"+
      "48 : G          Vote{I, H, G, E, B, F, C, D, A} Tally{C:23, G:26}\n"+
      "49 : C          Vote{D, H, A, E, I, B, C, F, G} Tally{C:24, G:26}\n"+
      "\n"+
      "CNT     % NAME\n"+
      " 24  48.0 C\n"+
      " 26  52.0 G\n"+
      "\n"+
      "WINNER: G\n"+
      "";
    Election.main(args);
    String actual = localOut.toString();
    checkOutput(args,expect,actual);
  }
  
}
