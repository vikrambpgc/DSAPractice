package com.vikrambpgc.BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NQueens {
	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens(8));
	}

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		Set<ArrayList<String>> results = new HashSet<ArrayList<String>>();
		ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
		
		ArrayList<Character> charString = new ArrayList<Character>();
		for(int i=0;i<a;i++) charString.add('.');

		for(int i=0;i<a;i++) {
			result.add(charString);
		}

		System.out.println(result);
		new NQueens().nQueensUtil(a, 0, a, results, result);
		
		return new ArrayList<ArrayList<String>>(results);
	}

	public void nQueensUtil(int boardGridSize, int queenNumber, int nqueens, Set<ArrayList<String>> results, ArrayList<ArrayList<Character>> result) {
		if (queenNumber == nqueens) {
			ArrayList<String> resultInStrings = null;
			
			System.out.println("vik");
			for(int i=0; i < boardGridSize; i++) {
				resultInStrings = new ArrayList<String>();
				StringBuilder str = new StringBuilder();
				for(int j = 0; j < boardGridSize; j++) {
					str.append(result.get(i).get(j));
				}
				resultInStrings.add(str.toString());
			}
			
			results.add(resultInStrings);
			
			System.out.println(resultInStrings);
			System.out.println();
		} else {
			for(int i=0; i < boardGridSize;i++) {
				for(int j=0; j < boardGridSize; j++) {
					if (true == isSafePosition(boardGridSize, i, j, result)) {

						result.get(i).set(j, 'Q');
						nQueensUtil(8, queenNumber + 1, nqueens, results, result);
						result.get(i).set(j, '.');
					}
				}
			}
		}
	}

	private boolean isSafePosition(int boardGridSize, int x, int y, ArrayList<ArrayList<Character>> result) {
		int length = boardGridSize;
		for(int i=0; i < length; i++) {
			for(int j=0;j<length;j++) {
				if (result.get(i).get(j).charValue() == 'Q') {
					if (i == x || j == y || Math.abs(i - y) == Math.abs(i - x)) return false;
				}
			}	
		}
		
		return true;
	}
}
