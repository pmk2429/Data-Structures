package dsDemos;

/**
 * TreeMap
 */

import java.util.*;
import java.util.Map.Entry;

public class TreeMapDemo {
	public static void main(String[] args) {
		Dog2 d1 = new Dog2("red", 30);
		Dog2 d2 = new Dog2("black", 20);
		Dog2 d3 = new Dog2("white", 10);
		Dog2 d4 = new Dog2("grey", 55);

		TreeMap<Dog2, Integer> treeMap = new TreeMap<Dog2, Integer>();
		treeMap.put(d1, 10);
		treeMap.put(d2, 15);
		treeMap.put(d3, 5);
		treeMap.put(d4, 20);

		for (Entry<Dog2, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}

class Dog2 implements Comparable<Dog2> {
	String color;
	int size;

	Dog2(String c, int s) {
		color = c;
		size = s;
	}

	public String toString() {
		return color + " dog";
	}

	public int compareTo(Dog2 o) {
		return o.size - this.size;
	}

}
