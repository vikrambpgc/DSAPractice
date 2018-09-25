package com.vikrambpgc.Experiements;

public class PrivateProtectedTest1 {
	
	private int add1(int x) {
		return x+1;
	}
	
	protected int add2(int x) {
		return 1 + add1(x);
	}
}
