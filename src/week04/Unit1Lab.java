package week04;

public class Unit1Lab {

    public static void main(String[] args) {

        System.out.println(generateMemberTag("bilge ayhan", 2009)); // i -> I
        System.out.println(firstAndLastNameCapitalizer("bilge ayhan"));

    }

    public static String firstAndLastNameCapitalizer(String fullName) {
        String firstName = fullName.substring(0, 1).toUpperCase() + fullName.substring(1, fullName.indexOf(" "));
        String lastName = fullName.substring(fullName.indexOf(" ") + 1, fullName.indexOf(" ") + 2).toUpperCase()
                + fullName.substring(fullName.indexOf(" ") + 2);
        return firstName + " " + lastName;
    }

    /**
     * Write a public static String generateMemberTag(String fullName, int
     * birthYear) method:
     * • Extract the first 3 letters of fullName using .substring(0, 3).
     * • Generate a random 3-digit security code between 100 and 999 inclusive using
     * Math.random().
     * • Return a String in the format: PREFIX + birthYear + "-" + randomCode (e.g.,
     * "ALE2008-731").
     * 
     */
    // TAsk 1what is my return type in this method
    public static String generateMemberTag(String fullName, int birthYear) {
        String prefix = fullName.substring(0, 3).toUpperCase();
        // random 3-digit security code between 100 and 999 inclusive using
        // Math.random().
        int randomNum = (int) (Math.random() * 900) + 100;
        // Return a String in the format: PREFIX + birthYear + "-" + randomCode (e.g.,
        // "ALE2008-731").
        return prefix + birthYear + "-" + randomNum;
    }

    // Task 2: Substring & length
    public static String generateProductCode(String storeName, String itemName) {
        String storePrefix = storeName.substring(0, 2);
        String itemPrefix = itemName.substring(0, 3);
        int itemLength = itemName.length();
        



}
