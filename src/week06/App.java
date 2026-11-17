package week06;

public class App {

    public static void main(String[] args) {
        double grade = 50;

        // A B C D
        // 90>= A
        // 80>= B
        // 70>= C
        // 60>= D
        // fail

        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");

        } else if (grade >= 60) {
            System.out.println("D");
        } else {
            System.out.println("fail");
        }

        int x = -2;
        int y = 5;

        if (x > 0)
            if (y > 0)
                System.out.print("Positive");
            else
                System.out.print("Non-positive");

    }

    public static void logIn() {

        String username = "pearl_wise.java";
        String password = "123455";

        if (username != "pearl_wise.java") {
            // do not do anything
            return;
        }

        // log in
        if (password == "123455") {
            System.out.println("You will be logged in");
            // 10000

        }

    }

}