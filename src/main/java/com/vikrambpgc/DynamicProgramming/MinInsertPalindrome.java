package com.vikrambpgc.DynamicProgramming;

public class MinInsertPalindrome {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int result;
        String str = "abcdee";
        
        result = minInsertionsToPalindrome(str);
        
        System.out.println(result);

    }
    
    public static int minInsertionsToPalindrome(String str) {
        int strLength = str.length();
        int i,j,k;
        
        if (strLength == 0) return 0;
        
        int[][] table = new int[strLength][strLength];
        
        for(i=0;i<strLength;i++) {
            table[i][i] = 0;
        }
        
        for(i=0;i<strLength-1;i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                table[i][i+1] = 0;
            } else {
                table[i][i+1] = 1;
            }
        }
        
        for(k=3;k<=strLength;k++) {
            for(i=0;i<=strLength-k;i++) {
                j=i+k-1;
                
                if (str.charAt(i) == str.charAt(j)) table[i][j] = 0 + table[i+1][j-1];
                else table[i][j] = 1 + Math.min(table[i+1][j], table[i][j-1]);
            }
        }
        return table[0][strLength-1];
    }
}
