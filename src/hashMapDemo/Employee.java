package hashMapDemo;

import java.util.HashMap;

public class Employee {

	String name;
	String mobile;

	public Employee(String name, String mobile) {
		this.name = name;
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		System.out.println("calling hascode method of Employee");
		String str = this.name;
		Integer sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum = sum + str.charAt(i);
		}
		return sum;

	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("calling equals method of Employee");
		Employee emp = (Employee) obj;
		if (this.mobile.equalsIgnoreCase(emp.mobile)) {

			System.out.println("returning true");
			return true;
		} else {
			System.out.println("returning false");
			return false;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee emp = new Employee("abc", "hhh");
		Employee emp2 = new Employee("abc", "hhh");
		HashMap<Employee, Employee> h = new HashMap<>();
		// for (int i=0;i<5;i++){
		h.put(emp, emp);
		h.put(emp2, emp2);

		// }

		System.out.println("----------------");
		System.out.println("size of hashmap: " + h.size());

	}

}