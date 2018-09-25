package com.vikrambpgc.strings;
import java.util.List;
import java.util.Arrays;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(Arrays.asList("abcd", "abce", "ab")));
	}
	
	public String longestCommonPrefix(List<String> a) {
		if (null == a) return null;

	    String key = a.get(0);
	    
	    for(String value: a) {
	        int i = 0;
	        while (i<key.length() && i < value.length() && value.charAt(i) == key.charAt(i)) {
	            i++;
	        }
	        key = key.substring(0, i);
	    }
	    
	    return key;
	}
}
