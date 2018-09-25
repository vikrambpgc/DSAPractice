package com.vikrambpgc.Trees.V2;
import java.util.Stack;

public class InorderIterator {
    
    private Stack<TreeNode> stack;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootRight = new TreeNode(3);
        
        root.left = rootLeft;
        root.right = rootRight;
        
        InorderIterator s1 = new InorderIterator(root);
        while (s1.hasNext()) System.out.print(s1.next());
    }

    public InorderIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        
        if (!hasNext()) {
            return -1;
        }
        
        TreeNode node;
        node = stack.pop();
        int val = node.val;
        
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    
        return val;
        
    }
}
