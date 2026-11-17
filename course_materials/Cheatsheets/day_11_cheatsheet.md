# AP Computer Science A — Day 11 Quick Reference Cheat Sheet: Multi-Way Selection & Nested Conditionals

## 1. Multi-Way Selection: The `if-else-if` Ladder

When an algorithm requires choosing between three or more mutually exclusive paths, Java uses an `if-else-if` ladder.

```java
if (condition1) {
    // Executes only if condition1 is true
} else if (condition2) {
    // Executes only if condition1 is false AND condition2 is true
} else if (condition3) {
    // Executes only if condition1 and condition2 are false AND condition3 is true
} else {
    // Optional catch-all: Executes only if ALL preceding conditions are false
}
```

### Core Execution Rules
1. **Short-Circuit Evaluation of Branches:** Conditions are evaluated sequentially from top to bottom.
2. **Mutual Exclusion:** As soon as **one** condition evaluates to `true`, its block executes and Java **bypasses all remaining branches** in the entire structure.
3. **Trailing `else`:** The final `else` is optional. If present, it executes only when all conditions evaluate to `false`. If omitted and no condition evaluates to `true`, the entire statement does nothing.

---

## 2. The Condition Ordering Rule (Top-to-Bottom Traps)

Because Java executes the first branch that evaluates to `true`, conditions must be arranged from **most restrictive to least restrictive** (or in strict numerical sequence).

### ❌ The Classic AP Ordering Bug (Shadowed / Unreachable Conditions)
```java
int score = 95;

if (score >= 60) {
    System.out.println("D"); // Triggers here because 95 >= 60 is true!
} else if (score >= 70) {
    System.out.println("C");
} else if (score >= 80) {
    System.out.println("B");
} else if (score >= 90) {
    System.out.println("A"); // Never reached for any score!
}
// Output: D (Logical error!)
```

### ✅ The Correct Pattern (Narrowing Domain)
```java
int score = 95;

if (score >= 90) {
    System.out.println("A"); // Correctly captures 90+
} else if (score >= 80) {
    System.out.println("B"); // Reached only if score < 90
} else if (score >= 70) {
    System.out.println("C"); // Reached only if score < 80
} else if (score >= 60) {
    System.out.println("D"); // Reached only if score < 70
} else {
    System.out.println("F"); // Reached only if score < 60
}
// Output: A
```

---

## 3. Nested Conditionals & Logical Equivalence

A **nested conditional** is an `if`, `if-else`, or `if-else-if` placed entirely inside another conditional block.

* **Execution Gate:** The inner condition is evaluated **only if** the outer condition evaluates to `true`.
* **Equivalence to Compound AND (`&&`):**
  A simple nested `if` without intermediate statements is logically equivalent to a single `if` with an `&&` expression:

```java
// Nested Condition:
if (age >= 16) {
    if (hasPermit) {
        System.out.println("Eligible for road test");
    }
}

// Logically Equivalent Compound Condition:
if (age >= 16 && hasPermit) {
    System.out.println("Eligible for road test");
}
```

### When to Use Nested Conditionals Over `&&`
1. When intermediate code or calculations must occur between checks.
2. When guarding against null references or division by zero across multiple complex branch pathways.
3. When structuring a hierarchical decision tree (e.g., check user role first, then check specific permissions).

---

## 4. The "Dangling Else" Ambiguity Trap

In Java, an `else` clause always pairs with the **most recent unmatched `if` statement** within the same block level, regardless of how the code is indented.

### ⚠️ Misleading Indentation Example
```java
int x = -5;
int y = 10;

if (x > 0)
    if (y > 0)
        System.out.println("Both positive");
else
    System.out.println("x is negative"); // TRAP: Indented under outer if, but binds to inner if!
```
* **What happens:** The `else` belongs to `if (y > 0)`.
* Because `x > 0` is `false`, the outer `if` condition fails, skipping everything inside.
* **Output:** Nothing prints!

### ✅ The Antidote: Always Enforce Explicit Curly Braces `{}`
```java
int x = -5;
int y = 10;

if (x > 0) {
    if (y > 0) {
        System.out.println("Both positive");
    }
} else {
    System.out.println("x is negative"); // Now unambiguously bound to the outer if!
}
// Output: x is negative
```

---

## 5. Multiple Independent `if` Statements vs. `if-else-if`

Understanding when paths can combine versus when they are mutually exclusive is heavily tested on the AP Exam:

| Structure | Mechanics | Max Branches Executed | Best Used For |
| :--- | :--- | :---: | :--- |
| **`if-else-if` Ladder** | Mutually exclusive paths; halts after first `true` match | **At most 1** | Mutually exclusive categories (grades, tiers) |
| **Series of Independent `if`s** | Every condition is evaluated independently | **0 to All** | Independent flags, cumulative add-ons, discounts |

### Comparison Example
```java
int val = 15;

// Pattern A: if-else-if (Mutually Exclusive)
if (val > 10) {
    System.out.print("Big ");
} else if (val > 5) {
    System.out.print("Medium ");
}
// Output: Big

// Pattern B: Independent ifs (Cumulative)
if (val > 10) {
    System.out.print("Big ");
}
if (val > 5) {
    System.out.print("Medium ");
}
// Output: Big Medium 
```

---

## 6. Worked Tracing Practice Table

| No. | Code Segment | Step-by-Step Evaluation | Console Output |
| :---: | :--- | :--- | :---: |
| 1 | `int n = 8;`<br>`if (n < 5) System.out.print("S");`<br>`else if (n < 10) System.out.print("M");`<br>`else System.out.print("L");` | 8 < 5 is false &rarr; 8 < 10 is true &rarr; prints "M" &rarr; exits ladder | `"M"` |
| 2 | `int x = 20;`<br>`if (x > 15) System.out.print("A");`<br>`if (x > 10) System.out.print("B");`<br>`else System.out.print("C");` | Independent: 20 > 15 is true &rarr; prints "A". Next if-else: 20 > 10 is true &rarr; prints "B" | `"AB"` |
| 3 | `int a = 4, b = 7;`<br>`if (a > 5) { if (b > 5) System.out.print("1"); }`<br>`else { System.out.print("2"); }` | Outer condition 4 > 5 is false &rarr; branches directly to outer else &rarr; prints "2" | `"2"` |
| 4 | `int x = 12;`<br>`if (x % 2 == 0) System.out.print("E");`<br>`else if (x % 3 == 0) System.out.print("T");`<br>`else if (x % 4 == 0) System.out.print("F");` | 12 % 2 == 0 is true &rarr; prints "E" and immediately exits. Subsequent true conditions are bypassed | `"E"` |
| 5 | `int p = 0, q = 5;`<br>`if (p != 0) { if (q / p > 2) System.out.print("OK"); }`<br>`else System.out.print("Guard");` | Outer condition 0 != 0 is false &rarr; inner division is never reached, preventing ArithmeticException &rarr; prints "Guard" | `"Guard"` |
