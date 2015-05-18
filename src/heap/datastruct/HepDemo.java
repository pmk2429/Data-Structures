package heap.datastruct;

import java.util.Arrays;

public class HepDemo {
	public static void main(String[] args) {
		Heap<Integer> tmp = new Heap<Integer>();
		Integer[] b = { 8, 3, 9, 2, 6, 1, 12, 99, 5, 4 };
		// Integer[] result = (Integer[]) tmp.heapSort(b);
		tmp.heapSort(b);
		System.out.println(Arrays.toString(b));
	}
}
