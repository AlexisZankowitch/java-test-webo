import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.IOException;
import java.util.*;

public class AnagramSearch extends Utilities {

	public AnagramSearch(String path) throws IOException {

		HashMap<Integer, String> myList = new HashMap<>();
		IdList idList = new IdList(path);
		tmpList = idList.copyList(tmpList);

		HashMap<Integer, String> tmpH = new HashMap<>();
		for (int i = 0; i < idList.size(); i++) {
			myList.put(i, sortString(idList.get(i)));
			tmpList.set(i, sortString(tmpList.get(i)));
		}

		tmpList.sort(ALPHABETICAL_ORDER);

		int j;
		ArrayList<String> anagrams = new ArrayList<>();
		j = 0;
		for (int i = 0; i < tmpList.size(); i++) {
			j = i + 1;
			if (j < tmpList.size() && isAnagram(tmpList.get(i), tmpList.get(j))) {
				anagrams.add(tmpList.get(i));
			}
		}

		for (Integer key: myList.keySet()){
			for (String anagram : anagrams) {
				if (anagram.equals(myList.get(key))) {
					System.out.println("Anagram  found: "
						+ "original: "
						+ idList.get(key)
						+ " index: " + key
						+ " anagram: " + anagram);
				}
			}
		}
		System.out.println("aze");
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
