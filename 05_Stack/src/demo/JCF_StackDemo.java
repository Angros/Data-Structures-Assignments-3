/*
 * JCF_StackDemo.java
 * This source file contains a class that demonstrates the Stack class
 * from the Java Collections Framework.
 * NOTE: The JCF stack implementation is problematic because it extends
 *       the Vector class, so it allows access to any element by index
 *       instead of limiting access only to the top element.
 */

package demo;

import java.util.EmptyStackException;
import java.util.Stack;

public class JCF_StackDemo {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Stack<String> stk = new Stack<>();
		
		System.out.println("After creating a new stack...");
		print(stk);
		System.out.println();
		
		stk.push("cat");
		stk.push("dog");
		stk.push("tree");
		stk.push("house");
		stk.push("boat");
		stk.push("woman");
		stk.push("man");
		
		System.out.println("After adding some elements...");
		print(stk);
		System.out.println();
		
		System.out.println("The top element is " + stk.peek());
		System.out.println();
				
		System.out.println("Removing: " + stk.pop());
		System.out.println("Removing: " + stk.pop());
		
		System.out.println("After removing the top two elements...");
		print(stk);
		System.out.println();
		
		System.out.println("The top element is " + stk.peek());
		System.out.println();
		
		stk.clear();
		System.out.println("After clearing the stack...");
		print(stk);
		System.out.println();
		
		System.out.println("Trying to get the top element...");
		try {
			System.out.println("The top element is " + stk.peek());
		}
		catch (EmptyStackException e) {
			System.out.println("Error: stack is empty");
		}
	}
	
	// Prints the data, size and empty status of this stack.
	public static <E> void print(Stack<E> stk) {
		System.out.println("This is the stack: " + stk);
		System.out.println("Its size is " + stk.size());
		System.out.println("Is it empty? " + stk.isEmpty());
	}

}