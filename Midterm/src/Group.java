import java.util.ArrayList;

public class Group extends Shape {
	String name;
	ArrayList<Shape> list;
	
	public Group(String name, Group group, Shape shape) {
		this.name = name;
		list.add(group);
		list.add(shape);
	}

	public Group(String name, Shape s1, Shape s2) {
		this.name = name;
		list.add(s1);
		list.add(s2);
	}

	@Override
	public void calcBounds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getShapeName() {
		// TODO Auto-generated method stub
		return null;
	}
}
