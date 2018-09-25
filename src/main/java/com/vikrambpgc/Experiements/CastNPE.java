package com.vikrambpgc.Experiements;

public class CastNPE {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Long x = returnLong();
        System.out.println("X value: " + x);
        
        System.out.println(Boolean.TRUE.equals(returnBoolean()));
        
        int b = -1;
        System.out.println(Integer.toBinaryString(b));
        b >>>= 10;
        System.out.println(b);
        System.out.println(Integer.toBinaryString(b));

    }
    
    public static Long returnLong() {
        return (Long) null;
    }
    
    public static Boolean returnBoolean() {
        return Boolean.FALSE;
    }

}
