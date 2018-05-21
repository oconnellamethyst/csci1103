public class LoanCalc {
      
    /** This program calculates the Monthly Payment
      *  for a looan given the loan amount and yearly interest rate
      *  as a percentage and the term of the loan in years.
      */
    
    public static void main(String[] args) {
      
      // Get Loan Amount
      System.out.println("What is the amount of the loan?");
      double loanAmount = TextIO.getDouble();
      
      // Get loan term in years
      System.out.println("What is the loan term in years?");
      double loanTerm = TextIO.getDouble();
      
      // Get Yearly interest rate as percentage
      System.out.println("What is the yearly interest rate as a percent?");
      double yearlyInterest = TextIO.getDouble();
      while (yearlyInterest <= 0){
        System.out.println("This is not a positive percent, What is the yearly interest rate as a percent?");
      }
      if (yearlyInterest <= 1){
        System.out.println("Did you mean " + yearlyInterest + "% or " + yearlyInterest * 100 + "%?");
        System.out.println("If you meant " + yearlyInterest + "% please type false, otherwise, type true");
        boolean mathNerds = TextIO.getBoolean();
        if (mathNerds){
          yearlyInterest = yearlyInterest * 100;
        }
        else {
        ;
        }
      }
      else {
      ;
      }
            
      // This is where we do math!
      yearlyInterest = yearlyInterest/100;
      double monthlyPayment = (loanAmount * (yearlyInterest/12))/(1 - Math.pow( (1 - (yearlyInterest/12)), (12 * loanTerm)));
      System.out.printf("Your monthly payment is $%1.2f \n", monthlyPayment);
      
    }
    
}
