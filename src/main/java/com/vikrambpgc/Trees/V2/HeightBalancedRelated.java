package com.vikrambpgc.Trees.V2;
public class HeightBalancedRelated {
    
    int balanced = 1;
    
	public int isBalanced(TreeNode A) {
	    
	    balanced(A);
	    return balanced;
	    
	}
	
	public int balanced(TreeNode A) {
	    
	    if (A == null)
	        return 0;
	        
	    int heightLeft = 1 + balanced(A.left);
	    int heightRight = 1 + balanced(A.right);
	    
	    if (Math.abs(heightLeft - heightRight) > 1)
	        balanced = 0;
	    
	    return Math.max(heightLeft, heightRight);
	    
	}
}
