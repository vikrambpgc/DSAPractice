package com.australia.binarysearchtree;

import java.util.*;

class ClosestValueInBST {
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.data);
        inorder(root.right, nums);
    }

    public int closestValue(TreeNode root, double target) {
        List<Integer> nums = new ArrayList();
        inorder(root, nums);
        return Collections.min(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
    }

    public int closestValueIterative(TreeNode root, double target) {
        LinkedList<TreeNode> stack = new LinkedList();
        long pred = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();

            if (pred <= target && target < root.data)
                return Math.abs(pred - target) <= Math.abs(root.data - target) ? (int)pred : root.data;

            pred = root.data;
            root = root.right;
        }
        return (int)pred;
    }
}
