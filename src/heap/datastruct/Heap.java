package heap.datastruct;

/**
 * The below mentioned code represents the MinHeap presentation of Heap Data Structure.
 * Heap<Object extends Comparable<Object>> is the general Heap implementation using the Comparable interface.
 * This class provides the basic feature of Heap implementation.
 */

import java.util.*;

@SuppressWarnings("unchecked")
public class Heap<AnyType extends Comparable<AnyType>> {
	private static final int CAPACITY = 2;

	private int size; // Number of elements in heap
	private AnyType[] heap; // The heap array

	public Heap() {
		size = 0;
		heap = (AnyType[]) new Comparable[CAPACITY];
	}

	/**
	 * Construct the binary heap given an array of items.
	 */
	public Heap(AnyType[] array) {
		size = array.length;
		heap = (AnyType[]) new Comparable[array.length + 1];

		System.arraycopy(array, 0, heap, 1, array.length);// we do not use 0
															// index

		buildHeap();
	}

	/**
	 * runs at O(size)
	 */
	private void buildHeap() {
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
	}

	private void percolatingDown(int k) {
		AnyType tmp = heap[k];
		int child;

		for (; 2 * k <= size; k = child) {
			child = 2 * k;

			if (child != size && heap[child].compareTo(heap[child + 1]) > 0)
				child++;

			if (tmp.compareTo(heap[child]) > 0)
				heap[k] = heap[child];
			else
				break;
		}
		heap[k] = tmp;
	}

	/**
	 * Sorts a given array of items.
	 */
	public Object[] heapSort(AnyType[] array) {
		size = array.length;
		heap = (AnyType[]) new Comparable[size + 1];
		System.arraycopy(array, 0, heap, 1, size);
		buildHeap();

		for (int i = size; i > 0; i--) {
			AnyType tmp = heap[i]; // move top item to the end of the heap array
			heap[i] = heap[1];
			heap[1] = tmp;
			size--;
			percolatingDown(1);
		}
		for (int k = 0; k < heap.length - 1; k++)
			array[k] = heap[heap.length - 1 - k];

		return array;
	}

	/**
	 * Deletes the top item
	 */
	public AnyType deleteMin() throws RuntimeException {
		if (size == 0)
			throw new RuntimeException();
		AnyType min = heap[1];
		heap[1] = heap[size--];
		percolatingDown(1);
		return min;
	}

	/**
	 * Inserts a new item
	 */
	public void insert(AnyType x) {
		if (size == heap.length - 1)
			doubleSize();

		// Insert a new item to the end of the array
		int pos = ++size;

		// Percolate up
		for (; pos > 1 && x.compareTo(heap[pos / 2]) < 0; pos = pos / 2)
			heap[pos] = heap[pos / 2];

		heap[pos] = x;
	}

	private void doubleSize() {
		AnyType[] old = heap;
		heap = (AnyType[]) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	

	public String toString() {
		String out = "";
		for (int k = 1; k <= size; k++)
			out += heap[k] + " ";
		return out;
	}

	public static void main(String[] args) {
		Heap<String> h = new Heap<String>();

		h.insert("p");
		h.insert("a");
		h.insert("v");
		h.insert("i");
		h.insert("t");
		h.insert("r");
		h.insert("a");

		System.out.println(h);
		// h.deleteMin();
		// System.out.println(h);

		System.out.println("---------------------------------");

		Heap<Integer> tmp = new Heap<Integer>();
		Integer[] a = { 4, 7, 7, 7, 5, 0, 2, 3, 5, 1 };
		Integer[] result = (Integer[]) tmp.heapSort(a);
		System.out.println(Arrays.toString(a));

		// 1 2 8 3 4 9 12 99 5 6
		Integer[] b = { 8, 3, 9, 2, 6, 1, 12, 99, 5, 4 };
		tmp.heapSort(b);

		System.out.println("---------------------------------");
		System.out.println(Arrays.toString(b));
	}
}