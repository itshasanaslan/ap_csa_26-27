package week05;

public class IntroToUnit2 {

    public static void main(String[] args) {
        // local variables
        System.out.println("Helooo");
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

        boolean canDrive = !isAgeAppropriate;
            
        /*
            Parantheses
            ! unary NOT sign
            multplication, division modulus
            addition subtraction
            < > <= >=
            == !=
            &&
            ||

        
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