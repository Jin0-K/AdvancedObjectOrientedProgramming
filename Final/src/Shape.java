public class Shape implements Selectable{
    private String shapeName;
    private int minBoundsX;
    private int minBoundsY;
    private int maxBoundsX;
    private int maxBoundsY;

    // constructor
    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public int getMinBoundsX() { return minBoundsX; }
    public int getMinBoundsY() { return minBoundsY; }
    public int getMaxBoundsX() { return maxBoundsX; }
    public int getMaxBoundsY() { return maxBoundsY; }

    @Override
    public String getName() {
        return shapeName;
    }

    @Override
    public boolean isSelected(int x, int y) {
        if (x < getMinBoundsX()) {
            return false;
        }
        if (x > getMaxBoundsX()) {
            return false;
        }
        if (y < getMinBoundsY()) {
            return false;
        }
        if (y > getMaxBoundsY()) {
            return false;
        }
        return true;
    }

    @Override
    public void print() {
        System.out.print(getName());
        System.out.print(
                "minBoundsX: " + getMinBoundsX() + ", minBoundsY: " + getMinBoundsY() + "\n"
                + "maxBoundsX: " + getMaxBoundsX() + ", maxBoundsY: " + getMaxBoundsY() + "\n");
    }

    public void setMinBoundsX(int minX) {
        minBoundsX = minX;
    }

    public void setMinBoundsY(int minY) {
        minBoundsY = minY;
    }

    public void setMaxBoundsX(int maxX) {
        maxBoundsX = maxX;
    }

    public void setMaxBoundsY(int maxY) {
        maxBoundsY = maxY;
    }

    public String toString() {
        return getName() + ":\n"
                + "minBoundsX: " + getMinBoundsX() + ", minBoundsY: " + getMinBoundsY() + "\n"
                + "maxBoundsX: " + getMaxBoundsX() + ", maxBoundsY: " + getMaxBoundsY() + "\n";
    }

}
