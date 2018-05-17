# Week 2 Notes
[Ch 2](http://math.hws.edu/javanotes/c2/index.html)

Inputting text in Java is a pain, (Python is better), so for this Chapter, we're going to use a program, TextIO.java, that does it for us, and then learn to DIY it later. TextIO.java essentially Pythonifies the process, and adds error correction (try/except), though a copy of it needs to be in the folder, a la Python modules.


This is a docstring in Java
```java
/** A program to display the message
 *  "Hello World!" on standard output.
 */
```

A class is sort of like a module in Python except it's mandatory, and instead of just labelling the main part of the program with ```# Main```, you get to do it the fun way, mandatory labeling

```java
public static void main(String[] args) {
      statements
}
```

So when you do your programs, you do them like this
```
public class program-name {

    optional-variable-declarations-and-subroutines
    
    public static void main(String[] args) {
       statements
    }
    
    optional-variable-declarations-and-subroutines

}
```

Java is strongly typed, which means you have to assign a type to your variables and stick to it, unlike Python where you can pretty much go wild and free. Java has the following "primitive types" byte, short, int, long, float, double, char, and boolean. Doubles are kind of like floats with more space, and floats are like floats in Python. Ints are like integers in Python, Shorts are Ints that take up less space, longs are Ints that take up more space. Booleans are standard true and false, note, true and false, not True and False like Python. A char is a unicode character, but it can be used like a number, so it can do fun things like incrementing and decrementing, so I don't have to set up one of my famous ```chars = 'abcdefghijklmnopqrstuvwxyz'``` in Java, although in fairness to Python, I probably don't have to do that in Python either, I just don't know how to not do that yet, and I just really like looping through strings. This comes at a cost though, strings always use double quotes, chars use single quotes. 

You can declare multiple variables at the same time in Java, but you shouldn't. Escaping characters is a thing```\"```, ```\n``` as well as unicode characters like ```Pok\u00E9mon```. There are also hexadecimal numbers begining in ```0x```, binaries begining in ```0b```, and the ability to break up numeric literals with the underscore, which works like the comma like ```1_000_000```

You can exit the program in Java using ```System.exit(0)``` or ```System.exit(1)``` to exit in error. There are other stuffs like this with standard classes and built in things like ```Math.sqrt(x)``` or ```Math.PI```, and you don't even need to import math. Strings ops are a thing, like ```stringName.length()``` [super interesting stuff](http://math.hws.edu/javanotes/c2/s3.html), sorry, ["methods"](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), not going to recreate the docs. Java can also do enumerated types, you can basically define certain stuffs and it is it's own type, like seasons ```enum Season { SPRING, SUMMER, FALL, WINTER }``` which can be used to create variables ```Season vacation;``` which you can talk about ```vacation = Season.SUMMER;``` This is probably used in robotics code, also it makes things readable. Also, since you have to define these things, so they basically have a list, and an index to that list. Cool right?

Unlike Python, formatting is done in the formatted print function ```System.out.printf( "%1.2f", amount );``` 1 is the minimum characters, 2 is how many decimal spots. You can also do this mess which speaks for itself ```System.out.printf("The product of %d and %d is %d", x, y, x*y);```

[Math stuffs are pretty much the same as in Python](http://math.hws.edu/javanotes/c2/s5.html)

# Exercises
## Draw a memory diagram of...
Nah. Not really feeling it.
## Reading Data
```java
int i = TextIO.getInt(); \\ Gets an Integer from the User, Item A
double x = TextIO.getDouble(); \\ Gets a double from the User, Item B
boolean b = TextIO.getBoolean(); \\ Gets a boolean from the User, Item C
```
+ Whether or not the user is a student = C
+ GPA of the user = B
+ Age of the user = A
+ Cash in the pocket of the user = B
+ Credit Card Number = This is probably a security haz, but I think maybe B just because an integer might be too short, have to check docs
+ Which major? = You'd probably want a string for this actually, unless they are numbered, like EE is 25 and CSCI is 26, in which case you'd want an integer, or if there are only two majors, EE and CSCI, so you ask whether or not the person is one, and take a boolean.

## Math!
```java
double a = 3.5;
double b = -4.1;
double c = 0.5;
double numerator = -b + Math.sqrt(Math.pow( b , 2 ) - 4 * a * c);
double denominator = 2 * a;
double x = numerator / denominator;
```

```java
double q = 25.0;
double e = 2.718;
double r = 2.0;
double t = 1.7;
double p = q * Math.pow( e , r * t );
```

## printf()
```java
double x = 1.0331559932390235;
double q = 748.8384692277563;
System.out.printf("x: %.5f and q: $%.2f\n", x,q);
```

## Name Length
```java
System.out.println("What's your name?");
String name = TextIO.getWord();
int length = name.length();
System.out.println("The name " + name + " has " + length + " characters!");

```
