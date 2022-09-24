
public class CompareFileType implements Comparable {
	
	// Constructor
	public CompareFileType() {
		super();
	}
	
	@Override
	public int compareTo(Object o1, Object o2) {
		FileInfo f1 = (FileInfo) o1;
		FileInfo f2 = (FileInfo) o2;
		
		if (f1.getType().compareTo(f2.getType()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
