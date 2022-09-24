
public class CompareFileName implements Comparable {

	// Constructor
	public CompareFileName() {
		super();
	}
	
	@Override
	public int compareTo(Object o1, Object o2) {
		FileInfo f1 = (FileInfo) o1;
		FileInfo f2 = (FileInfo) o2;
		
		if (f1.getName().compareTo(f2.getName()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
