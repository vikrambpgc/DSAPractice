package com.vikrambpgc.Experiements;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ArraysExp {
    public static void main(String[] args) {
        List<String> finalArray = new ArrayList<String>(Arrays.asList("Vikram", "Rajesh"));
        
        for(String element: finalArray) System.out.println(element);
        
        finalArray.remove("Karthick");
        System.out.println(finalArray);
        
        finalArray.remove("Vikram");
        System.out.println(finalArray);
        
    }

    
}
