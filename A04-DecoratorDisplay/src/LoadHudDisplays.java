import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface{
	String filename;
	BufferedReader reader;
		
	public LoadHudDisplays(String filename) {
		this.filename = filename;
	}
	
	@Override
	public ArrayList<String> load() {
		ArrayList<String> list = new ArrayList<>();
		String word;
		try {
			reader = new BufferedReader(new FileReader(filename));
			// Read file by line to put it on the list
			while ((word = reader.readLine()) != null) {
				list.add(word);
			}
		} catch (FileNotFoundException e) {
			// Print Error message
			System.out.println(e);
		} catch (IOException e) {
			// Print Error message
			System.out.println(e);
		}
		return list;
	}
}
