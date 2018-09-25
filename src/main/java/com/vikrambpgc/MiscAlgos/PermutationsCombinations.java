package com.vikrambpgc.MiscAlgos;

public class PermutationsCombinations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "123";
        permute(str);
        combine(str);
    }
    
    public static void permute(String str) {
        permuteUtil("", str);
    }
    
    private static void permuteUtil(String prefix, String str) {
        int length = str.length(), i = 0;
        if ( length == 0) {
            System.out.println(prefix);
        } else {
            for(i = 0;i<length;i++) {
                permuteUtil(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1));
            }
        }
    }
    
    public static void combine(String str) {
        combineUtil("", str);
    }
    
    private static void combineUtil(String prefix, String str) {
        int length = str.length(), i = 0;
        System.out.println(prefix);
        for(i=0;i<length;i++) {
            combineUtil(prefix+str.charAt(i), str.substring(i+1));
        }
    }

}
