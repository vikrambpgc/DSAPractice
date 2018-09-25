package com.vikrambpgc.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreatestElement {
	
	private static class Node {
		int va11;
		int val2;
		
		private Node(int val1, int val2) {
			this.va11 = val1;
			this.val2 = val2;
		}
	}

	public static void main(String[] args) {
	    int[] inputArray = {10, 5, 20, 7, 11, 30};
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(10, 5, 20, 7, 11, 30));
		System.out.println(a);
		System.out.println(new NextGreatestElement().nextGreater2(a));
		new NextGreatestElement().nextGreater3(inputArray);
	}
	
	public ArrayList<Integer> nextGreater2(ArrayList<Integer> a) {
		
	    Stack<Integer> s = new Stack<Integer>();
	    s.push(a.get(0));

	    for (int i = 1; i < a.size(); i++) {
	        if (s.isEmpty() == false) {
	            while (true) {
	                if (s.isEmpty() == true || s.peek() > a.get(i)) {
	                    break;
	                }
	                System.out.println(s.pop() + ":" + a.get(i));
	            }
	        }
	        s.push(a.get(i));
	    }
	    while (s.isEmpty() == false) {
	        System.out.println(s.pop() + ":" + -1);
	    }
	    
	    return null;
	}

	//Doesn't work with Duplicates
    private void nextGreater3(int[] input) {
        int length = input.length;
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        int[] temp = new int[length];
        
        mergeSort(input.clone(), 0, length - 1, temp, result);

        for(int i=0;i<length;i++) {
            if(result.containsKey(input[i])) System.out.println(input[i] + "->" + result.get(input[i]));
            else System.out.println(input[i] + "-> -1");
        }
    }

    //Doesn't work at all, instead of NGE, it gives greatest of all on the left side.
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    
	    if (a == null || a.size() == 0) return null;
	    
	    int aLength = a.size();
	    
	    ArrayList<Node> result = new ArrayList<Node>();
	    ArrayList<Integer> sortedArray = new ArrayList<Integer>(a);
	    ArrayList<Integer> tmp = new ArrayList<Integer>(aLength);
	    //ArrayList<Integer> resultArray = new ArrayList<Integer>(aLength);
	    
	    for(int i=0; i<aLength;i++) {

	        tmp.add(-1);
	    }
	    
	    MergeSort(sortedArray, 0, aLength - 1, tmp, result);
	    
	    for(int i=0; i < result.size(); i++) {
	    		System.out.println(result.get(i).va11 + " : " + result.get(i).val2);
	    }
	    //return resultArray;
	    return null;
	}
	
	public void MergeSort(ArrayList<Integer> a, int start, int end, ArrayList<Integer> tmp,
			ArrayList<Node> result) {
	                              
	    if (start >= end) return;
	    
	    int mid = start + (end - start) / 2;
	    
	    MergeSort(a, start, mid, tmp, result);
	    MergeSort(a, mid+1, end, tmp, result);
	    Merge(a, start, mid, end, tmp, result);
	                              
	}

    private void mergeSort(int[] input, int left, int right, int[] temp, HashMap<Integer, Integer> result) {
        if(left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(input, left, mid, temp, result);
        mergeSort(input, mid + 1, right, temp, result);
        
        merge(input, left, mid, right, temp, result);
    }

	public void Merge(ArrayList<Integer> a, int start, int mid, int end, ArrayList<Integer> tmp,
			ArrayList<Node> result) {
	   
	   int mid2 = mid + 1;
	   int i=start, j=mid2, k = start;
	   
	   while (i<=mid && j <= end) {
	       if(a.get(i) < a.get(j)) {
	    	   result.add(new Node(a.get(i), a.get(j)));
	    	  
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
	
    private void merge(int[] input, int left, int mid, int right, int[] temp, HashMap<Integer, Integer> result) {
        int i=left, j = mid + 1, k = left;

        while(i<=mid && j<=right) {
            if(input[i] < input[j]) {
                if (result.containsKey(input[i]) == false) result.put(input[i], input[j]);

                temp[k] = input[i];
                i=i+1;
                k=k+1;
            } else {
                temp[k] = input[j];
                j=j+1;
                k=k+1;
            }
        }

        while(i<=mid) {
            temp[k] = input[i];
            i=i+1;
            k=k+1;
        }

        while(j<=right) {
            temp[k] = input[j];
            j=j+1;
            k=k+1;
        }

        for(k=left;k<=right;k++) {
            input[k] = temp[k];
        }
    }
}
