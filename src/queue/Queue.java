package queue;

import standardInputOutput.StdIn;
import standardInputOutput.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The <tt>Queue</tt> class represents a first-in-first-out (FIFO) queue of
 * generic items. It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods for peeking at the first item, testing if the
 * queue is empty, and iterating through the items in FIFO order.
 * <p>
 * This implementation uses a singly-linked list with a static nested class for
 * linked-list nodes. See {@link LinkedQueue} for the version from the textbook
 * that uses a non-static nested class. The <em>enqueue</em>, <em>dequeue</em>,
 * <em>peek</em>, <em>size</em>, and <em>is-empty</em> operations all take
 * constant time in the worst case.
 * <p>
 */
public class Queue<Item> implements Iterable<Item> {
  private int N; // number of elements on queue
  private Node<Item> first; // beginning of queue
  private Node<Item> last; // end of queue

  // helper linked list class
  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  /**
   * Initializes an empty queue.
   */
  public Queue() {
    first = null;
    last = null;
    N = 0;
  }

  /**
   * Is this queue empty?
   *
   * @return true if this queue is empty; false otherwise
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Returns the number of items in this queue.
   *
   * @return the number of items in this queue
   */
  public int size() {
    return N;
  }

  /**
   * Returns the item least recently added to this queue.
   *
   * @return the item least recently added to this queue
   * @throws java.util.NoSuchElementException if this queue is empty
   */
  public Item peek() {
    if (isEmpty())
      throw new NoSuchElementException("Queue underflow");
    return first.item;
  }

  /**
   * Adds the item to this queue.
   *
   * @param item the item to add
   */
  public void enqueue(Item item) {
    Node<Item> prev = last;
    last = new Node<>();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      prev.next = last;
    }
    N++;
  }

  /**
   * Removes and returns the item on this queue that was least recently added.
   *
   * @return the item on this queue that was least recently added
   * @throws java.util.NoSuchElementException if this queue is empty
   */
  public Item dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Queue underflow");
    Item item = first.item;
    first = first.next;
    N--;
    if (isEmpty())
      last = null; // to avoid loitering
    return item;
  }

  /**
   * Returns a string representation of this queue.
   *
   * @return the sequence of items in FIFO order, separated by spaces
   */
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Item item : this)
      s.append(item + " ");
    return s.toString();
  }

  /**
   * Returns an iterator that iterates over the items in this queue in FIFO
   * order.
   *
   * @return an iterator that iterates over the items in this queue in FIFO
   * order
   */
  public Iterator<Item> iterator() {
    return new QueueIterator<Item>(first);
  }

  // an iterator, doesn't implement remove() since it's optional
  private class QueueIterator<Item> implements Iterator<Item> {
    private Node<Item> current;

    public QueueIterator(Node<Item> first) {
      current = first;
    }

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  /**
   * Unit tests the <tt>Queue</tt> data type.
   */
  public static void main(String[] args) {
    Queue<String> q = new Queue<String>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-"))
        q.enqueue(item);
      else if (!q.isEmpty())
        StdOut.print(q.dequeue() + " ");
    }
    StdOut.println("(" + q.size() + " left on queue)");
  }
}
