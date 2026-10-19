# AP Computer Science A: Day 2 Quick Reference Cheat Sheet

## 1. Primitive Data Types & Memory Storage

### 1.1. Core Data Types Breakdown
Java provides specific built-in primitive data types to store numeric and logical values directly in memory. The table below synthesises the three primitive data types assessed in Unit 1 of the AP Computer Science A curriculum:

| Data Type | Value Category & Operational Purpose | Memory Allocation & Storage Details |
| :--- | :--- | :--- |
| **`int`** | Whole integers (numbers without decimal points) used for discrete counting and exact integer arithmetic. | Allocated exactly 4 bytes (32 bits) of finite memory space. |
| **`double`** | Real numbers (floating-point numbers containing decimal points) used for continuous mathematical values. | Allocated fixed memory space for real numbers; subject to round-off errors due to binary precision limits. |
| **`boolean`** | Logical states representing truth values; evaluates strictly to `true` or `false`. | Stores raw binary logical states directly in allocated memory space. |

> ⚠️ **AP EXAM WARNING**
> The primitive data types `long`, `float`, `char`, `byte`, and `short` are strictly excluded from the AP Computer Science A syllabus and exam scope. Questions will exclusively involve `int`, `double`, and `boolean`.

### 1.2. Key Conceptual Takeaways
* **Direct Value Storage:** A primitive variable is a designated storage location in memory that directly holds a raw value (such as an integer, real number, or Boolean value) matching its declared primitive type.
* **Contrast with Reference Types:** Unlike reference variables—which store an object reference representing the memory address of an object (or `null`)—a primitive variable directly contains the data value itself.
* **Variable Reassignment:** The stored value of a primitive variable can be updated during program execution using assignment operators, provided the newly assigned value is of a compatible data type.

### 1.3. Section Transition
Because an integer variable is allocated a fixed memory footprint of exactly 32 bits, it can only store numeric values within a strict range before binary memory capacity is exceeded.

---

## 2. Integer Boundaries & The Overflow Phenomenon

### 2.1. Constant Values & Bounds
Java defines explicit numeric boundaries for 32-bit integer storage within the `Integer` class library via two static constant values:

```java
// Java 32-bit integer boundary constants
int maximumPossible = Integer.MAX_VALUE; // Evaluates to  2147483647
int minimumPossible = Integer.MIN_VALUE; // Evaluates to -2147483648
```

* `Integer.MAX_VALUE`: Holds the maximum positive value for a 32-bit signed integer ($2^{31} - 1$, or `2147483647`).
* `Integer.MIN_VALUE`: Holds the minimum negative value for a 32-bit signed integer ($-2^{31}$, or `-2147483648`).

An `int` variable must strictly store values within the inclusive range from `Integer.MIN_VALUE` to `Integer.MAX_VALUE`.

### 2.2. The 32-Bit Wrap-Around Trap
If an arithmetic expression evaluates to an integer value exceeding the permitted 32-bit bounds, an **integer overflow** occurs. Rather than halting execution or throwing a compile-time syntax error, Java silently wraps the value around to the opposite end of the integer range.

```java
// Integer Overflow Code Demonstration
int maxInt = Integer.MAX_VALUE;
System.out.println(maxInt + 1); // Exceeds 2147483647
```
**Console Output:**
```text
-2147483648
```

> 🚨 **AP EXAM ALERT**
> Integer overflow produces no compiler errors or runtime exceptions. Attempting to add 1 to `Integer.MAX_VALUE` wraps directly around to `Integer.MIN_VALUE` (`-2147483648`). Likewise, subtracting 1 from `Integer.MIN_VALUE` wraps around to `Integer.MAX_VALUE`.

### 2.3. Section Transition
Having established how primitive numbers are bounded in memory, let us examine how computational results and escape formatting characters are rendered to the console screen.

---

## 3. Output Mechanics & Console Escape Sequences

### 3.1. Console Output: print vs println
Java provides two primary console output methods within `System.out` to display text output:

| Method Syntax | Cursor & Newline Behaviour |
| :--- | :--- |
| `System.out.print()` | Displays the specified information on the console and leaves the output cursor on the same line immediately following the printed content. |
| `System.out.println()` | Displays the specified information on the console and immediately advances the cursor to the beginning of the next line. |

### 3.2. Escape Sequences Reference Table
Escape sequences allow special control characters to be embedded directly inside Java string literals (text enclosed in double quotes). An escape sequence always begins with a backslash (`\`).

| Escape Sequence | Rendered Output | Function |
| :---: | :---: | :--- |
| `\"` | `"` | Inserts an explicit double quote character inside a string literal. |
| `\\` | `\` | Inserts a single backslash character inside a string literal. |
| `\n` | *Newline* | Repositions the console output cursor at the start of the next line. |
| `\t` | *Tab* | Inserts a horizontal tab space to align console output text. |

*(Note: `\"`, `\\`, and `\n` are the mandatory escape sequences explicitly assessed on the AP Exam).*

### 3.3. Code Walkthrough & Output Prediction
Examine the following code segment combining output methods, string literals, and escape sequences:

```java
System.out.print("AP ");
System.out.println("CS A:\nDay 2");
System.out.println("Line 1\\Line 2\t\"Done\"");
```

**Expected Console Output:**
```text
AP CS A:
Day 2
Line 1\Line 2	"Done"
```

### 3.4. Section Transition
Having mastered console text rendering and output mechanics, the final foundational pillar involves evaluating numerical operations and understanding Java's arithmetic rules.

---

## 4. Arithmetic Operators & Division Traps

### 4.1. Operator Overview
Java features five core arithmetic operators for numerical computation:

1. `+` (**Addition**): Sums two numeric values.
2. `-` (**Subtraction**): Subtracts the right operand from the left operand.
3. `*` (**Multiplication**): Multiplies two numeric values.
4. `/` (**Division**): Divides the left operand by the right operand.
5. `%` (**Remainder / Modulo**): Computes the integer remainder when dividing the left operand by the right operand.

**Operator Precedence Rules**
* **Precedence Order:** Multiplication (`*`), division (`/`), and remainder (`%`) hold higher precedence than addition (`+`) and subtraction (`-`).
* **Associativity:** Operators with equal precedence are evaluated sequentially from left to right.
* **Grouping:** Parentheses `()` override standard precedence rules.

> ℹ️ **INCREMENT / DECREMENT FORM EXCLUSION**
> On the AP Exam, post-increment (`x++`) and post-decrement (`x--`) statements are assessed as standalone statements. Prefix forms (`++x`, `--x`) and incrementing inside larger expressions (such as `arr[i++]` or `a = b++`) are strictly excluded from the exam scope.

### 4.2. Integer Division Truncation vs Floating-Point Division
The evaluation of division in Java depends strictly on the primitive data types of the operands:

* **Integer Division (`int` / `int`):** When both operands are integers, any decimal portion of the quotient is completely **truncated** (dropped towards zero). The operation yields an integer result.
* **Floating-Point Division:** If at least one operand is a `double` (e.g. `double` / `int`, `int` / `double`, or `double` / `double`), the expression evaluates to an exact `double` quotient.

**Comparative Examples:**
* `7 / 2` evaluates to `3` (the fractional decimal `.5` is truncated).
* `7.0 / 2` evaluates to `3.5` (contains a `double` operand).
* `7 / 2.0` evaluates to `3.5` (contains a `double` operand).

**Rounding double Values to the Nearest Integer**
To round a positive or negative `double` value to the nearest integer using explicit casting, apply the standard AP rounding formulas:

```java
// Rounding non-negative double values (x >= 0)
int roundedPositive = (int)(x + 0.5);

// Rounding negative double values (x < 0)
int roundedNegative = (int)(x - 0.5);
```

### 4.3. The Modulo Operator (%) & Division by Zero
The modulo operator (`%`) returns the integer remainder left over after integer division. For instance, `7 % 2` evaluates to `1` because `2` divides into `7` three full times with a remainder of `1`.

> ❌ **AP EXAM DANGER: Division by Zero**
> An attempt to divide an integer by the integer constant 0 (or compute modulo by 0), such as `5 / 0` or `5 % 0`, causes an immediate runtime error known as an `ArithmeticException`. The compiler will not catch this error, but the program will crash immediately upon execution.

**Additional AP Exam Exclusions for Arithmetic Operations**
To ensure focused preparation, keep the following official College Board Exclusion Statements in mind:
1. **Modulo Operand Constraints Exclusion:** Modulo expressions where the left operand is negative ($a < 0$) or the right operand is less than or equal to zero ($b \le 0$) are strictly excluded from the AP exam scope.
2. **Floating-Point Division by Zero Exclusion:** Expressions resulting in special floating-point double values such as `Infinity` or `NaN` (such as `5.0 / 0.0`) are strictly excluded from the AP exam scope.

### 4.4. Day 2 AP Exam Survival Checklist
- [ ] **Integer Overflow:** Remember that exceeding `Integer.MAX_VALUE` does not trigger a compiler error; it silently wraps around to negative numbers starting at `Integer.MIN_VALUE`.
- [ ] **Division Truncation & Rounding:** Always check operand types in division. `int / int` truncates all decimal places without rounding (e.g. `5 / 2` evaluates strictly to `2`). Use `(int)(x + 0.5)` to round positive real numbers.
- [ ] **Escape Sequence Orientation:** Verify backslash orientation (`\n`, `\"`, `\\`). Forward slashes (`/`) do not create valid escape sequences.
- [ ] **ArithmeticException Trap:** Avoid integer division or modulo operations where the denominator evaluates to integer `0`, which causes an instant runtime exception crash.