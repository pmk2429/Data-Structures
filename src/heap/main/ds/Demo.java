package heap.main.ds;

import java.util.Arrays;

public class Demo {
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

		Heap<Integer> tmp = new Heap<Integer>();
		Integer[] a = { 4, 7, 7, 7, 5, 0, 2, 3, 5, 1 };
		Integer[] result = (Integer[]) tmp.heapSort(a);
		System.out.println(Arrays.toString(a));

	}
}
