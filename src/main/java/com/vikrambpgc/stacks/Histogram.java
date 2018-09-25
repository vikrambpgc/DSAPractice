package com.vikrambpgc.stacks;
import java.util.*;

public class Histogram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {3,2,5,6,1,4,4,4};
        System.out.println("Max area in Histogram:" + maxAreaInHistogram(A));
    }
    
    public static int maxAreaInHistogram(int[] A) {
        final class StackItem {
            int data;
            int index;
            
            StackItem(int data, int index) {
                this.data = data;
                this.index = index;
            }
        }
        
        int inputLen = A.length, rightArea = 0, leftArea = 0, maxArea = 0, maxI = 0;
        StackItem temp;
        
        Stack<StackItem> s = new Stack<StackItem>();
        s.push(new StackItem(Integer.MIN_VALUE, -1));
        
        for(int i=0;i <= inputLen;i++) {
            StackItem cur = new StackItem((i== inputLen? Integer.MIN_VALUE:A[i]), i);
            
            if (cur.data > s.peek().data) {
                s.push(cur);
                continue;
            }
            
            temp = s.peek();
            while (s.size() > 1 && temp.data > cur.data) {
                rightArea = (cur.index - temp.index) * temp.data;
                leftArea = (temp.index - s.get(s.size() - 2).index - 1) * temp.data;
                
                if (maxArea < (leftArea + rightArea)) {
                    maxArea = leftArea + rightArea;
                    maxI = temp.index;
                }
                
                s.pop();
                temp = s.peek();
            }
            
            s.push(cur);
        }
        
        System.out.println("maxI:"+maxI);
        return maxArea;
    }
}
