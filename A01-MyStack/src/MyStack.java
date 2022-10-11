import java.util.ArrayList;
import java.util.Iterator;

public class MyStack<E> implements Iterable<E>{
	private ArrayList<E> stack;
	
	// Constructor
	public MyStack() {
		stack = new ArrayList<E>();
	}
	
	// Methods
	public void push(E e) {
		stack.add(e);
	}
	
	public E pop() {
		if (isEmpty()) {
			System.out.println("Error;The stack is empty");
			return null;
		}
		else {
			E item = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			return item;			
		}
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
		// return stack.size() == 0;
	}
	
	// Inner class for Iterator
	private class StackIterator implements Iterator<E> {
		int count;
		
		protected StackIterator() {
		count = 0;
		}
		
		@Override
		public boolean hasNext() {
			return count < stack.size();
		}
		
		@Override
		public E next() {
			return stack.get(count++);
		}
	}
		
	// Alternative class for StackIterator
	@SuppressWarnings("hiding")
	class MyStackIterator<E> implements Iterator<E> {
		private int index;
		
		public MyStackIterator() {
			index = stack.size() - 1;
		}
		
		public boolean hasNext() {
			return index >= 0;
		}
		
		public E next() {
			@SuppressWarnings("unchecked")
			E e = (E) stack.get(index--);
			return e;
		}
	}
	
	// java.util.Iterable implementation
	public Iterator<E> iterator() {
		return new StackIterator();
		// return new MyStackIterator<>();
	}
}
