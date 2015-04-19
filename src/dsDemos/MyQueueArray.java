package dsDemos;

import java.util.Arrays;

public class MyQueueArray {
	private int queueSize;
	private int[] queueArray;
	private int head, tail, numOfItems = 0;

	public MyQueueArray(int size) {
		queueSize = size;
		queueArray = new int[size];

		Arrays.fill(queueArray, -1);
	}

	public void insert(int item) {
		if (numOfItems + 1 <= queueSize) {
			if (tail == queueSize) {
				tail = 0;
			}
			queueArray[tail] = item;
			tail++;
			numOfItems++;
		} else {
			System.out.println("Queue is Full");
		}
	}

	public void remove() {
		if (numOfItems > 0) {
			queueArray[head] = -1;
			head++;
			numOfItems--;
		} else {
			System.out.println("Queue is empty!!!");
		}
	}

	public void peekFirst() {
		System.out.println("First Element of Queue: " + queueArray[head]);
	}

	public void peekLast() {
		System.out.println("Last element of Queue: " + queueArray[tail - 1]);
	}

	public void displayQueue() {
		for (int i = 0; i < queueSize; i++) {
			if (queueArray[i] == -1) {
				System.out.print(" _");
			} else {
				System.out.print(" " + queueArray[i]);
			}

		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyQueueArray queueObj = new MyQueueArray(5);
		queueObj.insert(5);
		queueObj.insert(8);
		queueObj.insert(25);
		queueObj.insert(16);
		queueObj.insert(40);

		queueObj.displayQueue();

		System.out.println("After removing itemms from Queue");
		queueObj.remove();
		queueObj.displayQueue();

		queueObj.peekFirst();
		queueObj.peekLast();
	}

}
