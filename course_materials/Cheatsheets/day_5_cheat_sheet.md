# AP Computer Science A: Day 5 Quick Reference Cheat Sheet (Math & String Methods)

## 1. Class (Static) Methods & The Java Math Library

### 1.1. Calling Static Class Methods
Class (static) methods are procedural abstractions associated directly with the class itself rather than with specific object instances. A static method header explicitly includes the `static` modifier keyword before the return type.

*   **External Class Calls:** To invoke a static method from outside its defining class, qualify the method name using the class name and dot operator (`.`): `ClassName.methodName(arguments)`.
*   **Internal Class Calls:** When invoking a static method from within its defining class, prefixing the call with `ClassName.` is optional.
*   **Scope & Instantiation Note:** The `Math` class in Java contains only static methods and constants. In the AP CS A curriculum, the `Math` class cannot be instantiated (i.e., you never call `new Math()`).

```java
// External Class Call: ClassName is mandatory
double squareRoot = Math.sqrt(25.0); 

// Internal Class Call: ClassName prefix is optional inside the defining class
double result = calculateTax(100.0); // Equivalent to MyClass.calculateTax(100.0)
```

### 1.2. Core Math Class Methods Reference
The `Math` class belongs to the `java.lang` package, which is automatically imported into every Java source file. All `Math` methods are static.

| Method Signature | Return Type & Range | Description & Output Example |
| :--- | :--- | :--- |
| `static int abs(int x)` | `int` ($x \ge 0$) | Returns the absolute value of an `int` value.<br>`Math.abs(-5)` $\rightarrow$ `5` |
| `static double abs(double x)` | `double` ($x \ge 0.0$) | Returns the absolute value of a `double` value.<br>`Math.abs(-3.14)` $\rightarrow$ `3.14` |
| `static double pow(double base, double exponent)` | `double` | Returns base raised to exponent.<br>`Math.pow(2.0, 3.0)` $\rightarrow$ `8.0` |
| `static double sqrt(double x)` | `double` ($x \ge 0.0$) | Returns the non-negative square root of a `double` value.<br>`Math.sqrt(16.0)` $\rightarrow$ `4.0` |
| `static double random()` | `double` ($0.0 \le x < 1.0$) | Returns a pseudo-random `double` value in the range $[0.0, 1.0)$.<br>`Math.random()` $\rightarrow$ `0.74251...` |

> **AP EXAM DISTRACTOR TRAP: `Math.pow` RETURN TYPE**
> `Math.pow` always returns a `double`. Passing integer literals (e.g., `Math.pow(2, 3)`) triggers implicit widening of arguments to `double` (`2.0`, `3.0`) and yields `8.0`, never an `int` such as `8`. On AP multiple-choice questions, integer return choices are common distractor options.

### 1.3. AP Exam Random Range Formula & Cast Precedence Traps
To generate a random integer within a specified range, scale, cast, and shift the output of `Math.random()`:

$$ \text{Standard AP Formula: } \mathbf{(int)(Math.random() * range) + min} $$

*   **Scaling (`range`):** Expands the basic interval from $0.0 \le x < 1.0$ to $0.0 \le x < \text{range}$.
*   **Casting (`(int)`):** Truncates the decimal portion, yielding an integer from $0$ to $\text{range} - 1$.
*   **Shifting (`+ min`):** Shifts the bound to generate an integer in the inclusive range $[\text{min}, \text{min} + \text{range} - 1]$.

```java
// Concrete Example: Simulating a standard 6-sided die roll (min = 1, range = 6)
int dieRoll = (int)(Math.random() * 6) + 1; // Evaluates to an integer from 1 to 6 inclusive
```

> **AP EXAM WARNING / COMMON PITFALL: CAST PRECEDENCE TRAP**
> In Java, the cast operator `(int)` has a higher operator precedence than the multiplication operator `*`.

```java
// FLAWED PRECEDENCE TRAP:
int val = (int) Math.random() * range + min; // ALWAYS EVALUATES TO min!

// CORRECT PARENTHESISED FORMULA:
int val = (int)(Math.random() * range) + min; // Evaluates correctly
```

**Step-by-Step Execution Failure:**
1. `(int) Math.random()` is evaluated first. Since `Math.random()` yields $0.0 \le x < 1.0$, casting it to `(int)` truncates the value strictly to `0`.
2. `0 * range` evaluates to `0`.
3. `0 + min` evaluates to `min`.

*AP Exam Tip: Always verify that inner parentheses enclose the product `(Math.random() * range)` before casting. Without them, `(int)Math.random()` truncates to `0` every single time.*

---

## 2. Primitive Data Types vs Object Reference Types

### 2.1. Storage & Memory Model: Values vs Memory Addresses
Java manages memory across two regions: Stack Memory (for local primitive variables and reference variables) and Heap Memory (for instantiated objects).

```text
    STACK MEMORY                                HEAP MEMORY
+--------------------+                     +-------------------+
| int x = 10         |                     | String object     |
| [ Raw Value: 10 ]  |                     | "hello"           |
+--------------------+                     +-------------------+
| String s = 0x1A4F  |-------------------->| Address: 0x1A4F   |
+--------------------+                     +-------------------+
```

| Criterion | Primitive Types (`int`, `double`, `boolean`) | Reference Types (`String`, User-Defined Classes) |
| :--- | :--- | :--- |
| **Memory Contents** | Stores the actual raw primitive value directly on the stack. | Stores an object reference (memory address pointing to heap allocation). |
| **Supported Types in Scope** | `int`, `double`, `boolean` | `String`, user-defined classes, library classes. |
| **Default / Unassigned State** | Local variables inside methods remain uninitialized. Instance variables default to `0`, `0.0`, or `false`. | Local variables remain uninitialized. Instance variables default to `null`. |

*Scope Exclusion Note: Primitive types `long`, `short`, `byte`, `float`, and `char` are outside the scope of the AP CS A exam.*

### 2.2. Null References & NullPointerException Traps
The literal `null` indicates that a reference variable is not currently associated with any physical object in heap memory.

> **PITFALL HIGHLIGHT: NullPointerException**
> Attempting to invoke an instance method or access an instance attribute on a `null` reference causes a runtime crash known as a `NullPointerException`.

```java
String name = null; // Reference declared, but no object instantiated in heap

int len = name.length(); // RUNTIME ERROR: Throws NullPointerException!
                         // Cannot invoke instance methods on a null reference.
```

---

## 3. Object Instantiation & Constructor Mechanics

### 3.1. Object Creation Syntax & Memory Allocation
Objects are created (instantiated) using the `new` keyword followed by a constructor call.

```java
ClassName variableName = new ClassName(arguments);
```
*   **`ClassName` (Type):** Defines the reference type of the variable being declared.
*   **`variableName`:** The identifier on the stack holding the memory address pointer.
*   **`new`:** Keyword that allocates heap memory for the new object.
*   **`ClassName(arguments)` (Constructor Call):** Executes constructor code to initialize object attributes. Arguments pass values to parameters via call-by-value.

### 3.2. Constructor Call Execution Flow & Call-by-Value
A constructor is a block of code sharing the exact name of its class. Constructors can be overloaded by defining multiple constructors with differing parameter lists (varying in parameter count, data types, or order).

```text
[1. Program Statement] ---> [2. Execution Interrupted] ---> [3. Constructor Body Runs]
                                                                      |
[5. Program Continues] <--- [4. Control Returns] <--------------------+
```

1. **Invocation:** Statement execution halts when a `new` constructor call is reached.
2. **Control Transfer:** Program control jumps to the matching constructor body.
3. **Call-by-Value Argument Passing:**
    *   **Primitive Arguments:** A copy of the literal primitive value is passed. Modifying the parameter inside the constructor does not change the original argument variable.
    *   **Reference Arguments:** A copy of the memory address is passed. Both caller argument and parameter variable hold copies of the same address, pointing to the exact same physical object in heap memory.
4. **Attribute Initialization:** Statements in the constructor execute to set initial object attribute values.
5. **Return of Control:** Control returns immediately to the statement following the instantiation call.

---

## 4. Essential String Class Methods & Immutability Rules

### 4.1. String Immutability & Concatenation Dynamics
A `String` object represents an immutable sequence of characters belonging to `java.lang`.
*   **String Immutability:** Once instantiated, a `String` object's content cannot be modified. Methods called on a `String` return a new `String` object rather than mutating the original object.
*   **Concatenation (`+` and `+=`):** Joining strings creates a brand-new `String` object.
*   **Implicit Conversion:** Concatenating a primitive or object with a `String` implicitly converts the operand to a `String`. For objects, concatenation implicitly calls the object's `toString()` method.

```java
String str = "hello";
str.toUpperCase(); // Returns "HELLO", but str IS UNCHANGED!
System.out.println(str); // Output: "hello"

str = str.toUpperCase(); // Reassignment updates str to store address of the new String
System.out.println(str); // Output: "HELLO"
```

### 4.2. String Indexing & Exception Boundaries
String indexing is zero-based, spanning valid indices from $0$ to $\text{length}() - 1$.

```text
 String str = "COMPUTE";
 Index:       0  1  2  3  4  5  6
 Length:      7 characters
```

> **INDEX BOUNDARY RULE**
> Accessing an index outside $0 \le \text{index} \le \text{length}() - 1$ (i.e., $\text{index} < 0$ or $\text{index} \ge \text{length}()$) throws a runtime `StringIndexOutOfBoundsException`.

### 4.3. Core String Method Quick Reference Table
All listed methods belong to the `String` class and are specified in the AP Java Quick Reference.

| Method Header | Return Type | Behaviour / Indexing Logic | Code Example & Result |
| :--- | :--- | :--- | :--- |
| `int length()` | `int` | Returns the total number of characters in the String. | `"Java".length()` $\rightarrow$ `4` |
| `String substring(int from, int to)` | `String` | Returns characters from index `from` up to `to - 1`.<br>• Edge Case: `substring(k, k)` returns `""` (empty string, length $0$).<br>• Throws `StringIndexOutOfBoundsException` if `from > to`, `from < 0`, or `to > length()`. | `"Java".substring(1, 3)` $\rightarrow$ `"av"`<br>`"Java".substring(2, 2)` $\rightarrow$ `""` |
| `String substring(int from)` | `String` | Returns substring from index `from` through `length() - 1`. Equivalent to `substring(from, length())`. | `"Java".substring(1)` $\rightarrow$ `"ava"` |
| `int indexOf(String str)` | `int` | Returns the index of the first occurrence of `str`; returns `-1` if `str` is not found. | `"Java".indexOf("v")` $\rightarrow$ `2`<br>`"Java".indexOf("x")` $\rightarrow$ `-1` |
| `boolean equals(Object other)` | `boolean` | Returns `true` if this string contains the exact same sequence of characters as `other`; `false` otherwise. | `"hi".equals("hi")` $\rightarrow$ `true`<br>`"hi".equals("HI")` $\rightarrow$ `false` |
| `int compareTo(String other)` | `int` | Returns $< 0$ if this is lexicographically less than `other`; $0$ if equal; $> 0$ if greater. Uses ASCII ordering (uppercase precedes lowercase). | `"A".compareTo("B")` $\rightarrow$ `negative value`<br>`"Zoo".compareTo("apple")` $\rightarrow$ `negative value` ('Z' ASCII 90 < 'a' ASCII 97) |
| **Single-Char Extraction Trick** | `String` | Extracts a single character at position `index` as a String using `substring(index, index + 1)`. | `"Java".substring(2, 3)` $\rightarrow$ `"v"` |

*AP Exam Tip: When tracing `substring(a, b)` on Section 1 questions, calculate the length of the resulting substring as `b - a`.*

### 4.4. Reference Equality (`==`) vs Logical Equality (`.equals()`)
Distinguishing reference equality from logical equality is critical for AP exam success:
*   `==` and `!=` (Reference Equality): Checks if two variables store the exact same memory address (referencing the exact same physical object in heap memory).
*   `.equals()` (Logical Equality): Checks if two `String` objects hold the identical sequence of characters, regardless of their memory locations.

> **AP EXAM WARNING: REFERENCE VS LOGICAL EQUALITY**
> On the AP exam, `new String("...")` is explicitly used to force the creation of distinct heap objects, bypassing JVM string pooling and making `==` evaluate to `false`.

```java
String str1 = new String("AP-CS"); // Explicit instantiation forces Object 1 in Heap
String str2 = new String("AP-CS"); // Explicit instantiation forces Object 2 in Heap

// REFERENCE EQUALITY (==)
boolean refCheck = (str1 == str2); 
// Result: FALSE (str1 and str2 point to distinct memory addresses)

// LOGICAL EQUALITY (.equals())
boolean valCheck = str1.equals(str2); 
// Result: TRUE (Both distinct objects contain the character sequence "AP-CS")
```