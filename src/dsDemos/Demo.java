package dsDemos;

public class Demo {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add(new Integer(5));
		list.add(new Integer(10));
		list.add(new Integer(2));
		list.add(new Integer(4));
		list.add(new Integer(1));
		list.add(new Integer(8));
		System.out.println("Size of my list: " + list.getSize());
		Integer a = (Integer) list.remove(1);
		System.out.println("Number " + a
				+ " was removed from MyList successfully");
		System.out.println("Size after removal:" + list.getSize());
		boolean check = list.contains(2);
		System.out.println("List contains number 2: " + check);
		boolean check2 = list.contains(15);
		System.out.println("List contains number 15: " + check2);
		int b = (Integer) list.get(2);
		System.out.println("Element at position 2 in list: " + b);
		for (int i = 0; i < list.getSize(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("\n\nCongrats...Custom LIST composed successfully!!!");
	}
}
