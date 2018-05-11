// Fill in code where comments indicate it is needed. Code may need to
// - Get a number the user types and store it in a variable
// - Do some mathematical calculations
// - Check a condition in an if(..)
// - Need an else inserted
// Don't forget to close any curly braces you open up with if's and else's
public class TimeAwareness{
  public static void main(String args[]){
    System.out.println("STUDENT TIME AWARENESS SURVEY");
    System.out.println("-----------------------------");
    System.out.println("On average, how many hours per day including lecture/lab");
    System.out.println("do you spend on CSCI 1103? (ex 1.5 hours):");

    // Get number of hours spent on CSCI 1103 per day

    // Calculate expected hours per day for CSCI 1103: 4 credit class
    // 1-credit = 3 hours per week
    // CSCI 1103 is 4 credits
    // 7 days in a week
    
    // Check if actual hours is less than expected hours per day
      System.out.printf("Expected hours per day for a 4-credit class: %.1f\n",
                        expectHoursPerDay);
      System.out.println("See https://policy.umn.edu/education/studentwork");
      System.out.println("Consider increasing your time spent on CSCI 1103");

    // Check if actual hours is excessive: > 6.5
      System.out.println("You may be overdoing it. Seek help from the 1103 staff");
      System.out.println("or ask someone out on a date (not the course staff).");

    // Not too small and not too big is probably good
      System.out.println("Sounds like you're applying proper effort");


    // Always print this part
    System.out.println();
    System.out.println("On average, how many hours per day do you spend using");
    System.out.println("social media such as Facebook/Twitter/Texting (ex 1.5 hours):");
    
    // Get the number of hours spent on social media

    // Check for 2 or more hours of social media use
      System.out.println("Warning: 2 or more hours per day of social media use");
      System.out.println("has strong correlation with social isolation, morbidity");
      System.out.println("and mortality (!). Consider reducing you use");

    
    // Check if social media use is greater than 1 hour per day and
    // hours per day on 1103 is less than expected, suggest shifting
      System.out.println();
      System.out.println("Suggestion: Consider shifting some time from Social Media ");
      System.out.println("use to learning Java: it will pay more in the long run.");


    // If both 1103 hours and social media hours are 0...
      System.out.println();
      System.out.println("What are you doing with your time?");

      
  }
}
