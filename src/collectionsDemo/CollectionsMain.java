package collectionsDemo;

import java.util.*;

public class CollectionsMain {
	public static void main(String[] args) {
		List list = Arrays.asList("one Two three Four five six one three Four"
				.split(" "));
		System.out.println(list);
		System.out.println("max: " + Collections.max(list));
		System.out.println("min: " + Collections.min(list));
	}
}
