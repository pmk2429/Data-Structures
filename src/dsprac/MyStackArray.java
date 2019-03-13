package dsprac;

public class MyStackArray {
  private int size;
  private int[] stackArray;
  private int TOS = -1;

  public MyStackArray(int size) {
    this.size = size;
    stackArray = new int[size];
  }

  // push
  public void push(int value) {
    if (TOS + 1 < size) {
      TOS++;
      stackArray[TOS] = value;
    } else {
      System.out.println("Stack is full!!!");
    }
  }

  public void pop() {
    if (TOS > 0) {
      stackArray[TOS] = 0;
      TOS--;
    } else {
      System.out.println("Stack is empty!!!");
    }
  }

  // peek
  public void peek() {
    System.out.println("Top of Stack: " + stackArray[TOS]);
  }

  // display Stack
  public void displayStack() {
    for (int i = 0; i < size; i++) {
      System.out.println(stackArray[i]);
    }
  }

  public static void main(String[] args) {
    MyStackArray stackObj = new MyStackArray(5);

    stackObj.push(5);
    stackObj.push(15);
    stackObj.push(25);
    stackObj.push(45);
    stackObj.push(65);
    stackObj.displayStack();

    System.out.println("\nAfter popping:");
    stackObj.pop();
    stackObj.pop();
    stackObj.displayStack();

    stackObj.peek();
  }
}
