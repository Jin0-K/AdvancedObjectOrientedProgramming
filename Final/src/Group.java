import java.util.ArrayList;

public class Group implements Selectable {
	private String name;
	private ArrayList<Shape> list;
	
	public Group(int num) {
		this.name = "Group: " + num;
	}

	public void add (Shape shape) {
		list.add(shape);
	}

	@Override
	public int getMinBoundsX() {
		int minX = 0;
		for (Shape shape : list) {
			if (minX > shape.getMinBoundsX()) {
				minX = shape.getMinBoundsX();
			}
		}
		return minX;
	}

	@Override
	public int getMinBoundsY() {
		int minY = 0;
		for (Shape shape : list) {
			if (minY > shape.getMinBoundsY()) {
				minY = shape.getMinBoundsY();
			}
		}
		return minY;
	}

	@Override
	public int getMaxBoundsX() {
		int maxX = 0;
		for (Shape shape : list) {
			if (maxX < shape.getMaxBoundsX()) {
				maxX = shape.getMaxBoundsX();
			}
		}
		return maxX;
	}

	@Override
	public int getMaxBoundsY() {
		int maxY = 0;
		for (Shape shape : list) {
			if (maxY < shape.getMaxBoundsY()) {
				maxY = shape.getMaxBoundsY();
			}
		}
		return maxY;
	}

	@Override
	public String getName() {
		return name;
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
		System.out.print(
				getName() + "\n"
				+ "NumOfSelectables: " + list.size()
				+ "minBoundsX: " + getMinBoundsX() + ", minBoundsY: " + getMinBoundsY() + "\n"
				+ "maxBoundsX: " + getMaxBoundsX() + ", maxBoundsY: " + getMaxBoundsY() + "\n");

		for (Shape shape : list) {
			System.out.print(shape.getName() + "\n"
					+ "minBoundsX: " + shape.getMinBoundsX() + ", minBoundsY: " + shape.getMinBoundsY() + "\n"
					+ "maxBoundsX: " + shape.getMaxBoundsX() + ", maxBoundsY: " + shape.getMaxBoundsY() + "\n");
		}
	}
}
