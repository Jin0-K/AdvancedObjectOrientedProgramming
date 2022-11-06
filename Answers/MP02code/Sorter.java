
public class Sorter {
    private Comparable comparable = null;

    public Sorter(Comparable comparable) {
        this.comparable = comparable;
    }

    public void bubbleSort(Object[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (comparable != null && comparable.compareTo(data[j], data[j + 1]) > 0) { // swap
                    Object temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void setComparable(Comparable comp) {
        comparable = comp;
    }
}
