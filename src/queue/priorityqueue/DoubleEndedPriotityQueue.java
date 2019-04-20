package queue.priorityqueue;

/**
 * Double ended priority queue
 * A double ended priority queue supports operations of both max heap (a max priority queue) and
 * min heap (a min priority queue). The following operations are expected from double ended priority queue.
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
 * We can try two heaps (min heap and max heap). We maintain a pointer of every max heap element in min heap.
 * To get minimum element, we simply return root. To get maximum element, we return root of max heap.
 * To insert an element, we insert in min heap and max heap both. The main idea is to maintain one to one
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
public class DoubleEndedPriotityQueue {
}
