package com.vikrambpgc.DivideAndConquer;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] A = {1, 10, 12, 14, 17, 18};
		int[] B = {19, 20, 21};
		
		System.out.println(findMedianOfTwoSortedArrays(A, 0, 5, B, 0, 2));

	}
	
	public static int findMedianOfTwoSortedArrays (int[] A, int aLow, int aHigh, int[] B, int bLow, int bHigh) {
		int aMid = aLow + (aHigh - aLow)/ 2, bMid = bLow + (bHigh - bLow) / 2;
		
		if (null == A && null == B) return -1;
		else if (null == A) return B[bMid];
		else if (null == B) return A[aMid];

		int aMedian = A[aMid], bMedian = B[bMid];
		
		if (aMedian == bMedian) return aMedian;
		//Base cases
		if ((aHigh - aLow <= 1) && (bHigh - bLow <= 1)) {
			return (Integer.max(A[aLow], B[bLow]) + Integer.min(A[aHigh], B[bHigh])) / 2;
		} else if (aMedian < bMedian)  return findMedianOfTwoSortedArrays(A, aMid, aHigh, B, bLow, bMid);
		else return findMedianOfTwoSortedArrays(A, aLow, aMid, B, bMid, bHigh);
	}
}
