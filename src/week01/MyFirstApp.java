package week01;

public class MyFirstApp {                    

    public static void main (String[] args) {
           // a bit
            // 15 // 
            //  1 1 1 1  -> 16 different values
            // 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
            // 1 1 1 unsigned integer 
        // this will print the text, and then move to the next line.
        System.out.println("hello, is this working properly?");
        // then, this will be printed.
        System.out.println("Oh my god! That's great!");
        int age = 16;
        // AN int occupies 32 bits which means 4 bytes
        // 1 1 1 1 1 1 1 1 = a byte
        // max value of a byte = 
        int biggestValue = 2147483647;
        biggestValue = biggestValue + 4;
        // integer overflow
        System.out.println("The max value in the memory is: " + biggestValue);
        System.out.println("Your age is:" + age);
        System.out.println("Happy birthday!Your age is:" );
        // a double holds 8 bytes (64 bits)
        double valueOfPi = 3.145 + 0.011;
        System.out.println(valueOfPi);
        // to store logical statements. Yes or no. true or false
        boolean canDrive = true;
        System.out.println("Can you drive: " + canDrive);
        // any arithmwrTİCAL operation in java just as in math
        int result = 25 + (10 - 3) / 5 - 1;
          //PMDAS
        int totalMinutes = 193;
        int hours = totalMinutes / 60;
        int remainingMinutes = totalMinutes % 60;
        System.out.println(remainingMinutes);

        double seven = 7;
        double two = 2;

        double theResult = seven / 2;
        System.out.println(theResult);
        System.out.println(17.0 / 4 );
        System.out.println(17 % 4);
    }

    public static int sayHello(){
        System.out.println("Hellloo from the first week");
        int myLuckyNumber = 33;

        return myLuckyNumber;
    }


}