package linkedlist;

import linkedlist.LinkedListMain.Node;

public class RemoveDuplicates {
	public static void main(String[] args) {
		LinkedListMain lList = new LinkedListMain();

		// add elements to LinkedList
		lList.add(new Integer(1));
		lList.add(new Integer(4));
		lList.add(new Integer(2));
		lList.add(new Integer(4));

		Node node = new RemoveDuplicates().removeDuplicates(lList.head);
		
	}

	public Node removeDuplicates(Node head) {
		Node returnNode = null;
		Node previous = head.next;
		if (previous.getData() == null) {
			System.out.println("NULL");
		}
		Node current = previous.next;
		while (current != null) {
			Node runner = head.next;
			while (runner != current) {
				if (runner.getData() == current.getData()) {
					Node temp = current.next;
					previous.next = temp;
					current = temp;
					returnNode = temp;
					break;
				}
				runner = runner.next;
				return returnNode;
			}
			if (runner == current) {
				previous = current;
				current = current.next;
			}
		}
		return returnNode;

	}
}
