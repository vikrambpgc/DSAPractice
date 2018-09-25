package com.vikrambpgc.BackTracking;
import java.util.ArrayList;

public class PermutationsCombinations {
    
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		System.out.println(new PermutationsCombinations().permute(a));
	}
    
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            permuteUtil(a, 0, result);
            
            return result;
	}
	
	public void permuteUtil(ArrayList<Integer> a, int start, ArrayList<ArrayList<Integer>> result) {
		int length = a.size();

	    if (start == length) {
	        ArrayList<Integer> subResult = new ArrayList<Integer>();
	        
	        for(int i=0;i<length;i++) {
	            subResult.add(a.get(i));
	        }
	        
	        result.add(subResult);
	        return;
	    }
	    
	    for(int i=start;i<length;i++) {
	    	swap(a, start, i);
	        permuteUtil(a, start+1, result);
	        swap(a, start, i);
	    }
	}
	
	public void swap(ArrayList<Integer> a, int index1, int index2) {
		Integer tmp  = a.get(index1);
		a.set(index1, a.get(index2));
		a.set(index2, tmp);
	}
}