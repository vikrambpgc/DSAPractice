package com.vikrambpgc.DynamicProgramming;

public class MinCoinChange {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int result, value = 140;
        int[] values = new int[value+1];
        int[] denom = {1,2,5,10,20,50,100};
        
        values[0] = 0;
        values[1] = 1;
        for(int i=2;i<value;i++) {
            values[i] = 0;
        }
        
        
        result = findMinDenom(denom, values, value);
        System.out.println(result);
        result = findMinDenomTabular(denom, value);
        System.out.println(result);
    }
    
    public static int findMinDenom(int[] denom, int[] values, int value) {
        int denomLength = denom.length;
        int i, coins, minCoins = 0;
        
        if (values[value] != 0) return values[value];
        
        for (i = 0; i < denomLength && (value - denom[i] >= 0);i++) {
            coins = findMinDenom(denom, values, value - denom[i]) + 1;
            if (minCoins == 0) minCoins = coins;
            else minCoins = Math.min(coins, minCoins);
        }
        
        values[value] = minCoins;
        return minCoins;
    }
    
    public static int findMinDenomTabular(int[] denom, int value) {
        int[][] table = new int[value + 1][denom.length];
        
        int i, j;
        for (j = 0;j<denom.length;j++) {
            table[0][j] = 0;
        }
        
        for (i = 1;i <=value;i++) {
            for (j=0;j<denom.length;j++) {
                if (j == 0) {
                    table[i][j] = 1 + table[i-denom[j]][j];
                    continue;
                }
                
                if (i-denom[j] >= 0) {
                    table[i][j] = Math.min( 1 + table[i-denom[j]][j], table[i][j-1]);
                } else {
                    table[i][j] = table[i][j-1];
                }
            }
        }
        return table[value][denom.length - 1];
    
    }
}
 