package map.hashMap;

import java.util.HashMap;

/**
 * keySet() only returns a set of key in your hashmap , you should iterate this
 * key set and the get the value from the hashmap using these keys .
 * 
 * In your example , the type of the hashmap 's key is TypeKey , but you
 * specified TypeValue in your generic for-loop , so it cannot be compiled. You
 * should change it to :
 * 
 * for (TypeKey name: example.keySet()){
 * 
 * String key =name.toString(); String value = example.get(name).toString();
 * System.out.println(key + " " + value);
 * 
 * 
 * } If you don't require to print key value and just need the hashmap value ,
 * you can use others' suggestion .
 * 
 * Another question: Is this collection is zero base? I mean if it has 1 key and
 * value will it size be 0 or 1? The collection returned from keySet() is a
 * Set.You cannot get the value from a Set using an index , so it is not an
 * question whether it is zero-based or one-based. If your hashmap has one key ,
 * the keySet() returned will has one entry inside , and its size is 1.
 * 
 * @author Pavitra
 *
 */

public class HashMapDemo {
	public static void main(String[] args) {
		String name = "pavitr komal itm";
		HashMap<Character, Integer> mapDemo = new HashMap<Character, Integer>();

		for (int i = 0; i < name.length(); i++) {
			if (mapDemo.containsKey(name.charAt(i))) {
				mapDemo.put(name.charAt(i), mapDemo.get(name.charAt(i)) + 1);
			} else {
				mapDemo.put(name.charAt(i), 1);
			}
		}

		for (Character charKey : mapDemo.keySet()) {

			char key = charKey;
			Integer value = mapDemo.get(charKey);
			if (value == 2)
				if (key == ' ')
					key = '^';
			System.out.println(key + " " + value);

		}
	}
}
