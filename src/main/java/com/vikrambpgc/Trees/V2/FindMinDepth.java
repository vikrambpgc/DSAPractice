package com.vikrambpgc.Trees.V2;
public class FindMinDepth {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        //TreeNode t3 = new TreeNode(3);
        
        t1.left = t2;
        //t2.right = t3;
        
        System.out.println(new FindMinDepth().minDepth(t1));
    }
          
   /* Function to calculate the minimum depth of the tree */
   public int minDepth(TreeNode a) {
       // Corner case. Should never be hit unless the code is 
       // called on root = NULL
       if (a == null)
           return 0;
 
       // Base case : Leaf Node. This accounts for height = 1.
       if (a.left == null && a.right == null)
          return 1;
 
       // If left subtree is NULL, recur for right subtree
       if (a.left != null)
          return minDepth(a.right) + 1;
 
       // If right subtree is NULL, recur for right subtree
       if (a.right != null)
          return minDepth(a.left) + 1;
 
       return Math.min(minDepth(a.left), minDepth(a.right)) + 1;
   }
}
