package dsDemos;

import java.util.*;

public class StackDemo {
	private String[] stackArray;
	private int stackSize;

	// Set stack as empty
	private int topOfStack = -1;

	StackDemo(int size) {
		stackSize = size;
		stackArray = new String[size];

		// Assign -1 to every value in array so that
		// we can control what gets printed on screen.

		Arrays.fill(stackArray, "-1");
	}

	/**
	 * push() is used to insert item or rather push item to Stack. For pushing
	 * item on stack, we need to check whether Stack is empty or whether Stack
	 * is full or whether the TOS can insert any element or not.
	 * 
	 * @param input
	 */
	public void push(String input) {
		if (topOfStack + 1 < stackSize) {
			topOfStack++;
			stackArray[topOfStack] = input;
		} else {
			System.out.println("Sorry the Stack is full!");
			displayStack();
			System.out
					.println("PUSH " + input + " was added to top of Stack\n");
		}
	}

	/**
	 * pop() always returns the element at the TOS. It will check is Stack is
	 * empty or not. It not, then it will pop the top element of the stack.
	 */
	public String pop() {
		if (topOfStack >= 0) {
			displayStack();
			System.out.println("POP: " + stackArray[topOfStack]
					+ " was Removed from Stack");

			// So after we perform this step, the item from memory will not be
			// deleted, but
			// it becomes unavailable from the Stack.

			stackArray[topOfStack] = "-1"; // Assign -1 so it won't appear on
											// Stack.
			return stackArray[topOfStack--];
		} else {
			displayStack();
			System.out.println("Sorry But the Stack is Empty");

			return "-1";

		}
	}

	public String peek() {

		displayStack();

		System.out.println("PEEK " + stackArray[topOfStack]
				+ " Is at the Top of the Stack\n");

		return stackArray[topOfStack];

	}

	public void pushMany(String multipleValues) {

		String[] tempString = multipleValues.split(" ");

		for (int i = 0; i < tempString.length; i++) {

			push(tempString[i]);

		}

	}

	public void popAll() {

		for (int i = topOfStack; i >= 0; i--) {

			pop();

		}

	}

	public void popDisplayAll() {

		String theReverse = "";

		for (int i = topOfStack; i >= 0; i--) {

			theReverse += stackArray[i];

		}

		System.out.println("The Reverse: " + theReverse);

		popAll();

	}

	public void displayStack() {

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < stackSize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < stackSize; n++) {

			if (stackArray[n].equals("-1"))
				System.out.print("|     ");

			else
				System.out.print(String.format("| %2s " + " ", stackArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

	}

	public static void main(String[] args) {

		StackDemo theStack = new StackDemo(10);

		theStack.push("10");
		theStack.push("17");
		theStack.push("13");

		// Look at the top value on the stack

		theStack.peek();

		// Remove values from the stack (LIFO)

		theStack.pop();
		theStack.pop();
		theStack.pop();

		theStack.push("24");
		theStack.push("29");
		// Add many to the stack

		// theStack.pushMany("R E D R U M");

		// Remove all from the stack

		// theStack.popAll();

		// Remove all from the stack and print them

		// theStack.popDisplayAll();

		theStack.displayStack();

	}

}
