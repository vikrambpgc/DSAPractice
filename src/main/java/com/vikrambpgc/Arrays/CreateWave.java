package com.vikrambpgc.Arrays;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class CreateWave {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(5,1,4,3,2);
 
        System.out.println(new CreateWave().wave(a));
    }
    
    public List<Integer> wave(List<Integer> A) {
        
        Collections.sort(A);
        int n = A.size();
        
        for (int i = 2; i <= n; i += 2) {
            exch(A, i - 2, i - 1);
        }
        
        return A;
        
    }
    
    private void exch(List<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

}
