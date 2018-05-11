// Solution to birthday problem with some extra if/else goodness.
public class BirthdayInput{
  public static void main(String args[]){
    System.out.println("Enter your age:");
    int age = TextIO.getInt();
    System.out.println("I hear you are " + age);
    age = age + 1;
    System.out.println("Next year you will be "+ age);
  }
}
