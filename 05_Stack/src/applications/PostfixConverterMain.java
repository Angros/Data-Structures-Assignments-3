/*
 * PostfixConverter.java
 * Angel G. Rosario Cintron : 841-12-7893
 * 29 - abril - 2014
 * Main application for the postfix converter class.
 */
package applications;

import java.util.Scanner;

import datastructures.PostfixConverter;

public class PostfixConverterMain {

		//Starts main application
		public static void main(String[] args) {
			PostfixConverter converter = new PostfixConverter();
			Scanner kb = new Scanner(System.in);

			System.out.println("Enter a valid Infix Expression: ");
			String expression = kb.nextLine();
			String postFix = converter.convert(expression);
			kb.close();

			System.out.println("This is the PostFix Expression");
			System.out.println(postFix);

			System.out.println("End of Application");
			System.exit(0);
		}

	}
	

