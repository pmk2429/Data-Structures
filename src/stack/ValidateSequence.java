package stack;

import java.util.Stack;

/**
 * Check if the given push and pop sequences of Stack is valid or not
 * Given push[] and pop[] sequences with distinct values. The task is to check if this could have been the result
 * of a sequence of push and pop operations on an initially empty stack. Return “True” if it otherwise returns “False”.
 * <p>
 * Example 1:
 * ---------
 * Input: pushed = { 1, 2, 3, 4, 5 }, popped = { 4, 5, 3, 2, 1 }
 * Output: True
 * Following sequence can be performed:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * Example 2:
 * ---------
 * Input: pushed = { 1, 2, 3, 4, 5 }, popped = { 4, 3, 5, 1, 2 }
 * Output: False
 * 1 can't be popped before 2.
 */
public class ValidateSequence {

    private static boolean isValid(int[] pushed, int[] popped) {
        Stack<Integer> visited = new Stack<>();
        // maintain total elements popped
        int j = 0;
        int length = pushed.length;
        for (int curr : pushed) {
            visited.push(curr);
            while (!visited.isEmpty() && j < length && visited.peek() == popped[j]) {
                visited.pop();
                j++;
            }
        }
        return j == length;
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(isValid(pushed, popped));
    }
}
