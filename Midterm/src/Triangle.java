public class Triangle extends Shape {
	int x1, x2, x3;
	int y1, y2, y3;
	
	// Constructor
	public Triangle(int min, int max) {
		setMinBoundsX(min);
		setMinBoundsY(min);
		setMaxBoundsX(max);
		setMaxBoundsY(max);
		x1 = MyRandom.randInt(min, max);
		x2 = MyRandom.randInt(min, max);
		x3 = MyRandom.randInt(min, max);
		y1 = MyRandom.randInt(min, max);
		y2 = MyRandom.randInt(min, max);
		y3 = MyRandom.randInt(min, max);
	}
	
	@Override
	public void calcBounds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getShapeName() {
		return "Triangle";
	}
}
