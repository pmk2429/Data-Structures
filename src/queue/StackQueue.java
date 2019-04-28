package queue;

import java.util.Stack;

public class StackQueue {

  private Stack<Integer> stack1;
  private Stack<Integer> stack2;
  public int size;

  public StackQueue() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
    size = 0;
  }

  public void push(int x) {
    stack1.push(x);
    size++;
  }

  public int pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    int value = stack2.pop();
    size--;
    return value;
  }

  public int peek() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    int value = stack2.peek();
    return value;
  }

  public boolean empty() {
    return size == 0;
  }
}
