public class Rectangle extends Shape {
	int x1, x2;
	int y1, y2;
	
	// Constructor
	public Rectangle(String name, int[] coords, int dx) {
		super(name);

		setMinBoundsX(getMin(x1, x2));
		setMinBoundsY(getMin(y1, y2));
		setMaxBoundsX(getMax(x1, x2);
		setMaxBoundsY(getMax(y1, y2));
		x1 = coords[dx];
		y1 = coords[dx + 1];
		x2 = coords[dx + 2];
		y2 = coords[dx + 3];
	}


	private int getMin(int a, int b) {
		if (a < b) { return a; }
		else { return b; }
	}

	private int getMax(int a, int b) {
		if (a > b) { return a; }
		else { return b; }
	}
}
