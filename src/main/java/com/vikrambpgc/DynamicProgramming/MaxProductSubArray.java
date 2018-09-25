package com.vikrambpgc.DynamicProgramming;

public class MaxProductSubArray {
    /**
     * The following solution assumes that the given input array always has a positive ouput.
     * The solution works for all cases mentioned above.
     * It doesn�t work for arrays like {0, 0, -20, 0}, {0, 0, 0}.. etc.
     * The solution can be easily modified to handle this case.
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {6,-3,-10,0,2};
        
        //System.out.println(maxProductSubArraySequence(a));
        System.out.println(maxProductSubArraySeries(a));
    }

    private static int maxProductSubArraySequence(int[] a) {
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
    
    private static int maxProductSubArraySeries(int[] a) {
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
