import java.util.ArrayList;
import java.util.Iterator;

public class MyStack<E> implements Iterable<Object>{
	ArrayList<E> stack = new ArrayList<E>();
	private int size;
	
	// Constructor
	public MyStack() {
		this.size = 0;
	}
	
	// Methods
	public void push(E e) {
		stack.add(e);
		size++;
	}
	
	public E pop() {
		if (isEmpty()) {
			System.out.println("Error;The stack is empty");
			return null;
		}
		else {
			E item = stack.get(size-1);
			stack.remove(size-1);
			size--;
			return item;			
		}
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	// Inner class for Iterator
	private class StackIterator implements Iterator {
		MyStack<E> stack;
		int count;
		
		protected StackIterator(MyStack stack) {
		this.stack = stack;
		count = 0;
		}
		
		@Override
		public boolean hasNext() {
			return count < stack.size;
		}
		
		@Override
		public Object next() {
			return stack.stack.get(count++);
		}
	}
	
	// java.util.Iterable implementation
	public Iterator<Object> iterator() {
		return new StackIterator(this);
	}
}
