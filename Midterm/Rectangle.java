package src;

public class Rectangle extends Shape {
    private String name;
    private int x1, y1, x2, y2;

    public Rectangle(String name, int min, int max) {
        this.name = name;
        x1 = MyRandom.randInt(min, max);
        y1 = MyRandom.randInt(min, max);
        x2 = x1 + 30;
        y2 = y1 + 20;
    }

    public void calcBounds() {
        setMinBoundsX(x1);
        setMinBoundsY(y1);
        setMaxBoundsX(x2);
        setMaxBoundsY(y2);
    }

    public String getShapeName() {
        return name;
    }
}
