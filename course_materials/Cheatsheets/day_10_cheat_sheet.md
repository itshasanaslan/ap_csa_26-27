# AP Computer Science A — Day 10 Quick Reference Cheat Sheet: Conditional Statements & Scoping

## 1. One-Way Selection: The `if` Statement

An `if` statement allows a program to conditionally execute a single statement or a block of statements based on whether a `boolean` expression evaluates to `true`.

### Syntax
```java
if (booleanCondition) {
    // Statements executed ONLY when booleanCondition is true
}
```

* If `booleanCondition` evaluates to `true`, the statements inside the curly braces `{}` execute sequentially.
* If `booleanCondition` evaluates to `false`, Java bypasses the entire block and continues with the next statement after the closing brace `}`.

```java
int score = 85;
if (score >= 70) {
    System.out.println("Passing score!");
}
System.out.println("Review completed.");
// Output:
// Passing score!
// Review completed.
```

---

## 2. Two-Way Selection: The `if-else` Statement

An `if-else` statement provides two distinct execution paths that are **mutually exclusive**. Exactly one branch will always execute.

### Syntax
```java
if (booleanCondition) {
    // Branch A: executed ONLY if booleanCondition is true
} else {
    // Branch B: executed ONLY if booleanCondition is false
}
```

* There is **no condition** attached to `else`. The `else` block catches all cases where `booleanCondition` is `false`.
* The branches are mutually exclusive: it is impossible for both branches to execute, and it is impossible for neither branch to execute.

```java
int temperature = 28;
if (temperature > 32) {
    System.out.println("Liquid water");
} else {
    System.out.println("Freezing point reached or below");
}
// Since 28 > 32 is false, the else branch executes.
// Output: Freezing point reached or below
```

---

## 3. Block Statements and Curly Braces `{ }`

A block statement consists of zero or more statements enclosed within curly braces `{ }`. Java treats the entire block as a single compound statement.

### The Danger of Omitting Braces
If curly braces `{ }` are omitted, the `if` or `else` statement controls **only the single immediate statement** following it. Indentation does not define code blocks in Java.

```java
// DANGEROUS CODE:
int balance = 50;
if (balance < 0)
    System.out.println("Overdrawn!");
    System.out.println("A $25 fee has been applied."); // THIS ALWAYS EXECUTES!

// What Java actually interprets:
if (balance < 0) {
    System.out.println("Overdrawn!");
}
System.out.println("A $25 fee has been applied."); // Not part of the if!
```

> **Best Practice:** Always use curly braces `{ }` for every `if` and `else` block, even when the block contains only a single statement.

---

## 4. Classic AP Exam Trap: The Dangling Semicolon

Placing a semicolon directly after the conditional header terminates the `if` statement immediately, creating an empty statement body.

```java
int x = 4;

// BUG: Semicolon immediately ends the if statement!
if (x > 10); 
{
    System.out.println("x is greater than 10"); // ALWAYS PRINTS!
}
```

### Why this happens:
Java interprets the semicolon `;` as the body of the `if`. The curly braces `{ }` that follow are treated as an independent block statement that always executes regardless of `x`.

---

## 5. Block Scoping & Variable Lifetime

The **scope** of a variable is the region of the program where that variable can be accessed. A variable declared inside a block (`{ }`) exists only from its point of declaration to the closing brace `}` of that block.

### Compilation Error: Declaring Variables Inside Blocks
```java
int totalPoints = 88;

if (totalPoints >= 90) {
    String grade = "A";
} else {
    String grade = "B";
}

// COMPILATION ERROR: grade cannot be resolved to a variable
System.out.println("Final Grade: " + grade);
```

### The Correct Pattern: Declare Before Selection
Declare the variable in the outer enclosing scope before the `if-else` statement so it remains accessible after the block ends:

```java
int totalPoints = 88;
String grade; // Declared in outer scope

if (totalPoints >= 90) {
    grade = "A";
} else {
    grade = "B";
}

// Valid and accessible:
System.out.println("Final Grade: " + grade); // Prints: Final Grade: B
```

---

## 6. Multiple Independent `if` Statements vs. `if-else`

Understanding the difference between consecutive independent `if` statements and paired `if-else` statements is critical for AP code tracing questions.

### Case A: Independent `if` Statements (Both can execute)
```java
int num = 12;

if (num % 2 == 0) {
    System.out.print("Even ");
}
if (num > 10) {
    System.out.print("Large");
}
// Both conditions are evaluated independently.
// 12 % 2 == 0 is true -> prints "Even "
// 12 > 10 is true     -> prints "Large"
// Output: Even Large
```

### Case B: Paired `if-else` (Mutually Exclusive)
```java
int num = 12;

if (num % 2 == 0) {
    System.out.print("Even ");
} else if (num > 10) {
    System.out.print("Large");
}
// 12 % 2 == 0 is true -> prints "Even "
// The else branch is skipped entirely!
// Output: Even 
```

---

## 7. Step-by-Step Code Tracing Practice

| No. | Code Segment | Step-by-Step Execution Trace | Printed Output |
| :---: | :--- | :--- | :---: |
| 1 | `int a = 7;`<br>`if (a * 2 > 10) {`<br>&nbsp;&nbsp;`System.out.print("A");`<br>`}`<br>`System.out.print("B");` | `a * 2` is `14`. `14 > 10` is `true`. Prints `"A"`. Continues to sequential print `"B"`. | `AB` |
| 2 | `int b = 4;`<br>`if (b % 2 != 0) {`<br>&nbsp;&nbsp;`System.out.print("Odd");`<br>`} else {`<br>&nbsp;&nbsp;`System.out.print("Even");`<br>`}` | `4 % 2` is `0`. `0 != 0` is `false`. Bypasses `if` block, executes `else` block. | `Even` |
| 3 | `int c = 15;`<br>`if (c < 10);`<br>`{`<br>&nbsp;&nbsp;`System.out.print("Small");`<br>`}` | The semicolon `;` terminates the `if`. The block `{ System.out.print("Small"); }` runs unconditionally. | `Small` |
| 4 | `int d = 20;`<br>`if (d >= 20)`<br>&nbsp;&nbsp;`System.out.print("One ");`<br>&nbsp;&nbsp;`System.out.print("Two ");`<br>`System.out.print("Three");` | No braces: only `"One "` belongs to the `if`. Both `"Two "` and `"Three"` execute unconditionally. | `One Two Three` |
| 5 | `int x = 8;`<br>`int y = 3;`<br>`if (x / y >= 2 && x % y == 2) {`<br>&nbsp;&nbsp;`System.out.print("Match");`<br>`} else {`<br>&nbsp;&nbsp;`System.out.print("No match");`<br>`}` | `8 / 3` is `2` (integer division). `2 >= 2` is `true`. `8 % 3` is `2`. `2 == 2` is `true`. `true && true` is `true`. | `Match` |
