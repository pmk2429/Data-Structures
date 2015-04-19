package dsDemos;

/**
 *  HashMapDemo class is used to cover all the features that can be performed by
 *  a HashMap.
 */

import java.util.*;

public class HashMapDemo {
	public static void main(String[] args) {

		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(5, "A");
		hmap.put(11, "C");
		hmap.put(4, "Z");
		hmap.put(77, "B");
		hmap.put(9, "P");
		hmap.put(66, "Q");
		hmap.put(0, "R");
		hmap.put(4, "T");
		hmap.put(77, "E");

		int max = Collections.max(hmap.keySet());
		System.out.println("Original size of HashMap: " + hmap.size());
		System.out.println("Max key value in map: " + hmap.get(max));
		// Fot Iteration on HashMap.
		System.out.println("\nThe HashMap:");
		Set setData = hmap.entrySet();
		Iterator iter = setData.iterator();
		while (iter.hasNext()) {
			Map.Entry entryData = (Map.Entry) iter.next();
			System.out.println(entryData.getKey() + " : "
					+ entryData.getValue());
		}

		// For arranging the HashMap by KEYS.
		System.out.println("\nAfter sorting the map by KEYS: ");
		Map<Integer, String> mapData = new TreeMap<Integer, String>(hmap);
		Set setMap = mapData.entrySet();
		Iterator iter2 = setMap.iterator();
		while (iter2.hasNext()) {
			Map.Entry entryData2 = (Map.Entry) iter2.next();
			System.out.println(entryData2.getKey() + " : "
					+ entryData2.getValue());
		}

		// Sorting the HashMap by Values.
		System.out.println("\nAfter sorting the map by Values: ");
		Map<Integer, String> sortedMapbyVal = sortByValues(hmap);
		Set set3 = sortedMapbyVal.entrySet();
		Iterator iterator3 = set3.iterator();
		while (iterator3.hasNext()) {
			Map.Entry map4 = (Map.Entry) iterator3.next();
			System.out.print(map4.getKey() + ": ");
			System.out.println(map4.getValue());
		}

	}

	/**
	 * HOW IT DOES IT?
	 * 
	 * @param hmap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Map<Integer, String> sortByValues(
			HashMap<Integer, String> hmap) {

		// This statement will make a new LinkedList
		List list = new LinkedList(hmap.entrySet());

		Collections.sort(list, new Comparator() {

			public int compare(Object o1, Object o2) {

				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
}
