package com.vikrambpgc.DynamicProgramming;
import java.util.*;

/*
 * Nothing but fibonacci series
 */
public class MinimalSteps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		Scanner reader = new Scanner(System.in);
		
		n = reader.nextInt();
		findMinimumSteps(n);
	}

	public static int findMinimumSteps(int n) {
		int i;
		int A[]  = new int[n+1];
		
		if(n<= 0) return -1;
		
		A[0] = -1; A[1] = 1; A[2] = 1;
		
		for(i=3; i<=n; i++) {
             A[i] = A[i-1] + A[i-2];
		}		
		System.out.println(Arrays.toString(A));
		return 0;
	}
	
}
