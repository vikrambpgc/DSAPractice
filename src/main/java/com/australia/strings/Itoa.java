package com.australia.strings;

public class Itoa {
    public static void main(String[] args) {
        int num = 123;
        String str = itoa(num);
        System.out.println("Integer: " + num + ", String: " + str);
    }

    public static String itoa(int num) {
        if (num == 0) {
            return "0";
        }

        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int digit = num % 10;
            sb.insert(0, (char) (digit + '0'));
            num /= 10;
        }

        if (isNegative) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }
}
