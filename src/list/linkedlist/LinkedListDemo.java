package list.linkedlist;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedListMain lList = new LinkedListMain();

		// add elements to LinkedList
		lList.add(new Integer(1));
		lList.add(new Integer(2));
		lList.add(new Integer(3));
		lList.add(new Integer(4));
		lList.add(new Integer(5));

		/*
		 * Please note that primitive values can not be added into LinkedList
		 * directly. They must be converted to their corresponding wrapper
		 * class.
		 */

		for (int i = 1; i <= lList.size(); i++) {
			System.out.print(lList.get(i) + " ");
		}
	}
}
