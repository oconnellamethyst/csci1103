# Week 3 Notes
[Ch 3.1](http://math.hws.edu/javanotes/c3/s1.html), [3.2](http://math.hws.edu/javanotes/c3/s2.html), [3.5](http://math.hws.edu/javanotes/c3/s5.html)

## Control Structures

```java
{
     //This is a block, code goes here
}
```

Java isn't Python, how pretty the code is doesn't affect how it runs. People want pretty code anyways tho. Also, if you declare a variable in a block, it's local to the block.  

Why are blocks important? Because unlike Python, you have to store the guts of your statements.  

```java
while (boolean-expression) {
    // Code goes here
}
```
This is a while loop!

```java
if ( boolean-expression ) {
    // Code goes here
}
else {
    // Code goes here
}
```
An if-else statement!

```java
if (x < y && x < z) {
    output x, followed by y and z in their correct order
}
else if (x > y && x > z) {
    output y and z in their correct order, followed by x
}
else {
    output x in between y and z in their correct order
}
```
Elifs!  

Empty statements (pass in Python) are done using a semicolon after the statement or {empty braces}. Bear in mind that this is a thing, because it can cause errors. You can also just have an if statement, but be careful.

#Excercises
## Trace Conditional Execution
I believe the code gives "sum is 30" because the else statement is connected to if(addC) which is false.
## Trickier Conditional Execution
I believe the sum is (a+b)*2 due to how it changes. addA is true, addB is true, and div2 is false by the end of it


