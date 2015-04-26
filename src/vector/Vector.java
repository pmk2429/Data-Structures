package vector;

import java.util.*;

public class Vector<E> extends AbstractList<E> implements List<E>, Cloneable, java.io.Serializable {

	protected Object[] elementData;

	protected int elementCount;

	protected int capacityIncrement;

	// used for version control in Serializable class.
	private static final long serialVersionUID = -89439L;

	public Vector(int initialCapacity, int capacityIncrement) {
		super();
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		this.elementData = new Object[initialCapacity];
		this.capacityIncrement = capacityIncrement;
	}

	public Vector(int initialCapacity) {
		this(initialCapacity, 0);
	}

	public Vector() {
		this(10);
	}

	public Vector(Collection<? extends E> c) {
		elementData = c.toArray();
		elementCount = elementData.length;
		// c.toArray might (incorrectly) not return Object[] (see 6260652)
		if (elementData.getClass() != Object[].class)
			elementData = Arrays.copyOf(elementData, elementCount, Object[].class);
	}

	public synchronized void copyInto(Object[] anArray) {
		System.arraycopy(elementData, 0, anArray, 0, elementCount);
	}

	public synchronized void trimToSize() {
		modCount++;
		int oldCapacity = elementData.length;
		if (elementCount < oldCapacity) {
			elementData = Arrays.copyOf(elementData, elementCount);
		}
	}

	public synchronized void ensureCapacity(int minCapacity) {
		modCount++;
		ensureCapacityHelper(minCapacity);
	}

	private void ensureCapacityHelper(int minCapacity) {
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			Object[] oldData = elementData;
			int newCapacity = (capacityIncrement > 0) ? (oldCapacity + capacityIncrement) : (oldCapacity * 2);
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	public synchronized void setSize(int newSize) {
		modCount++;
		if (newSize > elementCount) {
			ensureCapacityHelper(newSize);
		} else {
			for (int i = newSize; i < elementCount; i++) {
				elementData[i] = null;
			}
		}
		elementCount = newSize;
	}

	public synchronized int capacity() {
		return elementData.length;
	}

	public synchronized int size() {
		return elementCount;
	}

	public synchronized boolean isEmpty() {
		return elementCount == 0;
	}

	public Enumeration<E> elements() {
		return new Enumeration<E>() {
			int count = 0;

			public boolean hasMoreElements() {
				return count < elementCount;
			}

			public E nextElement() {
				synchronized (Vector.this) {
					if (count < elementCount) {
						return elementData(count++);
					}
				}
				throw new NoSuchElementException("Vector Enumeration");
			}
		};
	}

	public boolean contains(Object o) {
		return indexOf(o, 0) >= 0;
	}

	public int indexOf(Object o) {
		return indexOf(o, 0);
	}

	public synchronized int indexOf(Object o, int index) {
		if (o == null) {
			for (int i = index; i < elementCount; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = index; i < elementCount; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	public synchronized E firstElement() {
		if (elementCount == 0) {
			throw new NoSuchElementException();
		}
		return elementData(0);
	}

	public synchronized E lastElement() {
		if (elementCount == 0) {
			throw new NoSuchElementException();
		}
		return elementData(elementCount - 1);
	}

	public synchronized void setElementAt(E obj, int index) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
		}
		elementData[index] = obj;
	}

	public synchronized void removeElementAt(int index) {
		modCount++;
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
		} else if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int j = elementCount - index - 1;
		if (j > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, j);
		}
		elementCount--;
		elementData[elementCount] = null; /* to let gc do its work */
	}

	public synchronized void insertElementAt(E obj, int index) {
		modCount++;
		if (index > elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " > " + elementCount);
		}
		ensureCapacityHelper(elementCount + 1);
		System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
		elementData[index] = obj;
		elementCount++;
	}

	/**
	 * Adds the specified component to the end of this vector, increasing its
	 * size by one. The capacity of this vector is increased if its size becomes
	 * greater than its capacity.
	 *
	 * 
	 */
	public synchronized void addElement(E obj) {
		modCount++;
		ensureCapacityHelper(elementCount + 1);
		elementData[elementCount++] = obj;
	}

	/**
	 * Removes the first (lowest-indexed) from this vector. If the object is
	 * found in this vector, each component in the vector with an index greater
	 * or equal to the object's index is shifted downward to have an index one
	 * smaller than the value it had previously.
	 *
	 */
	public synchronized boolean removeElement(Object obj) {
		modCount++;
		int i = indexOf(obj);
		if (i >= 0) {
			removeElementAt(i);
			return true;
		}
		return false;
	}

	/**
	 * Removes all components from this vector and sets its size to zero.
	 *
	 */
	public synchronized void removeAllElements() {
		modCount++;
		// Let gc do its work
		for (int i = 0; i < elementCount; i++)
			elementData[i] = null;

		elementCount = 0;
	}

	/**
	 * Returns an array containing all of the elements in this Vector in the
	 * correct order; the runtime type of the returned array is that of the
	 * specified array. If the Vector fits in the specified array, it is
	 * returned therein. Otherwise, a new array is allocated with the runtime
	 * type of the specified array and the size of this Vector.
	 *
	 *
	 */
	@SuppressWarnings("unchecked")
	public synchronized <T> T[] toArray(T[] a) {
		if (a.length < elementCount)
			return (T[]) Arrays.copyOf(elementData, elementCount, a.getClass());

		System.arraycopy(elementData, 0, a, 0, elementCount);

		if (a.length > elementCount)
			a[elementCount] = null;

		return a;
	}

	// Positional Access Operations

	@SuppressWarnings("unchecked")
	E elementData(int index) {
		return (E) elementData[index];
	}

	/**
	 * Returns the element at the specified position in this Vector.
	 *
	 */
	public synchronized E get(int index) {
		if (index >= elementCount)
			throw new ArrayIndexOutOfBoundsException(index);

		return elementData(index);
	}

	/**
	 * Replaces the element at the specified position in this Vector with the
	 * specified element.
	 *
	 */
	public synchronized E set(int index, E element) {
		if (index >= elementCount)
			throw new ArrayIndexOutOfBoundsException(index);

		E oldValue = elementData(index);
		elementData[index] = element;
		return oldValue;
	}

	/**
	 * Appends the specified element to the end of this Vector.
	 *
	 */
	public synchronized boolean add(E e) {
		modCount++;
		ensureCapacityHelper(elementCount + 1);
		elementData[elementCount++] = e;
		return true;
	}

	/**
	 * Removes the first occurrence of the specified element in this Vector If
	 * the Vector does not contain the element, it is unchanged. It removes the
	 * element with the lowest index i such that
	 * {@code (o==null ? get(i)==null : o.equals(get(i)))}
	 *
	 */
	public boolean remove(Object o) {
		return removeElement(o);
	}

	/**
	 * Inserts the specified element at the specified position in this Vector.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 *
	 */
	public void add(int index, E element) {
		insertElementAt(element, index);
	}

	/**
	 * Removes the element at the specified position in this Vector. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * Returns the element that was removed from the Vector.
	 */
	public synchronized E remove(int index) {
		modCount++;
		if (index >= elementCount)
			throw new ArrayIndexOutOfBoundsException(index);
		E oldValue = elementData(index);

		int numMoved = elementCount - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		elementData[--elementCount] = null; // Let gc do its work

		return oldValue;
	}

	// ************************ Bulk Operations

	/**
	 * Returns true if this Vector contains all of the elements in the specified
	 * Collection.
	 *
	 */
	public synchronized boolean containsAll(Collection<?> c) {
		return super.containsAll(c);
	}

	/**
	 * Appends all of the elements in the specified Collection to the end of
	 * this Vector, in the order that they are returned by the specified
	 * Collection's Iterator.
	 *
	 */
	public synchronized boolean addAll(Collection<? extends E> c) {
		modCount++;
		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityHelper(elementCount + numNew);
		System.arraycopy(a, 0, elementData, elementCount, numNew);
		elementCount += numNew;
		return numNew != 0;
	}

	/**
	 * Removes from this Vector all of its elements that are contained in the
	 * specified Collection.
	 *
	 */

	/**
	 * Inserts all of the elements in the specified Collection into this Vector
	 * at the specified position. Shifts the element currently at that position
	 * (if any) and any subsequent elements to the right (increases their
	 * indices). The new elements will appear in the Vector in the order that
	 * they are returned by the specified Collection's iterator.
	 *
	 */
	public synchronized boolean addAll(int index, Collection<? extends E> c) {
		modCount++;
		if (index < 0 || index > elementCount)
			throw new ArrayIndexOutOfBoundsException(index);

		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityHelper(elementCount + numNew);

		int numMoved = elementCount - index;
		if (numMoved > 0)
			System.arraycopy(elementData, index, elementData, index + numNew, numMoved);

		System.arraycopy(a, 0, elementData, index, numNew);
		elementCount += numNew;
		return numNew != 0;
	}

	/**
	 * Compares the specified Object with this Vector for equality. Returns true
	 * if and only if the specified Object is also a List, both Lists have the
	 * same size, and all corresponding pairs of elements in the two Lists are
	 * <em>equal</em>.
	 */
	public synchronized boolean equals(Object o) {
		return super.equals(o);
	}

	/**
	 * Returns the hash code value for this Vector.
	 */
	public synchronized int hashCode() {
		return super.hashCode();
	}

	/**
	 * Returns a string representation of this Vector, containing the String
	 * representation of each element.
	 */
	public synchronized String toString() {
		return super.toString();
	}

	// ***************** Iterator

	public synchronized ListIterator<E> listIterator(int index) {
		if (index < 0 || index > elementCount)
			throw new IndexOutOfBoundsException("Index: " + index);
		return new ListItr(index);
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence).
	 *
	 */
	public synchronized ListIterator<E> listIterator() {
		return new ListItr(0);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 *
	 */
	public synchronized Iterator<E> iterator() {
		return new Itr();
	}

	/**
	 * An optimized version of AbstractList.Itrerator
	 */
	private class Itr implements Iterator<E> {
		int cursor; // index of next element to return
		int lastRet = -1; // index of last element returned; -1 if no such
		int expectedModCount = modCount;

		public boolean hasNext() {
			return cursor != elementCount;
		}

		public E next() {
			synchronized (Vector.this) {
				checkForComodification();
				int i = cursor;
				if (i >= elementCount)
					throw new NoSuchElementException();
				cursor = i + 1;
				return elementData(lastRet = i);
			}
		}

		public void remove() {
			if (lastRet == -1)
				throw new IllegalStateException();
			synchronized (Vector.this) {
				checkForComodification();
				Vector.this.remove(lastRet);
				expectedModCount = modCount;
			}
			cursor = lastRet;
			lastRet = -1;
		}

		final void checkForComodification() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
		}
	}

	/**
	 * An optimized version of AbstractList.ListItr
	 */
	final class ListItr extends Itr implements ListIterator<E> {
		ListItr(int index) {
			super();
			cursor = index;
		}

		public boolean hasPrevious() {
			return cursor != 0;
		}

		public int nextIndex() {
			return cursor;
		}

		public int previousIndex() {
			return cursor - 1;
		}

		public E previous() {
			synchronized (Vector.this) {
				checkForComodification();
				int i = cursor - 1;
				if (i < 0)
					throw new NoSuchElementException();
				cursor = i;
				return elementData(lastRet = i);
			}
		}

		public void set(E e) {
			if (lastRet == -1)
				throw new IllegalStateException();
			synchronized (Vector.this) {
				checkForComodification();
				Vector.this.set(lastRet, e);
			}
		}

		public void add(E e) {
			int i = cursor;
			synchronized (Vector.this) {
				checkForComodification();
				Vector.this.add(i, e);
				expectedModCount = modCount;
			}
			cursor = i + 1;
			lastRet = -1;
		}
	}
}