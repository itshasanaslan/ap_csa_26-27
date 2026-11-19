package week06;

public class Authenticator {

    // Stored credential constants
    public static final String ADMIN_USER = "admin";
    public static final String ADMIN_PASS = "Vault99#";
    public static final String GUEST_USER = "guest";

    /**
     * Validates a user login request and returns an authorization message.
     *
     * @param username the entered username (may be null)
     * @param password the entered password (may be null)
     * @param isLocked whether the account has been administrative locked
     * @return an authorization status String
     */
    public static String authenticateUser(String username, String password, boolean isLocked) {
        
        // TODO 1: Check if the account is locked. If true, return "ACCESS DENIED: Account Locked"


        // TODO 2: Validate username presence using a defensive short-circuit check.
        // If username is null OR empty, return "ACCESS DENIED: Missing Username"


        // TODO 3: Check for administrator login using .equals()
        // If username matches ADMIN_USER:
        //    - verify password is not null AND matches ADMIN_PASS
        //    - if valid password: return "ACCESS GRANTED: Administrator"
        //    - otherwise: return "ACCESS DENIED: Invalid Admin Password"


        // TODO 4: Check for guest login using .equals()
        // If username matches GUEST_USER: return "ACCESS GRANTED: Guest"


        // TODO 5: Default rejection for unrecognized accounts
        return "ACCESS DENIED: User Not Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Authenticator Verification Suite ===");

        // Test 1: Valid admin with new String instances
        String u1 = new String("admin");
        String p1 = new String("Vault99#");
        System.out.println("Test 1: " + authenticateUser(u1, p1, false)
            + " [Expected: ACCESS GRANTED: Administrator]");

        // Test 2: Admin with incorrect password
        System.out.println("Test 2: " + authenticateUser("admin", "wrongPass", false)
            + " [Expected: ACCESS DENIED: Invalid Admin Password]");

        // Test 3: Admin with null password (must not throw NullPointerException!)
        System.out.println("Test 3: " + authenticateUser("admin", null, false)
            + " [Expected: ACCESS DENIED: Invalid Admin Password]");

        // Test 4: null username (must not throw NullPointerException!)
        System.out.println("Test 4: " + authenticateUser(null, "anyPass", false)
            + " [Expected: ACCESS DENIED: Missing Username]");

        // Test 5: Valid guest login
        System.out.println("Test 5: " + authenticateUser(new String("guest"), null, false)
            + " [Expected: ACCESS GRANTED: Guest]");

        // Test 6: Locked account
        System.out.println("Test 6: " + authenticateUser("admin", "Vault99#", true)
            + " [Expected: ACCESS DENIED: Account Locked]");

        // Test 7: Unregistered user
        System.out.println("Test 7: " + authenticateUser("unknownUser", "pass123", false)
            + " [Expected: ACCESS DENIED: User Not Found]");
    }
}

