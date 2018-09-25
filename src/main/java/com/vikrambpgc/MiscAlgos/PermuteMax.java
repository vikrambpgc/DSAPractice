package com.vikrambpgc.MiscAlgos;
// you can also use imports, for example:
// import java.math.*;
class PermuteMax {
    public int solution(int A, int B, int C, int D) {
        int[] Array = {A, B, C, D};
        int[] solution = {0};
        permuteFindFun(Array, 0, 3, solution);
        
        return solution[0];
    }
    
    public static void permuteFindFun(int[] A, int start, int end, int[] sol) {
        int length = A.length, j;
        
        if (start == end) {
            calMaxFun(A, sol);
            return;
        }
        for (j=start;j<length;j++) {
            swap(A, start, j);
            permuteFindFun(A, start+1, end, sol);
            swap(A, j, start);
        }
    }
    
    public static void calMaxFun(int[] A, int[] sol) {
        int sum = 0, length = A.length, i;
        for (i=0;i<length-1;i++) {
            sum = sum + Math.max(A[i] - A[i+1], A[i+1] - A[i]);
        }
        
        if (sum > sol[0]) sol[0] = sum;
    }
    
    public static void swap(int[] A, int i, int j) {
        int temp;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}