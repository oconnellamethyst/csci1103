import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class GrowableStackTests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("GrowableStackTests");
  }

  @Test public void growablestack_grow1(){
    GrowableStack stack = new GrowableStack(2);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    assertEquals("C"   , stack.getTop());
    assertEquals(4     , stack.getCapacity());
    assertEquals(3     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void growablestack_grow2(){
    GrowableStack stack = new GrowableStack(1);
    stack.push("A");
    assertEquals("A"   , stack.getTop());
    assertEquals(1     , stack.getCapacity());
    assertEquals(1     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());

    stack.push("B");
    assertEquals("B"   , stack.getTop());
    assertEquals(2     , stack.getCapacity());
    assertEquals(2     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());

    stack.push("C");
    assertEquals("C"   , stack.getTop());
    assertEquals(4     , stack.getCapacity());
    assertEquals(3     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false  , stack.isFull());
    stack.push("D");
    assertEquals("D"   , stack.getTop());
    assertEquals(4     , stack.getCapacity());
    assertEquals(4     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());

    stack.push("E");
    assertEquals("E"   , stack.getTop());
    assertEquals(8     , stack.getCapacity());
    assertEquals(5     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void growablestack_growtoString1(){
    String expect,actual,msg;
    GrowableStack stack = new GrowableStack(1);
    stack.push("A");
    expect =
      "size: 1\n"+
      "0 : A\n"+
      "";
    actual = stack.toString();
    msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
    stack.push("B");
    expect =
      "size: 2\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    actual = stack.toString();
    msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
    stack.push("C");
    expect =
      "size: 3\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    actual = stack.toString();
    msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
    stack.push("D");
    expect =
      "size: 4\n"+
      "3 : D\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    actual = stack.toString();
    msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
    stack.push("E");
    expect =
      "size: 5\n"+
      "4 : E\n"+
      "3 : D\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    actual = stack.toString();
    msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
  }
  @Test public void growablestack_grow_contentsString(){
    String expect,actual,msg;
    GrowableStack stack = new GrowableStack(1);
    stack.push("A");
    expect =
      "capacity: 1\n"+
      "0 : A\n"+
      "";
    actual = stack.contentsString();
    msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
    stack.push("B");
    expect =
      "capacity: 2\n"+
      "0 : A\n"+
      "1 : B\n"+
      "";
    actual = stack.contentsString();
    msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
    stack.push("C");
    expect =
      "capacity: 4\n"+
      "0 : A\n"+
      "1 : B\n"+
      "2 : C\n"+
      "3 : null\n"+
      "";
    actual = stack.contentsString();
    msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
    stack.push("D");
    expect =
      "capacity: 4\n"+
      "0 : A\n"+
      "1 : B\n"+
      "2 : C\n"+
      "3 : D\n"+
      "";
    actual = stack.contentsString();
    msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
    stack.push("E");
    expect =
      "capacity: 8\n"+
      "0 : A\n"+
      "1 : B\n"+
      "2 : C\n"+
      "3 : D\n"+
      "4 : E\n"+
      "5 : null\n"+
      "6 : null\n"+
      "7 : null\n"+
      "";
    actual = stack.contentsString();
    msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
    // 
  }


  @Test public void growablestack_constructor1(){
    GrowableStack stack = new GrowableStack(5);
  }
  @Test public void growablestack_constructor2(){
    GrowableStack stack = new GrowableStack(2);
  }

  @Test public void growablestack_basicAccessors1(){
    GrowableStack stack = new GrowableStack(5);
    assertEquals(5     , stack.getCapacity());
    assertEquals(0     , stack.getSize());
    assertEquals(true  , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void growablestack_basicAccessors2(){
    GrowableStack stack = new GrowableStack(2);
    assertEquals(2     , stack.getCapacity());
    assertEquals(0     , stack.getSize());
    assertEquals(true  , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }

  @Test public void growablestack_pushTop1(){
    GrowableStack stack = new GrowableStack(2);
    stack.push("A");
    assertEquals("A"   , stack.getTop());
    assertEquals(2     , stack.getCapacity());
    assertEquals(1     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void growablestack_pushTop2(){
    GrowableStack stack = new GrowableStack(2);
    stack.push("A");
    stack.push("B");
    assertEquals("B"   , stack.getTop());
    assertEquals(2     , stack.getCapacity());
    assertEquals(2     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());

  }
  @Test public void growablestack_pushTop3(){
    GrowableStack stack = new GrowableStack(5);
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
  @Test public void growablestack_pushTop4(){
    GrowableStack stack = new GrowableStack(5);
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");
    stack.push("E");
    assertEquals("E"   , stack.getTop());
    assertEquals(5     , stack.getCapacity());
    assertEquals(5     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());

  }

  @Test public void growablestack_getTopEmpty1(){
    GrowableStack stack = new GrowableStack(2);
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
  @Test public void growablestack_getTopEmpty2(){
    GrowableStack stack = new GrowableStack(5);
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


  @Test public void growablestack_pop1(){
    GrowableStack stack = new GrowableStack(2);
    stack.push("A");
    stack.pop();
    assertEquals(2     , stack.getCapacity());
    assertEquals(0     , stack.getSize());
    assertEquals(true  , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void growablestack_pop2(){
    GrowableStack stack = new GrowableStack(2);
    stack.push("A");
    stack.push("B");
    stack.pop();
    assertEquals("A"   , stack.getTop());
    assertEquals(2     , stack.getCapacity());
    assertEquals(1     , stack.getSize());
    assertEquals(false , stack.isEmpty());
    assertEquals(false , stack.isFull());
  }
  @Test public void growablestack_pop3(){
    GrowableStack stack = new GrowableStack(5);
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


  @Test public void growablestack_toString1(){
    String expect =
      "size: 0\n" +
      "";
    GrowableStack stack = new GrowableStack(2);
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void growablestack_toString2(){
    String expect =
      "size: 1\n"+
      "0 : A\n"+
      "";
    GrowableStack stack = new GrowableStack(2);
    stack.push("A");
    String actual = stack.toString();
    String msg =
      String.format("\ntoString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void growablestack_toString3(){
    String expect =
      "size: 2\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    GrowableStack stack = new GrowableStack(2);
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
  @Test public void growablestack_toString4(){
    String expect =
      "size: 3\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    GrowableStack stack = new GrowableStack(5);
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
  @Test public void growablestack_toString5(){
    String expect =
      "size: 5\n"+
      "4 : E\n"+
      "3 : D\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    GrowableStack stack = new GrowableStack(5);
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
  @Test public void growablestack_toString6(){
    String expect =
      "size: 3\n"+
      "2 : C\n"+
      "1 : B\n"+
      "0 : A\n"+
      "";
    GrowableStack stack = new GrowableStack(5);
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
  @Test public void growablestack_toString7(){
    String expect =
      "size: 0\n"+
      "";
    GrowableStack stack = new GrowableStack(5);
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

  @Test public void growablestack_contentsString1(){
    String expect =
      "capacity: 2\n"+
      "0 : null\n"+
      "1 : null\n"+
      "";
    GrowableStack stack = new GrowableStack(2);
    String actual = stack.contentsString();
    String msg =
      String.format("\ncontentsString() wrong\n") +
      String.format("EXPECT:\n%s\n",expect) +
      String.format("ACTUAL:\n%s\n",actual) +
      "";
    assertEquals(msg, expect, actual);
  }
  @Test public void growablestack_contentsString2(){
    String expect =
      "capacity: 3\n"+
      "0 : A\n"+
      "1 : B\n"+
      "2 : null\n"+
      "";
    GrowableStack stack = new GrowableStack(3);
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
  @Test public void growablestack_contentsString3(){
    String expect =
      "capacity: 5\n"+
      "0 : A\n"+
      "1 : B\n"+
      "2 : C\n"+
      "3 : D\n"+
      "4 : E\n"+
      "";
    GrowableStack stack = new GrowableStack(5);
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
  @Test public void growablestack_contentsString4(){
    String expect =
      "capacity: 5\n"+
      "0 : A\n"+
      "1 : C\n"+
      "2 : D\n"+
      "3 : null\n"+
      "4 : null\n"+
      "";
    GrowableStack stack = new GrowableStack(5);
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
