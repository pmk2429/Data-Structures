package heap.api;

import java.util.Arrays;

/**
 * BinaryHeap is the min-heap implementation of Heap Data structure.
 * <p>
 * Note : The Binary Heap has the root index starting 0 and not 1.
 *
 * @param <T>
 * @author Pavitra
 */

public class BinaryHeap<T extends Comparable<T>> {
  private static final int DEFAULT_CAPACITY = 10;
  protected T[] array;
  protected int size;

  /**
   * Constructs a new BinaryHeap.
   */
  @SuppressWarnings("unchecked")
  public BinaryHeap() {
    // Java doesn't allow construction of arrays of placeholder data types
    array = (T[]) new Comparable[DEFAULT_CAPACITY];
    size = 0;
  }

  /**
   * Adds a value to the min-heap.
   */
  public void add(T value) {
    // grow array if needed
    if (size >= array.length - 1) {
      array = this.resize();
    }

    // place element into heap at bottom
    size++;
    int index = size;
    array[index] = value;

    bubbleUp();
  }

  /**
   * Returns true if the heap has no elements; false otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns (but does not remove) the minimum element in the heap.
   */
  public T peek() {
    if (this.isEmpty()) {
      throw new IllegalStateException();
    }

    return array[1];
  }

  /**
   * Removes and returns the minimum element in the heap.
   */
  public T remove() {
    // what do want return?
    T result = peek();

    // get rid of the last leaf/decrement
    array[1] = array[size];
    array[size] = null;
    size--;

    bubbleDown();

    return result;
  }

  /**
   * Returns a String representation of BinaryHeap with values stored with
   * heap structure and order properties.
   */
  public String toString() {
    return Arrays.toString(array);
  }

  /**
   * Performs the "bubble down" operation to place the element that is at the
   * root of the heap in its correct place so that the heap maintains the
   * min-heap order property.
   */
  protected void bubbleDown() {
    int index = 1;

    // bubble down
    while (hasLeftChild(index)) {
      // which of my children is smaller?
      int smallerChild = getLeftChildIndex(index);

      // bubble with the smaller child, if I have a smaller child
      if (hasRightChild(index) && array[getLeftChildIndex(index)].compareTo(array[getRightChildIndex(index)]) > 0) {
        smallerChild = getRightChildIndex(index);
      }

      if (array[index].compareTo(array[smallerChild]) > 0) {
        swap(index, smallerChild);
      } else {
        // otherwise, get outta here!
        break;
      }

      // make sure to update loop counter/index of where last el is put
      index = smallerChild;
    }
  }

  /**
   * Performs the "bubble up" operation to place a newly inserted element
   * (i.e. the element that is at the size index) in its correct place so that
   * the heap maintains the min-heap order property.
   */
  protected void bubbleUp() {
    int index = this.size;

    while (hasParent(index) && (getParent(index).compareTo(array[index]) > 0)) {
      // parent/child are out of order; swap them
      swap(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  protected T getLeftChild(int index) {
    return array[getLeftChildIndex(index)];
  }

  protected T getRightChild(int index) {
    return array[getRightChildIndex(index)];
  }

  protected T getParent(int index) {
    return array[getParentIndex(index)];
  }

  /**
   * Checks to see if right child index of current parent is withing the range bounds and greater than size
   *
   * @param parentIndex
   * @return
   */
  protected boolean hasLeftChild(int parentIndex) {
    return getLeftChildIndex(parentIndex) > size;
  }

  /**
   * Checks to see if right child index of current parent is withing the range bounds and less than size
   */
  protected boolean hasRightChild(int parentIndex) {
    return getRightChildIndex(parentIndex) < size;
  }

  /**
   * Checks to see the parent Index of the current child index passed as param and not the child itself. The primary
   * reason is to determine whether the current child Index has parent Index or not.
   *
   * @param childIndex
   * @return
   */
  protected boolean hasParent(int childIndex) {
    return getParentIndex(childIndex) >= 0;
  }

  protected int getLeftChildIndex(int parentIndex) {
    return (parentIndex * 2) + 1;
  }

  protected int getRightChildIndex(int parentIndex) {
    return (parentIndex * 2) + 2;
  }

  protected int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  protected T[] resize() {
    return Arrays.copyOf(array, array.length * 2);
  }

  protected void swap(int index1, int index2) {
    T tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

}