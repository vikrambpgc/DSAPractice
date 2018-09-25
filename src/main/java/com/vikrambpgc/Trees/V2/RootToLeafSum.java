package com.vikrambpgc.Trees.V2;

public class RootToLeafSum {

	public RootToLeafSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		TreeNode t1 = ExampleTrees.getInstance().getSimpleTree();
		System.out.println(new RootToLeafSum().hasPathSum(t1, 1000));

	}
	
	public int hasPathSum(TreeNode a, int b) {
		
		if (a == null) return 0;
	
		b = b - a.val;

		//Only leaves. Not one child nodes.
	    if (a.left == null && a.right == null) {
	        if (b == 0) return 1;
	        else return 0;
	    }
	     
        return hasPathSum(a.left, b) |  hasPathSum(a.right, b);
	    
	}

}
