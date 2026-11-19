# AP Computer Science A — Day 12 Quick Reference Cheat Sheet: Object Equality & Null References

## 1. Primitives vs. Reference Types: Memory Representation

In Java, data types are divided into two fundamental categories that handle computer memory differently:

* **Primitive Types (`int`, `double`, `boolean`, `char`):**
  * Store their **actual numeric or truth value** directly in the variable's memory box on the stack.
  * The `==` operator directly compares the binary values stored in those boxes.
* **Reference Types (`String`, Scanner, custom objects):**
  * Do **not** store the object data directly in the variable's memory box.
  * Store a **memory address (reference pointer)** that points to the actual object stored on the heap.
  * The `==` operator compares the **memory addresses**, NOT the contents of the objects.

```text
PRIMITIVE (Direct Value):
int x = 42;          [ x: 42 ]
int y = 42;          [ y: 42 ]
x == y               --> true (42 == 42)

REFERENCE (Memory Address Pointer):
String a = new String("Java");   [ a: 0x1A4F ] ----> Heap: [ "Java" ] at 0x1A4F
String b = new String("Java");   [ b: 0x9B8C ] ----> Heap: [ "Java" ] at 0x9B8C
a == b                           --> false (0x1A4F != 0x9B8C, different addresses!)
a.equals(b)                      --> true  (both hold identical characters: "Java")
```

---

## 2. Identity vs. Equivalence: `==` vs. `.equals()`

Understanding the distinction between reference identity and content equivalence is one of the most frequently tested concepts on the AP Computer Science A Exam.

| Operator / Method | What It Compares | Typical Question It Answers | Example with `String s1, s2` |
| :---: | :--- | :--- | :---: |
| `==` | **Memory Address (Reference Identity)** | *Are these two variables pointing to the exact same object in memory?* | `s1 == s2` |
| `!=` | **Memory Address (Reference Difference)** | *Are these two variables pointing to different memory locations?* | `s1 != s2` |
| `.equals(...)` | **Object Contents (Logical Equivalence)** | *Do the two objects contain identical state/characters?* | `s1.equals(s2)` |

> ⚠️ **Critical AP Exam Trap:** Never use `==` or `!=` to test if two `String` objects contain the same text! While `s1 == s2` might occasionally evaluate to `true` when string literals are shared by Java's compiler optimization (the string pool), comparing user input, substrings, or newly instantiated strings with `==` results in false negatives. **Always use `.equals()` for String content comparison.**

---

## 3. Object Aliasing & Reference Assignment

When an existing reference variable is assigned to a new reference variable using `=`, the memory address is copied. **No new object is created.** Both variables now point to the exact same object on the heap. This relationship is called **aliasing**.

```java
String first = new String("Falcon");
String second = new String("Falcon");
String alias = first; // Copies address of 'first' into 'alias'

System.out.println(first == second);     // false (different heap objects)
System.out.println(first == alias);      // true  (same memory address)
System.out.println(first.equals(second));// true  (same characters: "Falcon")
System.out.println(first.equals(alias)); // true  (same characters: "Falcon")
```

---

## 4. The `null` Reference & `NullPointerException`

* **Definition:** `null` is a special literal in Java that signifies an object reference variable does not point to any object in memory.
* **Uninitialized State:** Instance variables of reference types automatically default to `null` before initialization.
* **The Crash:** If code attempts to invoke an instance method or access an instance variable through a reference that holds `null`, the Java Virtual Machine halts execution and throws a runtime **`NullPointerException`**.

```java
String username = null;

// VALID: Comparing reference directly to null using == or !=
if (username == null) {
    System.out.println("No username provided"); // Executes safely
}

// RUNTIME RUN-TIME CRASH (NullPointerException):
if (username.equals("admin")) { 
    // Throws NullPointerException because 'username' does not point to any object!
}
```

---

## 5. Defensive Guarding with Short-Circuit Evaluation

To safely call methods on reference variables that might be `null`, use a **defensive guard check** placed as the left operand of a logical AND (`&&`) expression.

Because Java performs **short-circuit evaluation**, if the left operand evaluates to `false`, evaluation stops immediately and the right operand is **never executed**.

```java
String input = null;

// SAFE GUARD PATTERN:
// Step 1: (input != null) evaluates to false.
// Step 2: Java short-circuits and skips input.length() > 0 entirely!
if (input != null && input.length() > 0) {
    System.out.println("Valid input: " + input);
}

// FATAL MISTAKE (Reversed Order):
// Java evaluates input.length() FIRST -> Instant NullPointerException crash!
if (input.length() > 0 && input != null) {
    System.out.println("This crashes before reaching the null check!");
}
```

---

## 6. The Constant-First Strategy (Null-Safe Comparison)

When comparing an object reference variable against a known, constant string literal, place the string literal **on the left side** of the `.equals()` call:

```java
String role = null; // could be null or user-provided

// METHOD A (Requires explicit null guard):
if (role != null && role.equals("MANAGER")) { ... }

// METHOD B (Constant-First / Null-Safe):
// Since "MANAGER" is a literal, it is guaranteed to never be null.
// If role is null, "MANAGER".equals(null) safely evaluates to false without crashing!
if ("MANAGER".equals(role)) {
    System.out.println("Access granted to manager portal");
}
```

---

## 7. Master Tracing & Comparison Table

Examine the following code definitions:
```java
String p = "apple";
String q = "apple";
String r = new String("apple");
String s = new String("apple");
String t = r;
String u = null;
String v = "APPLE";
```

| Expression | Evaluates To | Primary Reason |
| :--- | :---: | :--- |
| `p == q` | `true` | Both refer to the identical string literal pooled by Java |
| `p == r` | `false` | `p` is in the string pool; `r` was allocated as a new heap object |
| `r == s` | `false` | Two separate `new` operations created two distinct heap objects |
| `r == t` | `true` | `t` is an alias of `r`; both store the exact same heap memory address |
| `p.equals(r)` | `true` | Both contain the identical sequence of characters: `"apple"` |
| `r.equals(s)` | `true` | Both contain the identical sequence of characters: `"apple"` |
| `p.equals(v)` | `false` | `.equals()` is strictly case-sensitive (`"apple"` vs `"APPLE"`) |
| `u == null` | `true` | Reference comparison verifying `u` points to nothing |
| `u != null && u.equals("apple")` | `false` | Short-circuit guard: `u != null` is `false`, so right side never executes |
| `"apple".equals(u)` | `false` | Literal on left safely checks equivalence against `null` without crashing |
| `u.equals("apple")` | **Exception** | **`NullPointerException`**: Cannot call instance method on `null` |
