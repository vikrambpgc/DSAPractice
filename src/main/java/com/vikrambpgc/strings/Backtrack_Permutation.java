package com.vikrambpgc.strings;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author vikramc
 * Base case return statement is also important. not just dealing border case.
 *
 */
public class Backtrack_Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		Backtrack_Permutation bg = new Backtrack_Permutation();
		bg.go(3, 2);
	}
	
	public void go(int n, int k) {
		int[] A = new int[n];
		generateString(A, n, k);
	}
	
	public void generateString(int[] A, int n, int k) {
		int i, count;
		if (n < 1) {
			System.out.println();
			count = A.length;
			for (i=0;i<count;i++) {
				System.out.print(A[i]);
			}
			return;
		}
		for(i=0; i < k; i++) {
			A[n-1] = i;
			generateString(A, n-1, k);
		}		
	}
}