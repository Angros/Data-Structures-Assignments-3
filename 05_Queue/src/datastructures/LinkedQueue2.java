/**
 * LinkedQueue2.java
 * @author Angel Rosario
 * 841-11-6930
 * May 13, 2014
 * This class implements the Circular Linked List data structure for Queue.
 */
package datastructures;

public class LinkedQueue2<E> implements Queue<E> {
	
	
	private Node<E> rear;
	private int count;
	
	
	@Override
	public void enqueue(E element) {
		if(rear == null){
			rear = new Node<>(element, null);
			rear.next = rear; 
		}else
			rear = rear.next = new Node<>(element, rear.next); 
		count++;	
	}
	
	
	@Override
	public E dequeue() {
		if(isEmpty())
			throw new ElementNotFoundException();
		E element = rear.next.data;
		if(rear.next == rear) 
			rear = null; 
		else
			rear.next = rear.next.next;
		count--;
		return element;
	}
	
	
	@Override
	public E peek() {
		if(isEmpty())
			throw new ElementNotFoundException();
		return rear.next.data;
	}
	
	
	@Override
	public void clear() {
		rear = null;
		count = 0;
	}
	
	
	@Override
	public int size() {
		return count;
	}
	
	
	@Override
	public boolean isEmpty() {
		return rear == null;
	}
	
	
	@Override
	public String toString(){
		String str = "[";
		if(!isEmpty()){
			str += rear.next.data;
			for(Node<E> curr = rear.next.next; curr != rear.next; curr = curr.next)
				str += ", " + curr.data;
		}
		return str + "]";
	}
}
