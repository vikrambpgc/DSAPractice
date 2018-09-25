package com.vikrambpgc.Experiements;

public class TernaryOperators {
    public static void main(String[] args) {
        System.out.println(getIntegerObject());
    }
    
    public static Integer getIntegerObject() {
        String contentType = "1";
        
        return (null == contentType)? null : 3;
    }
}
