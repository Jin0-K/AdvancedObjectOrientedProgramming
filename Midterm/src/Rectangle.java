public class Rectangle extends Shape {
	int x1, x2;
	int y1, y2;
	
	// Constructor
	public Rectangle(int min, int max) {
		setMinBoundsX(min);
		setMinBoundsY(min);
		setMaxBoundsX(max);
		setMaxBoundsY(max);
		x1 = MyRandom.randInt(min, max);
		y1 = MyRandom.randInt(min, max);
		x2 = x1 + 30;
		y2 = y2 + 20;
	}
	
	@Override
	public void calcBounds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getShapeName() {
		
		return "Rectangle";
	}

}
