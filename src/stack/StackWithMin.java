package stack;

import iomain.io.In;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
    private final Stack<Integer> minStack;

    public StackWithMin() {
        minStack = new Stack<>();
    }

    public void push(int value) {
        if (value <= min()) {
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin minStack = new StackWithMin();
        minStack.push(5);
        minStack.push(6);
        minStack.push(1);
        minStack.push(4);
        System.out.println(minStack.min());

    }

}
