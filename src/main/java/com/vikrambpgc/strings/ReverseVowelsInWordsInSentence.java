package com.vikrambpgc.strings;

public class ReverseVowelsInWordsInSentence {

	//Needs change
	public static String reverse(String str_words){
	    char[] c_array = str_words.toCharArray();
	    int pos_start = 0;
	    int pos_end;
	    char c, c_tmp; 
	    int i, j, rev_length;
	    for(i = 0; i < c_array.length; i++){
	        c = c_array[i];
	        if( c == ' ' || c == '\n'){
	            if(pos_start != i){ 
	                pos_end = i-1;
	                rev_length = (i-pos_start)/2;
	                for(j = 0; j < rev_length; j++){
	                    c_tmp = c_array[pos_start+j];
	                    c_array[pos_start+j] = c_array[pos_end-j];
	                    c_array[pos_end-j] = c_tmp;
	                }
	            }
	            pos_start = i+1;
	        }
	    }
	    //redundant, if only java had '\0' @ end of string
	    if(pos_start != i){
	        pos_end = i-1;
	        rev_length = (i-pos_start)/2;
	        for(j = 0; j < rev_length; j++){
	            c_tmp = c_array[pos_start+j];
	            c_array[pos_start+j] = c_array[pos_end-j];
	            c_array[pos_end-j] = c_tmp;
	        }
	    }   
	    return new String(c_array);
	}
}
