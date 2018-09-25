package com.vikrambpgc.Experiements;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Date;


public class StringFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str1 = "vik", str2 = null;
		if (str1.equals(str2)) {
			System.out.println("Yes, Equals");
		} else {
			System.out.println("Not Equals");
		}
		/*
		List<String> keys = new LinkedList<String>(Arrays.asList("Vikram", "Rajesh"));
		//List<String> keys = null; //Throws null
		for(String key: keys) System.out.println(key);
		
		Long maxPosition = null;
		System.out.println(String.format("vikram: %s", maxPosition));
		
		List<String> stringsList1 = new LinkedList<String>(Arrays.asList("1", "2"));
		List<String> stringsList2 = null;
		List<String> stringsList3 = new ArrayList(Arrays.asList("3")); //Will work for empty list too.
		//stringsList1.addAll(stringsList2); //Throws null
		stringsList1.addAll(stringsList3);
		for(String str: stringsList1) System.out.println(str);
		stringsList3.add("4");
		for(String str: stringsList1) System.out.println(str);
	    */
		
		//test string contains
		//testStringContains();
		
		//dateFormat();
		longFormat();
		
	}
	
	private static void longFormat() {
		//Long longVar = 1000000000000000000l;
		Long longVar = null;
		System.out.println(String.format("The value is %d", longVar));
	}
	
	private static void testStringContains() {
	    String str1 = "tutorials point", str2 = "http://";

	    CharSequence cs1 = "INT";
	    
	    // string contains the specified sequence of char values
	    boolean retval = str1.contains(cs1);
	    System.out.println("Method returns : " + retval);
	    
	    // string does not contain the specified sequence of char value
	    retval = str2.contains("_");   
	    System.out.println("Methods returns: " + retval);
	}
	
	private static void dateFormat() {
		  SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//dd/MM/yyyy
		  Date now = new Date();
		  String strDate = sdfDate.format(now);
		  System.out.println(strDate);
	}
}
