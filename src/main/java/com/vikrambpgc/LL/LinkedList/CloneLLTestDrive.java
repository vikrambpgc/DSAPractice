package com.vikrambpgc.LL.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class CloneLLTestDrive {
	public static void main(String[] args) {
		ListNode onode1 = new ListNode(1);
		ListNode onode2 = new ListNode(2);
		ListNode onode3 = new ListNode(3);
		
		LinkedList list1 = new LinkedList(onode1);
		list1.add(onode2);
		list1.add(onode3);
		
		onode1.setRandom(onode3);
		onode2.setRandom(onode1);
		onode3.setRandom(onode2);

        list1.printLinkedList();

		LinkedList list2 = CloneLLTestDrive.cloneLinkedList(list1);		
		list2.printLinkedList();
		System.out.println(list2.head.getRandom().getData()+" "+list2.head.getNext().getRandom().getData());
		
		list2 = CloneLLTestDrive.cloneLinkedListUsingHashMap(list1);	
		System.out.println("Using HashMap:");
		list2.printLinkedList();
		System.out.println(list2.head.getRandom().getData()+" "+list2.head.getNext().getRandom().getData());
	}
	
	public static LinkedList cloneLinkedList(LinkedList list) {
			ListNode clonedHead;
			ListNode origHead = list.head;			
			ListNode onode, cnode;
			
			onode = origHead;
			while(onode != null) {
				ListNode temp = new ListNode(onode.getData());
				temp.setNext(onode.getRandom());
				onode.setRandom(temp);
				
				onode = onode.getNext();
			}
						
			
			onode = origHead;
			clonedHead = onode.getRandom();
			while(onode != null) {
				cnode = onode.getRandom();
				cnode.setRandom(cnode.getNext().getRandom());				
				onode = onode.getNext();
			}
			
			onode = origHead;
			while(onode != null) {
				cnode = onode.getRandom();
				onode.setRandom(cnode.getNext());
				if (onode.getNext() != null) {
					cnode.setNext(onode.getNext().getRandom());
				} else {
					cnode.setNext(null);
				}
				
				onode = onode.getNext();
			}
			
			return new LinkedList(clonedHead);
	}


	public static LinkedList cloneLinkedListUsingHashMap(LinkedList list) {
		Map<ListNode, ListNode> m = new HashMap<ListNode, ListNode>();
		
		ListNode X = list.head, Y;
		
		while(X != null) {
			Y = new ListNode(X.getData());
			Y.setNext(null);
			Y.setRandom(null);
			m.put(X,Y);
			
			X = X.getNext();
		}
		
		X = list.head;
		while(X != null) {
			Y = m.get(X);
			Y.setNext(m.get(X.getNext()));
			Y.setRandom(m.get(X.getRandom()));
			
			X = X.getNext();
		}
		
		return new LinkedList(m.get(list.head));
	}
}