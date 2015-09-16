package hashMap;

import java.util.*;

public class HMDemo {
	public static void main(String[] args) {
		// create hash map
		Map<Integer, String> mapData = new HashMap<Integer, String>();
		ArrayList<String> newmap = new ArrayList<String>();

		// populate hash map
		newmap.add("pavitra");
		newmap.add("mukund");
		newmap.add("kansara");
		newmap.add("mantra");
		newmap.add("mukund");
		newmap.add("kansara");
		newmap.add("tyson");
		newmap.add("rashmi");
		newmap.add("kansara");

		int count = 1;
		for (int i = 0; i < newmap.size(); i++) {
			if (mapData.containsValue(newmap.get(i))) {
				mapData.put(count + 1, newmap.get(i));
			} else {
				mapData.put(count + 1, newmap.get(i));
			}
		}

		Set set = mapData.entrySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry sortData = (Map.Entry) iter.next();
			System.out.println(sortData.getKey() + " : " + sortData.getValue());
		}

		System.out.println(mapData.containsValue("kansara"));
	}
}
