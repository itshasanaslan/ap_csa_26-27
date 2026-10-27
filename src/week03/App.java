package week03;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
    int randomValue =    (int)    (Math.random() * 7) ;
    System.out.println(randomValue);

        // min = 0.0> inclusive
        // max 1.0 (exclusive) 0.99999999999999999


   
    }


        public static void temporary(){
              

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

        // calcualte the distance and print on the screen
        double hypothenuse = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return hypothenuse;
    }
  
}

