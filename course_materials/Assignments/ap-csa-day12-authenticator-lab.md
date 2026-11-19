# AP Computer Science A — Lab: Secure Login Authenticator

---

### Overview
Enterprise software systems require strict validation of user credentials before granting system access. Reference variables like `String` require defensive checks to ensure the application never crashes with a `NullPointerException` when users submit missing, malformed, or uninitialized credentials.

Your task is to implement the `authenticateUser` method in `Authenticator.java` following the business logic and security specifications below.

---

### System Specifications

#### 1. Security Preconditions
* Stored system constants:
  * `ADMIN_USER = "admin"`
  * `ADMIN_PASS = "Vault99#"`
  * `GUEST_USER = "guest"`
* **Account Lock Check:** If `isLocked` is `true`, return `"ACCESS DENIED: Account Locked"` immediately.
* **Username Presence:** If `username` is `null` or has a length of `0` (`username.length() == 0`), return `"ACCESS DENIED: Missing Username"`. **You must use a short-circuit guard (`username == null || ...`) to prevent a `NullPointerException`.**

#### 2. Authentication Logic
* **Administrator Verification:**
  * Compare `username` against `ADMIN_USER` using `.equals()`. Do not use `==`.
  * If the username matches:
    * Check if `password` is non-null AND equals `ADMIN_PASS`.
    * If both match, return `"ACCESS GRANTED: Administrator"`.
    * If password does not match or is `null`, return `"ACCESS DENIED: Invalid Admin Password"`.
* **Guest Verification:**
  * If `username` matches `GUEST_USER` using `.equals()`, return `"ACCESS GRANTED: Guest"`. (Guest accounts require no password).
* **Unregistered User Fallback:**
  * If the username matches neither administrator nor guest, return `"ACCESS DENIED: User Not Found"`.

---

### Starter Template (`Authenticator.java`)

```java
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
```
