package com.vikrambpgc.Trees.V2;
public class FlattenTreeNoExtraSpace {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		
		t1 = new FlattenTreeNoExtraSpace().flatten(t1);
		
		while(t1 != null) {
			System.out.print(t1.val + "->");
			t1 = t1.right;
		}
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode flatten(TreeNode a) {
		if (a == null) return null;
		
		TreeNode temp = a;
		while (temp != null) {
			TreeNode rightMostNodeLeft = temp.left;
			
			if (rightMostNodeLeft != null) {
				while(rightMostNodeLeft.right != null) rightMostNodeLeft = rightMostNodeLeft.right;
				rightMostNodeLeft.right = temp.right;
				temp.right = temp.left;
				temp.left = null;
			}
			
			temp = temp.right;
		}

		
		return a;
	}

	public TreeNode flatten2(TreeNode a) {
	    if (a == null) return null;
	    TreeNode left = flatten(a.left);
	    TreeNode right = flatten(a.right);
	    TreeNode returnNode = null;
	    
	    if (left != null) {
	    	a.right = left;
	    	
	        TreeNode temp = a;
	        while(temp.right != null) {
	            temp = temp.right;
	        }
	        temp.right = right;
	        
	        returnNode = a;
	    } else {
	    	a.right = right;
	        returnNode = a; 
	    }
	    
	    return returnNode;
	}
}