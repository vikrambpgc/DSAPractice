package com.vikrambpgc.Sorting;
import java.util.ArrayList;
import java.util.Arrays;

public class DutchFlags {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(0,1,2,0,1,2));
		new DutchFlags().sortColors(a);
		System.out.println(a);
	}
	
	public void sortColors(ArrayList<Integer> a) {
		int length = a.size();
		int start = 0, mid = 0, end = length - 1;

		while(mid <= end) {
			if (a.get(mid) == 0) {
				int temp = a.get(start);
				a.set(start, 0);
				a.set(mid, temp);
				
				start++;
				mid++;
				
			} else if (a.get(mid) == 1) {
				
				mid++;
				
			} else if (a.get(mid) == 2) {
				int temp = a.get(end);
				a.set(end, 2);
				a.set(mid, temp);
				
				end--;
			}
		}
	}
}
