package com.vikrambpgc.Basics;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class BlockingCallAndInput {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] numberStringArray = line.split(" ");
        int numberStringArrayLength = numberStringArray.length;

        Set<Integer> inputNumbersSet = new HashSet<Integer>(numberStringArrayLength); 
        for(int i=0; i < numberStringArrayLength;i++) {
            inputNumbersSet.add(Integer.parseInt(numberStringArray[i]));
        }

        int k = Integer.parseInt(br.readLine());
        List<Integer> inputNumbers = new ArrayList<Integer>(inputNumbersSet);
        Collections.sort(inputNumbers);
    }
}
