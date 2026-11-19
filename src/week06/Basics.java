package week06;

public class Basics {
    public static void main(String[] args) {
        String text = new String("Hello");

        // Exceptions
        // NullPointerException
        // System.out.println(student1.fullName.length());
        String name = "bilge"; // String literals
        String name2 = "bilge";

        String name3 = new String("emir");
        String name4 = new String("emir");
        boolean areTheyTheSame = name3 != name4;
        boolean areTheyTheSameThisTime = name3.equals(name4);

        System.out.println(areTheyTheSameThisTime);

        String first = new String("Falcon");
        String second = new String("Falcon");
        String alias = first;

        first = "sensations";
        System.out.println(alias);
        
        Student student1 = new Student();

        // null safety check
        if (student1.fullName == null) {
            System.out.println("This is null. Hello hacker");
        } else {
            System.out.println("You are not a hacker. Who are u?");
        }

    }
}
