package com.vikrambpgc.strings;
public class IsNumberPalindrome {
	
	public static void main(String[] args) {
		System.out.println(new IsNumberPalindrome().isPalindromeGivenNumber(12345));
	}
	
	public boolean isPalindromeGivenNumber(int a) {
	    if (a < 0) return false;
	    
	    int x = 0, y = a;
	    System.out.println(x +"," + a);
	    while (a != 0) {
	        x = x * 10 + a % 10;
	        a = a / 10;
	        System.out.println(x +"," + a);
	    }
	    
	    if (x == y) return true;
	    else return false;
	}
}
