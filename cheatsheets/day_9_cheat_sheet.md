# AP Computer Science A — Day 9 Quick Reference Cheat Sheet: Boolean Logic & De Morgan's Laws

## 1. Relational Operators & Primitive Comparisons

Relational operators compare two primitive numeric values (`int` or `double`) and evaluate strictly to a primitive `boolean` value: `true` or `false`.

| Operator | Meaning | Example Expression | Result (`x = 5, y = 10`) |
| :---: | :--- | :--- | :---: |
| `==` | Equal to | `x == y` | `false` |
| `!=` | Not equal to | `x != y` | `true` |
| `<` | Strictly less than | `x < y` | `true` |
| `>` | Strictly greater than | `x > y` | `false` |
| `<=` | Less than or equal to | `x <= 5` | `true` |
| `>=` | Greater than or equal to | `y >= 12` | `false` |

> **Watch Out:** Never confuse `=` (assignment) with `==` (equality comparison). The single equals sign stores a value into a variable, while the double equals sign compares two values. In Java, writing `if (x = 5)` will not compile because an `int` cannot be converted to a `boolean`.

---

## 2. Logical Operators & Compound Expressions

Logical operators combine or invert boolean values to direct program execution.

* **Logical NOT (`!`):** Unary operator that flips the truth value. If `A` is `true`, `!A` is `false`.
* **Logical AND (`&&`):** Evaluates to `true` **only if both** operands are `true`. If either operand is `false`, the entire expression evaluates to `false`.
* **Logical OR (`||`):** Evaluates to `true` **if at least one** operand is `true`. It evaluates to `false` only when both operands are `false`.

### Master Truth Table

| `A` | `B` | `!A` | `A && B` | `A \|\| B` |
| :---: | :---: | :---: | :---: | :---: |
| `true` | `true` | `false` | `true` | `true` |
| `true` | `false` | `false` | `false` | `true` |
| `false` | `true` | `true` | `false` | `true` |
| `false` | `false` | `true` | `false` | `false` |

---

## 3. Java Operator Precedence Hierarchy

When an expression contains arithmetic, relational, and logical operators without parentheses, Java evaluates them in this strict order:

1. **Parentheses:** `()` *(Evaluated from innermost to outermost)*
2. **Unary Operators:** `!`, `++`, `--`, unary `-`
3. **Multiplicative Arithmetic:** `*`, `/`, `%`
4. **Additive Arithmetic:** `+`, `-`
5. **Relational Comparisons:** `<`, `>`, `<=`, `>=`
6. **Equality Comparisons:** `==`, `!=`
7. **Logical AND:** `&&`
8. **Logical OR:** `||`
9. **Assignment Operators:** `=`, `+=`, `-=`, `*=`, `/=`, `%=`

### Step-by-Step Tracing Example
```java
int a = 3, b = 4, c = 5;
boolean result = a + b * 2 > c && !(b == 4) || c - a == 2;

// 1. Multiplicative arithmetic: b * 2 = 8
// 2. Additive arithmetic: 3 + 8 = 11, 5 - 3 = 2
// 3. Inside parentheses: (b == 4) is true
// 4. Unary NOT: !(true) is false
// 5. Relational and equality: 11 > 5 is true, 2 == 2 is true
//    Expression simplifies to: true && false || true
// 6. Logical AND before OR: true && false is false
// 7. Logical OR: false || true evaluates to true
```

---

## 4. Short-Circuit Evaluation & The Guard Pattern

Java evaluates logical expressions from left to right and stops evaluation as soon as the final boolean result is guaranteed:

* **In an `AND` expression (`A && B`):** If `A` is `false`, the whole expression must be `false`. Java **skips evaluating `B`**.
* **In an `OR` expression (`A || B`):** If `A` is `true`, the whole expression must be `true`. Java **skips evaluating `B`**.

### The Defensive Guard Pattern
Short-circuiting prevents runtime crashes like `ArithmeticException` (division by zero) or `NullPointerException` by placing safety checks first:

```java
int count = 0;
int total = 100;

// SAFE: count != 0 evaluates to false, so total / count is skipped entirely!
if (count != 0 && total / count > 5) {
    System.out.println("Average is high");
}

String text = null;

// SAFE: text != null evaluates to false, so text.length() is never called!
if (text != null && text.length() > 0) {
    System.out.println("Text is valid");
}
```

> **Trap Warning:** If the order is reversed to `if (total / count > 5 && count != 0)`, Java executes division by zero first and crashes before reaching the check!

---

## 5. De Morgan's Laws & Boolean Simplification

De Morgan's Laws provide the rules for distributing a negation (`!`) across compound conditions:

1. `!(A && B)` is equivalent to `!A || !B`
2. `!(A || B)` is equivalent to `!A && !B`

### Relational Inversion Table

| Original Condition | Negated Equivalent |
| :---: | :---: |
| `!(x < y)` | `x >= y` |
| `!(x <= y)` | `x > y` |
| `!(x > y)` | `x <= y` |
| `!(x >= y)` | `x < y` |
| `!(x == y)` | `x != y` |
| `!(x != y)` | `x == y` |

### Range Negation Rules
* **Inside Range:** `(val >= 1 && val <= 10)`
* **Negated Range (Outside):** `!(val >= 1 && val <= 10)` simplifies to `(val < 1 || val > 10)`

---

## 6. Comprehensive Boolean Expression Practice Sets

The following practice tables illustrate evaluation steps from atomic comparisons to complex multi-operator conditions.

### Set A: Simple Boolean Expressions

| No. | Expression | Step-by-Step Evaluation | Result |
| :---: | :--- | :--- | :---: |
| 1 | `3 >= 2` | Numeric comparison: 3 is greater than or equal to 2 | `true` |
| 2 | `!(10 == 10)` | Inner `10 == 10` is `true`. Negating gives `!(true)` | `false` |
| 3 | `12 % 5 == 2` | Arithmetic modulo: `12 % 5` is `2`. Comparison `2 == 2` | `true` |
| 4 | `7 < 6` | Numeric comparison: 7 is not less than 6 | `false` |
| 5 | `!(8 != 8)` | Inner `8 != 8` is `false`. Negating gives `!(false)` | `true` |

### Set B: Logical Operators in Action

| No. | Expression | Step-by-Step Evaluation | Result |
| :---: | :--- | :--- | :---: |
| 1 | `(2 + 2 == 4) && (3 * 3 == 9)` | `(4 == 4) && (9 == 9)` &rarr; `true && true` | `true` |
| 2 | `(7 > 5) \|\| (3 < 1)` | Left `7 > 5` is `true`. Short-circuits over right side | `true` |
| 3 | `(4 % 2 == 0) && (10 / 2 > 3)` | Left `0 == 0` is `true`. Right `5 > 3` is `true` &rarr; `true && true` | `true` |
| 4 | `!(6 > 4) \|\| (2 <= 3)` | Left `!(true)` is `false`. Right `2 <= 3` is `true` &rarr; `false \|\| true` | `true` |
| 5 | `(5 + 5 == 10) && !(20 / 4 != 5)` | Left `10 == 10` is `true`. Right `!(5 != 5)` is `!(false) = true` &rarr; `true && true` | `true` |

### Set C: Nested Conditions

| No. | Expression | Step-by-Step Evaluation | Result |
| :---: | :--- | :--- | :---: |
| 1 | `(10 > 8) && ((5 - 3) == 2)` | `true && (2 == 2)` &rarr; `true && true` | `true` |
| 2 | `!(4 * 2 == 8) \|\| (12 / 4 == 3)` | Left `!(8 == 8)` is `false`. Right `3 == 3` is `true` &rarr; `false \|\| true` | `true` |
| 3 | `((7 - 4 > 2) \|\| (10 % 3 == 1)) && (15 / 5 == 3)` | Inner left `3 > 2` is `true`, so nested OR is `true`. Right `3 == 3` is `true` &rarr; `true && true` | `true` |
| 4 | `((8 <= 8) && !(3 > 5)) \|\| ((9 / 3 == 3) && (7 > 6))` | Left block: `true && !(false)` is `true && true = true`. Short-circuits entire OR expression | `true` |
| 5 | `!(3 * 3 != 9) && ((4 + 4 == 8) \|\| (2 == 5))` | Left: `!(9 != 9)` is `!(false) = true`. Right: `(8 == 8)` is `true` &rarr; `true && true` | `true` |

### Set D: Math-Heavy & Tricky Boolean Expressions

| No. | Expression | Step-by-Step Evaluation | Result |
| :---: | :--- | :--- | :---: |
| 1 | `(5 * 2 == 10) && (10 / 2 != 4)` | `(10 == 10) && (5 != 4)` &rarr; `true && true` | `true` |
| 2 | `((10 % 3 == 1) && (4 * 2 >= 8)) \|\| !(7 == 7)` | Left block: `(1 == 1) && (8 >= 8)` &rarr; `true && true = true`. Short-circuits OR | `true` |
| 3 | `((6 + 2 > 9) \|\| (8 - 3 < 6)) && (12 / 4 == 3)` | Nested OR: `(8 > 9 \|\| 5 < 6)` &rarr; `false \|\| true = true`. Right: `3 == 3` &rarr; `true && true` | `true` |
| 4 | `!(2 * 3 > 5) \|\| ((10 / 5 == 2) && (15 % 4 == 3))` | Left: `!(6 > 5)` is `!(true) = false`. Right: `(2 == 2) && (3 == 3)` is `true && true = true` &rarr; `false \|\| true` | `true` |
| 5 | `((2 + 3 == 5) && !(9 - 3 > 7)) \|\| (4 * 4 == 16)` | Left block: `(5 == 5) && !(6 > 7)` &rarr; `true && !(false) = true`. Short-circuits OR | `true` |

### Set E: Challenge Boolean Expressions

| No. | Expression | Step-by-Step Evaluation | Result |
| :---: | :--- | :--- | :---: |
| 1 | `(5 > 2) && ((10 % 3 == 1) \|\| (2 * 3 < 5))` | Left: `5 > 2` is `true`. Right block: `(1 == 1)` is `true`, OR short-circuits to `true` &rarr; `true && true` | `true` |
| 2 | `!(3 + 3 == 6) \|\| ((4 / 2 == 2) && !(7 < 9))` | Left: `!(6 == 6)` is `false`. Right: `(2 == 2) && !(true)` &rarr; `true && false = false` &rarr; `false \|\| false` | `false` |
| 3 | `(6 * 6 == 36) && ((9 % 4 == 1) \|\| !(8 <= 10))` | Left: `36 == 36` is `true`. Right block: `(1 == 1)` is `true`, OR short-circuits to `true` &rarr; `true && true` | `true` |
| 4 | `((12 / 4 == 3) && (5 % 2 == 1)) \|\| ((3 * 3 > 8) && !(6 == 7))` | Left block: `(3 == 3) && (1 == 1)` &rarr; `true && true = true`. Short-circuits OR expression | `true` |
| 5 | `!(5 > 10) && ((7 - 2 < 6) \|\| ((4 * 3 == 12) && (10 / 2 >= 5)))` | Left: `!(false)` is `true`. Right block: `(5 < 6)` is `true`, OR short-circuits to `true` &rarr; `true && true` | `true` |
