package datastructures;

public class LinkedQueue2<T> implements Queue<T> {

	private Node<T> rear;
	
	private int count;
	
	@Override
	public void enqueue(T element) {
		Node<T> node = new Node<>(element, null);
		if (rear == null) {
			rear = new Node<>(element, null);
			rear.next = rear; 
		}
		else { 
			rear.next = rear = new Node<>(element, rear.next);
			count++;
		}
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			throw new ElementNotFoundException();
		T element = rear.next.data;
		rear = rear.next;
		if (rear.next == rear)
			rear = null;
		else
			rear.next = rear.next.next; 
		count--;
		return element;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new ElementNotFoundException();
		return rear.next.data;
	}

	@Override
	public void clear() {
		count = 0;
		rear = null;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0; // rear == null 
	}

}

