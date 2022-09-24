
public class CompareModifiedDate implements Comparable {

	// Constructor
	public CompareModifiedDate() {
		super();
	}
	
	@Override
	public int compareTo(Object o1, Object o2) {
		FileInfo f1 = (FileInfo) o1;
		FileInfo f2 = (FileInfo) o2;
		
		if (f1.getModifiedDate().compareTo(f2.getModifiedDate()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
