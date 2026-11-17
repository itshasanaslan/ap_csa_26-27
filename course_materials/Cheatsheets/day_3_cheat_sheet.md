# AP Computer Science A: Day 3 Quick Reference Cheat Sheet

## 1. Constants and Immutability (The `final` Keyword)

In program design, constants and immutable data abstractions maintain data integrity by guaranteeing that critical values remain unchanged throughout execution. A literal is the source code representation of a fixed value (such as `0.07` or `"AP CS A"`). In Java, constants are defined using the `final` keyword, which prevents variable reassignment after initialisation.

### Syntax & Rules
To declare a constant variable, prefix the data type declaration with the `final` modifier:

```java
// Declaring immutable constant variables
final double TAX_RATE = 0.07;
final int MAX_ATTEMPTS = 3;
```

### Naming Conventions
* **All Uppercase Formatting:** Constant identifiers must be written in `ALL_CAPS`.
* **Snake Case Separation:** Multi-word constants use underscores (`_`) to separate words (e.g., `TAX_RATE`, `MAX_ATTEMPTS`).
* **Visual Distinction:** This naming standard visually distinguishes immutable constants from standard mutable variables (e.g., `taxRate`) during code reviews and tracing.

### Memory Model: Primitive vs Reference Immutability
Understanding immutability requires distinguishing between primitive data types and reference data types in Java's memory model:
* **Primitive Immutability:** Marking a primitive variable `final` locks the stored value directly within the variable's memory allocation.
* **Reference Immutability:** Marking an object reference variable `final` prevents that variable from being reassigned to point to a new object memory address (or `null`). However, it does not render the internal attributes of the referenced object immutable if that object's class provides mutator methods.
* **Inherently Immutable Reference Types:** Conversely, objects of the `String` class are inherently immutable by design. Once a `String` instance is instantiated in memory, its character sequence cannot be altered; any method call executed on a `String` returns a newly instantiated `String` object in memory rather than modifying the original instance.

### Compiler Behaviour
Java enforces immutability strictly at compile time. The compiler checks code for syntax errors prior to execution. If a programmer attempts to re-assign a value to a `final` variable after its initial assignment, the compiler detects a syntax error, preventing the program from compiling.

> ℹ️ **AP Exam Tip (CED Topic 1.2):** 
> Defining fixed parameters as `final` constants prevents accidental reassignment logic errors and significantly improves code maintainability. On AP Free-Response Questions (FRQs), using `final` constants for fixed boundary values demonstrates robust program design and prevents unintended side-effects during method execution.

*While fixed constants and literals provide unchanging values within source code, interactive applications frequently require dynamic data gathered from user interactions via console input.*

---

## 2. Interactive Input with the Scanner Class

The `Scanner` class, located within the `java.util` package library, provides procedural methods for reading text input from keyboard entry streams (`System.in`).

### Setup Steps
1. **Import the Package:** Place the import directive at the top of the Java source file (before the class header) to make the library accessible:
   ```java
   import java.util.Scanner;
   ```
2. **Instantiate the Object:** Declare a reference variable of type `Scanner` and instantiate the object using the `new` keyword, passing `System.in` as the parameter to the constructor:
   ```java
   Scanner keyboard = new Scanner(System.in);
   ```

### Method Breakdown Table

| Method Call | Return Data Type | Primary Purpose & Behaviour |
| :--- | :--- | :--- |
| `nextInt()` | `int` | Scans and returns the next entered token as a primitive `int`. |
| `nextDouble()` | `double` | Scans and returns the next entered token as a primitive `double`. |
| `nextLine()` | `String` | Scans and returns the entire remaining text line as a `String` object. |
| `close()` | `void` | Closes the scanner stream to release system resource allocations. |

### Functional Code Snippet

```java
import java.util.Scanner;

public class UserInputDemo {
    public static void main(String[] args) {
        // Instantiate Scanner bound to standard input stream
        Scanner keyboard = new Scanner(System.in);
        
        // Read primitive integer and double values
        int userAge = keyboard.nextInt();
        double userSalary = keyboard.nextDouble();
        
        // Resource cleanup
        keyboard.close();
    }
}
```

> ⚠️ **AP Exam Tip (CED Topic 1.4.B.1 Exclusions):** 
> While the `Scanner` class is widely used in classroom laboratory assignments (such as the AP Receipt Lab) to capture interactive console entry, specific keyboard input mechanisms like `Scanner` are explicitly **excluded** from formal assessment on the AP Computer Science A Exam. On both Multiple-Choice Questions (MCQs) and Free-Response Questions (FRQs), input data is supplied directly via method parameters or data structures rather than standard input streams.

*Because user inputs gathered via console streams or method parameters often require mathematical processing across differing numerical data types, programmers must frequently convert between numerical data types using primitive type casting.*

---

## 3. Primitive Type Casting and Truncation

Java categorises numeric primitive types into integers (`int`) and real numbers (`double`). Converting values between these types requires understanding implicit widening, explicit casting, truncation mechanics, and operator precedence rules.

### Concepts & Truncation Mechanics
* **Implicit Widening:** Java automatically casts an `int` value to a `double` whenever an integer is used in an arithmetic expression or assignment expecting floating-point values (e.g., assigning `int x = 5` to `double y` implicitly stores `5.0`).
* **Explicit Casting:** Converting a `double` value to an `int` requires explicit unary casting operators: `(int)` or `(double)`.
* **Truncation Rules:** Casting a `double` to an `int` via `(int)` does not round to the nearest integer. Instead, it strictly **truncates** (discards) all digits to the right of the decimal point toward zero.

```java
double value = 3.99;
int truncatedValue = (int) value; // Evaluates strictly to 3
```

### Precedence Trap Comparison
Unary casting operators `(int)` and `(double)` have higher operator precedence than binary arithmetic operators (`+`, `-`, `*`, `/`, `%`). Parentheses modify this standard evaluation sequence.

**Cast Expression Trap**

| Expression | Step-by-Step Evaluation Steps with Data Types | Final Result |
| :--- | :--- | :--- |
| **Trap A:** `(double)(7 / 2)` | 1. Evaluates inner expression `$7 / 2$` first using integer division $\rightarrow$ yields `int` value `3`. <br> 2. Explicitly casts `int` value `3` $\rightarrow$ yields `double` value `3.0`. | `3.0` |
| **Trap B:** `(double)7 / 2` | 1. Evaluates unary cast `(double)7` first due to precedence $\rightarrow$ yields `double` value `7.0`. <br> 2. Evaluates floating-point division `$7.0 / 2$` (widening 2 to 2.0) $\rightarrow$ yields `double` value `3.5`. | `3.5` |

### Division and Arithmetic Faults
* **Integer Division by Zero:** Attempting to divide an integer by the integer literal 0 (e.g., `$5 / 0$`) triggers an unhandled `ArithmeticException` at run time, terminating program execution abnormally (CED Topic 1.3.C.6).
* **Floating-Point Arithmetic Scope:** Operations involving at least one `double` operand execute floating-point division.
* **AP Curriculum Exclusions:** Operations resulting in floating-point division by zero, `Infinity`, `NaN` (Not a Number) values (CED Topic 1.3.C.2), as well as modulo arithmetic operations involving negative operands (`$a < 0$` or `$b \le 0$` in `$a \pmod b$`) (CED Topic 1.3.C.4), are strictly outside the testing scope of the AP CS A Exam.

*While primitive explicit casting directly truncates decimal values toward zero, standard AP Exam algorithms require precise mathematical formulas to perform true numerical rounding and handle binary storage boundaries.*

---

## 4. AP Exam Rounding Formulas and Numeric Limits

To round a floating-point `double` value to its nearest whole integer on the AP Exam, standard mathematical offset formulas must be applied prior to explicit unary truncation.

### Canonical AP Rounding Formulas
* **Positive / Non-Negative Numbers:** `(int)(x + 0.5)`
* **Negative Numbers:** `(int)(x - 0.5)`

### Worked Examples (Including Boundary Conditions)
* **Rounding Positive Decimal (`$x = 3.8$`):**
  1. Apply positive offset: `$3.8 + 0.5 \rightarrow 4.3$`
  2. Cast to `int`: `(int)(4.3) \rightarrow 4`
* **Rounding Negative Decimal (`$x = -3.8$`):**
  1. Apply negative offset: `$-3.8 - 0.5 \rightarrow -4.3$`
  2. Cast to `int`: `(int)(-4.3) \rightarrow -4`
* **Positive Whole Number Boundary Case (`$x = 4.0$`):**
  1. Apply positive offset: `$4.0 + 0.5 \rightarrow 4.5$`
  2. Cast to `int`: `(int)(4.5) \rightarrow 4` (Algorithm remains robust for whole integers)
* **Negative Whole Number Boundary Case (`$x = -4.0$`):**
  1. Apply negative offset: `$-4.0 - 0.5 \rightarrow -4.5$`
  2. Cast to `int`: `(int)(-4.5) \rightarrow -4` (Algorithm remains robust for whole integers)

### Memory & Precision Boundaries

**Integer Bounds & Overflow**
Integer values are stored using a finite memory allocation of 4 bytes (32 bits). The exact numerical range limits are defined by constants in the `Integer` wrapper class:
* `Integer.MAX_VALUE`: Largest representable `int` value (`$2^{31} - 1 = 2,147,483,647$`).
* `Integer.MIN_VALUE`: Smallest representable `int` value (`$-2^{31} = -2,147,483,648$`).

If an arithmetic evaluation produces a value exceeding `Integer.MAX_VALUE` or falling below `Integer.MIN_VALUE`, an **integer overflow** occurs (CED Topic 1.5.B.3). The evaluation wraps around within the allowed 32-bit integer boundary, producing an incorrect, unexpected numerical result without throwing a run-time exception.

**Floating-Point Round-Off Errors**
Computers allocate fixed memory bit-widths for storing `double` data types. Because fractional decimal values are converted into binary floating-point representation, numbers that cannot be represented exactly in binary produce a **round-off error** (CED Topic 1.5.C.1).

For example, evaluating the floating-point expression `$0.1 + 0.2$` in Java yields `0.30000000000000004` rather than exact `0.3`. To eliminate round-off errors completely in discrete counting or indexing logic, always use `int` primitive variables.

*Beyond standard rounding and boundary evaluations, Java provides concise shortcut evaluation techniques through compound assignment and arithmetic increment operators to streamline variable updates.*

---

## 5. Compound Assignment and Post-Increment/Decrement Operators

Compound assignment operators combine binary arithmetic operations with value storage into a single operational step.

### Compound Operator Matrix

| Operator | Sample Expression | Equivalent Full Expression | Net Effect on Stored Variable |
| :---: | :--- | :--- | :--- |
| `+=` | `x += 5` | `x = x + 5` | Adds 5 to `x` and stores the sum in `x`. |
| `-=` | `x -= 5` | `x = x - 5` | Subtracts 5 from `x` and stores the difference in `x`. |
| `*=` | `x *= 5` | `x = x * 5` | Multiplies `x` by 5 and stores the product in `x`. |
| `/=` | `x /= 5` | `x = x / 5` | Divides `x` by 5 and stores the quotient in `x`. |
| `%=` | `x %= 5` | `x = x % 5` | Calculates remainder of `$x / 5$` and stores it in `x`. |

### Post-Increment and Post-Decrement
* **Post-Increment (`x++`):** Adds 1 to the current stored value of numeric variable `x` and assigns the updated value back to `x` (CED Topic 1.6.A.2).
* **Post-Decrement (`x--`):** Subtracts 1 from the current stored value of numeric variable `x` and assigns the updated value back to `x`.

> 🚨 **AP Exam Exclusion Notice (CED Topics 1.4 & 1.6):** 
> The use of increment and decrement operators in prefix form (e.g., `++x`, `--x`) is strictly outside the scope of the AP Computer Science A curriculum and exam. Furthermore, embedding increment or decrement operators inside other statements (e.g., `arr[x++]`), as well as chaining assignment operators (e.g., `a = b = 4` or `a[i += 5]`), are explicitly excluded from testing and will not appear on the AP Exam.

---
*Meticulously reviewing these foundational syntax rules, numerical storage boundaries, and operator evaluation sequences will ensure complete accuracy when tracing and implementing code for AP CS A multiple-choice and free-response assessment questions.*