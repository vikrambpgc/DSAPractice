package com.vikrambpgc.Experiements;
import java.io.*;
import java.util.Scanner;

public class Solution {
	public static void main(String args[] ) throws Exception {
	    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		//in.nextLine();
		for (int testCaseNumber = 0; testCaseNumber < T; testCaseNumber++) {
			int N = in.nextInt();
			//in.nextLine();
			int maxExitTime = 0;
			
			int[][] entryExitArray = new int[N][2];
			//Get the data and store
			for(int i=0;i<N;i++) {
				entryExitArray[i][0] = in.nextInt();
				entryExitArray[i][1]  = in.nextInt();
				//in.nextLine();
				maxExitTime = Math.max(maxExitTime, entryExitArray[i][1]);
			}

			int personsAtAnyTime = 0;
			int maxPersonsAtAnyTime = 0;
			for(int i=1;i<=maxExitTime;i++) {
				for(int j=0;j<N;j++) {
					if (entryExitArray[j][0] == i) {
						personsAtAnyTime++;
						maxPersonsAtAnyTime = Math.max(personsAtAnyTime, maxPersonsAtAnyTime);
					}
				}
				for(int j=0;j<N;j++) {
					if (entryExitArray[j][1] == i) personsAtAnyTime--;
				}
			}
			System.out.println(maxPersonsAtAnyTime);
		}
	}
}
