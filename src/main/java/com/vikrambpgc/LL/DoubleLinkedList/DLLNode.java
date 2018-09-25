package com.vikrambpgc.LL.DoubleLinkedList;

public class DLLNode<E> {
	private E key;
	private DLLNode next;
	private DLLNode prev;
	
	public void setKey(E key) {
		this.key = key;
	}
}
