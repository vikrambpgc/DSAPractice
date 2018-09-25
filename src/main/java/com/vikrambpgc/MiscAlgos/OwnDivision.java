package com.vikrambpgc.MiscAlgos;

public class OwnDivision {
    
    private static class DivisionResults {
        public DivisionResults() {
            this.Quotient = 0;
            this.Remainder = 0;
        }
        int Quotient;
        int Remainder;
    }
    
    public static void main(String[] args) {
        divide(40, 4);
    }
    
    public static void divide(int dividend, int divisor) {
            DivisionResults results = new DivisionResults();
            divisionHelper(dividend, divisor, results);
            System.out.println("Quotient:"+results.Quotient+","+"Remainder:"+results.Remainder);        
    }
    
    private static void divisionHelper(int dividend, int divisor, DivisionResults results) {
        int answer = 1;
        int denom = divisor;
        
        if (denom > dividend) {
            results.Quotient += 0;
            results.Remainder += dividend;
            return;
        } 
        if (denom == dividend) {
            results.Quotient += 1;
            results.Remainder = 0;
            return;
        }
        
        while(dividend >= denom) {
            denom <<= 1;
            answer <<= 1;    
        }
        
        denom >>= 1;
        answer >>= 1;
        
        results.Quotient += answer;
        results.Remainder += 0;
        dividend = dividend - denom;
        divisionHelper(dividend, divisor, results);
        
        return;
    }
}    
