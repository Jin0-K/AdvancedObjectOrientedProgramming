package src;

public class Group extends ShapeDecorator {
    String name;
    Shape newShape;

    public Group(String name, Shape existingShape, Shape newShape) {
        super();
        this.name = name;
        this.newShape = newShape;
    }

    public void calcBounds() {
        existingShape.calcBounds();
        newShape.calcBounds();
        setMinBoundsX(Math.min(existingShape.getMinBoundsX(), newShape.getMinBoundsX()));
        setMinBoundsY(Math.min(existingShape.getMinBoundsY(), newShape.getMinBoundsY()));
        setMaxBoundsX(Math.min(existingShape.getMaxBoundsX(), newShape.getMaxBoundsX()));
        setMaxBoundsY(Math.min(existingShape.getMaxBoundsY(), newShape.getMaxBoundsY()));
    }

    public String toString() {
        return super.toString() + existingShape.toString() + newShape.toString();
    }

    public String getShapeName() { return name; }
}
