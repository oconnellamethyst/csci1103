import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;


public class TimeAwarenessTests extends KTests {
  /*Main method runs tests in this file*/ 
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("TimeAwarenessTests");
  } 

  @Test public void TimeAwareness_main1() {
    String input = "2.0 0.5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "STUDENT TIME AWARENESS SURVEY\n"+
      "-----------------------------\n"+
      "On average, how many hours per day including lecture/lab\n"+
      "do you spend on CSCI 1103? (ex 1.5 hours):\n"+
      "Sounds like you're applying proper effort\n"+
      "\n"+
      "On average, how many hours per day do you spend using\n"+
      "social media such as Facebook/Twitter/Texting (ex 1.5 hours):\n"+
      "";
    TimeAwareness.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void TimeAwareness_main2() {
    String input = "1.1 0.5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "STUDENT TIME AWARENESS SURVEY\n"+
      "-----------------------------\n"+
      "On average, how many hours per day including lecture/lab\n"+
      "do you spend on CSCI 1103? (ex 1.5 hours):\n"+
      "Expected hours per day for a 4-credit class: 1.7\n"+
      "See https://policy.umn.edu/education/studentwork\n"+
      "Consider increasing your time spent on CSCI 1103\n"+
      "\n"+
      "On average, how many hours per day do you spend using\n"+
      "social media such as Facebook/Twitter/Texting (ex 1.5 hours):\n"+
      "";
    TimeAwareness.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void TimeAwareness_main3() {
    String input = "1.9 2.5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "STUDENT TIME AWARENESS SURVEY\n"+
      "-----------------------------\n"+
      "On average, how many hours per day including lecture/lab\n"+
      "do you spend on CSCI 1103? (ex 1.5 hours):\n"+
      "Sounds like you're applying proper effort\n"+
      "\n"+
      "On average, how many hours per day do you spend using\n"+
      "social media such as Facebook/Twitter/Texting (ex 1.5 hours):\n"+
      "Warning: 2 or more hours per day of social media use\n"+
      "has strong correlation with social isolation, morbidity\n"+
      "and mortality (!). Consider reducing you use\n"+
      "";
    TimeAwareness.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }
  @Test public void TimeAwareness_main4() {
    String input = "8.4 2.5";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "STUDENT TIME AWARENESS SURVEY\n"+
      "-----------------------------\n"+
      "On average, how many hours per day including lecture/lab\n"+
      "do you spend on CSCI 1103? (ex 1.5 hours):\n"+
      "You may be overdoing it. Seek help from the 1103 staff\n"+
      "or ask someone out on a date (not the course staff).\n"+
      "\n"+
      "On average, how many hours per day do you spend using\n"+
      "social media such as Facebook/Twitter/Texting (ex 1.5 hours):\n"+
      "Warning: 2 or more hours per day of social media use\n"+
      "has strong correlation with social isolation, morbidity\n"+
      "and mortality (!). Consider reducing you use\n"+
      "";
    TimeAwareness.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

  @Test public void TimeAwareness_main5() {
    String input = "0 0";
    TextIO.readStream(new StringReader(input));
    String expect = 
      "STUDENT TIME AWARENESS SURVEY\n"+
      "-----------------------------\n"+
      "On average, how many hours per day including lecture/lab\n"+
      "do you spend on CSCI 1103? (ex 1.5 hours):\n"+
      "Expected hours per day for a 4-credit class: 1.7\n"+
      "See https://policy.umn.edu/education/studentwork\n"+
      "Consider increasing your time spent on CSCI 1103\n"+
      "\n"+
      "On average, how many hours per day do you spend using\n"+
      "social media such as Facebook/Twitter/Texting (ex 1.5 hours):\n"+
      "\n"+
      "What are you doing with your time?\n"+
      "";
    TimeAwareness.main(empty);
    String actual = localOut.toString();
    checkOutput(input,expect,actual);
  }

}
