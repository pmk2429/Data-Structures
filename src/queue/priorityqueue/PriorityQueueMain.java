package queue.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Java Program to show How to use PriorityQueue in Java. This example also
 * demonstrate that PriorityQueue doesn't allow null elements and how
 * PriorityQueue keeps elements i.e. ordering.
 *
 * @author
 */
public class PriorityQueueMain {

	public static void main(String args[]) {

		Queue<Item> items = new PriorityQueue<Item>();
		items.add(new Item("IPone", 900));
		items.add(new Item("IPad", 1200));
		items.add(new Item("Xbox", 300));
		items.add(new Item("Watch", 200));

		System.out.println("Order of items in PriorityQueue");
		System.out.println(items);

		System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
		System.out.println(items);

		System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
		System.out.println(items);

		System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
		System.out.println(items);

		// items.add(null); // null elements not allowed in PriorityQueue -
		// NullPointerException

	}

	private static class Item implements Comparable<Item> {

		private String name;
		private int price;

		public Item(String name, int price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Item other = (Item) obj;
			if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
				return false;
			}
			if (this.price != other.price) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			int hash = 5;
			hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
			hash = 97 * hash + this.price;
			return hash;
		}

		@Override
		public int compareTo(Item i) {
			return (this.price < i.price) ? -1 : (this.price > i.price) ? 1 : 0;

			/*if (this.price == i.price) {
				return this.name.compareTo(i.name);
			}

			return this.price - i.price;*/
		}

		@Override
		public String toString() {
			return String.format("%s: $%d", name, price);
		}

	}
}
