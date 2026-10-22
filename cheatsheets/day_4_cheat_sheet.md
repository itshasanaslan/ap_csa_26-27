# 📌 AP Computer Science A — Day 4 Quick Reference Cheat Sheet

## 1. APIs & Packages (`java.lang` vs. `java.util`)
* **API (Application Program Interface):** A set of pre-written classes, interfaces, and methods provided by Java libraries.
* **Packages:** Collections of related classes.
  * `java.lang`: Auto-imported by default. Contains core classes like `System`, `Math`, `String`, `Integer`, `Double`.
  * `java.util`: Requires explicit import. Contains utility classes like `Scanner`:
    ```java
    import java.util.Scanner; // Placed at the top of the file before class definition
    ```

---

## 2. Documentation & Javadoc
Java supports three comment styles to document code structure and requirements:

```java
// 1. Single-line comment (internal developer notes)

/* 2. Multi-line comment
      for block notes */

/**
 * 3. Javadoc comment (used to generate official HTML API documentation)
 * Precondition: x >= 0.0
 * Postcondition: Returns the non-negative square root of x
 */
```

### ⚠️ Preconditions vs. Postconditions (AP Exam Favorite)
* **Precondition:** A requirement that must be true **BEFORE** a method is called. The caller is responsible for ensuring preconditions are met. The method does not check or handle invalid preconditions.
* **Postcondition:** A guarantee describing the state or return value **AFTER** the method successfully executes.

---

## 3. Method Signatures & Procedural Abstraction
* **Procedural Abstraction:** Using a method by knowing *what* it does without needing to know *how* its internal code is implemented.
* **Method Signature:** Composed of the **Method Name + Ordered List of Parameter Types**. *(Return types and variable names are NOT part of the signature).*

### Key Method Mechanics
* **Void vs. Non-Void:**
  * `void` methods perform an action and return no value. Calling a `void` method inside `System.out.println()` causes a **Compiler Error**.
  * **Non-void** methods return a typed value (`int`, `double`, `boolean`, etc.) that must be assigned to a variable, printed, or used in an expression.
* **Parameters vs. Arguments:**
  * **Parameters:** Variables defined in the method header (placeholders).
  * **Arguments:** Actual values passed into the method during invocation.
* **Call-by-Value:** Java passes *copies* of primitive arguments into method parameters. Modifying a primitive parameter inside a method does **NOT** change the original variable in `main`.
* **Method Overloading:** Multiple methods in the same class sharing the same name but having different parameter lists (types, order, or quantity). Changing *only* the return type does not count as overloading and produces a compiler error.

---

## 4. Calling Class (`static`) Methods
Methods declared with the `static` keyword belong to the class itself, not to individual object instances.
* **Invocation Syntax:** `ClassName.methodName(arguments)`
  ```java
  double root = Math.sqrt(25.0); // Called using the Class name 'Math'
  ```
* **Note:** If calling a `static` method from within the same class, the `ClassName.` prefix is optional.

---

## 5. The `Math` Class & AP Random Range Formula
All methods in the `Math` class are `static` and part of `java.lang`.

### Core `Math` Methods on the AP Java Quick Reference

| Method Signature | Description | Return Type | Example |
| :--- | :--- | :--- | :--- |
| `Math.abs(int x)` / `Math.abs(double x)` | Returns the absolute value of $x$. | Matches input type (`int` or `double`) | `Math.abs(-5)` $\rightarrow 5$ |
| `Math.pow(double base, double exp)` | Returns `base` raised to `exp` ($\text{base}^{\text{exp}}$). | `double` | `Math.pow(3, 2)` $\rightarrow 9.0$ |
| `Math.sqrt(double x)` | Returns non-negative square root ($\sqrt{x}$). | `double` | `Math.sqrt(16)` $\rightarrow 4.0$ |
| `Math.random()` | Returns a random number in $[0.0, 1.0)$. | `double` | `0.72491...` |

---

### 🎲 Mastering the AP `Math.random()` Integer Range Formula
`Math.random()` generates a floating-point number in the semi-open interval $[0.0, 1.0)$ (inclusive of $0.0$, exclusive of $1.0$).

To generate a random integer in an inclusive range $[min, max]$:

$$\text{range} = max - min + 1$$

$$\text{int randomNum} = (\text{int})(\text{Math.random}() \times \text{range}) + min;$$

#### 💡 Concrete Example: Rolling a 6-Sided Die ($1$ to $6$)
```java
int min = 1;
int max = 6;
int range = max - min + 1; // 6 - 1 + 1 = 6 possible outcomes

int die = (int)(Math.random() * 6) + 1; // Generates 1, 2, 3, 4, 5, or 6
```

#### 🚨 AP Exam Cast Precedence Trap
The explicit cast `(int)` has higher operator precedence than multiplication (`*`).

```java
// ❌ THE BUG (Evaluates to 1 EVERY TIME!):
int badDie = (int) Math.random() * 6 + 1;
// Step 1: (int) Math.random() truncates [0.0, 1.0) down to 0
// Step 2: 0 * 6 = 0
// Step 3: 0 + 1 = 1

// ✅ THE FIX (Parentheses force multiplication first):
int goodDie = (int)(Math.random() * 6) + 1;
```