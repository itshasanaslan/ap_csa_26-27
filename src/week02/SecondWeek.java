package week02;
import java.util.Scanner;
import week01.MyFirstApp;

public class SecondWeek {

    // THIS IS THE MAIN METHOD. MY APP STARTS FROM HERE.


    
    public static void main(String[] args) {
       //int borrowedNum = MyFirstApp.sayHello();
       //System.out.println("And from the second week, the num is" + borrowedNum);

        int myNumber = 10;

        int result = calculate(myNumber);
        System.out.println(result);

        System.out.println("My number in the main is:" + result);
     
    }

    public static int calculate(int myNumber) {
        // before calculation, increment myNumber by 1
        myNumber++;
        System.out.println("My number has changed to " + myNumber);
        int result = myNumber * 3;
        return result;
    }

// method header (method signature)
    public static String registerAndWelcome(String myDay){
       myDay = "Monday";
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = reader.nextLine();
        System.out.print("Enter your age: ");
        int age = reader.nextInt();
        System.out.println("Hello, " + name + " you are " +  age + " years old. Today is " + myDay);
    
        return name;
    }



    public static void tuesday()  {
          // runtime error
        // System.out.println(5 / 0);
        // primitive char boolean int double
        // declaration initialization

        // Javadoc -> java documentation
        /*
         * 
         * String firstName = "emir";
         * 
         * System.out.println(firstName);
         * 
         * int initialAmount = 387;
         * final int DOLLAR_AMOUNT = 100;
         * int dollars = initialAmount / DOLLAR_AMOUNT;
         * 
         * 
         * 
         * 
         * double price = 100;
         * price *= 3;
         * 
         * System.out.println(price);
         * 
         * int age = 17;
         * 
         * 
         * System.out.println("You are " + age + " years old");
         * 
         * //incrementation && decrementation
         * age++;
         * 
         * System.out.println("Happy birthday. Now you are: " + age);
         * age--;
         */
        

        /* 
        
            double numberToBeRounded = 1.3;
            int rounded = (int) (numberToBeRounded + 0.5);
        
        */


        // "\n"
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter your age:");
        int age = reader.nextInt();
        age++;

      //  (get rid of the )consume the new line in the buffer
      reader.nextLine();

            // reader.next() to read a word
        System.out.print("Enter your name:");
        String name = reader.nextLine();

        System.out.print("Enter your last name:");
        String lastName = reader.nextLine();

        System.out.println("Hello, mr. " + lastName + ", " + name + ". You are " + age + " years old");
        reader.close();


        int seven = 7;
        int two = 2;
// casting -> type conversion
    System.out.println( (double) seven / two); // 3.5
    


    double x = 1.0; // 0.333333333

    double firstValue = 0.3; // 0.300000000000000000005
    double secondValue = 0.4; 
// double / floating number truncation
    boolean areTheyEqual = (firstValue + 0.1) == secondValue;
    

    double numberToBeRounded = 1.3;
    int rounded = (int) (numberToBeRounded + 0.5);

   



    }



}