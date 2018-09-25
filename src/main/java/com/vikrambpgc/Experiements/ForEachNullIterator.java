package com.vikrambpgc.Experiements;

public class ForEachNullIterator {
	public static void main(String[] args) {
		String[] strings = {};
		
		for(String str: strings) {
			System.out.println(str);
		}
	}
}
