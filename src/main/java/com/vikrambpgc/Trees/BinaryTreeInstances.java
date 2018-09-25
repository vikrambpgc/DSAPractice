package com.vikrambpgc.Trees;
public class BinaryTreeInstances {
    private static BinaryTree BALANCED_TREE;
    private static BinaryTree UNBALANCED_TREE;
    private static BinaryTree UNBALANCED_BST;
    
    static {
        BALANCED_TREE = createBalancedTree();
        UNBALANCED_TREE = createUnbalancedTree();
        UNBALANCED_BST = createUnbalancedBST();
    }
    
    public static BinaryTree getBalancedTree() {
        return BALANCED_TREE;
    }
    
    public static BinaryTree getUnbalancedTree() {
        return UNBALANCED_TREE;
    }
    
    public static BinaryTree getUnbalancedBST() {
        return UNBALANCED_BST;
    }
    
    private static BinaryTree createBalancedTree() {
        BinaryTree btree = new BinaryTree();
        btree.root = btree.insert(btree.root, new TreeNode(1));
        btree.root = btree.insert(btree.root, new TreeNode(2));
        btree.root = btree.insert(btree.root, new TreeNode(3));
        btree.root = btree.insert(btree.root, new TreeNode(4));
        btree.root = btree.insert(btree.root, new TreeNode(5));
        btree.root = btree.insert(btree.root, new TreeNode(6));
        btree.root = btree.insert(btree.root, new TreeNode(7));
        
        return btree;
    }
    
    private static BinaryTree createUnbalancedTree() {
        BinaryTree btree = new BinaryTree();
        
        btree.root = new TreeNode(1);
        btree.root.setLeft(new TreeNode(2));
        btree.root.setRight(new TreeNode(3));
        btree.root.getLeft().setLeft(new TreeNode(4));
        btree.root.getRight().setLeft(new TreeNode(6));
        btree.root.getRight().setRight(new TreeNode(7));
        
        return btree;
    }
    
    private static BinaryTree createUnbalancedBST() {
        BinaryTree btree = new BinaryTree();
        
        btree.root = new TreeNode(6);
        btree.root.setLeft(new TreeNode(4));
        btree.root.setRight(new TreeNode(10));
        btree.root.getLeft().setLeft(new TreeNode(1));
        btree.root.getLeft().setRight(new TreeNode(5));
        btree.root.getLeft().getLeft().setRight(new TreeNode(3));
        btree.root.getRight().setLeft(new TreeNode(7));
        btree.root.getRight().setRight(new TreeNode(15));
        
        return btree;
    }
}
