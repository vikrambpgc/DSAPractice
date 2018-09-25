package com.vikrambpgc.MiscAlgos;

public class SlidingWindow {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int startIndex, windowSize, i;
        int A[] = {1,3,-1,-3,5,3,6,7};
        windowSize = 3;
        startIndex = bestWindow(A, windowSize);
        
        System.out.print("[");
        for(i = startIndex; i < (startIndex + windowSize); i++) {
            System.out.print(A[i]+ " ");    
        }
        System.out.println("]");
    }
    
    private static int bestWindow(int[] A, int w) {
        int start = 0, end, i, length = A.length;
        int currentSum = 0, maxStart;
        
        if (length < w) return -1;
        for (i = 0; i<w; i++) {
            currentSum += A[i];
        }
        maxStart = start;
        for (i = w; i < length; i++) {
            currentSum = currentSum - A[start] + A[i];
            if (currentSum > maxStart) maxStart = start;
            start++;
        }
        
        return start;
    }

}
