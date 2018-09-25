package com.vikrambpgc.MiscAlgos;
public class ReverseIntegerOverflowDetect {
	
	public static void main(String[] args) {
		System.out.println(new ReverseIntegerOverflowDetect().reverse(-1146467285));
	}
	
	public int reverse(int a) {
	    boolean isNegative = false;
	    long ans = 0;
	    
	    if (a < 0) isNegative = true;
	    
	    a = Math.abs(a);
	    
	    while(a != 0) {
	    	System.out.println(ans + " " + a);
	        ans = ans * 10l + a % 10l;
	        
	        if (ans != (int) ans) return 0;
	        a = a / 10;
	        
	    }
	    System.out.println(ans + " " + a);
	    
	    if (ans < 0) return 0; 
	    
	    int returnValue = (int) ans;
	    if (isNegative == false) return returnValue;
	    else return -1 * returnValue;
	}
}
