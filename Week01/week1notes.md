## Week 1 Notes
[Ch 1](http://math.hws.edu/javanotes/c1/index.html)

CPU = Boxes in memory
Variables, ways to refer to memory boxes, (remember CSCI 1410)
Memory box diagrams are important!

## Java Equivalents
Java's Version of Print
```java
System.out.println()
```
Java's Version of Declaring variables
```java
int a;
a = 800;
```
or
```java
int b = 303;
```
Java's Version of addition
```java
int c = a + b;
```
Java's Version of String Concatenation in a Print Statement
```java
System.out.println(a + " plus " + b);
System.out.println("is " + c);
```
Java's version of comments
```java
// This is a single line comment
/* This comments
spans
multiple
lines */
```
Java's version of naming convention
Letters numbers and underscores okay, spaces... no.
```java
forVariablesWeUseCamelCase
ForClassesWeDoThatButWithTheFirstOneCapitalized
```

## DrJava Information
We're using DrJava to make our code, specifically, [a modified version found here](https://github.com/DrJavaAtRice/drjava). It works just fine on my Ubuntu 16.04 Laptop [because it's a jar file](https://cs.gmu.edu/~kauffman/drjava/).

It can be run by double clicking it in the GUI or changing to it's directory and then running the command

```bash
java -jar drjava.jar
```

(Or in my case, it's probably drjava-gmu.jar)

## Java Logistics
Java code files have a .java extension. Compiled Java files have a .class extension. .class files need to be run by a Java interpreter, because Java uses the *Hannah Montana Voice* Beeeeeessssssttttt of both worlds (by that, I mean Python is better :P ) Java programs are compiled and then interpreted.

Also Object-Oriented Code! Basically, you know how in Python, with top-down design, it's hard to reuse code (I'll take your word on that textbook because I reuse code quite a bit), well with Object-Oriented Code, your code stuffs are objects, like a toaster. What goes on inside a toaster, who knows, but you send messages to your toaster (the bread), whenever you want, and it responds in a predictable way (with toast, hopefully, though more realistically char), so it's super reusable (toasters everywhere!)

To compile the program on the command line:
```
cd whereeveryouputyourjavacodestuffs/
javac WhateverYouNamedYourCode.java
```

To run the program on the command line:
```
java WhateverYouNamedYourCode
```

I mean, you could just do this in the IDE, but then you'll never impress your nerd friends.

# Exercises, Week 1 Lecture

## CPU Exercise

```
copy box #1024 to #1032
copy box #1028 to #1024
copy box #1032 to #1028
print "first",#1024
print "second",#1028
```

## Quick Review

1. The three physical components to a computer (in our simplified model) are
2. Box numbers like #1024 do not change, but their contents do
3. Boxes with names are variables
4. Java is a high-ish level programming language for computers
5. For a named box in Java, one declares a variable like so ```java int variable;```

## Swapping boxes in Java
```java
int x;
int y;
int temp;

x = 19;
y = 31;
temp = x;
x = y;
y = temp;
System.out.println("first " + x);
System.out.println("second " + y);
```

## Compile/Run
```java
public class Swap{
 public static void main(String args[]){
  int x;
  int y;
  int temp;

  x = 19;
  y = 31;
  temp = x;
  x = y;
  y = temp;
  System.out.println("first " + x);
  System.out.println("second " + y);
 }
}
```


