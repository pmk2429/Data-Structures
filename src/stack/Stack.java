package stack;

/*************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

import iomain.standardio.StdIn;
import iomain.standardio.StdOut;

/**
 * The <tt>Stack</tt> class represents a last-in-first-out (LIFO) stack of
 * generic items. It supports the usual <em>push</em> and <em>pop</em>
 * operations, along with methods for peeking at the top item, testing if the
 * stack is empty, and iterating through the items in LIFO order.
 * <p>
 * All stack operations except iteration are constant time.
 * <p>
 */
public class Stack<Item> implements Iterable<Item> {
  private int N; // size of the stack
  private Node first; // top of stack

  // helper linked list class
  private class Node {
    private Item item;
    private Node next;
  }

  /**
   * Create an empty stack.
   */
  public Stack() {
    first = null;
    N = 0;
  }

  /**
   * Is the stack empty?
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Return the number of items in the stack.
   */
  public int size() {
    return N;
  }

  /**
   * Add the item to the stack.
   */
  public void push(Item item) {
    Node prev = first;
    first = new Node();
    first.item = item;
    first.next = prev;
    N++;
  }

  /**
   * Delete and return the item most recently added to the stack. Throw an
   * exception if no such item exists because the stack is empty.
   */
  public Item pop() {
    if (isEmpty())
      throw new RuntimeException("Stack underflow");
    Item item = first.item; // save item to return
    first = first.next; // delete first node
    N--;
    return item; // return the saved item
  }

  /**
   * Return the item most recently added to the stack. Throw an exception if
   * no such item exists because the stack is empty.
   */
  public Item peek() {
    if (isEmpty())
      throw new RuntimeException("Stack underflow");
    return first.item;
  }

  /**
   * Return string representation.
   */
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Item item : this)
      s.append(item + " ");
    return s.toString();
  }

  /**
   * Return an iterator to the stack that iterates through the items in LIFO
   * order.
   */
  public Iterator<Item> iterator() {
    return new StackIterator();
  }

  // an iterator, doesn't implement remove() since it'ST optional
  private class StackIterator implements Iterator<Item> {
    private Node current = first;

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
   * A test client.
   */
  public static void main(String[] args) {
    Stack<String> s = new Stack<String>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-"))
        s.push(item);
      else if (!s.isEmpty())
        StdOut.print(s.pop() + " ");
    }
    StdOut.println("(" + s.size() + " left on stack)");
  }
}