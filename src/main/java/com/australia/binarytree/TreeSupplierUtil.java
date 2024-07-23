package com.australia.binarytree;

public class TreeSupplierUtil {


    // Create an unbalanced binary tree
    public static TreeNode getBalancedBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //root.left.left = new Node(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        // root.right.right = new Node(7);

        return root;
    }
}
