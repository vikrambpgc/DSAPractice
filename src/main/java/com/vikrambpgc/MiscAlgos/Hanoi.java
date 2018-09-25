package com.vikrambpgc.MiscAlgos;

public class Hanoi {

    /**
     * @param args
     * Better to write base case separately then managing edge case with actual code.
     */
    public static void main(String[] args) {
        Hanoi h = new Hanoi();
        h.go(1, 'A', 'B', 'C');
    }
    
    private void go(int n, char fromPeg, char toPeg, char auxPeg) {
        if (n > 0) {
            go(n-1, fromPeg, auxPeg, toPeg);
            System.out.println("Move disk from " + fromPeg + " to " + toPeg);
            go(n-1, auxPeg, toPeg, fromPeg);
        } else {
            return;
        }
    }
}
