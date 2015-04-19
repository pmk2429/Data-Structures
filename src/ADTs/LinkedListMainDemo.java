package ADTs;

import Practice.LinkedListMain;

public class LinkedListMainDemo {
	public static void main(String []args){
		LinkedListMain lmain = new LinkedListMain();
		
		lmain.add("5");
		lmain.add("10");
		lmain.add("15");
		
		System.out.println((lmain.get(0)));
	}
}
