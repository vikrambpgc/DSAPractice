package com.vikrambpgc.strings;
import java.util.*;

public class GenericPuzzles {
	public static void main(String[] args) {
		String str = "the sky is blue";
		System.out.println(reverseWordsInSentence(str));
	}
	
	public static String reverseWordsInSentence(String str) {
		String result = "";
		StringTokenizer tokens = new StringTokenizer(str, " ");
		while (tokens.hasMoreTokens()) {
			result = tokens.nextToken() + " "+result;
		}
		
		return result.trim();
	}
}
