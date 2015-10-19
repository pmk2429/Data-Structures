package api.undirected;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The <tt>SET</tt> class represents an ordered set of comparable keys. It
 * supports the usual <em>add</em>, <em>contains</em>, and <em>delete</em>
 * methods. It also provides ordered methods for finding the <em>minimum</em>,
 * <em>maximum</em>, <em>floor</em>, and <em>ceiling</em> and set methods for
 * <em>union</em>, <em>intersection</em>, and <em>equality</em>.
 * <p>
 * This implementation uses a balanced binary search tree. It requires that the
 * key type implements the <tt>Comparable</tt> interface and calls the
 * <tt>compareTo()</tt> and method to compare two keys. It does not call either
 * <tt>equals()</tt> or <tt>hashCode()</tt>. The <em>add</em>, <em>contains</em>, <em>delete</em>, <em>minimum</em>, <em>maximum</em>, <em>ceiling</em>, and
 * <em>floor</em> methods take logarithmic time in the worst case. The
 * <em>size</em>, and <em>is-empty</em> operations take constant time.
 * Construction takes constant time.
 * <p>
 */

public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
	private TreeSet<Key> set;

	/**
	 * Initializes an empty set.
	 */
	public SET() {
		set = new TreeSet<Key>();
	}

	/**
	 * Unit tests the <tt>SET</tt> data type.
	 */
	public static void main(String[] args) {
		SET<String> set = new SET<String>();

		// insert some keys
		set.add("www.cs.princeton.edu");
		set.add("www.cs.princeton.edu"); // overwrite old value
		set.add("www.princeton.edu");
		set.add("www.math.princeton.edu");
		set.add("www.yale.edu");
		set.add("www.amazon.com");
		set.add("www.simpsons.com");
		set.add("www.stanford.edu");
		set.add("www.google.com");
		set.add("www.ibm.com");
		set.add("www.apple.com");
		set.add("www.slashdot.com");
		set.add("www.whitehouse.gov");
		set.add("www.espn.com");
		set.add("www.snopes.com");
		set.add("www.movies.com");
		set.add("www.cnn.com");
		set.add("www.iitb.ac.in");

		System.out.println(set.contains("www.cs.princeton.edu"));
		System.out.println(!set.contains("www.harvardsucks.com"));
		System.out.println(set.contains("www.simpsons.com"));
		System.out.println();

		System.out.println("----- ceil: returns the smallest key in the set greater than or equal to key");
		System.out.println("ceil(www.snopesr.com) = " + set.ceil("www.snopesr.com"));
		System.out.println("ceil(www.simpsons.com) = " + set.ceil("www.simpsons.com"));
		System.out.println("ceil(www.simpsonr.com) = " + set.ceil("www.simpsonr.com"));
		System.out.println("ceil(www.simpsont.com) = " + set.ceil("www.simpsont.com"));
		System.out.println();
		System.out.println("----- floor: returns the largest key in the set less than or equal to key");
		System.out.println("floor(www.simpsonr.com) = " + set.floor("www.simpsonr.com"));
		System.out.println("floor(www.simpsons.com) = " + set.floor("www.simpsons.com"));
		System.out.println("floor(www.simpsont.com) = " + set.floor("www.simpsont.com"));
		System.out.println();

		// print out all keys in the set in lexicographic order
		for (String s : set) {
			System.out.println(s);
		}
	}

	/**
	 * Adds the key to the set if it is not already present.
	 *
	 * @param key
	 *            the key to add
	 * @throws NullPointerException
	 *             if <tt>key</tt> is <tt>null</tt>
	 */
	public void add(Key key) {
		if (key == null)
			throw new NullPointerException("called add() with a null key");
		set.add(key);
	}

	/**
	 * Does this symbol table contain the given key?
	 *
	 * @param key
	 *            the key
	 * @return <tt>true</tt> if this symbol table contains <tt>key</tt> and
	 *         <tt>false</tt> otherwise
	 * @throws NullPointerException
	 *             if <tt>key</tt> is <tt>null</tt>
	 */
	public boolean contains(Key key) {
		if (key == null)
			throw new NullPointerException("called contains() with a null key");
		return set.contains(key);
	}

	/**
	 * Removes the key from the set if the key is present.
	 *
	 * @param key
	 *            the key
	 * @throws NullPointerException
	 *             if <tt>key</tt> is <tt>null</tt>
	 */
	public void delete(Key key) {
		if (key == null)
			throw new NullPointerException("called delete() with a null key");
		set.remove(key);
	}

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 *
	 * @return the number of key-value pairs in this symbol table
	 */
	public int size() {
		return set.size();
	}

	/**
	 * Is this symbol table empty?
	 *
	 * @return <tt>true</tt> if this symbol table is empty and <tt>false</tt>
	 *         otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns all of the keys in the symbol table as an iterator. To iterate
	 * over all of the keys in a set named <tt>set</tt>, use the foreach
	 * notation: <tt>for (Key key : set)</tt>.
	 *
	 * @return an iterator to all of the keys in the set
	 */
	public Iterator<Key> iterator() {
		return set.iterator();
	}

	/**
	 * Returns the largest key in the set.
	 *
	 * @return the largest key in the set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	public Key max() {
		if (isEmpty())
			throw new NoSuchElementException("called max() with empty set");
		return set.last();
	}

	/**
	 * Returns the smallest key in the set.
	 *
	 * @return the smallest key in the set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	public Key min() {
		if (isEmpty())
			throw new NoSuchElementException("called min() with empty set");
		return set.first();
	}

	/**
	 * Returns the smallest key in the set greater than or equal to <tt>key</tt>
	 * .
	 *
	 * @return the smallest key in the set greater than or equal to <tt>key</tt>
	 * @param key
	 *            the key
	 * @throws NoSuchElementException
	 *             if the set is empty
	 * @throws NullPointerException
	 *             if <tt>key</tt> is <tt>null</tt>
	 */
	public Key ceil(Key key) {
		if (key == null)
			throw new NullPointerException("called ceil() with a null key");
		SortedSet<Key> tail = set.tailSet(key);
		if (tail.isEmpty())
			throw new NoSuchElementException();
		return tail.first();
	}

	/**
	 * Returns the largest key in the set less than or equal to <tt>key</tt>.
	 *
	 * @return the largest key in the set table less than or equal to
	 *         <tt>key</tt>
	 * @param key
	 *            the key
	 * @throws NoSuchElementException
	 *             if the set is empty
	 * @throws NullPointerException
	 *             if <tt>key</tt> is <tt>null</tt>
	 */
	public Key floor(Key key) {
		if (key == null)
			throw new NullPointerException("called floor() with a null key");
		// headSet() does not include key if present (!)
		if (set.contains(key))
			return key;
		SortedSet<Key> head = set.headSet(key);
		if (head.isEmpty())
			throw new NoSuchElementException();
		return head.last();
	}

	/**
	 * Returns the union of this set and that set.
	 *
	 * @param that
	 *            the other set
	 * @return the union of this set and that set
	 * @throws NullPointerException
	 *             if <tt>that</tt> is <tt>null</tt>
	 */
	public SET<Key> union(SET<Key> that) {
		if (that == null)
			throw new NullPointerException("called union() with a null argument");
		SET<Key> c = new SET<Key>();
		for (Key x : this) {
			c.add(x);
		}
		for (Key x : that) {
			c.add(x);
		}
		return c;
	}

	/**
	 * Returns the intersection of this set and that set.
	 *
	 * @param that
	 *            the other set
	 * @return the intersection of this set and that set
	 * @throws NullPointerException
	 *             if <tt>that</tt> is <tt>null</tt>
	 */
	public SET<Key> intersects(SET<Key> that) {
		if (that == null)
			throw new NullPointerException("called intersects() with a null argument");
		SET<Key> c = new SET<Key>();
		if (this.size() < that.size()) {
			for (Key x : this) {
				if (that.contains(x))
					c.add(x);
			}
		} else {
			for (Key x : that) {
				if (this.contains(x))
					c.add(x);
			}
		}
		return c;
	}

	/**
	 * Does this set equal <tt>y</tt>? Note that this method declares two empty
	 * sets to be equal even if they are parameterized by different generic
	 * types. This is consistent with the behavior of <tt>equals()</tt> within
	 * Java's Collections framework.
	 *
	 * @param y
	 *            the other set
	 * @return <tt>true</tt> if the two sets are equal; <tt>false</tt> otherwise
	 */
	public boolean equals(Object y) {
		if (y == this)
			return true;
		if (y == null)
			return false;
		if (y.getClass() != this.getClass())
			return false;
		SET<Key> that = (SET<Key>) y;
		if (this.size() != that.size())
			return false;
		try {
			for (Key k : this)
				if (!that.contains(k))
					return false;
		} catch (ClassCastException exception) {
			return false;
		}
		return true;
	}

	/**
	 * Returns a string representation of this set.
	 *
	 * @return a string representation of this set, with the keys separated by
	 *         single spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Key key : this)
			s.append(key + " ");
		return s.toString();
	}

}
