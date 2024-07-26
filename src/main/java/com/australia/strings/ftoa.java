package com.australia.strings;

public class ftoa {
    public static String ftoa(float num) {
        if (num == 0) {
            return "0.0";
        }

        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }

        StringBuilder sb = new StringBuilder();
        int integerPart = (int) num;
        float fractionalPart = num - integerPart;

        // Convert integer part
        while (integerPart > 0) {
            int digit = integerPart % 10;
            sb.insert(0, (char) (digit + '0'));
            integerPart /= 10;
        }

        // Convert fractional part
        sb.append(".");
        while (fractionalPart > 0) {
            fractionalPart *= 10;
            int digit = (int) fractionalPart;
            sb.append((char) (digit + '0'));
            fractionalPart -= digit;
        }

        if (isNegative) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }
}
