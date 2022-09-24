
public class Sorter {
	Comparable compare;
	
	// Constructor
	public Sorter(Comparable comparable) {
		compare = comparable;
	}
	
	//Methods
	public void setComparable(Comparable comparable) {
		compare = comparable;
	}
	
	public void bubbleSort(FileInfo[] file_list) {
		FileInfo temp;
		for (int i = 0; i < file_list.length - 1; i++) {
			for (int j = i + 1; j  < file_list.length; j++) {
				// Swap if the order is not correct
				if (compare.compareTo(file_list[i], file_list[j]) == 1) {
					temp = file_list[i];
					file_list[i] = file_list[j];
					file_list[j] = temp;
				}
			}
		}
	}
	
	/*
    void bubbleSortInts(Integer[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) { // swap
                    Integer temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    void bubbleSortDates(Date[] data3) {
        for (int i = 0; i < data3.length - 1; i++) {
            for (int j = 0; j < data3.length - i - 1; j++) {
                if (data3[j].compareTo(data3[j + 1]) > 0) { // swap
                    Date temp = data3[j];
                    data3[j] = data3[j + 1];
                    data3[j + 1] = temp;
                }
            }
        }
    }
    
    void bubbleSortStrings(String[] data2) {
        for (int i = 0; i < data2.length - 1; i++) {
            for (int j = 0; j < data2.length - i - 1; j++) {
                if (data2[j].compareTo(data2[j + 1]) > 0) { // swap
                    String temp = data2[j];
                    data2[j] = data2[j + 1];
                    data2[j + 1] = temp;
                }
            }
        }
    }
    */
}
