package heap.main;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class Heap<T extends Comparable<T>> implements IHeap<T> {

  // represents total child each node can have
  private final int d = 2;
  private static final int CAPACITY = 10;

  private int size; // Number of elements in heap
  private T[] heap; // The heap array

  public Heap() {
    size = 0;
    heap = (T[]) new Comparable[CAPACITY];
  }

  public Heap(T[] array) {
    size = array.length;
    heap = (T[]) new Comparable[array.length + 1];

    System.arraycopy(array, 0, heap, 1, array.length);// we do not use 0
    // index

    buildHeap();
  }

  private void buildHeap() {
    for (int k = size / 2; k > 0; k--) {
      percolatingDown(k);
    }
  }

  public int leftIndex(int parentIndex) {
    return parentIndex * 2;
  }

  public int rightIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }

  public int parentIndex(int childIndex) {
    return childIndex / 2;
  }

  @Override
  public T leftChild(int index) {
    return null;
  }

  @Override
  public T rightChild(int index) {
    return null;
  }

  @Override
  public T[] resize() {
    return null;
  }

  public String toString() {
    String out = "";
    for (int k = 1; k <= size; k++)
      out += heap[k] + " ";
    return out;
  }

  private void percolateUp(int k, T x) {
    for (; k > 1 && x.compareTo(heap[k / 2]) < 0; k = k / 2) {
      heap[k] = heap[k / 2];
    }

    heap[k] = x;
  }

  @Override
  public void insert(T x) {
    ensureExtraCapacity();

    // Insert a new item to the end of the array
    int index = ++size;
    percolateUp(index, x);
  }

  private void percolatingDown(int k) {
    T tmp = heap[k];
    int child;

    for (; 2 * k <= size; k = child) {
      child = 2 * k;
      if (child != size && heap[child].compareTo(heap[child + 1]) > 0) {
        child++;
      }
      if (tmp.compareTo(heap[child]) > 0) {
        heap[k] = heap[child];
      } else {
        break;
      }
    }
    heap[k] = tmp;
  }

  @Override
  public T remove(int index) throws RuntimeException {
    if (isEmpty())
      throw new NoSuchElementException("Underflow Exception");
    T keyItem = heap[index];
    heap[index] = heap[size - 1];
    size--;
    percolatingDown(index);
    return keyItem;
  }

  @Override
  public T poll() throws RuntimeException {
    if (size == 0)
      throw new RuntimeException();
    T min = heap[1];
    heap[1] = heap[size--];
    percolatingDown(1);
    return min;
  }

  @Override
  public T findMin() {
    if (isEmpty())
      throw new NoSuchElementException("Underflow Exception");
    return heap[0];
  }

  @Override
  public T findMax() {
    if (isEmpty()) {
      throw new NoSuchElementException("Empty Heap");
    }
    return heap[size - 1];
  }

  @Override
  public T peek() {
    if (this.isEmpty()) {
      throw new IllegalStateException();
    }
    return heap[0];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean hasLeftChild(int index) {
    return leftIndex(index) <= size;
  }

  @Override
  public boolean hasRightChild(int index) {
    return rightIndex(index) <= size;
  }

  @Override
  public T parent(int index) {
    return heap[parentIndex(index)];
  }

  @Override
  public T kthChild(int index, int k) {
    return null;
  }

  @Override
  public boolean hasParent(int i) {
    return false;
  }

  @Override
  public int leftChildIndex(int parentIndex) {
    return 0;
  }

  @Override
  public int rightChildIndex(int parentIndex) {
    return 0;
  }

  /**
   * Makes sure the Heap have enough room to add elements
   */
  private void ensureExtraCapacity() {
    if (size == CAPACITY) {
      T[] old = heap;
      heap = (T[]) new Comparable[heap.length * 2];
      System.arraycopy(old, 1, heap, 1, size);
    }
  }

  public Object[] heapSort(T[] array) {
    size = array.length;
    heap = (T[]) new Comparable[size + 1];
    System.arraycopy(array, 0, heap, 1, size);
    buildHeap();

    for (int i = size; i > 0; i--) {
      T tmp = heap[i]; // move top item to the end of the heap array
      heap[i] = heap[1];
      heap[1] = tmp;
      size--;
      percolatingDown(1);
    }
    for (int k = 0; k < heap.length - 1; k++)
      array[k] = heap[heap.length - 1 - k];

    return array;
  }

}
