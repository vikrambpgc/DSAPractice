package com.vikrambpgc.Heaps;
//Implementing a Min PQ
public class PriorityQueue {

	private int[] A;
	private int capacity;
	private int count;
	
	public PriorityQueue(int capacity) {
		this.capacity = capacity;
		this.A = new int[capacity];
	}
	public static void main(String[] args) {
		PriorityQueue ex = new PriorityQueue(5);
		ex.insert(40);
		ex.insert(30);
		ex.insert(10);
		ex.insert(20);
		ex.insert(5);
		
		System.out.println(ex.getMin());
		
		// TODO Auto-generated method stub

	}
	
	private int leftChild(int i) {
		if (i >=  count || i < 0) return -1;
		int temp;
		
		temp =  2*i - 1;
		if (temp < count) return temp;
		else return -1;
	}
	
	private int rightChild(int i) {
		if (i >=  count || i < 0) return -1;
		int temp;
		
		temp =  2*i + 1;
		if (temp < count) return temp;
		else return -1;
	}
	
	private int parent(int i) {
		int temp = 0;
		if (i >=  count || i < 0) return -1;
		temp = (i - 1) / 2;
		
		if (temp<0) return -1;
		
		return temp;
	}
	
	public void percolateDown(int i) {
		if (i >=  count || i < 0) return;
		int max = i, leftChild, rightChild, temp = 0;
		
		leftChild = leftChild(i);
		rightChild = rightChild(i);
		
		if (leftChild != -1 && A[i] < A[leftChild]) {
			max = leftChild;
		}
		
		if (rightChild != 1 && A[max] < A[rightChild]) {
			max = rightChild;
		}
		
		A[temp] = A[max];
		A[max] = A[i];
		A[i] = A[temp];
		
		percolateDown(max);
	}
	
	public void insert(int data) {
		int i;
		
		count++;
		
		i = count - 1;
		while(i>0 && parent(i) != -1 && data < A[(i-1)/2]) {
			A[i] = A[(i-1)/2];
			i = (i-1)/2;
		}
		
		this.A[i] = data;
	}
	
	public int getMin() {
		if (count < 0) return -1;
		return A[0];
	}
}
