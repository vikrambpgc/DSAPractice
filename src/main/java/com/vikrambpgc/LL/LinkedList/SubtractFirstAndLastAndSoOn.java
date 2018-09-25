package com.vikrambpgc.LL.LinkedList;
public class SubtractFirstAndLastAndSoOn {
    //Definition for singly-linked list.
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        
        ListNode a = new ListNode(1);
        ListNode b =  new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        SubtractFirstAndLastAndSoOn sol = new SubtractFirstAndLastAndSoOn();
        sol.subtract(a);
        sol.printLL(a);
        
    }
    
    public ListNode subtract(ListNode a) {
        ListNode startNode = a, middleNode = findMiddleNode(a), startOfSecondHalfNode = middleNode.next;
        
        middleNode.next = null;

        ListNode reverseHead = reverseLL(startOfSecondHalfNode);
        
        ListNode tmp = reverseHead;
        
        while(tmp != null) {
            startNode.val = tmp.val - startNode.val;
            startNode = startNode.next;
            tmp = tmp.next;
        }
        
        startOfSecondHalfNode = reverseLL(reverseHead);
        middleNode.next = startOfSecondHalfNode;

        return a;
    }
    
    public ListNode findMiddleNode(ListNode a) {
        if (null == a) return a;
        ListNode tmp1=a, tmp2=a;
        
        while(tmp2.next != null && tmp2.next.next != null) {
            tmp1 = tmp1.next;
            tmp2= tmp2.next.next;
        }
        
        return tmp1;
    }
    
    public ListNode reverseLL(ListNode a) {
        ListNode prev = null, tmp1 = a, tmp2 = null;
        
        while (tmp1 != null) {
            tmp2 = tmp1.next;
            tmp1.next = prev;
            prev = tmp1;
            tmp1 = tmp2;
        }
        
        return prev;
    }
    
    public void printLL(ListNode a) {
        for(ListNode tmp = a; tmp != null;tmp = tmp.next) System.out.print(tmp.val + "->");
        System.out.println();
    }
}
