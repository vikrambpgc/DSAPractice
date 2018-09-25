package com.vikrambpgc.Trees;
import java.util.*;
public class MyTraverseTreeAndReturnListContainingAllNodes {
    
    private static class Node {
        String label;
        List<Node> children;
        
        Node(String label) {
            this.label = label;
            this.children = new ArrayList<Node>();
        }
    }

     public static List<Node> traverseTreeAndReturnListContainingAllNodes(Node n) {
        if (n == null) return null;
        List<Node> result = new ArrayList<Node>();
        
        traverseTreeRecursiveUtil(n, result);
        
        return result;
    }
     
     public static void traverseTreeRecursiveUtil(Node n, List<Node> result) {
         if (n == null) return;
         
         result.add(n);
         
         for(Node temp:n.children) {
             traverseTreeRecursiveUtil(temp, result);
         }
     }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int result;
        
        //result = findCommonLargest(new ArrayList(Arrays.asList(1, 10, 7, 8, 3)), new ArrayList(Arrays.asList(-10, 1, 4, 7, 13)));
        //System.out.println("Answer is: "+result);
        
        List<Node> answer;
        Node n1,n2,n3,n4,n5,n6,n7,n8,n9;
        n9 = new Node("9");
        n8 = new Node("8");
        n7 = new Node("7");
        n6 = new Node("6");
        n5 = new Node("5");
        n4 = new Node("4");
        n3 = new Node("3");
        n2 = new Node("2");
        n1 = new Node("1");
        
        n7.children.add(n9);
        n4.children.add(n6);
        n4.children.add(n7);
        n5.children.add(n8);
        n2.children.add(n5);
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        
        
        answer = traverseTreeAndReturnListContainingAllNodes(n1);
        
        for(Node temp: answer) {
            System.out.print(temp.label);
        }
        
        
    }
    
    /*
     * Time complexity of the algorithm is O(NlogN) + O(NlogN) + O(N) ~ O(NlogN)
     * First two O(NlogN)s' are for sorting & last O(N) is for finding the common Largest number.
     */
    public static int findCommonLargest(List<Integer> list1, List<Integer> list2) {
        int commonLargest = 0, i, j;

        if (list1.size() == 0 || list2.size() == 0) return -1;
        
        mergeSortUtil(list1);
        mergeSortUtil(list2);
        
        /*
         * Even though a while loop is inside of for loop, the order of this
         * block is O(N) only and NOT O(N^2) because list2 is traversed only once.
         * 
         * This algo will return -1 if there is no Common Largest element.
         */
        for (i = list1.size() - 1, j = list2.size() - 1; i>=0 & j>=0;) {
            while (j>=0 && list1.get(i) <  list2.get(j)) {
                j--;
            }
            
            if (j < 0) return -1;
            
            if (list1.get(i) ==  list2.get(j)) {
                commonLargest = list1.get(i);
                break;
            } else {
                i--;
            }
        }
        
        if (i < 0 || j < 0) return -1;
        
        return commonLargest;
    }
    
    public static void mergeSortUtil(List<Integer> list) {
        int[] result = new int[list.size()];
        
        mergeSort(list, 0, list.size() - 1, result);
    }
    public static void mergeSort(List<Integer> list, int start, int end, int[] result) {
        int mid = start + (end - start) / 2;
        
        if ((end - start + 1) <= 1) return;
        
        mergeSort(list, 0, mid, result);
        mergeSort(list, mid + 1, end, result);
        
        merge(list, start, mid, end, result);
    }
    
    public static void merge(List<Integer> list, int start, int mid, int end, int[] result) {
        int i = start, k = start, j = mid + 1;
        
        while (i <= mid && j <= end) {
            if (list.get(i) < list.get(j)) {
                result[k] = list.get(i);
                k++;
                i++;
            } else {
                result[k] = list.get(j);
                k++;
                j++;
            }
        }
        
        while (i<=mid) {
            result[k] = list.get(i);
            k++;
            i++;
        }
        
        while(j<=end) {
            result[k] = list.get(j);
            k++;
            j++;
        }
        
        for (i=start;i<=end;i++) {
            list.set(i, result[i]);
        }
    }
}
 