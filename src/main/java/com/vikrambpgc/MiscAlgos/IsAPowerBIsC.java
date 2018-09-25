package com.vikrambpgc.MiscAlgos;
import java.lang.Math;

public class IsAPowerBIsC {

    private static final int INT_MAX = (int) Math.pow(2, 31) - 1;
    
    public boolean isPower(int x) {
        if (x <= 1) return true;
        for (int base = 2; base < x && base < INT_MAX / base; base++) {
            int temp = base; 
            while (temp <= x && temp < INT_MAX / base) {
                temp *= base;
                if (temp == x) return true;
            }
        }
        return false;
    }
//    public boolean isPower(int A) {
//        double x=2;
//        double i;
//        if(A==1) return true;
//        for(i=2;(i<33)&&(x<=(double)(Math.pow(2,16)));i++)
//        {   
//            if(Math.pow(x,i)==(double)A) return true;
//            if(Math.pow(x,i) >= (Math.pow(2,32))) {i=1;x++;}
//        }
//        return false;
//    }
}

