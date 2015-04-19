package linkedlist;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * LinkedHashMap extends HashMap and it preserves the insertion order.
 * 
 * @author Pavitra
 * 
 */

public class LinkedHashMapDemo {
	public static void main(String[] args) {

		Dog d1 = new Dog("red");
		Dog d2 = new Dog("black");
		Dog d3 = new Dog("white");
		Dog d4 = new Dog("white");
		Dog d5 = new Dog("yellow");

		LinkedHashMap<Dog, Integer> linkedHashMap = new LinkedHashMap<Dog, Integer>();
		linkedHashMap.put(d1, 10);
		linkedHashMap.put(d2, 15);
		linkedHashMap.put(d3, 5);
		linkedHashMap.put(d4, 20);
		linkedHashMap.put(d5, 24);

		for (Entry<Dog, Integer> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}

class Dog {
	String color;

	Dog(String c) {
		color = c;
	}

	public boolean equals(Object o) {
		return ((Dog) o).color == this.color;
	}

	public int hashCode() {
		return color.length();
	}

	public String toString() {
		return color + " dog";
	}
}