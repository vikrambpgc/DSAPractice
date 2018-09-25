package com.vikrambpgc.strings;
public class VersioningComparision {
	public static void main(String[] args) {
		System.out.println(new VersioningComparision().compareVersion("1.0", "1"));
	}
	
	public int compareVersion(String a, String b) {
	    String[] achars = a.split("\\.");
	    String[] bchars = b.split("\\.");
	    int answer = 0;
	    

	    int length = (achars.length < bchars.length) ? achars.length : bchars.length;
	    
	    int i = 0;
	    for(; i <length; i++) {
	    	String str1 = achars[i];
	    	String str2 = bchars[i];
	    	
	    	if (i==0) {
		    	str1 = achars[i].replaceFirst("^0+(?!$)", "");
		    	str2 = bchars[i].replaceFirst("^0+(?!$)", "");
		    	
		    	if (str1.length() > str2.length()) return 1;
		    	else if (str1.length() < str2.length()) return -1;
	    	}
	    	
	    	int compareResult = str1.compareTo(str2);
	        if (compareResult > 0) {
	        	answer = 1;
	        	break;
	        } else if (compareResult < 0) {
	        	answer = -1;
	        	break;
	        }
	        //Dont do anything for equals
	    }
	    
	    if (i == length) {
	    	if (achars.length == bchars.length) { 
	    		answer = 0;
	        }else {
	    		String[] scanFurther =  (achars.length < bchars.length) ? bchars : achars;
	    		for(;i<scanFurther.length;i++) {
	    			
	    			if (scanFurther[i].equals("0") == false) {
	    				answer = (scanFurther == achars) ? 1 : -1;

    					return answer;
	    			}
	    		}
	    		if (i == scanFurther.length) {
	    		    answer = 0;
	    		}
	    	}
	    }
	    
	    return answer;
	}
}
