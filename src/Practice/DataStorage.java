package Practice;

import java.util.*;

public class DataStorage {

	private int maxSize;
	private long[]stackData;
	private int top;
	
	public DataStorage(int s){
		maxSize = s;
		stackData = new long[maxSize];
		top = -1;
	}
	
	public void push(long j){
		stackData[++top] = j;
	}
	
	public long pop(){
		return stackData[top--];
	}
	
	public long peek(){
		return stackData[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == maxSize - 1);
	}
	public static void main(String[] args) {
		DataStorage theStack  = new DataStorage(10);
		Stack s = new Stack();
		s.push(5);
		s.push(10);
		int a = s.search(10);
		System.out.println(a);
		System.out.println("Enter the values to add in Stack: ");
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			int data = input.nextInt();
			theStack.push(data);
		}
	    System.out.println("TOP of stack: " + theStack.peek());
	    System.out.print("stack: [");
	    while (!theStack.isEmpty()) {
	         long value = theStack.pop();
	         System.out.print(value);
	         System.out.print(" ");
	      }
	    System.out.print("]");
	      
	}

}
