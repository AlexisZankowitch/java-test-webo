import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class IdList {
	private ArrayList<String> idList;

	public IdList(String path) throws IOException {
		FileInputStream     fStream     = new FileInputStream(path);
		BufferedReader      bReader     = new BufferedReader(new InputStreamReader(fStream));
		String              tmp;

		this.idList = new ArrayList<>();

		while ((tmp = bReader.readLine()) != null) {
			idList.add(tmp);
		}
	}

	public void setValue (int i, String value){
		this.idList.set(i, value);
	}

	public ArrayList<String> getIdList() {
		return idList;
	}

	public ArrayList<String> copyList(ArrayList<String> target){
		target.addAll(idList);
		return target;
	}

	public int size() {
		return idList.size();
	}

	public String get(int k) {
		return idList.get(k);
	}
}
