package com.vikrambpgc.Arrays;
import java.util.ArrayList;

public class PrettyPrintRim {
    public static void main(String[] args) {
        System.out.println(new PrettyPrintRim().prettyPrint(4));
    }
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        int mainArrayLength = 2*a - 1;
        int data = a;
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>(mainArrayLength);

        for(int i=0;i<mainArrayLength;i++) {
            ArrayList<Integer> subarray = new ArrayList<Integer>(mainArrayLength);
            for(int j=0;j<mainArrayLength;j++) subarray.add(0);
            array.add(subarray); 
        }
        
        for(int i=0;i<a;i++) {
            printRim(array, i, data, 2*data - 1, mainArrayLength);
            data--;
        }

        return array;
    }
    
    public void printRim(ArrayList<ArrayList<Integer>> array, int upperCorner, int data, int rimLength, int mainArrayLength) {
        for(int j=0;j<rimLength;j++) {
            //Upper Edge
            ArrayList<Integer> subarray1 = array.get(upperCorner);
            subarray1.set(j + upperCorner, data);

            //Lower Edge
            ArrayList<Integer> subarray2 = array.get(mainArrayLength - 1 - upperCorner);
            subarray2.set(j + upperCorner, data);
            
            //Left edge
            ArrayList<Integer> subarray3 = array.get(j + upperCorner);
            subarray3.set(upperCorner, data);
            
            //Right edge
            ArrayList<Integer> subarray4 = array.get(j + upperCorner);
            subarray4.set(upperCorner + rimLength - 1, data);
        }
    }
}