package heap.main;

/**
 * Base interface for implementing Min Heap Data Structure
 *
 * @param <T>
 */
interface IHeap<T> {
  void insert(T x);

  T remove(int index) throws RuntimeException;

  /**
   * Deletes the minimum element in the Heap
   *
   * @return
   * @throws RuntimeException
   */
  T poll() throws RuntimeException;

  T findMin();

  T findMax();

  T peek();

  boolean isEmpty();

  boolean hasLeftChild(int index);

  boolean hasRightChild(int index);

  boolean hasParent(int index);

  int leftChildIndex(int parentIndex);

  int rightChildIndex(int parentIndex);

  int parentIndex(int childIndex);

  T leftChild(int index);

  T rightChild(int index);

  T parent(int index);

  /**
   * Returns kth child of i
   *
   * @param index
   * @param k
   * @return
   */
  T kthChild(int index, int k);

  T[] resize();

}
