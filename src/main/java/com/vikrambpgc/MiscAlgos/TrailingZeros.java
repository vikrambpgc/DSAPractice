package com.vikrambpgc.MiscAlgos;
public class TrailingZeros {
    public static void main(String[] args) {
        System.out.println(new TrailingZeros().trailingZeroes(9247));
    }
    public int trailingZeroes(int a) {
        int count = 0;
        for(int i=5; a/i >= 1; i*=5) {
            count += a/i;
        };
        return count;
    }
}
