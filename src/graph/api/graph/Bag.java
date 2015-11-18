package graph.api.graph;

/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a singly-linked list.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Bag < tobe.txt
 *  size of bag = 14
 *  is
 *  -
 *  -
 *  -
 *  that
 *  -
 *  -
 *  be
 *  -
 *  to
 *  not
 *  or
 *  be
 *  to
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

import iomain.standardio.StdIn;
import iomain.standardio.StdOut;

/**
 * The <tt>Bag</tt> class represents a bag (or multiset) of generic items. It
 * supports insertion and iterating over the items in arbitrary order.
 * <p>
 * This implementation uses a singly-linked list with a static nested class
 * Node. The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations take
 * constant time. Iteration takes time proportional to the number of items.
 * <p>
 *
 */
public class Bag<Item> implements Iterable<Item> {
	private int N; // number of elements in bag
	private Node<Item> first; // beginning of bag

	/**
	 * Initializes an empty bag.
	 */
	public Bag() {
		first = null;
		N = 0;
	}

	/**
	 * Unit tests the <tt>Bag</tt> data type.
	 */
	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			bag.add(item);
		}

		StdOut.println("size of bag = " + bag.size());
		for (String s : bag) {
			StdOut.println(s);
		}
	}

	/**
	 * Is this bag empty?
	 * 
	 * @return true if this bag is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in this bag.
	 * 
	 * @return the number of items in this bag
	 */
	public int size() {
		return N;
	}

	/**
	 * Adds the item to this bag.
	 * 
	 * @param item
	 *            the item to add to this bag
	 */
	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	/**
	 * Returns an iterator that iterates over the items in the bag in arbitrary
	 * order.
	 * 
	 * @return an iterator that iterates over the items in the bag in arbitrary
	 *         order
	 */
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
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

}
