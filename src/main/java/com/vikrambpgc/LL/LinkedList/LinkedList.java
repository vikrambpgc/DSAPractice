package com.vikrambpgc.LL.LinkedList;
public class LinkedList {
    public ListNode head;
    
    public LinkedList(ListNode node) {
        head = node;
    }
    
    public LinkedList() {
    }
    
    public static void main(String[] args) {
        ListNode middle;
        
        LinkedList list = new LinkedList(new ListNode(1));
        list.add(new ListNode(2));
        list.add(new ListNode(3));
        list.add(new ListNode(4));    
        System.out.println("Add operations:");
        list.printLinkedList();

        list.add(new ListNode(5), 3);
        list.add(new ListNode(6), 1);
        list.add(new ListNode(7), list.getLength() + 1);        
        System.out.println("Insert at start, mid & end operations:");
        list.printLinkedList();
        
        list = LinkedList.makeSampleLL(10);
        System.out.println("Reverse Linked List Iterative:");
        LinkedList.ReverseLLIterative(list);
        list.printLinkedList();
        
        System.out.println("Reverse Linked List Recursive:");
        list.head = LinkedList.ReverseLLRecursive(list.head);
        list.printLinkedList();
        
        System.out.println("Reverse K-node Linked List:");
        if (list != null) list.head = LinkedList.SwapKNodesLL(list.head, 2);
        list.printLinkedList();
        
        System.out.println("Make a loop:");
        list = LinkedList.makeSampleLL(10);
        LinkedList.makeLoop(list, 3);
        list.printLinkedList(30);
        
        System.out.println("Print Loop statistics:");
        LinkedList.getLoopStatisticsAndRemoveLoop(list);
        list.printLinkedList();
        
        System.out.println("Even or odd:return Middle node");
        list.printLinkedList();
        middle = LinkedList.middleNode(list);
        System.out.println(middle.getData());    
        
        list = LinkedList.makeSampleLL(11);
        list.printLinkedList();
        middle = LinkedList.middleNode(list);
        System.out.println(middle.getData());
        
        System.out.println("Merge sorted lists");
        int[] A = {1,3,5};
        int[] B = {2,4,6};
        list = LinkedList.mergeLinkedLists(A, B, true);
        System.out.print("Merged list:With Space: ");
        list.printLinkedList();
        list = LinkedList.mergeLinkedLists(A, B, false);
        System.out.print("Merged list:No space: ");
        list.printLinkedList();
    }

    public void add(ListNode addNode, int position) {
        ListNode prevNode = head;
        int length = getLength();
        int count = 1;
        
        if(position < 1 || position > (length+1)) {
            System.out.println("Invalid");
        } else {
            if (position == 1) {
                addNode.setNext(head);
                this.head = addNode;
                return;
            } else {
                while(count < (position - 1)) {
                    prevNode = prevNode.getNext();
                    count++;
                }
                    addNode.setNext(prevNode.getNext());
                    prevNode.setNext(addNode);
            }        
        }
    }
    
    public void add(ListNode addNode) {
        ListNode node = head;
        
        if (head == null) {
            head = addNode;
            return;
        }
        while(node.getNext() != null) node = node.getNext();
        
        node.setNext(addNode);
        addNode.setNext(null);
        
        return;
    }
    
    public void printLinkedList() {
        if(head == null) {
            System.out.println("The List is empty");
        } else {
            ListNode node = head;
            while(node != null) {
                System.out.print(node.getData()+"->");
                node = node.getNext();
            }
            System.out.println("null");
        }
    }
    
        public void printLinkedList(int count) {
        if(head == null) {
            System.out.println("The List is empty");
        } else {
            ListNode node = head;
            while(node != null & count != 0) {
                System.out.print(node.getData()+"->");
                node = node.getNext();
                count--;
            }
            System.out.println("null");
        }
    }
    
    public int getLength() {
        int count=0;
        
        if (head == null) return 0;
        
        ListNode node = head;
        while(node != null) {
            count++;
            node = node.getNext();
        }
        
        return count;
    }

    public static LinkedList makeSampleLL(int N) {
        int count = 1;
        LinkedList list = new LinkedList(new ListNode(count));
        
        while(count < N) {
            count++;
            list.add(new ListNode(count));            
        }

        return list;
    }
    
    public static LinkedList makeSampleLL(int[] A) {
        int i=0, length = A.length;
        if(length == 0) return null;
        LinkedList list = new LinkedList(new ListNode(A[i++]));
        while(i < length) {
            list.add(new ListNode(A[i++]));
        }
        return list;
    }
    
    public static void ReverseLLIterative(LinkedList list){
        ListNode prevNode = null, currentNode = null, temp;
        
        if (list == null || list.head == null) return;
        
        prevNode = list.head;
        currentNode = list.head.getNext();
        prevNode.setNext(null);
        
        while(currentNode != null) {
            temp = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = temp;            
        }
        
        list.head = prevNode;
    }
    
    public static ListNode ReverseLLRecursive(ListNode head) {
        ListNode temp, rhead;
        
        if(head == null) return null;
        
        if(head.getNext() == null) return head;
        
        temp = head;
        head = head.getNext();
        
        rhead = ReverseLLRecursive(head);
        
        head.setNext(temp);    
        temp.setNext(null);
        
        return rhead;
    }
    
    public static ListNode SwapKNodesLL(ListNode head, int k) {
        ListNode temp = head, prev = null, rhead = null, rhead2 = null;
        int count = 0;
        while (temp != null & count < k) {
            count++;
            prev = temp;
            temp = temp.getNext();                    
        }
        prev.setNext(null);
        rhead = LinkedList.ReverseLLRecursive(head);
        
        if (temp != null) {
            rhead2 = LinkedList.SwapKNodesLL(temp, k);
            head.setNext(rhead2);
        }
        
        return rhead;    
    }
    
    public static void makeLoop(LinkedList list, int position) {
        int count = 1;
        ListNode node = null, positionNode = null;
        
        if (list != null && list.head != null) {
            node = list.head;
        } else return;
        
        while (node.getNext() != null) {
            if (count == position) {
                positionNode = node;            
            }
            node = node.getNext(); 
            count++;
        }
        
        node.setNext(positionNode);    
    }
    
    public static void getLoopStatisticsAndRemoveLoop(LinkedList list) {
        ListNode temp1, temp2;
        int count;
        
        if (list == null || list.head == null) return;
        
        if(list.head.getNext() == list.head) {
            System.out.println("Loop  at head with length 1");
        }
        
        temp1 = temp2 = list.head;
        
        while (true) {
            temp1 = temp1.getNext();
            if (temp2.getNext() != null) temp2 = temp2.getNext().getNext();
            
            if (temp1 == temp2) break;
        }
        
        if (temp2 != null) {
            temp1 = list.head;
            
            while(temp1.getNext() != temp2.getNext()) {
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            }
            
            System.out.print("Loop exists at " + temp1.getNext().getData() + " ");
            
            temp1 = temp1.getNext();
            temp2 = temp1.getNext();
            
            count = 2;
            while (temp2.getNext() != temp1) {
                temp2 = temp2.getNext();
                count++;
            }
            
            System.out.println("of Length " + count);
            temp2.setNext(null);
        }
    }
    
    public static ListNode middleNode(LinkedList list) {
        ListNode temp1, temp2, prevNode=null, retNode=null;
        
        if(list == null || list.head == null) return null;
        temp1 = temp2 = list.head;
        
        while(temp2 != null && temp2.getNext() != null) {
            prevNode = temp1;
            temp1 = temp1.getNext();
            temp2 = temp2.getNext().getNext();
        }
        
        if (temp2 == null) {
            System.out.print("Even Nodes: middle:");
            retNode = prevNode;
        }
        else if (temp2.getNext() == null) {
            System.out.print("Odd Nodes: middle:");
            retNode = temp1;
        }        
        
        return retNode;
    }
    
    public static LinkedList mergeLinkedLists(int[] A, int[] B, boolean extraSpace){
        LinkedList list1, list2, list = new LinkedList();
        ListNode temp1, temp2;
        
        list1 = LinkedList.makeSampleLL(A);
        list1.printLinkedList();
        list2 = LinkedList.makeSampleLL(B);
        list2.printLinkedList();
        
        temp1 = list1.head;
        temp2 = list2.head;
        
        if (extraSpace) {
                while(temp1 != null && temp2 != null) {
                    if (temp1.getData() < temp2.getData()) {
                        list.add(new ListNode(temp1.getData()));
                        temp1 = temp1.getNext();
                    } else {
                        list.add(new ListNode(temp2.getData()));
                        temp2 = temp2.getNext();
                    }
                }
                
                if(temp1 == null) {
                    while (temp2 != null) {
                        list.add(new ListNode(temp2.getData()));
                        temp2 = temp2.getNext();
                    }
                } else if(temp2 == null) {
                    while (temp1 != null) {
                        list.add(new ListNode(temp1.getData()));
                        temp1 = temp1.getNext();
                    }
                }
                
                
            } else {
                list.head = MergeLLRec(temp1, temp2);
            }
        
        return list;
        }
        
    public static ListNode MergeLLRec(ListNode node1, ListNode node2) {
        ListNode ret;
        
        if (node1 == null && node2 == null) return null;
        else if(node1 == null) return node2;
        else if (node2 == null) return node1;
        
        if (node1.getData() < node2.getData()) {
            node1.setNext(MergeLLRec(node1.getNext(), node2));
            ret = node1;
        } else {
            node2.setNext(MergeLLRec(node1, node2.getNext()));
            ret = node2;
        }
        
        return ret;
    }

}