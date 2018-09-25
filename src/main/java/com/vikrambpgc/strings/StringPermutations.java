package com.vikrambpgc.strings;

public class StringPermutations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[] a = "AAA".toCharArray();
        int stringLength = a.length;
        //permute(a, 0, stringLength - 1);
        
        //permutations("", "ABC");
        String s = "ABC";
        System.out.println(s.substring(3, 3));
    }
    
    public static void permute(char[] a, int start, int end) {
        int i,j;
        if (start == end) {
            System.out.println(a);
            return;
        }
        for(i=start; i< a.length; i++) {
            swap(a, start, i);
            permute(a, start + 1, end);
            swap(a, i, start);
        }
    }
    
    public static void swap(char[] a,int x, int y) {
        char temp;
        temp = a[y];
        a[y] = a[x];
        a[x] = temp;
    }
    
    public static void permutations(String prefix, String s) {
        int n = s.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for(int i = 0; i < n; i++){
               permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
            }
        }
    }
}
