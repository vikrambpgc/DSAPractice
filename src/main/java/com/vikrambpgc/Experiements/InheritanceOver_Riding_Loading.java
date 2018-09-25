package com.vikrambpgc.Experiements;

public class InheritanceOver_Riding_Loading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s = new Shape();
		s.draw(2);
		s = new Circle();
		s.draw(2);
	}
}

class Shape {
	public static void draw(int x) {System.out.println(x);}
}

class Circle extends Shape {
    public static void draw(int x) {System.out.println(2*x);}
}