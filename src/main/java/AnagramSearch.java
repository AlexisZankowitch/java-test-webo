import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.IOException;
import java.util.*;

public class AnagramSearch extends Utilities {

	public AnagramSearch(String path) throws IOException {

		HashMap<String, Integer> myList = new HashMap<>();
		IdList idList = new IdList(path);
		tmpList = idList.copyList(tmpList);

		HashMap<Integer, String> tmpH = new HashMap<>();
		for (int i = 0; i < idList.size(); i++) {
			myList.put(sortString(idList.get(i)), i);
			tmpList.set(i, sortString(tmpList.get(i)));
		}

		tmpList.sort(ALPHABETICAL_ORDER);

		int j;
		System.out.println("without hash");
		j = 0;
		for (int i = 0; i < tmpList.size(); i++) {
			j = i + 1;
			if (j < tmpList.size() && isAnagram(tmpList.get(i), tmpList.get(j))) {
				System.out.println("Anagram  found: " + "index: " + myList + " " + tmpList.get(i) + ", index:" + myList.get(j) + " " + tmpList.get(j));
			}
		}
		System.out.println("aze");
	}

	/**
	 * From https://www.mkyong.com/java/how-to-sort-a-map-in-java/
	 */
	private static Map<Integer, String> sortByValue(Map<Integer, String> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<Integer, String>> list =
			new LinkedList<Map.Entry<Integer, String>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		//    Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			public int compare(Map.Entry<Integer, String> o1,
			                   Map.Entry<Integer, String> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
		for (Map.Entry<Integer, String> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	private String sortString(String str) {
		str = str.toLowerCase();
		char[] c1 = str.toCharArray();
		Arrays.sort(c1);
		return new String(c1);
	}

	private boolean isAnagram(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String sc1 = new String(c1);
		String sc2 = new String(c2);
		return sc1.equals(sc2);
	}

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Please enter path to fichier-ID.log");
			return;
		}
		new AnagramSearch(args[0]);
	}
}
