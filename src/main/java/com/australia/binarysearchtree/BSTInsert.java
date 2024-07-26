package com.australia.binarysearchtree;

class BSTInsert {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        // insert into the right subtree
        if (val > root.data) root.right = insertIntoBST(root.right, val);
            // insert into the left subtree
        else root.left = insertIntoBST(root.left, val);
        return root;
    }

    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            // insert into the right subtree
            if (val > node.data) {
                // insert right now
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root; // (or) break;
                }
                else node = node.right;
            }
            // insert into the left subtree
            else {
                // insert right now
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root; // (or) break;
                }
                else node = node.left;
            }
        }
        return new TreeNode(val);
    }
}