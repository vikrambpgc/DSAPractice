package com.myjava;

import java.util.ArrayList;
import java.util.List;

public class StringTokenizer {
    private String str;
    private String delimiters;
    private int position;

    public StringTokenizer(String str, String delimiters) {
        this.str = str;
        this.delimiters = delimiters;
        this.position = 0;
    }

    public boolean hasMoreTokens() {
        return position < str.length();
    }

    public String nextToken() {
        if (!hasMoreTokens()) {
            throw new RuntimeException("No more tokens");
        }

        int startIndex = position;
        while (position < str.length() && !isDelimiter(str.charAt(position))) {
            position++;
        }

        if (position == str.length()) {
            return str.substring(startIndex);
        }

        while (position < str.length() && isDelimiter(str.charAt(position))) {
            position++;
        }

        return str.substring(startIndex, position);
    }

    private boolean isDelimiter(char c) {
        return delimiters.indexOf(c) != -1;
    }

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("hello,world,java", ",");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
