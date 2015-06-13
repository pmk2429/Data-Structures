package heap.main.ds;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class Heap<T extends Comparable<T>> implements IHeap<T> {

	private static final int CAPACITY = 5;

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

	/*private void percolatingUp(int k) {

	}*/

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

	private void increaseSize() {
		T[] old = heap;
		heap = (T[]) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	protected int leftIndex(int i) {
		return i * 2;
	}

	protected int rightIndex(int i) {
		return i * 2 + 1;
	}

	protected int parentIndex(int i) {
		return i / 2;
	}

	public String toString() {
		String out = "";
		for (int k = 1; k <= size; k++)
			out += heap[k] + " ";
		return out;
	}

	// ///////////////////////////////////////////////////////
	// /////// All the default methods of Heap ///////////////
	// ///////////////////////////////////////////////////////

	@Override
	public void insert(T x) {
		if (size == heap.length - 1) {
			increaseSize();
		}

		// Insert a new item to the end of the array
		int pos = ++size;

		// Percolate up
		for (; pos > 1 && x.compareTo(heap[pos / 2]) < 0; pos = pos / 2)
			heap[pos] = heap[pos / 2];

		heap[pos] = x;

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
	public T deleteMin() throws RuntimeException {
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
	public T peek() {

		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		return heap[1];
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

}
