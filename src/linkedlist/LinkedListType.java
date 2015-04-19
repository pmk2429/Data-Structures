package linkedlist;

public class LinkedListType {

	// reference to Node head
	private Node head;
	private int listCount;

	// default constructor.
	public LinkedListType() {
		head = new Node(null);
		listCount = 0;
	}

	// add(Object) method for adding data to LinkedList.
	public void add(Object data) {
		Node temp = new Node(data);
		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		listCount++;
	}

	// to insert data after specified node in LinkedList.
	public void add(Object data, int index) {
		Node temp = new Node(data);
		Node current = head;

		for (int i = 0; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}

	// to get an element at specific index in LinkedList.
	public Object get(int index) {
		if (index <= 0) {
			return null;
		}
		Node current = head.getNext();
		for (int i = 0; i < index; i++) {
			if (current.getNext() == null) {
				return null;
			}
			current = current.getNext();
		}
		return current.getData();
	}

	// remove a specific element from LinkedList
	public boolean remove(int index) {
		if (index < 1 || index > size()) {
			return false;
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			if (current.getNext() == null) {
				return false;
			}
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--;
		// finally return true if element is successfully removed.
		return true;
	}

	// size of LinkedList.
	public int size() {
		return listCount;
	}

	// Node class which defines the primitive data entity in LinkedList.
	public class Node {
		// define the Node.
		Node next;
		Object data;

		public Node(Object data) {
			this.next = null;
			this.data = data;
		}

		public Node(Node next, Object data) {
			this.next = next;
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

	}
}
