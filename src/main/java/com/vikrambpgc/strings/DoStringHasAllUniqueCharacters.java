package com.vikrambpgc.strings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * 
 * @author dhirajk
 *
 */
public class DoStringHasAllUniqueCharacters {
    
    public static void main(String[] args) {
        String input = "TestString";
        boolean duplicate = false;
        //With a data structure
        // O(n)
        System.out.println("********************* Using Set *************************");
        Set<Character> set = new HashSet<Character>();
        char[] characters = input.toCharArray();
        for(char characterValue:characters){
            if(!set.add(characterValue)){
                System.out.println("String has got duplicate characters. First one is : " + characterValue);
                duplicate = true;
                break;
            }
        }
        if(!duplicate){
            System.out.println("String does not contains any duplicate charater!");
        }
        duplicate = false;
        
        
        //Without any data structure
        //sort the string based on the characters it contain and then see if any two consecutive 
        //characters are same! its a O(n + nlog(n)) algo ~ O(nlog(n)) 
        
        
        System.out.println("********************* Without Using any data structure *************************");
        Arrays.sort(characters);//Use any sorting algo
        for(int i = 0 ; i < characters.length -1; i++){
            if(characters[i] == characters[i+1]){
                System.out.println("String has got duplicate characters");
                duplicate = true;
                break;
            }
        }
        
        if(!duplicate){
            System.out.println("String does not contains any duplicate charater!");
        }
        duplicate = false;
    }

}