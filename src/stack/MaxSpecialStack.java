package stack;

import java.util.Stack;

/**
 * Below are the different functions designed to push and pop elements from the stack.
 * Push(x) : Inserts x at the top of stack.
 * ---------------------------------------------
 * If stack is empty, insert x into the stack and make maxEle equal to x.
 * If stack is not empty, compare x with maxEle. Two cases arise:
 * If x is less than or equal to maxEle, simply insert x.
 * If x is greater than maxEle, insert (2*x – maxEle) into the stack and make maxEle equal to x.
 * For example, let previous maxEle was 3. Now we want to insert 4. We update maxEle as 4 and insert 2*4 – 3 = 5 into the stack.
 * <p>
 * Pop() : Removes an element from top of stack.
 * ---------------------------------------------
 * Remove element from top. Let the removed element be y. Two cases arise:
 * If y is less than or equal to maxEle, the maximum element in the stack is still maxEle.
 * If y is greater than maxEle, the maximum element now becomes (2*maxEle – y), so update (maxEle = 2*maxEle – y).
 * This is where we retrieve previous maximum from current maximum and its value in stack.
 * For example, let the element to be removed be 5 and maxEle be 4. We remove 5 and update maxEle as 2*4 – 5 = 3.
 */
public class MaxSpecialStack {
  Stack<Integer> s = new Stack<Integer>();
  int maxEle;

  // Prints maximum element of MyStack
  void getMax() {
    if (s.empty())
      System.out.print("Stack is empty\n");

      // variable maxEle stores the maximum element
      // in the stack.
    else
      System.out.print("Maximum Element in" +
          "the stack is: " + maxEle + "\n");

  }

  // Prints top element of MyStack
  void peek() {
    if (s.empty()) {

      System.out.print("Stack is empty ");
      return;
    }

    int t = s.peek(); // Top element.

    System.out.print("Top Most Element is: ");

    // If t < maxEle means maxEle stores
    // value of t.
    if (t > maxEle)
      System.out.print(maxEle);
    else
      System.out.print(t);
  }

  // Remove the top element from MyStack
  void pop() {
    if (s.empty()) {
      System.out.print("Stack is empty\n");
      return;
    }

    System.out.print("Top Most Element Removed: ");
    int t = s.peek();
    s.pop();

    // Maximum will change as the maximum element
    // of the stack is being removed.
    if (t > maxEle) {
      System.out.print(maxEle + "\n");
      maxEle = 2 * maxEle - t;
    } else
      System.out.print(t + "\n");
  }

  // Removes top element from MyStack
  void push(int x) {
    // Insert new number into the stack
    if (s.empty()) {
      maxEle = x;
      s.push(x);
      System.out.print("Number Inserted: " + x + "\n");
      return;
    }

    // If new number is less than maxEle
    if (x > maxEle) {
      s.push(2 * x - maxEle);
      maxEle = x;
    } else
      s.push(x);

    System.out.print("Number Inserted: " + x + "\n");
  }
}
