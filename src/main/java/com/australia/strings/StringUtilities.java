package com.australia.strings;

import java.util.Arrays;

public class StringUtilities {
    public static void main(String[] args) {
        String[] tokens = "/abc/def".split("/");
        System.out.println(tokens.length);
        if ("".equals(tokens[0])) System.out.println("Empty string");
        Arrays.stream(tokens).forEach((a) -> System.out.println("Tokens: " + a + " :done"));
    }
}
