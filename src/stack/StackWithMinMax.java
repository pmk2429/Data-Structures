package stack;

import java.util.Stack;

public class StackWithMinMax extends Stack<Integer> {

    private final Stack<Integer> minStack;
    private final Stack<Integer> maxStack;

    public StackWithMinMax() {
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int value) {
        if (value <= min()) { // Note the '=' sign here
            minStack.push(value);
        }

        if (value >= max()) {
            maxStack.push(value);
        }

        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();

        if (value == min()) {
            minStack.pop();
        }

        if (value == max()) {
            maxStack.pop();
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

    public int max() {
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        else {
            return maxStack.peek();
        }
    }
}
