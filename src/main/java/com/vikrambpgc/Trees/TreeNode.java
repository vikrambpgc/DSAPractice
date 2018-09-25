package com.vikrambpgc.Trees;

public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int data) {
		this.setData(data);
		this.setLeft(null);
		this.setRight(null);
	}
	
	public TreeNode() {
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setLeft(TreeNode node) {
		this.left = node;
	}
	
	public TreeNode getLeft() {
		return this.left;
	}
	
	public void setRight(TreeNode node) {
		this.right = node;
	}
	
	public TreeNode getRight() {
		return this.right;
	}
}
