package com.vikrambpgc.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDerivableNumbers {

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrayLength = Integer.parseInt(br.readLine());
        
        List<Integer> inputNumbers = new ArrayList<Integer>(arrayLength);

        String line = br.readLine();
        String[] numberStringArray = line.split(" ");

        for(int i=0; i < arrayLength;i++) {
            inputNumbers.add(Integer.parseInt(numberStringArray[i]));
        }

        Collections.sort(inputNumbers);
        
        Set<Integer> possibleNumbers = new HashSet<Integer>();
        List<Integer> derivedNumbers = new ArrayList<Integer>();
        
        for (Integer input: inputNumbers) {
            if (true == possibleNumbers.contains(input)) derivedNumbers.add(input);
            Set<Integer> tmp = new HashSet<Integer>();
            for(Integer possibleNumber: possibleNumbers) {
                if (possibleNumber != input) tmp.add(possibleNumber * input);
            }
            possibleNumbers.addAll(tmp);
            possibleNumbers.add(input);
        }
        
        for(Integer derivedNumber: derivedNumbers) {
            inputNumbers.remove(derivedNumber);
        }
        
        for(Integer input: inputNumbers) {
            System.out.print(input + " ");
        }
    }
}
