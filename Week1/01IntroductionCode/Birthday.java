// Solution to birthday problem with some extra if/else goodness.
public class Birthday{
  public static void main(String args[]){
    int age = 20;
    System.out.println("I hear you are " + age);
    age = age + 1;
    System.out.println("Next year you will be "+ age);

    // Something extra...
    age = age - 1;
    if(age >= 21){
      System.out.println("Let's get rickety wrecked!");
    }
    else{
      int countDown = 21 - age;
      System.out.println(countDown + " more years...");
    }
  }
}
