# AP Computer Science A — Homework Assignment: Object Comparison & Multi-Way Selection

---

### Section 1: Written Code Tracing

For each code segment below, predict the exact output that will be displayed on the console. If the code results in a runtime error or compilation error, state the specific type of error (e.g., `NullPointerException`, `Compilation Error`) and explain why.

#### Question 1
```java
String w1 = new String("orbit");
String w2 = new String("orbit");
String w3 = w1;

System.out.println(w1 == w2);
System.out.println(w1 == w3);
System.out.println(w1.equals(w2));
```

#### Question 2
```java
String tag = null;
if (tag != null && tag.equals("featured")) {
    System.out.println("Highlight Product");
} else {
    System.out.println("Standard Product");
}
```

#### Question 3
```java
String code = null;
if (code.equals("VIP") && code != null) {
    System.out.println("Priority Seating");
} else {
    System.out.println("General Seating");
}
```

#### Question 4
```java
int income = 45000;
String filingStatus = new String("Single");
double taxRate = 0.0;

if (income <= 20000) {
    taxRate = 0.10;
} else if (income <= 50000) {
    if (filingStatus.equals("Single")) {
        taxRate = 0.15;
    } else {
        taxRate = 0.12;
    }
} else {
    taxRate = 0.25;
}
System.out.println("Tax Rate: " + taxRate);
```

#### Question 5
```java
String a = "data";
String b = "data";
String c = new String("data");

boolean check1 = (a == b);
boolean check2 = (a == c);
boolean check3 = (a.equals(c));

if (check1 && !check2 && check3) {
    System.out.println("Condition Alpha");
} else {
    System.out.println("Condition Beta");
}
```

---

### Section 2: Bug Hunting & Correction

Identify the flaw in each code segment below. Explain why the bug occurs, and rewrite the corrected code.

#### Bug 1: Dangerous String Comparison in Multi-Way Selection
A programmer is designing a loyalty tier classifier. The following method compiles, but does not behave as expected when comparing user input from external sources:
```java
public static double getDiscount(String tier) {
    if (tier == "Bronze") {
        return 0.05;
    } else if (tier == "Silver") {
        return 0.10;
    } else if (tier == "Gold") {
        return 0.20;
    } else {
        return 0.0;
    }
}
```
* **Question:** Why does this method fail when `tier` is constructed using `new String(...)` or read from a scanner/file? Provide the corrected implementation.

#### Bug 2: Reversed Null Guard Condition
The following method is supposed to validate whether a user has entered a valid security token:
```java
public static boolean isTokenValid(String token) {
    if (token.length() >= 8 && token != null) {
        return true;
    }
    return false;
}
```
* **Question:** What occurs when `isTokenValid(null)` is called? Explain the role of short-circuit evaluation in fixing this method.

---

### Section 3: Programming Practice — `AccountServiceValidator.java`

Global Retail Systems requires a customer profile validator that evaluates customer tier status, applies purchase discounts, and handles uninitialized customer data defensively.

Create a class named `AccountServiceValidator` with the method specified below.

#### Method Header
```java
public static double calculateFinalPrice(double basePrice, String membershipTier, int customerYears)
```

#### Business Rules
1. **Input Validation:**
   * If `basePrice` is less than or equal to `0.0`, return `-1.0` immediately.
2. **Null & Default Tier Handling:**
   * If `membershipTier` is `null` or does not match any recognized tier (`"Standard"`, `"Silver"`, `"Gold"`), treat the customer as `"Standard"`.
   * Comparisons between `membershipTier` and the tier names must be safe against `NullPointerException` and compare contents using `.equals()`.
3. **Tiered Base Discount (Multi-Way Selection `if-else-if`):**
   * `"Standard"`: 0% discount on base price.
   * `"Silver"`: 10% discount on base price (`basePrice * 0.90`).
   * `"Gold"`: 20% discount on base price (`basePrice * 0.80`).
4. **Loyalty Longevity Bonus (Nested Conditional):**
   * For `"Silver"` or `"Gold"` customers who have been members for **more than 5 years** (`customerYears > 5`), apply an additional **$10.00 credit** deducted from their discounted price.
   * Standard tier customers do not receive the longevity bonus regardless of years.
5. **Safety Floor Check:**
   * If the final price after all discounts and credits is less than `0.0`, set the final price to `0.0`.

#### Test Suite
Include a `main` method that executes the following test cases to verify your implementation:

```java
public static void main(String[] args) {
    System.out.println("=== Running Account Service Verification Suite ===");

    // Test 1: Standard tier, 3 years -> No discount ($100.0)
    System.out.println("Test 1: " + calculateFinalPrice(100.0, "Standard", 3) + " [Expected: 100.0]");

    // Test 2: Silver tier, 2 years -> 10% off ($90.0)
    System.out.println("Test 2: " + calculateFinalPrice(100.0, "Silver", 2) + " [Expected: 90.0]");

    // Test 3: Silver tier, 7 years -> 10% off ($90.0) - $10 bonus = $80.0
    System.out.println("Test 3: " + calculateFinalPrice(100.0, "Silver", 7) + " [Expected: 80.0]");

    // Test 4: Gold tier, 10 years -> 20% off ($160.0) - $10 bonus = $150.0
    System.out.println("Test 4: " + calculateFinalPrice(200.0, "Gold", 10) + " [Expected: 150.0]");

    // Test 5: null tier -> Defaults to Standard ($100.0)
    System.out.println("Test 5: " + calculateFinalPrice(100.0, null, 10) + " [Expected: 100.0]");

    // Test 6: Invalid price -> Returns -1.0
    System.out.println("Test 6: " + calculateFinalPrice(-25.0, "Gold", 4) + " [Expected: -1.0]");

    // Test 7: Safety floor test (small price with bonus) -> 20% off $8.0 = $6.4 - $10.0 = -$3.6 -> Floor $0.0
    System.out.println("Test 7: " + calculateFinalPrice(8.0, "Gold", 6) + " [Expected: 0.0]");
}
```
