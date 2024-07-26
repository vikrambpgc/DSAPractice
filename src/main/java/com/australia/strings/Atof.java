package com.australia.strings;

public class Atof {
    public static void main(String[] args) {
        String strNum = "123";
        String strFloatNum = "123.45";

        int num = atoi(strNum);
        float floatNum = atof(strFloatNum);

        System.out.println("String: " + strNum + ", Integer: " + num);
        System.out.println("String: " + strFloatNum + ", Float: " + floatNum);
    }

    public static int atoi(String str) {
        int num = 0;
        boolean isNegative = false;

        // Check for negative sign
        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1);
        }

        // Convert string to integer
        for (char c : str.toCharArray()) {
            num = num * 10 + (c - '0');
        }

        // Return negative number if necessary
        return isNegative ? -num : num;
    }

    public static float atof(String str) {
        float num = 0;
        boolean isNegative = false;
        boolean isFractional = false;
        float fractionalPart = 0;
        int decimalPlaces = 0;

        // Check for negative sign
        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1);
        }

        // Convert string to float
        for (char c : str.toCharArray()) {
            if (c == '.') {
                isFractional = true;
            } else if (isFractional) {
                fractionalPart = fractionalPart * 10 + (c - '0');
                decimalPlaces++;
            } else {
                num = num * 10 + (c - '0');
            }
        }

        // Calculate fractional part
        fractionalPart /= Math.pow(10, decimalPlaces);

        // Return negative number if necessary
        return isNegative ? -(num + fractionalPart) : num + fractionalPart;
    }
}
