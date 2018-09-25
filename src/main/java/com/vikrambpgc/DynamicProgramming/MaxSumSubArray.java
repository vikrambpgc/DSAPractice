package com.vikrambpgc.DynamicProgramming;

public class MaxSumSubArray {
    
    public static void main(String[] args) {
        int a[] = {6,-3,-10,0,2};
        
        //System.out.println(maxSumSubArraySequence(a));
        System.out.println(maxSumSubArraySeries(a));
    }

    //Needs change
    private static int maxSumSubArraySequence(int[] a) {
        int maxSoFar = 1, maxEndingHere = 1, minEndingHere = 1;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                maxEndingHere = maxEndingHere * a[i];
                minEndingHere = Math.min(minEndingHere, minEndingHere * a[i]); 
            } else if (a[i] == 0) {
                minEndingHere = Math.min(minEndingHere, 0);
            } else {
                int temp = maxEndingHere;
                maxEndingHere = Math.max(maxEndingHere, minEndingHere * a[i]);
                minEndingHere = Math.min(minEndingHere, temp * a[i]); 
            }
            
            System.out.println(maxEndingHere + " , " + minEndingHere);
        }
        
        return maxEndingHere;
    }
    
    //Needs change
    private static int maxSumSubArraySeries(int[] a) {
        int maxSoFar = 1, maxEndingHere = 1, minEndingHere = 1;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                maxEndingHere = maxEndingHere * a[i];
                minEndingHere = Math.min(minEndingHere * a[i], 1); 
            } else if (a[i] == 0) {
                minEndingHere = 1;
                maxEndingHere = 1;
            } else {
                int temp = maxEndingHere;
                maxEndingHere = Math.max(minEndingHere * a[i], 1);
                minEndingHere = Math.min(temp * a[i], 1); 
            }
            
            //System.out.println(maxEndingHere + " , " + minEndingHere);
            if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
        }
        
        return maxSoFar;
    }
}
