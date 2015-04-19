package objectOrdering;

enum Tutorials {
	x, y, z;
}

public class CompareToDemo {
	public static void main(String args[]) {

		Tutorials t1, t2, t3;

		t1 = Tutorials.y;
		t2 = Tutorials.x;
		t3 = Tutorials.z;

		if (t1.compareTo(t2) > 0) {
			System.out.println("Case 1: " + t2 + " completed before " + t1);
		}

		if (t1.compareTo(t2) < 0) {
			System.out.println("Case 2: " + t1 + " completed before " + t2);
		}

		if (t1.compareTo(t3) == 0) {
			System.out.println("Case 3: " + t1 + " completed with " + t3);
		}
	}
}
