package com.vikrambpgc.Arrays;
import java.util.ArrayList;

public class PascalsTriangle {

    public PascalsTriangle() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < a; i++) {
            ArrayList<Integer> subarray = new ArrayList<Integer>();
            for(int j=0;j<=i;j++) {
                if (i == 0 || j == 0 || j == i) subarray.add(1);
                else {
                    subarray.add(array.get(i-1).get(j-1) + array.get(i-1).get(j));
                }
            }
            array.add(subarray);
        }  
        return array;
    }
}
