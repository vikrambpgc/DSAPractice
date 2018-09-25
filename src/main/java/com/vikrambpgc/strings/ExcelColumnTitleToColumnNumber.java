package com.vikrambpgc.strings;

public class ExcelColumnTitleToColumnNumber {

	public static void main(String[] args) {
		System.out.println(new ExcelColumnTitleToColumnNumber().titleToNumber("AA"));
	}
	
	public int titleToNumber(String a) {
	    int columnNumber = 0;
	    
	    for(int i=0; i<a.length();i++) {
	        char ch = a.charAt(i);
	        columnNumber = columnNumber * 26 + (ch - 'A' + 1);
	    }
	    
	    return columnNumber;
	}

}
