package com.vikrambpgc.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonOfTwoSortedArrays {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(10000000, 10000000);
        List<Integer> b = Arrays.asList(10000000, 10000000);

        System.out.println(new CommonOfTwoSortedArrays().intersect(a, b));
    }
    // DO NOT MODIFY THE LISTS
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0,j=0;i<=a.size()-1 && j<=b.size()-1;) {

            if (a.get(i).intValue() < b.get(j).intValue()) {
                while(i <= a.size()-1 && a.get(i) < b.get(j)) i++;
            } else if (a.get(i).intValue() == b.get(j).intValue()) {
                result.add(a.get(i));
                i++;j++;
            } else {
                while(j<=b.size()-1 && b.get(j).intValue() < a.get(i).intValue()) j++;
            }
        }

        return result;
    }
}