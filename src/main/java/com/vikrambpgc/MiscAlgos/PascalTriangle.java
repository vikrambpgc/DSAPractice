package com.vikrambpgc.MiscAlgos;
public class PascalTriangle {
    public static void main(String args[]) {
        int n = 5;
        Integer pas[][] = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pas[i][j] = 0;
            }
        }
        pas[0][n - 1] = 1;
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
                if (i - 1 >= 0) {
                    pas[i][j] += pas[i - 1][j];
                }
                if (i - 1 >= 0 && j + 1 < n) {
                    pas[i][j] += pas[i - 1][j + 1];
                }
                if(pas[i][j] != 0)
                    System.out.print(pas[i][j]);

            }
        }
    }
}
