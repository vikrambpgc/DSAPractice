package com.vikrambpgc.Trees.V2;
import java.util.Stack;

public class PredecessorSuccessor {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootRight = new TreeNode(3);
        
        root.left = rootLeft;
        root.right = rootRight;
        
        PredecessorSuccessor s1 = new PredecessorSuccessor();
        TreeNode inorderSuccessor = s1.inorderSuccessor(root, rootRight);
        if (null != inorderSuccessor) System.out.println(inorderSuccessor.val);

    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode inorderSuccessorForNode) {
        TreeNode tmp = inorderSuccessorForNode;
        
        if (inorderSuccessorForNode == null) return inorderSuccessorForNode;

        if (tmp.right != null) {
            tmp = tmp.right;
            while(tmp.left != null) tmp = tmp.left;

            return tmp;
        } else {
            Stack<TreeNode> s = new Stack<TreeNode>();
            tmp = root;

            while(true) {
                if (inorderSuccessorForNode.val < tmp.val) {
                    s.push(tmp);
                    tmp = tmp.left;
                } else if (inorderSuccessorForNode.val > tmp.val) {
                    s.push(tmp);
                    tmp = tmp.right;
                }
                else {
                    break;
                }
            }
            
            while(false == s.isEmpty() && tmp != s.peek().left) {
                tmp = s.pop();
            }
            
            if (s.isEmpty() == true) return null;
            
            tmp = s.pop();
        }
        
        if (tmp != null) return tmp;
        return null;
    }
}
