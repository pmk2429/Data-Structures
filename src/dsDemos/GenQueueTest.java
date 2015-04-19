package dsDemos;

import java.util.*;

class GenQueue<E> {
	private LinkedList<E> list = new LinkedList<E>();

	public void enqueue(E item) {
		list.addLast(item);
	}

	public E dequeue() {
		return list.poll();
	}

	public boolean hasItems() {
		return !list.isEmpty();
	}

	public int size() {
		return list.size();
	}

	public void addItems(GenQueue<? extends E> q) {
		while (q.hasItems())
			list.addLast(q.dequeue());
	}
}

public class GenQueueTest {
	public static void main(String[] args) {
		GenQueue<Employee> empList;
		empList = new GenQueue<Employee>();
		GenQueue<HourlyEmployee> hList;
		hList = new GenQueue<HourlyEmployee>();
		hList.enqueue(new HourlyEmployee("Ted", "Drake"));
		hList.enqueue(new HourlyEmployee("John", "Becker"));
		hList.enqueue(new HourlyEmployee("Frannie", "Mae"));
		empList.addItems(hList);
		System.out.println("The employees' names are:");
		while (empList.hasItems()) {
			Employee emp = empList.dequeue();
			System.out.println(emp.firstName + " " + emp.lastName);
		}
	}
}

class Employee {
	public String lastName;
	public String firstName;

	public Employee() {
	}

	public Employee(String first, String last) {
		this.lastName = last;
		this.firstName = first;
	}

	public String toString() {
		return firstName + " " + lastName;
	}
}

class HourlyEmployee extends Employee {
	public double hourlyRate;

	public HourlyEmployee(String last, String first) {
		super(last, first);
	}
}
