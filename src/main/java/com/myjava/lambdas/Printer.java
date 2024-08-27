package com.myjava.lambdas;

public class Printer {
    public static void main(String[] args) {
        /**
         * (message) -> System.out.println(message) is a lambda expression that implements the print method.
         */
        Printable printer = System.out::println; //better
        // Printable printer = (message) -> System.out.println(message);
        printer.print("Hello, World!");
    }
}
