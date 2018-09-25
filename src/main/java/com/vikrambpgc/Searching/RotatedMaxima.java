package com.vikrambpgc.Searching;

public class RotatedMaxima {

    /**
     * @param args
     */
    
    static {
        System.out.println("Vikram");
    }
    
    public static void main(String[] args) {
        int[] input = {22, 30, 35, 1, 2, 3, 9, 10, 12, 19};
        
        //int[][] input1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        //fizzBuzz(1, 100);
        
        //rotatedMaxima(input);
        
        //modifyMatrix(input1, 3, 4);
        
    }
    
    public static void modifyMatrix(int[][] A, int rows, int columns) {
        int i, j;
        int[][] B = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        
        for (i=0;i< rows;i++) {
            for(j=0;j<columns;j++) {
                    B[i][j] = A[(i+2) % rows][columns - j - 1];    
            }
        }
        
        for (i=0;i< rows;i++) {
            for(j=0;j<columns;j++) {
                System.out.print(B[i][j]+ " ");
            }
        }
    }
    
    public static void rotatedMaxima(int[] a) {
        int start, end, mid, result = 0, length;
        
        if (a == null) return;
        start = 0;
        end = a.length - 1;
        
        while(start<=end) {
            
            mid = start + (end - start) / 2;
            length =  end - start + 1;
            
            if (length == 1) {
                result = a[start];
                break;
            } else if (length == 2) {
                if (a[start] > a[end]) result = a[start];
                else result = a[end];
                break;
            }
            
            if (a[start] <= a[end]) {
                result = a[end];
                break;
            }
            
            if (a[start] >= a[mid] && a[mid] <= a[end]) {
                end = mid;
            } else if (a[start] <= a[mid] && a[mid] >= a[end]) {
                start = mid;
            }
        }
        
        System.out.println("answer:"+ result);
    }
    
    public static void fizzBuzz(int start, int end) {
        int i;
        boolean divBy3 = false, divBy5 = false;
        final String fizz = "Fizz";
        final String buzz = "Buzz";
        final String fizzBuzz = "FizzBuzz";
        
        
        for (i = start;i<=end;i++) {
            
            if (i % 3 == 0) divBy3 = true;
            else divBy3 = false;
            
            if (i % 5 == 0) divBy5 = true;
            else divBy5 = false;
                    
            if (divBy3 == true && divBy5 == true) {
                System.out.println(i + ":" + fizzBuzz);
            } else if (divBy3 == true) {
                System.out.println(i + ":" + fizz);
            } else if (divBy5 == true) {
                System.out.println(i + ":" + buzz);
            }
        }
    }
}
