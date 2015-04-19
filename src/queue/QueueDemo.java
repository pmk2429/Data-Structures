package queue;

import java.util.Iterator;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(4);
		queue.enqueue(6);
		queue.enqueue(2);
		queue.enqueue(7);
		System.out.println(queue + " ");
		queue.dequeue();
		System.out.println(queue + " ");
		System.out.println("Top of Queue: " + queue.peek());
		Iterator iter = queue.iterator();
		System.out.println("Elements of Queue using Iterator");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}

	}
}
