package hashMap;

import java.util.*;

public class HashMapSortByValue {
	public static void main(String[] args) {
		HashMapSortByValue hObj = new HashMapSortByValue();
		HashMap<Integer, String> hmapObj = new HashMap<Integer, String>();

		hmapObj.put(1, "A");
		hmapObj.put(5, "F");
		hmapObj.put(7, "G");
		hmapObj.put(6, "E");
		hmapObj.put(2, "Y");
		hmapObj.put(8, "B");
		hmapObj.put(3, "O");
		hmapObj.put(4, "C");

		hObj.sortByKey(hmapObj);
		hObj.sortByValue(hmapObj);

	}

	private void sortByKey(HashMap<Integer, String> hmapObj) {
		System.out.println("Sorting Map by KEYS:\n");
		Map<Integer, String> mapSort = new TreeMap<Integer, String>(hmapObj);
		Set mapSet = mapSort.entrySet();
		Iterator iter = mapSet.iterator();
		while (iter.hasNext()) {
			Map.Entry entryMap = (Map.Entry) iter.next();
			System.out.println(entryMap.getKey() + " : " + entryMap.getValue());
		}
	}

	@SuppressWarnings("unchecked")
	private void sortByValue(HashMap<Integer, String> hmapObj) {
		System.out.println("\n------------------------------");
		System.out.println("Sorting HashMap by VALUES");
		List list = new LinkedList(hmapObj.entrySet());

		Collections.sort(list, new Comparator() {

			@Override
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

		Map<Integer, String> mapSort = sortedHashMap;
		Set setMap = mapSort.entrySet();
		Iterator iter = setMap.iterator();
		while (iter.hasNext()) {
			Map.Entry entryMap = (Map.Entry) iter.next();
			System.out.println(entryMap.getKey() + " : " + entryMap.getValue());
		}
	}

}
