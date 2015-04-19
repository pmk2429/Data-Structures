package dsDemos;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList {
	private Object[] myList;
	private int size;
	ArrayList list = new ArrayList();

	public MyArrayList() {
		myList = new Object[10];
		list.contains(5);
	}

	// add method to add elements to List.
	public void add(Object obj) {
		if (myList.length - size <= 5) {
			increaseListSize();
		}
		myList[size++] = obj;
	}

	// get method to get specific element from the List.
	public Object get(int index) {
		if (index < size) {
			return myList[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	// remove method to remove the element at specific index
	public Object remove(int index) {
		if (index < size) {
			Object obj = myList[index];
			myList[index] = null;
			int temp = index;
			while (temp < size) {
				myList[temp] = myList[temp + 1];
				myList[temp + 1] = null;
				temp++;
			}
			size--;
			return obj;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	// size() to get the current size of List.
	public int getSize() {
		return size;
	}

	// contains() to check whether the List contains specific element or not.
	public boolean contains(Object obj) {
		return indexOf(obj) >= 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (myList[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(myList[i]))
					return i;
		}
		return -1;
	}

	// increaseListSize() method is used to increase the size
	// of the existing ArrayList.
	private void increaseListSize() {
		myList = Arrays.copyOf(myList, myList.length * 2);
	}

}
