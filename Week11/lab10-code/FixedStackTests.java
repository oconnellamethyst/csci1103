import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class FixedStackTests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("FixedStackTests");
  }

  @Test public void fixedstack_constructor1(){
    FixedStack stack = new FixedStack(5);
  }
  @Test public void fixedstack_constructor2(){
    FixedStack stack = new FixedStack(2);
  }

  @Test public void fixedstack_basicAccessors1(){
    FixedStack stack = new FixedStack(5);
    assertEquals(5     , stack.getCapacity());
    assertEquals(0     , stack.getSize());
    assertEquals(true  , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void fixedstack_basicAccessors2(){
    FixedStack stack = new FixedStack(2);
    assertEquals(2     , stack.getCapacity());
    assertEquals(0     , stack.getSize());
    assertEquals(true  , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }

  @Test public void fixedstack_pushTop1(){
    FixedStack stack = new FixedStack(2);
    stack.push("A");
    assertEquals("A"   , stack.getTop());
    assertEquals(2     , stack.getCapacity());
    assertEquals(1     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void fixedstack_pushTop2(){
    FixedStack stack = new FixedStack(2);
    stack.push("A");
    stack.push("B");
    assertEquals("B"   , stack.getTop());
    assertEquals(2     , stack.getCapacity());
    assertEquals(2     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(true  , stack.isFull());
  }
  @Test public void fixedstack_pushTop3(){
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    assertEquals("D"   , stack.getTop());
    assertEquals(5     , stack.getCapacity());
    assertEquals(4     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void fixedstack_pushTop4(){
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    stack.push("E");
    assertEquals("E"   , stack.getTop());
    assertEquals(5     , stack.getCapacity());
    assertEquals(5     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(true  , stack.isFull());
  }

  @Test public void fixedstack_getTopEmpty1(){
    FixedStack stack = new FixedStack(2);
    try{
      String t = stack.getTop();
    }
    catch(RuntimeException e){
      if(e.getMessage().equals("Stack empty")){
        return;                 // pass
      }
    }
    fail("Should throw an exception with message 'Stack empty'");
  }
  @Test public void fixedstack_getTopEmpty2(){
    FixedStack stack = new FixedStack(5);
    try{
      String t = stack.getTop();
    }
    catch(RuntimeException e){
      if(e.getMessage().equals("Stack empty")){
        return;                 // pass
      }
    }
    fail("Should throw an exception with message 'Stack empty'");
  }

  @Test public void fixedstack_pushException1(){
    FixedStack stack = new FixedStack(2);
    stack.push("A");
    stack.push("B");
    try{
      stack.push("C");
    }
    catch(RuntimeException e){
      if(e.getMessage().equals("Stack full")){
        return;                 // pass
      }
    }
    fail("Should throw an exception with message 'Stack full'");
  }
  @Test public void fixedstack_pushException2(){
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    stack.push("E");
    try{
      stack.push("F");
    }
    catch(RuntimeException e){
      if(e.getMessage().equals("Stack full")){
        return;                 // pass
      }
    }
    fail("Should throw an exception with message 'Stack full'");
  }

  @Test public void fixedstack_pop1(){
    FixedStack stack = new FixedStack(2);
    stack.push("A");
    stack.pop();
    assertEquals(2     , stack.getCapacity());
    assertEquals(0     , stack.getSize());
    assertEquals(true  , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void fixedstack_pop2(){
    FixedStack stack = new FixedStack(2);
    stack.push("A");
    stack.push("B");
    stack.pop();
    assertEquals("A"   , stack.getTop());
    assertEquals(2     , stack.getCapacity());
    assertEquals(1     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void fixedstack_pop3(){
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.pop();
    stack.push("C");
    stack.push("D");
    stack.pop();
    assertEquals("C"   , stack.getTop());
    assertEquals(5     , stack.getCapacity());
    assertEquals(2     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }


  @Test public void fixedstack_toString1(){
    String expect =
      "size: 0\n" +
      "";
    FixedStack stack = new FixedStack(2);
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_toString2(){
    String expect =
      "size: 1\n"+
      "0 : A\n"+
      "";
    FixedStack stack = new FixedStack(2);
    stack.push("A");
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_toString3(){
    String expect =
      "size: 2\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    FixedStack stack = new FixedStack(2);
    stack.push("A");
    stack.push("B");
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_toString4(){
    String expect =
      "size: 3\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_toString5(){
    String expect =
      "size: 5\n"+
      "4 : E\n"+
      "3 : D\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    stack.push("E");
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_toString6(){
    String expect =
      "size: 3\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    stack.push("E");
    stack.pop();
    stack.pop();
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_toString7(){
    String expect =
      "size: 0\n"+
      "";
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    stack.push("E");
    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }

  @Test public void fixedstack_contentsString1(){
    String expect =
      "capacity: 2\n"+
      "0 : null\n"+
      "1 : null\n"+
      "";
    FixedStack stack = new FixedStack(2);
    String actual = stack.contentsString();
    String msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_contentsString2(){
    String expect =
      "capacity: 3\n"+
      "0 : A\n"+
      "1 : B\n"+
      "2 : null\n"+
      "";
    FixedStack stack = new FixedStack(3);
    stack.push("A");
    stack.push("B");
    String actual = stack.contentsString();
    String msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_contentsString3(){
    String expect =
      "capacity: 5\n"+
      "0 : A\n"+
      "1 : B\n"+
      "2 : C\n"+
      "3 : D\n"+
      "4 : E\n"+
      "";
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    stack.push("E");
    String actual = stack.contentsString();
    String msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void fixedstack_contentsString4(){
    String expect =
      "capacity: 5\n"+
      "0 : A\n"+
      "1 : C\n"+
      "2 : D\n"+
      "3 : null\n"+
      "4 : null\n"+
      "";
    FixedStack stack = new FixedStack(5);
    stack.push("A");
    stack.push("B");
    stack.pop();
    stack.push("C");
    stack.push("D");
    stack.push("E");
    stack.pop();
    String actual = stack.contentsString();
    String msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }

}
