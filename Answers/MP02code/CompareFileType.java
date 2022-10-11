public class CompareFileType implements Comparable {
    public int compareTo(Object o1, Object o2) {
        String s1 = ((FileInfo) o1).getType();
        String s2 = ((FileInfo) o2).getType();
        return s1.compareTo(s2);
    }
}
