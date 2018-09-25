package com.vikrambpgc.Sorting;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		ArrayList<Integer> listToSort = new ArrayList<Integer>(Arrays.asList(5, 10, 3, 1));
		ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(5, 10, 3, 1));
		new MergeSort().mergeSort(listToSort, 0, listToSort.size() - 1, tmp);
		System.out.println(listToSort);
	}
	
	public void mergeSort(ArrayList<Integer> a, int start, int end, ArrayList<Integer> tmp) {
	                              
	    if (start >= end) return;
	    
	    int mid = start + (end - start) / 2;
	    
	    mergeSort(a, start, mid, tmp);
	    mergeSort(a, mid+1, end, tmp);
	    merge(a, start, mid, end, tmp);
	                              
	}
	
	public void merge(ArrayList<Integer> a, int start, int mid, int end, ArrayList<Integer> tmp) {
	   
	   int mid2 = mid + 1;
	   int i=start, j=mid2, k = start;
	   
	   while (i<=mid && j <= end) {
	       if(a.get(i) < a.get(j)) {
	    	  
	           tmp.set(k, a.get(i));
	           k++;
	           i++;
	                      
	       } else {
	           tmp.set(k, a.get(j));
	           k++;
	           j++;
 	       }
	   }
	   
	   while(i<=mid) {
	       tmp.set(k, a.get(i));
	       i++;
	       k++;
	   }
	   
	   while(j<=end) {
	       tmp.set(k, a.get(j));
	       j++;
	       k++;
	   }
	   
	   for(k=start;k<=end;k++) {
	       a.set(k, tmp.get(k));
	   }
	}
}
