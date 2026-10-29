package week03;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Java is an OOP language.
        // Object-Oriented Programming Language

        // primitive = default value = int 0, double = 0.000000 boolean = false
        // STRINGS ARE IMMUTABLE = CANNOT BE CHANGED!!!!!!!!
        String title = new String("AP Computer Science A");

        int numOfLetters = title.length();

        System.out.println("Title has got " + numOfLetters + " letters.");

        // substring
        String firstTwoLetters = title.substring(3, 4);
        System.out.println("The first two letters are: " + firstTwoLetters);

        // Remainder
        String remainder = title.substring(3);
        System.out.println("Remainder is " + remainder);

        // check if word "Science" exists in string
        // be careful with Capital or lowercase letters!!!!
        int indexOfScience = title.indexOf("Science");
        System.out.println("Science keyword was found at position(index):  " + indexOfScience);

        String student1 = "bilge";
        String student2 = "bilge";

        String studentOne = new String("bilge");
        String studentTwo = new String("bilge");

        boolean areTheyEqual = student1 == student2;
        boolean areStringObjectsEqual = studentOne == studentTwo;

        System.out.println("String stored in the string pool are: " + areTheyEqual);
        System.out.println("String stored in the HEAP  are: " + areStringObjectsEqual);
        System.out.println("Are the PLACES of the studentOne and StudentTwo on the HEAP MEMORY the same: " +   (studentOne == studentTwo));
        System.out.println("Are the values of the studentOne and StudentTwo the same: " +   studentOne.equals(studentTwo));

       
    }

    public static void diceSimulator() {

        // x >= 0 inclusive
        // x < 1 exclusive
        // max= 0.999999
        int randomValue = (int) (Math.random() * 11);

        // System.out.println(randomValue);

        // dice simulator
        // 6 edges
        // min = 1
        int min = -6;
        int max = 6;
        int range = max - min + 1; // 11 possible values (10 through 20 inclusive) // 13
        int randomInt = (int) (Math.random() * range) + min;
        System.out.println(randomInt);
    }

    public static void temporary() {

        // int x = Math.abs(3);

        int squareOfFive = (int) Math.pow(5, 2);
        System.out.println(squareOfFive);

        int sqrtOfSeven = (int) Math.sqrt(7);

        System.out.println(sqrtOfSeven);

        double distance = calculateHypotenuse();

    }

    public static double calculateHypotenuse() {
        Scanner reader = new Scanner(System.in);
        // Ask user for x1
        // Ask user for x2
        System.out.print("Enter x1 x2");
        double x1 = reader.nextDouble();
        double x2 = reader.nextDouble();

        // ask user for y1
        // ask user for y2
        System.out.print("\nEnter y1 y2");
        double y1 = reader.nextDouble();
        double y2 = reader.nextDouble();

        // Distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
        // calcualte the distance and print on the screen
        double hypothenuse = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return hypothenuse;
    }

}
