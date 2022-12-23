public class Triangle extends Shape {

	private int x1, x2, x3;
	private int y1, y2, y3;
	
	// Constructor
	public Triangle(String name, int[] coords, int dx) {
		super(name);

		x1 = coords[dx];
		x2 = coords[dx + 2];
		x3 = coords[dx + 4];
		y1 = coords[dx + 1];
		y2 = coords[dx + 3];
		y3 = coords[dx + 5];

		setMinBoundsX(getMin(x1, x2, x3));
		setMinBoundsY(getMin(y1, y2, y3));
		setMaxBoundsX(getMax(x1, x2, x3));
		setMaxBoundsY(getMax(y1, y2, y3));
	}

	private int getMin(int a, int b, int c) {
		if (a < b) {
			if (a < c) {
				return a;
			}
			else {
				return c;
			}
		}
		else {
			if (b < c) {
				return b;
			}
			else {
				return c;
			}
		}
	}

	private int getMax(int a, int b, int c) {
		if (a > b) {
			if (a > c) {
				return a;
			}
			else {
				return c;
			}
		}
		else {
			if (b > c) {
				return b;
			}
			else {
				return c;
			}
		}
	}
}
