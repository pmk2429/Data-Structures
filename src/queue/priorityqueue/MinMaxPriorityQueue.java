package queue.priorityqueue;

import java.util.*;

public class MinMaxPriorityQueue {

    private final Queue<Integer> q;
    private final Deque<Integer> dq;

    public MinMaxPriorityQueue() {
        q = new LinkedList<>();
        dq = new ArrayDeque<>();
    }

    void enqueue(int data) {
        while (!dq.isEmpty() && dq.getLast() > data) {
            dq.removeLast();
        }
        dq.addLast(data);
        q.add(data);
    }

    void deque() {
        if (Objects.equals(dq.getFirst(), q.peek())) {
            dq.removeFirst();
        }
        q.remove();
    }

    int getMin() throws Exception {
        if (q.isEmpty())
            throw new Exception("Queue is Empty");
        else
            return dq.getFirst();
    }

    int getMax() throws Exception {
        if (q.isEmpty()) {
            throw new Exception(("Queue is Empty"));
        }
        else {
            return dq.getLast();
        }
    }

    public static void main(String[] args) throws Exception {
        MinMaxPriorityQueue arr = new MinMaxPriorityQueue();
        arr.enqueue(1);
        arr.enqueue(2);
        arr.enqueue(3);
        arr.enqueue(6);
        arr.enqueue(4);
        arr.enqueue(9);
        arr.enqueue(5);
        System.out.println(arr.getMin());
        System.out.println(arr.getMax());
        arr.deque();
        System.out.println(arr.getMin());
        System.out.println(arr.getMax());
    }
}
