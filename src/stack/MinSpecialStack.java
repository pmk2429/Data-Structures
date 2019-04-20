package stack;

import java.util.Stack;

/**
 * Push(x) : Inserts x at the top of stack.
 * ---------------------------------------------
 * If stack is empty, insert x into the stack and make minEle equal to x.
 * If stack is not empty, compare x with minEle. Two cases arise:
 * - If x is greater than or equal to minEle, simply insert x.
 * - If x is less than minEle, insert (2*x – minEle) into the stack and make minEle equal to x.
 * For example, let previous minEle was 3. Now we want to insert 2. We update minEle as 2 and insert 2*2 – 3 = 1 into the stack.
 * <p>
 * Pop() : Removes an element from top of stack.
 * ---------------------------------------------
 * Remove element from top. Let the removed element be y. Two cases arise:
 * - If y is greater than or equal to minEle, the minimum element in the stack is still minEle.
 * - If y is less than minEle, the minimum element now becomes (2*minEle – y), so update (minEle = 2*minEle – y).
 * This is where we retrieve previous minimum from current minimum and its value in stack.
 * For example, let the element to be removed be 1 and minEle be 2. We remove 1 and update minEle as 2*2 – 1 = 3.
 */
public class MinSpecialStack {
  Stack<Integer> s;
  Integer minEle;

  MinSpecialStack() {
    s = new Stack<Integer>();
  }

  // Prints minimum element of MyStack
  void getMin() {
    // Get the minimum number in the entire stack
    if (s.isEmpty())
      System.out.println("Stack is empty");

      // variable minEle stores the minimum element
      // in the stack.
    else
      System.out.println("Minimum Element in the " +
          " stack is: " + minEle);
  }

  // prints top element of MyStack
  void peek() {
    if (s.isEmpty()) {
      System.out.println("Stack is empty ");
      return;
    }

    Integer t = s.peek(); // Top element.

    System.out.print("Top Most Element is: ");

    // If t < minEle means minEle stores
    // value of t.
    if (t < minEle)
      System.out.println(minEle);
    else
      System.out.println(t);
  }

  // Removes the top element from MyStack
  void pop() {
    if (s.isEmpty()) {
      System.out.println("Stack is empty");
      return;
    }

    System.out.print("Top Most Element Removed: ");
    Integer t = s.pop();

    // Minimum will change as the minimum element
    // of the stack is being removed.
    if (t < minEle) {
      System.out.println(minEle);
      minEle = 2 * minEle - t;
    } else
      System.out.println(t);
  }

  // Insert new number into MyStack
  void push(Integer x) {
    if (s.isEmpty()) {
      minEle = x;
      s.push(x);
      System.out.println("Number Inserted: " + x);
      return;
    }

    // If new number is less than original minEle
    if (x < minEle) {
      s.push(2 * x - minEle);
      minEle = x;
    } else
      s.push(x);

    System.out.println("Number Inserted: " + x);
  }
}
