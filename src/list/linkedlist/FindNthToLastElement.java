package list.linkedlist;

import java.util.LinkedList;

/**
 * FindElement class implements an algorithm to find nth to last element of a
 * singly linked list. For example in a LinkedList from 1-10, 3rd element from
 * last should return 8.
 * 
 * @author Pavitra
 *
 */

public class FindNthToLastElement {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.add(new Integer(i));
		}

		FindNthToLastElement findObj = new FindNthToLastElement();
		int position = 4;
		int desiredElement = findObj.findNthToLastElement(list, position);
		System.out.println("List: " + list);
		System.out.println("'" + position + "' Element to last in List is: " + desiredElement);
	}

	private int findNthToLastElement(LinkedList<Integer> list, int position) {
		int desiredElement = list.size() - position;
		return list.get(desiredElement);
	}
}
