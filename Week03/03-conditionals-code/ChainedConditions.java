// Demonstrate a chain of if/else if.. to get exactly 1 discount to
// apply.
public class ChainedConditions{
  public static void main(String args[]){
    double bill = 50.00;
    System.out.printf("Current bill is $%.2f\n",bill);

    System.out.println("Check for discounts, only the best one will apply");

    System.out.println("Are you a student (15% off)? (true/false)");
    boolean student = TextIO.getBoolean();
    System.out.println("Is it your birthday (20% off)? (true/false)");
    boolean birthday = TextIO.getBoolean();
    System.out.println("Do you have a coupon (10% off)? (true/false)");
    boolean coupon = TextIO.getBoolean();

    double discount = 0.0;
    if(student){
      discount = 0.15;
    }
    else if(birthday){
      discount = 0.20;
    }
    else if(coupon){
      discount = 0.05;
    }

    bill = bill * (1.0-discount);
    System.out.printf("Current bill is $%.2f\n",bill);
  }
}
