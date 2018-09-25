package com.vikrambpgc.LL.LinkedList;
public class RandomPointer {
    
    private static class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
    };
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        RandomListNode one, two, three, temp1, temp2;
        
        one = new RandomListNode(1);
        two = new RandomListNode(2);
        three = new RandomListNode(3);
        
        one.next = two;
        two.next = three;
        three.next = null;
        
        one.random = three;
        three.random = two;
        two.random = null;
        
        RandomListNode cloneOne = copyRandomList(one);
        
        temp1 = one;
        temp2 = cloneOne;
        while (temp1 != null) {
            System.out.println("Address: "+temp1+":"+temp2);
            System.out.println("Data: "+temp1.label+":"+temp2.label);
            System.out.println("Next: "+temp1.next+":"+temp2.next);
            System.out.println("Random: "+temp1.random+":"+temp2.random);
            System.out.println();
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
    }
    
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cloneHead = null, current = head, cloneCurrent;
        
        while(current != null) {
            cloneCurrent = new RandomListNode(current.label);
            cloneCurrent.next = current.random;
            cloneCurrent.random = current.random;
            current.random = cloneCurrent;
            
            current = current.next;
        }
        
        current = head;
        if (head != null) cloneHead = head.random;
        
        while(current != null) {
            cloneCurrent = current.random;
            if (cloneCurrent.random != null) {
                cloneCurrent.random = cloneCurrent.random.random;
            }
            
            current = current.next;
        }
        
        //Repairing original
        current = head;
        while(current != null) {
            cloneCurrent = current.random;
            current.random = cloneCurrent.next;
            if (current.next != null) {
                cloneCurrent.next = current.next.random;
            } else {
                cloneCurrent.next = null;
            }
            
            current = current.next;
        }
        
        return cloneHead;
    }
}
