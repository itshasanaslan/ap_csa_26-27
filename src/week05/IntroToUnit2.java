package week05;

import java.util.Scanner;

public class IntroToUnit2 {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        // let's create an age variable and read from the user.
        System.out.print("Enter your age: ");
        int age = reader.nextInt();
        boolean isUnderage = age < 18;
        System.out.println("You are " + age + " years old");

        // ccheeck if user is underage
        if (isUnderage) {
            // SCOPE - CONTEXT
            System.out.println("You are an underage. You can't buy a ticket!");
            // 10000
            // local variable
            boolean canBuyaTicket = true;

        }

        else {
            System.out.println("You are an adult. You can buy a ticket! You will be redirected to the purchase page.");
        }

        // Enter a score. So print the message first
        System.out.print("Enter your score: ");
        // then, read the score. But I need a Scanner for it. So create it.
        // read the score using scanner and store it in a variable.

        int score = reader.nextInt();

        // check if it is greater than 70. print pass
        if (score >= 70)
            System.out.println("Pass");

        // otherwise print fail
        else
            System.out.println("Fail");

        System.out.println("Goodbye!");
    }

    // scope
    public static void tuesday() {

        // all the variables here are LOCAL VARIABLES
        // String -> class
        // int double boolean -> primitive typees
        // declaring a variable
        // assigning a value
        // double x; // 4 bytes - - - -
        // String h; // null

        // we check for conditions
        //

        int age = 17;
        int eligibleAge = 18;

        // if 18 or smaller, no
        // otherwise yes

        // we have a free concert ticket for women's day. But you must be above 18 AND a
        // woman to claim the ticket.
        // if age is smaller than 18 but you have a parent, you can also claim
        boolean isWoman = true;
        boolean isAgeAppropriate = age >= eligibleAge;
        boolean isParentPresent = true;
        // binary AND OPERATOR &&
        // binary OR OPERATOR ||

        boolean hasParentOrAgeIsEligible = isAgeAppropriate || isParentPresent;
        boolean meetsBothCriteria = isWoman && hasParentOrAgeIsEligible;
        System.out.println("The user can claim a concert ticket?: " + meetsBothCriteria);

        /*
         * Parantheses
         * ! unary NOT sign
         * multplication, division modulus
         * addition subtraction
         * < > <= >=
         * == !=
         * &&
         * ||
         * 
         * 
         */

        /**
         * T
         * F
         * 3 >= 2 T
         * !(10 == 10) F
         * 12 % 5 == 2 T
         * 7 < 6 F
         * !(8 != 8) T
         * 
         * 
         * 
         * 
         */
    }

}