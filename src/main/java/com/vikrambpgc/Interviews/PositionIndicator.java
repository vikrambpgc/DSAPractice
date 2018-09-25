package com.vikrambpgc.Interviews;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class PositionIndicator {
	
	public static void pos(String[] args) {
		int i;
		
		 
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vikramc\\Documents\\SampleInput.txt"));
			PrintWriter writer = new PrintWriter("C:\\Users\\vikramc\\Documents\\SampleOutput.txt", "UTF-8");			
			String sCurrentLine;
			
			for(i=1;i<7;i++) {
				writer.print("         "+i);
			}
			writer.println();
			
			for(i=1;i<7;i++) {
				writer.print("1234567890");
			}
			writer.println();
			writer.println("Designed by:Vikram Chunduru");
			
			i=1;
			while ((sCurrentLine = br.readLine()) != null) {
				writer.print(i+" ");
				writer.println(sCurrentLine);
				i++;
			}
			writer.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}

