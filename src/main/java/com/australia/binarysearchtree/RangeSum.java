package com.australia.binarysearchtree;

import java.util.Stack;

class RangeSum {

    //iterative
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.data && node.data <= high)
                    ans += node.data;
                if (low < node.data)
                    stack.push(node.left);
                if (node.data < high)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
