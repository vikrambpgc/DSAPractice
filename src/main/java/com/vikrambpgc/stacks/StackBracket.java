package com.vikrambpgc.stacks;
import java.io.*;
import java.util.*;
import java.math.*;

class StackBracket {
    public int solution(String S) {
        char[] temp = S.toCharArray();
        int i, strLength = S.length(), ret;
        Stack<Character> st = new Stack<Character>();
        
        for (i = 0; i < strLength; i++) {
        	
        	if (Character.isLetter(temp[i])) continue;
        	
        	if (temp[i] == '{' || temp[i] == '(' || temp[i] == '[') {
        		st.add(temp[i]);
        		continue;
        	}
        	
        	if (temp[i] == '}' && st.isEmpty() != true && st.peek() == '{') {
        		st.pop();
        		continue;
        	} else if (temp[i] == ')' && st.isEmpty() != true && st.peek() == '(') {
        		st.pop();
        		continue;
        	} else if (temp[i] == ']' && st.isEmpty() != true && st.peek() == '[') {
        		st.pop();
        		continue;
        	} else {
        		return 0;
        	}
        }
        
        if (st.isEmpty()) return 1;
        else return 0;
    }
}