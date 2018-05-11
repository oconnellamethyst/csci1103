public class Dog{
  public String name;
  public int age;
  public boolean hasBone;

  public Dog(String name, int age){
    this.name = name;
    this.age = age;
    this.hasBone = false;
  }

  public String toString(){
    return
      String.format("Name: %s  Age: %d  Bone? %b",
                    this.name, this.age, this.hasBone);
  }

  public static void main(String args[]){
    Dog s = new Dog("Stout",3);
    Dog r = new Dog("Rufus",1);
    r.hasBone = true;
    System.out.println(s.toString());
    System.out.println(r.toString());
  }
}
    
