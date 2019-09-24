/*
 * PostfixConverter.java
 * Angel G. Rosario Cintron : 841-12-7893
 * 29 - abril - 2014
 * This program converts an Infix expression to a Postfix expression
 */
package datastructures;

import java.util.Scanner;

public class PostfixConverter {
	
	public PostfixConverter() {}
	
	//Converts an infix expression into a postfix Expression
	public String convert(String expression){
		//initialize postfix expression to empty string
		String postFixExp = "";
		ArrayStack<String> stackOperators = new ArrayStack<>();
		Scanner tokens = new Scanner(expression);
		while(tokens.hasNext()) {
			String token = tokens.next();
			
			if(!isOperator(token) && !token.equals("(") && !token.equals(")")){
				postFixExp += token + " "; //appends operand
			}else if(token.equals("(")){
				stackOperators.push(token); //push to stack left parenthesis
			}else if(token.equals(")")){
				while(!stackOperators.peek().equals("(")){
					postFixExp += stackOperators.pop() + " "; //appends operators until it finds left parenthesis
				}
				stackOperators.pop();  // pops left parenthesis
			}else if(isOperator(token)){
				while(!stackOperators.isEmpty() && !stackOperators.peek().equals("(") && 
						precedence(token) <= precedence(stackOperators.peek())){
					postFixExp += stackOperators.pop() + " "; //appends operators to postFix Expression
				}
				stackOperators.push(token); //push the operators
			}
		}
		while(!stackOperators.isEmpty())
			postFixExp += stackOperators.pop() + " "; //appends the operators
		tokens.close(); // Closes the Scanner
		return postFixExp; //returns postFix expression
	}
	
	//Determines if its an operator
	private boolean isOperator(String token) {
		return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
	}
	
	//Order of precedence
	private int precedence(String operator){
		switch(operator){
			case "*":
			case "/":
				return 2;
			case "+":
			case "-":
				return 1;
			default:
				return 0;
		}
	}
}