package queue.priorityqueue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Double ended priority queue
 * A double ended priority queue supports operations of both max heap (a max priority queue) and
 * getMin heap (a getMin priority queue). The following operations are expected from double ended priority queue.
 * <p>
 * getMax() : Returns maximum element.
 * getMin() : Returns minimum element.
 * deleteMax() : Deletes maximum element.
 * deleteMin() : Deletes minimum element.
 * size() : Returns count of elements.
 * isEmpty() : Returns true if the queue is empty.
 * <p>
 * We can try different data structure like Linked List. In case of linked list, if we maintain elements in
 * sorted order, then time complexity of all operations become O(1) except the operation insert() which takes O(n) time.
 * <p>
 * We can try two heaps (getMin heap and max heap). We maintain a pointer of every max heap element in getMin heap.
 * To get minimum element, we simply return root. To get maximum element, we return root of max heap.
 * To insert an element, we insert in getMin heap and max heap both. The main idea is to maintain one to one
 * correspondence, so that deleteMin() and deleteMax() can be done in O(Log n) time.
 * <p>
 * getMax() : O(1)
 * getMin() : O(1)
 * deleteMax() : O(Log n)
 * deleteMin() : O(Log n)
 * size() : O(1)
 * isEmpty() : O(1)
 * <p>
 * Another solution is to use self balancing binary search tree. A self balancing BST is implemented as set in C++ and TreeSet in Java.
 * ---------
 * getMax() : O(1)
 * getMin() : O(1)
 * deleteMax() : O(Log n)
 * deleteMin() : O(Log n)
 * size() : O(1)
 * isEmpty() : O(1)
 */
public class DoubleEndedPriorityQueue {
    Set<Integer> qImpl;

    private DoubleEndedPriorityQueue() {
        qImpl = new HashSet<>();
    }

    // Returns size of the queue. Works in O(1) time
    int size() {
        return qImpl.size();
    }

    // Returns true if queue is empty. Works
    // in O(1) time
    private boolean isEmpty() {
        return (qImpl.size() == 0);
    }

    // Inserts an element. Works in O(Log n) time
    private void insert(int x) {
        qImpl.add(x);
    }

    // Returns minimum element. Works in O(1) time
    private int getMin() {
        return Collections.min(qImpl, null);
    }

    // Returns maximum element. Works in O(1) time
    private int getMax() {
        return Collections.max(qImpl, null);
    }

    // Deletes minimum element. Works in O(Log n)
    // time
    private void deleteMin() {
        if (qImpl.size() == 0) {
            return;
        }
        qImpl.remove(Collections.min(qImpl, null));
    }

    // Deletes maximum element. Works in O(Log n)
    // time
    private void deleteMax() {
        if (qImpl.size() == 0) {
            return;
        }
        qImpl.remove(Collections.max(qImpl, null));
    }

    public static void main(String[] args) {
        DoubleEndedPriorityQueue d = new DoubleEndedPriorityQueue();
        d.insert(10);
        d.insert(50);
        d.insert(40);
        d.insert(20);
        System.out.println(d.getMin());
        System.out.println(d.getMax());
        d.deleteMax();
        System.out.println(d.getMax());
        d.deleteMin();
        System.out.println(d.getMin());
    }
}
