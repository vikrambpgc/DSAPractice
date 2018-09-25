package com.vikrambpgc.stacks;
import java.util.Stack;
public class Spans {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A= {6,3,4,5,2}, S;
		int i, oLength;
		S = findSpans(A);
		oLength =  S.length;
		for(i = 0; i<oLength;i++) {
			System.out.print(S[i]+",");
		}
	}
	
	public static int[] findSpans(int[] A) {
		int length = A.length;
		int[] p = new int[length];
		Stack<Integer> s = new Stack<Integer>();
		int i, span;
		
		if (length == 0) return A;

		for (i=0; i < length; i++) {
			while (s.empty() != true && A[s.peek()] < A[i]) {
				s.pop();
			}
			if (s.empty() == false) {
				span = s.peek();
			} else {
				span = -1;
			}
			s.push(new Integer(i));
			p[i] = i - span;
		}
		return p;
	}

}
