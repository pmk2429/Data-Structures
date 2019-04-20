package heap.impl;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * BinaryHeap allows to implement Heap DS in Java.
 * This class covers  basic implementations of Heaps such as
 **/
public class MinBinaryHeapInt {
  /**
   * The number of children each node has
   **/
  private static final int d = 2;
  private int size;
  private int[] heap;

  /**
   * Constructor
   **/
  public MinBinaryHeapInt(int capacity) {
    size = 0;
    heap = new int[capacity + 1];
    Arrays.fill(heap, -1);
  }

  /**
   * Function to check if heap is empty
   **/
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Check if heap is full
   **/
  public boolean isFull() {
    return size == heap.length;
  }

  /**
   * Clear heap
   */
  public void makeEmpty() {
    size = 0;
  }

  /**
   * Returns index of k-th child of <code>i</code> element in Heap
   **/
  private int kthChildIndex(int i, int k) {
    return d * i + k;
  }

  /**
   * Function Heapify up when new elements are inserted into Heap
   **/
  private void heapifyUp() {
    // start with the last element in the Heap because that's where we added the new element.
    int index = size - 1; // current element index
    int currElem = heap[index];

    while (index > 0 && currElem < heap[getParentIndex(index)]) {
      heap[index] = heap[getParentIndex(index)];
      index = getParentIndex(index);
    }
    heap[index] = currElem;


    // alternative way for percolatingUp heapifyingUp
    /*
    while (hasParent(index) && heap[index] < parent(index)) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
    */
  }

  /**
   * Function to insert element
   */
  public void insert(int node) {
    if (isFull()) {
      throw new IllegalArgumentException("Cannot add node to empty Heap");
    }
    heap[size++] = node;
    heapifyUp();
  }

  /**
   * Function to find least element
   **/
  public int findMin() {
    if (isEmpty())
      throw new NoSuchElementException("Underflow Exception");
    return heap[0];
  }

  /**
   * Function to delete min element
   **/
  public int deleteMin() {
    int keyItem = heap[0];
    delete(0);
    return keyItem;
  }

  private void heapifyDown(int index) {
    int childIndex;
    int tmp = heap[index];
    while (kthChildIndex(index, 1) < size) {
      childIndex = minChildIndex(index);
      if (heap[childIndex] < tmp) {
        heap[index] = heap[childIndex];
      } else {
        break;
      }
      index = childIndex;
    }
    heap[index] = tmp;
  }

  /**
   * Little expensive because on every deletion, we do the heapifyDown for the entire Heap no matter the position
   * of the element in the Heap.
   */
  private void percolateDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);
      if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
        smallerChildIndex = getRightChildIndex(index);
      }

      if (heap[index] < heap[smallerChildIndex]) {
        break;
      } else {
        swap(index, smallerChildIndex);
      }
      index = smallerChildIndex;
    }
  }

  /**
   * Function to delete element at an index
   **/
  public int delete(int index) {
    if (isEmpty()) {
      throw new NoSuchElementException("Underflow Exception");
    }
    int keyItem = heap[index];
    heap[index] = heap[size - 1];
    size--;
    heapifyDown(index);
    return keyItem;
  }

  /**
   * Returns the index of the element from the Heap
   *
   * @param element
   * @return
   */
  public int findIndex(int element) {
    return 0;
  }

  /**
   * Function to delete element at an index
   **/
  public int deleteElement(int element) {
    if (isEmpty()) {
      throw new NoSuchElementException("Underflow Exception");
    }
    int keyIndex = findIndex(element);
    return delete(keyIndex);
  }

  /**
   * Returns the smallest child index of the current index.
   **/
  public int minChildIndexPosition(int index) {
    int bestChildIndex = kthChildIndex(index, 1);
    int k = 2;
    int posIndex = kthChildIndex(index, k);
    while ((k <= d) && (posIndex < size)) {
      if (heap[posIndex] < heap[bestChildIndex]) {
        bestChildIndex = posIndex;
      }
      posIndex = kthChildIndex(index, k++);
    }
    return bestChildIndex;
  }

  public int minChildIndex(int index) {
    int leftChild = kthChildIndex(index, 1);
    int rightChild = kthChildIndex(index, 2);

    return heap[leftChild] < heap[rightChild] ? leftChild : rightChild;
  }

  /**
   * Function to return the maximum child index of the current index
   *
   * @param index
   * @return
   */
  public int maxChildIndex(int index) {
    int leftChild = kthChildIndex(index, 1);
    int rightChild = kthChildIndex(index, 2);

    return heap[rightChild] > heap[leftChild] ? rightChild : leftChild;
  }

  /**
   * Function to print heap
   **/
  public void printHeap() {
    System.out.print("\nHeap = ");
    for (int i = 0; i < size; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
  }

  protected int getLeftChildIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }

  protected int getRightChildIndex(int parentIndex) {
    return parentIndex * 2 + 2;
  }

  protected int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  protected boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) > size;
  }

  protected boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  protected boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  protected int leftChild(int index) {
    return heap[getLeftChildIndex(index)];
  }

  protected int rightChild(int index) {
    return heap[getRightChildIndex(index)];
  }

  protected int parent(int index) {
    return heap[getParentIndex(index)];
  }

  private void swap(int i, int j) {
    int temp = i;
    i = j;
    j = temp;
  }

  public boolean isLeaf(int index) {
    if ((index > size / 2) && index < size) {
      return true;
    }

    return false;
  }

  public boolean isValidMinHeap(int[] heapArr) {
    return false;
  }

  public boolean isValidMaxHeap(int[] heapArr) {
    return false;
  }

  /**
   * Checks whether the current heap satisfies the minHeap property or not
   *
   * @return
   */
  public boolean isMinHeap() {
    boolean isMinHeap = true;

    int n = heap.length - 1;

    for (int i = (n / 2 - 1); i >= 0; i--) {
      if (heap[i] > heap[getLeftChildIndex(i)]) {
        isMinHeap = false;
      }

      if (getRightChildIndex(i) < n) {
        if (heap[i] > heap[getRightChildIndex(i)]) {
          isMinHeap = false;
        }
      }
    }
    return isMinHeap;
  }

  /**
   * Checks whether the current heap satisfies the maxHeap property or not
   *
   * @return
   */
  public boolean isMaxHeap() {
    boolean isMaxHeap = true;
    int n = heap.length - 1;

    for (int i = (n / 2 - 1); i >= 0; i--) {
      if (heap[i] > heap[getLeftChildIndex(i)]) {
        isMaxHeap = false;
      }

      if (getRightChildIndex(i) < n) {
        if (heap[i] < heap[getRightChildIndex(i)]) {
          isMaxHeap = false;
        }
      }
    }

    return isMaxHeap;
  }

  public int kthSmallestElement() {
    return -1;
  }

  public int kthLargestElement() {
    return -2;
  }
}