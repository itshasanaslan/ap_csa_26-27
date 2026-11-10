# AP Computer Science A — Day 9 Quick Reference Cheat Sheet
### Boolean Logic & De Morgan's Laws

---

## 1. Relational Operators & Primitive Comparisons

Relational operators compare two primitive operand values (such as `int` or `double`) and evaluate strictly to a primitive `boolean` value: `true` or `false`.

| Operator | Meaning | Example Expression | Result (`x = 5`, `y = 10`) |
| :---: | :--- | :---: | :---: |
| `==` | Equal to | `x == y` | `false` |
| `!=` | Not equal to | `x != y` | `true` |
| `<` | Strictly less than | `x < y` | `true` |
| `>` | Strictly greater than | `x > y` | `false` |
| `<=` | Less than or equal to | `x <= 5` | `true` |
| `>=` | Greater than or equal to | `y >= 12` | `false` |

> **Watch Out:** Never confuse `=` (assignment) with `==` (equality comparison). The single equals sign stores a value into a variable, while the double equals sign compares two values. In Java, writing `if (x = 5)` will not compile because an `int` cannot be converted to a `boolean`.

---

## 2. Logical Operators & Compound Expressions

Logical operators combine or invert boolean values to make decisions in code.

* **Logical NOT (`!`):** A unary operator that flips the truth value of its operand. If `A` is `true`, `!A` is `false`.
* **Logical AND (`&&`):** Evaluates to `true` only if **both** operands are `true`. If either operand is `false`, the entire expression is `false`.
* **Logical OR (`||`):** Evaluates to `true` if **at least one** operand is `true`. It evaluates to `false` only when both operands are `false`.

### Master Truth Table

| `A` | `B` | `!A` | `A && B` | `A \|\| B` |
| :---: | :---: | :---: | :---: | :---: |
| `true` | `true` | `false` | `true` | `true` |
| `true` | `false` | `false` | `false` | `true` |
| `false` | `true` | `true` | `false` | `true` |
| `false` | `false` | `true` | `false` | `false` |

---

## 3. Java Operator Precedence Hierarchy

When an expression contains arithmetic, relational, and logical operators without explicit parentheses, Java evaluates them in the following strict order of operations:

1. **Parentheses:** `()` *(Evaluated from innermost to outermost)*
2. **Unary Operators:** `!`, `++`, `--`, unary `-`
3. **Multiplicative Arithmetic:** `*`, `/`, `%`
4. **Additive Arithmetic:** `+`, `-`
5. **Relational Comparisons:** `<`, `>`, `<=`, `>=`
6. **Equality Comparisons:** `==`, `!=`
7. **Logical AND:** `&&`
8. **Logical OR:** `||`
9. **Assignment:** `=`, `+=`, `-=`, `*=`, `/=`, `%=`

### Step-by-Step Tracing Example

```java
int a = 3, b = 4, c = 5;
boolean result = a + b * 2 > c && !(b == 4) || c - a == 2;

// Step 1: Multiplicative arithmetic   -> b * 2 = 8
// Step 2: Additive arithmetic         -> 3 + 8 = 11, 5 - 3 = 2
// Step 3: Inside parentheses          -> (b == 4) is true
// Step 4: Unary NOT                   -> !(true) is false
// Step 5: Relational comparisons      -> 11 > 5 is true, 2 == 2 is true
//                                        Expression is now: true && false || true
// Step 6: Logical AND before OR       -> true && false is false
// Step 7: Logical OR                  -> false || true evaluates to true