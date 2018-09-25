package com.vikrambpgc.strings;
import java.util.*;

public class RankOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(returnRank("TAKE"));
	}
	
	public static int returnRank(String input) {
	    if (null == input) return 0;
	    char[] inputArray = input.toCharArray();
	    int length = input.length();
	    int resultRank = 0;
	    int fixedLengthSoFar = 0;
	    List<Character> charArray = new ArrayList<Character>(length);
	    
	    for (int i = 0; i < length; i++) {
	        charArray.add(inputArray[i]); 
	    } 
	    
	    for(fixedLengthSoFar = 0; fixedLengthSoFar < length; fixedLengthSoFar++) {
	    	int lexLessCharacters = 0; 
	        lexLessCharacters = utilityLexLessCharacters(charArray, inputArray[fixedLengthSoFar]);
	        resultRank = resultRank + lexLessCharacters * factorial(charArray.size() - 1);
	        charArray.remove(0);
	    }
	    
	    //Above algo gives number of letters before current string. So result rank is +1 of the above result.
	    return resultRank + 1;
	    
	}
	
	//Gives number of characters lexicographically less than a given character in a list of characters.
	public static int utilityLexLessCharacters(List<Character> array, char c) {
		int result = 0;
		for(int i=0; i < array.size(); i++) {
			if (c != array.get(i) && c > array.get(i)) result++;
		}
		return result;
	}
	
	public static int factorial(int n) {
	        int fact = 1; // this  will be the result
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	}
}
