package com.vikrambpgc.Experiements;

class Dog {
     public static void main(String [] args) {
         Dog d = new Dog();
         //System.out.println(d instanceof Cat);
         
        Shape s = new Shape();
        s.draw(2);
        s = new Circle();
        s.draw(2);
     }
     
     public static void draw(int x) {System.out.println(2*x);}
}