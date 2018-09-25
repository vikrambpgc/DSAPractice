package com.vikrambpgc.LL.LinkedListV2;
public class IterativeMergeTwoLists {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null && b == null) return null;
        else if (a == null) return b;
        else if (b == null) return a;
        
        ListNode head = null, mergeTmp = null, tmp = null;
        
        while(a != null && b != null) {
            if (a.val <= b.val) {
                tmp = a;
                a= a.next;
                tmp.next = null;
                
                if (null == head) { 
                    head = tmp;
                    mergeTmp = tmp;
                } else {
                    mergeTmp.next = tmp;
                    mergeTmp = mergeTmp.next;
                }
            } else {
                tmp = b;
                b = b.next;
                tmp.next = null;
                
                if (null == head) {
                    head = tmp;
                    mergeTmp = tmp;
                } else {
                    mergeTmp.next = tmp;
                    mergeTmp = mergeTmp.next;  
                }
            }
        }
        
        while(a != null) {
            mergeTmp.next = a;
            mergeTmp = mergeTmp.next;
            a = a.next;
        }
        
       while(b != null) {
            mergeTmp.next = b;
            mergeTmp = mergeTmp.next;
            b = b.next;
        }

        return head;
    }
}
