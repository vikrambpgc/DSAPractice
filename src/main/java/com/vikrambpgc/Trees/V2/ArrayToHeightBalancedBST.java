package com.vikrambpgc.Trees.V2;
import java.util.List;

public class ArrayToHeightBalancedBST {
	public static void main(String[] args) {

	}
	
	public TreeNode sortedArrayToBST(final List<Integer> a) {
		if (a == null) return null;

	    return sortedArrayToBSTutil(a, 0, a.size() - 1);
	}
	
	private TreeNode sortedArrayToBSTutil(List<Integer> a, int start, int end) {
		
		if (start > end) return null;

		int mid = start + (end - start) / 2;
		
		TreeNode node = new TreeNode(a.get(mid));
		node.left = sortedArrayToBSTutil(a, start, mid - 1);
		node.right = sortedArrayToBSTutil(a, mid + 1, end);
		
		return node;
	}
}
