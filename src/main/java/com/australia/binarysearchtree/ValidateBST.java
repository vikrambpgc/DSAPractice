package com.australia.binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ValidateBST {
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }

        // The current node's value must be between low and high.
        if (
                (low != null && root.data <= low) ||
                        (high != null && root.data >= high)
        ) {
            return false;
        }

        // The left and right subtree must also be valid.
        return (
                validate(root.right, root.data, high) &&
                        validate(root.left, low, root.data)
        );
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}

class Solution {
    private Deque<TreeNode> stack = new LinkedList();
    private Deque<Integer> upperLimits = new LinkedList();
    private Deque<Integer> lowerLimits = new LinkedList();

    public void update(TreeNode root, Integer low, Integer high) {
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }

    public boolean isValidBST(TreeNode root) {
        Integer low = null, high = null, val;
        update(root, low, high);

        while (!stack.isEmpty()) {
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();

            if (root == null) continue;
            val = root.data;
            if (low != null && val <= low) {
                return false;
            }
            if (high != null && val >= high) {
                return false;
            }
            update(root.right, val, high);
            update(root.left, low, val);
        }
        return true;
    }
}

class InOrderSolution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (prev != null && root.data <= prev) {
                return false;
            }
            prev = root.data;
            root = root.right;
        }
        return true;
    }
}
