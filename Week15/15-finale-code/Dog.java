import java.util.Scanner;
import java.io.File;

public class Dog{
  private String name;
  private int age;
  private boolean likesCats;

  // Create a instance of Dog with the given parameters
  // Examples:
  //   Dog d = new Dog("Val", 6, true);
  //   Dog e = new Dog("Stout", 3, false);
  public Dog(String name, int age, boolean likesCats){
    this.name=name;
    this.age=age;
    this.likesCats=likesCats;
  }

  public String toString(){
    return String.format("Dog{%s, %d, %b}",
                         this.name.this.age,this.likesCates);
  }

  // Retrieve the name of the dog
  public String getName(){
    return this.name;
  }

  // Change the name of the dog to the new name
  // Examples:
  //   d.rename("Valentine");
  //   String n = d.getName(); // "Valentine"
  public void rename(String name){
    this.name = name;
  }

  // Increase the age of the dog by 1
  public void birthday(){
    this.age++;
  }

  // Change the internal state of the dog so that it likes cats
  public void trainForCats(){
    this.likesCats = true;
  }

  // Return whether the dog is appropriate for elderly owners. The dog
  // must be 8 years or older and must like cats to be appropriate for
  // elderly owners.
  public boolean okForElderly(){
    return this.age >= 8 && this.likesCats;
  }

  // Create a dog from a string of information. Use a Scanner to parse
  // the string argument.  Valid input strings contain the Dog's name,
  // age, and the word yes or no depending on whether the dog likes
  // cats. Examples:
  //   Dog d = Dog.fromString("Val 6 yes");
  //   Dog e = Dog.fromString("Stout 3 no");
  public static Dog fromString(String s){
    Scanner scan = new Scanner(s);
    String name = scan.next();
    int age = scan.nextInt();
    String yesNo = scan.next();
    return new Dog(name, age, yesNo.equals("yes"));
  }

  // Read dogs from the given file. Count lines in the file using a
  // Scanner (do not assume a countLines method). Allocate an array of
  // that size, reset the scanner to beginning of the file, then read
  // lines and create dogs in the array. Make use of the
  // Dog.fromString() method.
  public static Dog [] readDogsFromFile(String filename) throws Exception{
    Scanner in = new Scanner(new File(filename));
    int lineCount = 0;
    while(in.hasNextLine()){
      in.nextLine();
      lineCount++;
    }
    in.close();
    Dog dogs[] = new Dog[lineCount];
    in = new Scanner(new File(filename));
    for(int i=0; i<lineCount; i++){
      String line = in.nextLine();
      dogs[i] = Dog.fromString(line);
    }
    in.close();
    return dogs;
  }
}
