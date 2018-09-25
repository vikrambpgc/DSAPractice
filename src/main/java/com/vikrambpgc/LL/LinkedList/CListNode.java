package com.vikrambpgc.LL.LinkedList;
public class CListNode {
	private int data;
	private CListNode next;
	
	public CListNode(int data) {
		this.data = data;
		this.setNext(this);
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public CListNode getNext() {
		return this.next;
	}
	
	public void setNext(CListNode next) {
		this.next = next;
	}
}
