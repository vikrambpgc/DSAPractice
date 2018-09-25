package com.vikrambpgc.strings;
public class LengthOfLastWordClass {

	public static void main(String[] args) {
		System.out.println(new LengthOfLastWordClass().lengthOfLastWord(" Hello world "));
	}
	
	public int lengthOfLastWord(final String a) {
		char[] inputString = a.toCharArray();
		int lastWordLastLetter = -1, lastWordFirstLetter = -1;
		
		for(int i= inputString.length - 1; i>=0; i--) {
			if (inputString[i] != ' ') {
				lastWordLastLetter = i;
				break;
			}
		}
	
		if (lastWordLastLetter == -1) return 0;

		for(int i= lastWordLastLetter; i>=0; i--) {
			if (inputString[i] == ' ') {
				lastWordFirstLetter = i + 1;
				break;
			}
		}
		
		if (lastWordFirstLetter == -1) return (lastWordLastLetter + 1);
		
		return (lastWordLastLetter - lastWordFirstLetter + 1);
	}
}