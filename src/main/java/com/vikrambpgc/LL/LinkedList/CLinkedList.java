package com.vikrambpgc.LL.LinkedList;
public class CLinkedList {
	public CListNode head;
	
	public CLinkedList(CListNode node) {
		head = node;
		head.setNext(head);
	}
	
	public static void main(String[] args) {
		CLinkedList ll = new CLinkedList(new CListNode(1));
		ll.add(new CListNode(2));
		ll.add(new CListNode(3));
		ll.add(new CListNode(4));	
		System.out.println("Add operations:");
		ll.printLinkedList();

		ll.add(new CListNode(5), 3);
		ll.add(new CListNode(6), 1);
		ll.add(new CListNode(7), ll.getLength() + 1);		
		System.out.println("Insert at start, mid & end operations:");
		ll.printLinkedList();
		
	}
	public void add(CListNode addNode, int position) {
		CListNode prevNode = head;
		int length = getLength();
		int count = 1;
		
		if(position < 1 || position > (length+1)) {
			System.out.println("Invalid");
		} else {
			if (position == 1) {			
				prevNode = head.getNext();
				while(prevNode.getNext() != head) {
					prevNode = prevNode.getNext();
				}
				addNode.setNext(head);
				this.head = addNode;
				prevNode.setNext(head);
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
	
	public void add(CListNode addNode) {
		CListNode node = head;
		
		if (head == null) {
			head = addNode;
			head.setNext(head);
			return;
		}
		while(node.getNext() != head) node = node.getNext();
		
		node.setNext(addNode);
		addNode.setNext(head);
		
		return;
	}
	
	public void printLinkedList() {
		if(head == null) {
			System.out.println("The List is empty");
		} else {
			CListNode node = head.getNext();
			while(node != head) {
				System.out.print(node.getData()+"->");
				node = node.getNext();
			}
			System.out.format("head(%d)", head.getData());
			System.out.println();
		}
	}
	
	public int getLength() {
		int count=1;
		
		if (head == null) return 0;
		
		CListNode node = head.getNext();
		while(node != head) {
			count++;
			node = node.getNext();
		}
		
		return count;
	}
}