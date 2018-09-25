package com.vikrambpgc.Experiements;
import java.util.Scanner;
public class IterativeInput {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // firstProgram();
        // secondProgram();
        // thirdProgram();
         fourthProgram();
    }
    
    public static void firstProgram() {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals("done")) {
                break;
            } else {
                int strLen = s.length();
                
                if (Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(s.charAt(strLen - 1))) {
                    System.out.println(s + ": Yes");
                } else {
                    System.out.println(s + ": No");
                }
            }
        }
        
        sc.close();
    }
    
    public static void secondProgram() {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter string to reverse:");
        
        String input = sc.nextLine();
        
        if (input != null) {
            int strLen = input.length();
            StringBuilder output = new StringBuilder();
            
            for(int i = strLen - 1; i >= 0 ; i--) {
                output.append(input.charAt(i));
            }
            
            System.out.println(output.toString());
        }
        sc.close();
    }
    
    public static void thirdProgram() {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter 'n' to calculate sum of first  n odd positive numbers: ");
        
        int n = sc.nextInt();
        double sum = 0;
        
        //Using Arithmetic progression formula with number of terms 'n', difference 'd'
        //and starting term 'a':
        //Sum = n / 2 (2a + (n-1)d
        sum = (n / 2.0) * (2*1 + (n - 1) * 2);
        
        System.out.println("Sum is: " + sum);
        
        sc.close();
    }
    
    public static void fourthProgram() {
        Scanner sc  = new Scanner(System.in);
        
        while(true) {
            System.out.print("Enter the secret code:");
            
            if (sc.hasNextInt()) {
                break;
            } else {
                sc.nextLine();
                System.out.println("Please enter only an integer as Secret code!");
                System.out.println();
            }
        }    
        
        //53840
        String secretCode = String.valueOf(sc.nextInt());
        sc.nextLine();
        
        while(true) {
            System.out.print("Enter the guess:");
            
            if (sc.hasNextInt()) {
                break;
            } else {
                sc.nextLine();
                System.out.println("Please enter only an integer as Guess!");
                System.out.println();
            }            
        }
        
        //83241
        String guess = String.valueOf(sc.nextInt());
        sc.nextLine();
        
        int outputSum = 0;
        int matchedLetterCount = 0;
        
        for(int i = 0, j = 0; i < secretCode.length() && j < guess.length(); i++,j++) {
            if (secretCode.charAt(i) == guess.charAt(j)) {
                outputSum += Integer.parseInt(Character.toString(secretCode.charAt(i)));
                matchedLetterCount++;
            }
        }
        
        System.out.println("Number of digits matching: " + matchedLetterCount);
        System.out.println("Sum of matched digits: " + outputSum);
                        
        sc.close();
    }
}