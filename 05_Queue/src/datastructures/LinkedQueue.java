/*
 * LinkedQueue.java
 * By Antonio F. Huertas
 * Class that represents a queue implemented using links.
 */

package datastructures;

public class LinkedQueue<E> implements Queue<E> {

	// Fields for the front and rear nodes of this queue
	private Node<E> front, rear;

	// Field for the number of elements in this queue.
	private int count;
		
	// Adds the given element at the rear end of this queue.
	@Override
	public void enqueue(E element) {
		Node<E> node = new Node<>(element, null);
		if (front == null)
			front = rear = node;
		else
			rear = rear.next = node;
		count++;
	}

	// Removes and returns the element from the front end of this queue.
	@Override
	public E dequeue() {
		if (isEmpty())
			throw new ElementNotFoundException();
		E element = front.data;
		front = front.next;
		if (front == null)
			rear = null;
		count--;
		return element;
	}

	// Returns the element at the front end of this queue.
	@Override
	public E peek() {
		if (isEmpty())
			throw new ElementNotFoundException();
		return front.data;
	}

	// Removes all elements from this queue.
	@Override
	public void clear() {
		front = rear = null;
		count = 0;
	}

	// Returns true if this queue contains no elements.
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	// Returns the number of elements in this queue.
	@Override
	public int size() {
		return count;
	}
	
	// Returns the string representation of this queue.
	@Override
	public String toString() {
		String str = "[";

		if (! isEmpty()) {
			str += front.data;
			for (Node<E> current = front.next; current != null; current = current.next)
				str += ", " + current.data;
		}
		return str + "]";
	}
		
}