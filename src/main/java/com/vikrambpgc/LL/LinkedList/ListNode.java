package com.vikrambpgc.LL.LinkedList;
public class ListNode {
    private int data;
    private ListNode next;
    private ListNode random;
    
    public ListNode(int data) {
        this.data = data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public int getData() {
        return this.data;
    }
    
    public ListNode getNext() {
        return this.next;
    }
    
    public void setNext(ListNode next) {
        this.next = next;
    }
    
        public ListNode getRandom() {
        return this.random;
    }
    
    public void setRandom(ListNode random) {
        this.random = random;
    }
}