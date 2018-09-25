package com.vikrambpgc.Experiements;

public class MultipleMain {

    public static void main(String[] args) {
        System.out.println("Main1");
    }
}

class Main2 {
    public static void main(String[] args) {
        System.out.println("Main2");
        MultipleMain.main(new String[] {"vik", "raj"});
    }
}
