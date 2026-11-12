# AP Computer Science A — Day 10 Homework Assignment
**Topic: Conditional Statements (`if`, `if-else`) & Block Scoping**

---

## Instructions
Complete all three sections of this assignment. For Sections 1 and 2, write your answers and step-by-step traces clearly. For Section 3, write syntactically correct Java code that adheres strictly to the AP Java subset.

---

## Section 1: Written Code Tracing

For each code segment below, trace the execution step-by-step and write the exact output produced. If a segment produces a compilation error, state the error and explain why it occurs.

### Question 1
```java
int a = 14;
int b = 5;

if (a / b >= 2) {
    System.out.print("Path 1 ");
}
if (a % b == 4) {
    System.out.print("Path 2 ");
} else {
    System.out.print("Path 3 ");
}
System.out.println("End");
```
* **Step-by-Step Trace:**
* **Exact Output:**

---

### Question 2
```java
int speed = 45;
int speedLimit = 35;

if (speed > speedLimit + 10);
{
    System.out.print("Warning: Speeding detected! ");
}
System.out.println("Drive safely.");
```
* **Step-by-Step Trace:**
* **Exact Output:**

---

### Question 3
```java
int balance = 120;
int withdrawal = 50;

if (balance >= withdrawal) {
    int newBalance = balance - withdrawal;
    System.out.println("Transaction approved. Remaining: " + newBalance);
} else {
    System.out.println("Insufficient funds.");
}

System.out.println("Account balance is: " + newBalance);
```
* **Step-by-Step Trace:**
* **Exact Output (or Compilation Error explanation):**

---

### Question 4
```java
int x = 6;
int y = 9;

if (x * 2 > y)
    System.out.print("Apple ");
    System.out.print("Banana ");
System.out.print("Cherry");
```
* **Step-by-Step Trace:**
* **Exact Output:**

---

## Section 2: Bug Hunting & Spot-the-Error

Examine each buggy code snippet below. Identify the bug (syntax error, scoping issue, or logic flaw) and rewrite the corrected code.

### Bug 1: The Scoping Error
```java
// Intended behavior: Determine ticket category based on age
int age = 16;
if (age < 13) {
    String category = "Child";
} else {
    String category = "Standard";
}
System.out.println("Ticket Category: " + category);
```
* **Identified Bug:**
* **Corrected Code:**

---

### Bug 2: The Semicolon Flaw
```java
// Intended behavior: Only print "Discount Applied" if hasCoupon is true
boolean hasCoupon = false;
double price = 40.0;

if (hasCoupon); {
    price = price * 0.85;
    System.out.println("Discount Applied");
}
System.out.println("Final Price: " + price);
```
* **Identified Bug:**
* **Corrected Code:**

---

### Bug 3: The Missing Braces Logic Bug
```java
// Intended behavior: When eligible for honors, increment count AND print confirmation
int gpa = 38; // represents 3.8
int honorsCount = 0;

if (gpa >= 35)
    honorsCount++;
    System.out.println("Honors confirmed!");

System.out.println("Total honors students: " + honorsCount);
```
* **Identified Bug:**
* **Corrected Code:**

---

## Section 3: Programming Practice — Cinema Box Office

Write a complete Java class named `CinemaBoxOffice` containing the static method `calculateTicketPrice`.

### Specifications
* **Method Header:**
  ```java
  public static double calculateTicketPrice(int age, boolean isMatinee)
  ```
* **Preconditions:**
  * `age >= 0`
* **Pricing Rules:**
  1. Base regular admission is `$14.00`.
  2. If the customer is a child (`age <= 12`) **or** a senior (`age >= 65`), their base ticket price is `$9.00`.
  3. If the showing is a matinee (`isMatinee == true`), apply an additional `$2.50` discount to the ticket price (regardless of age category).
  4. Children under age 3 (`age < 3`) are admitted completely free of charge (`$0.00`), regardless of whether it is a matinee.

### Test Cases to Verify Your Code:
| Method Call | Expected Return Value | Explanation |
| :--- | :---: | :--- |
| `calculateTicketPrice(2, false)` | `0.0` | Under 3 years old -> free admission |
| `calculateTicketPrice(2, true)` | `0.0` | Under 3 years old -> free admission even during matinee |
| `calculateTicketPrice(10, false)` | `9.0` | Child regular price |
| `calculateTicketPrice(10, true)` | `6.5` | Child matinee price ($9.00 - $2.50) |
| `calculateTicketPrice(25, false)` | `14.0` | Standard regular price |
| `calculateTicketPrice(25, true)` | `11.5` | Standard matinee price ($14.00 - $2.50) |
| `calculateTicketPrice(70, false)` | `9.0` | Senior regular price |
| `calculateTicketPrice(70, true)` | `6.5` | Senior matinee price ($9.00 - $2.50) |

---

### Submission Requirements:
* Submit your handwritten solutions to Sections 1 and 2.
* Implement and test `CinemaBoxOffice.java` in VS Code. Ensure all 8 test cases pass without errors.
