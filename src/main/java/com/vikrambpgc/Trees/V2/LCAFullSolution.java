package com.vikrambpgc.Trees.V2;
public class LCAFullSolution {

    public int lca(TreeNode a, int val1, int val2) {
        TreeNode firstVal = findInTree(a, val1);
        TreeNode secondVal = findInTree(a, val2);
        
        if (firstVal == null || secondVal == null) return -1;
        
        return lcaUtil(a, val1, val2).val;
    }
    
    private TreeNode lcaUtil(TreeNode a, int val1, int val2) {
        if (a == null) return null;
        
        if (a.val == val1 || a.val == val2) return a;
        TreeNode left = lcaUtil(a.left, val1, val2);
        TreeNode right = lcaUtil(a.right, val1, val2);
        
        if (left != null && right != null) return a;
        else return (left != null) ? left : right;
       
    }
    
    private TreeNode findInTree(TreeNode a, int value) {
        TreeNode result = null;
        if (a == null) return null;
        
        if (a.val == value) return a;
        if ((result = findInTree(a.left, value)) != null) return result;
        if ((result = findInTree(a.right, value)) != null) return result;
        
        return null;
    }
}
