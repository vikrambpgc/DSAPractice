package com.vikrambpgc.Matrices;

public class MaxKeyRow {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] A = {{1,1,1,1,1}, {1,1,1,1,1}, {1,0,0,0,0}, {0,0,0,0,0}, {1,1,1,0,0}};
        findRowWithMaxKey(A, 5, 5, 0);
    }
    
    public static void findRowWithMaxKey(int[][] A, int m, int n, int key) {
        int i, index;
        int maxRow, maxOcc = -1, currentOcc = -1;
        
        index = findFirstOccurrenceKey(A[0], 0, n-1, key);
        if (index != -1) maxOcc = currentOcc = n - index;
        maxRow = 0;
            
        for(i=1;i<m;i++) {
            if ((index == -1) || (index != -1 && A[i][currentOcc-1] == key)) {
                index = findFirstOccurrenceKey(A[i], 0, n-1, key);
                if (index != -1) {
                    currentOcc = n - index;
                    if (currentOcc > maxOcc) {
                        maxOcc = currentOcc;
                        maxRow = i;
                    }
                }
            }
        }
        
        System.out.println("max Key Row is:"+ maxRow);
    }
    
    public static int findFirstOccurrenceKey(int[] A, int start, int end, int key) {
        int index= -1;
        int mid;
        
        if (start > end) return -1;
        
        mid = start + (end - start)/2;
        
        if ((A[mid] == key) && (mid == start || (A[mid-1] != key))) {
            return mid;
        } else if(A[mid] > key) {
            return findFirstOccurrenceKey(A, mid + 1, end, key);
        } else if (A[mid] <= key){
            return findFirstOccurrenceKey(A, 0, mid - 1, key);
        }
           
        return index;
    }

}
