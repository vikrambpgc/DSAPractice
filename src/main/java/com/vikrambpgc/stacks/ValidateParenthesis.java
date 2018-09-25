package com.vikrambpgc.stacks;
import java.util.*;


public class ValidateParenthesis {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (validateParenthesis() == true) {
			System.out.println("Sucess");
		} else {
			System.out.println("Failure");
		}
	}
	
	public static boolean validateParenthesis() {
		int i, length;
		Stack<Character> stack;
		char[] c;
		char temp;
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter Input String:");
		String s = reader.nextLine();
		
		c = s.toCharArray();
		length = c.length;
		
		if (length == 0) return false;
		stack = new Stack<Character>();
		for (i = 0;i < length; i++) {
			if (c[i] == '{' || c[i] == '[' || c[i] == '(') {
				stack.push(c[i]);
			}
			
			if (c[i] == '}' || c[i] == ']' || c[i] == ')') {
				temp = stack.pop();
				if (c[i] == '}' && temp == '{') continue;
				else if (c[i] == ']' && temp == '[') continue;
				if (c[i] == ')' && temp == '(') continue;
				else return false;
			}					
		}
		if (stack.isEmpty()) return true;
		return false;
	}

}
