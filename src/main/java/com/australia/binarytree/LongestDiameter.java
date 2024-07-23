package com.australia.binarytree;

import apple.laf.JRSUIUtils;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    int depth;
    int diameter;

    Pair(int depth, int diameter) {
        this.depth = depth;
        this.diameter = diameter;
    }
}

public class LongestDiameter  {
    public static void main(String[] args) {

        int longestDiameter = new LongestDiameter().diameterOfBinaryTree(
                TreeSupplierUtil.getBalancedBinaryTree());
        System.out.println(longestDiameter);
    }

    private int diameterOfBinaryTree(TreeNode root) {
        Pair resultPair = diameterOfBinaryTreeHelper(root);
        return resultPair.diameter;
    }

    public Pair diameterOfBinaryTreeHelper(TreeNode node) {
        if (node == null) return new Pair(0,0);

        Pair pairLeft = diameterOfBinaryTreeHelper(node.left);
        Pair pairRight = diameterOfBinaryTreeHelper(node.right);

        int currDepth = Math.max(pairLeft.depth, pairRight.depth) + 1;
        int currMaxDiameter = Math.max(Math.max(pairLeft.diameter, pairRight.diameter),
                pairLeft.depth + pairRight.depth);
        return new Pair(currDepth, currMaxDiameter);
    }
}
