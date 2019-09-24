package datastructures;

public class ArrayStack<E> implements Stack<E> {

	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	private static int GROWTH_FACTOR = 2;
	
	private E[] data;
	private int top = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initCapacity){
		if (initCapacity < 1)
			throw new InvalidCapacityException();    
		data = (E[]) new Object[initCapacity];
	}
	
	public ArrayStack() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	@Override
	public void push(E elem) {
		ensureCapacity();
		data[++top] = elem;
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (size() == data.length ) /* if (top + 1 == data.length) */  {
			E[] temp = (E[]) new Object[size() * GROWTH_FACTOR ]; // [data.length * GROWTH_FACTOR ]; or [(top+1) * GROWTH_FACTOR ];
			for (int curr = top; curr >= 0; curr--) //(int curr = 0; curr <= top; curr ++)
				temp[curr] = data[curr];
				data = temp;
		}
	}

	@Override
	public E pop() {
		if (isEmpty())
			throw new ElementNotFoundException();
		E elem = data[top];
		data[top--] = null;
		return elem;
	}

	@Override
	public E peek() {
		if (isEmpty())
			throw new ElementNotFoundException();
		return data[top];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top + 1; // 
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0; // top == -1
	}

	@Override
	public String toString() {
		String str = "[";
		
		if(! isEmpty()){
			str += data[top];
			
			for (int curr = top -1; curr >= 0; curr--)
				str += ", " + data[curr];
		}
		return str + "]";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
		top = -1;
		
	}
	
}
