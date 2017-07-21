import java.util.ArrayList;
import java.util.Comparator;

public abstract class Utilities {

	IdList idList;
	ArrayList<String> tmpList = new ArrayList<>();

	protected static Comparator<String> ALPHABETICAL_ORDER = (str1, str2) -> {
		int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
		return (res == 0) ? res : str1.compareTo(str2);
	};
}
