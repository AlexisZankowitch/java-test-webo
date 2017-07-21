import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class DuplicateSearch extends Utilities{

	private DuplicateSearch(String path) throws IOException {

		idList = new IdList(path);

		ArrayList<String>   duplicateId     = new ArrayList<>();

		//Alphabetical sort
		tmpList = idList.copyList(tmpList);
		tmpList.sort(ALPHABETICAL_ORDER);

		//Duplicate search
		int i, j;
		for (i = 0; i < tmpList.size(); i++) {
			j = i + 1;
			while (j < tmpList.size() && tmpList.get(i).equals(tmpList.get(j))) {
				//duplicate found
				duplicateId.add(tmpList.get(i));
				j++;
			}
		}

		//Result display
		for (int k = 0; k < idList.size(); k++) {
			for (String aDuplicateId : duplicateId) {
				if (aDuplicateId.equals(idList.get(k))) {
					System.out.println("index: " +k + ", value: " + idList.get(k));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length == 0){
			System.out.println("Please enter path to fichier-ID.log");
			return;
		}
		new DuplicateSearch(args[0]);
	}
}
