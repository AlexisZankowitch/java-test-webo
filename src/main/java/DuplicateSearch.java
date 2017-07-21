import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class DuplicateSearch {

	private DuplicateSearch(String path) throws IOException {

		FileInputStream     fStream         = new FileInputStream(path);
		BufferedReader      bReader         = new BufferedReader(new InputStreamReader(fStream));
		ArrayList<String>   list            = new ArrayList<>();
		ArrayList<String>   duplicateId     = new ArrayList<>();
		// will be used to display result with correct indexes
		ArrayList<String>   cList           = new ArrayList<>();

		//List creation
		String tmp;
		while ((tmp = bReader.readLine()) != null) {
			list.add(tmp);
		}
		cList.addAll(list);
		list.sort(ALPHABETICAL_ORDER);

		//Duplicate search
		int i, j;
		for (i = 0; i < list.size(); i++) {
			j = i + 1;
			while (j < list.size() && list.get(i).equals(list.get(j))) {
				//duplicate found
				duplicateId.add(list.get(i));
				j++;
			}
		}

		//Result display
		for (int k = 0; k < cList.size(); k++) {
			for (String aDuplicateId : duplicateId) {
				if (aDuplicateId.equals(cList.get(k))) {
					System.out.println("index: " +k + ", value: " + cList.get(k));
				}
			}
		}
	}

	private static Comparator<String> ALPHABETICAL_ORDER = (str1, str2) -> {
		int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
		return (res == 0) ? res : str1.compareTo(str2);
	};

	public static void main(String[] args) throws IOException {
		if (args.length == 0)
			return;
		new DuplicateSearch(args[0]);
	}
}
