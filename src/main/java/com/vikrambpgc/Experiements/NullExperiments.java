package com.vikrambpgc.Experiements;
import java.util.*;
public class NullExperiments {
    
    public static void main(String[] args) {
        experimentLong();
    }
    
    public static void experimentLong() {
        Long fileLength = null;
        String output = null;
        
        output = Long.toString(fileLength);
        System.out.println(output);
    }
    
    Map<String, String> myMap = new HashMap<String, String>();
    
}
