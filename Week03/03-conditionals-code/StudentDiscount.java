// Get user input to determine whether discounts apply
public class StudentDiscount{
  public static void main(String args[]){
    double bill = 50.00;
    System.out.printf("Current bill is $%.2f\n",bill);

    System.out.println("Are you a student? (true/false)");
    boolean student = TextIO.getBoolean();
    double discount = 0.00;       // Fraction discount

    // CONDITIONALS
    if(student){
      System.out.println("Applying a 10% discount");
      discount = discount + 0.10; // Increase discount by 10%
    }
    else{
      System.out.println("Sucks being an adult, doesn't it?");
    }      

    bill = bill * (1.0-discount);
    System.out.printf("Current bill is $%.2f\n",bill);
  }
}
