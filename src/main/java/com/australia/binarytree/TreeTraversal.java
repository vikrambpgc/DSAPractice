package com.australia.binarytree;

import java.util.*;


public class TreeTraversal {
    public static void bfsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Method to print binary tree level by level
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Print nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");

                // Add children to queue for next level
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Move to next line after each level
            System.out.println();
        }
    }

    public static void dfsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }


        }
    }

    public static void iterativeInorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            // Go as far left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the node and go right
            current = stack.pop();
            System.out.print(current.data + " ");

            current = current.right;
        }
    }

    public static void main(String[] args) {

        TreeNode root = TreeSupplierUtil.getBalancedBinaryTree();
        System.out.println("BFS Traversal:");
        bfsTraversal(root);

        System.out.println("\nDFS Traversal:");
        dfsTraversal(root);
    }
}
