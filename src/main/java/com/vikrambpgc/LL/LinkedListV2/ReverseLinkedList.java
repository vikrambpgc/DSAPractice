package com.vikrambpgc.LL.LinkedListV2;

public class ReverseLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static ListNode ReverseLLRecursiveM2(ListNode head) {
        ListNode temp, rhead;
        
        if(head == null) return null;
        
        if(head.next == null) return head;
        
        temp = head;
        head = head.next;
        
        rhead = ReverseLLRecursiveM2(head);
        
        head.next = temp;    
        temp.next = null;
        
        return rhead;
    }

    public ListNode reverseListRecursiveM1(ListNode a) {
        return reverseListRecursiveM1Util(null, a);
    }
    
    public ListNode reverseListRecursiveM1Util(ListNode prev, ListNode head) {
        
        if (head == null) return null;
        
        ListNode tmp = head.next;
   
        if (tmp == null) {
            head.next = prev;
            
            return head;
        }
        
        
        head.next = prev;
            
        return reverseListRecursiveM1Util(head, tmp);
    }

}
