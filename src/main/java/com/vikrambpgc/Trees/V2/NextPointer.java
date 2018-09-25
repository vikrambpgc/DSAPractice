package com.vikrambpgc.Trees.V2;
import java.util.LinkedList;
import java.util.Queue;

public class NextPointer {
    //Definition for binary tree with next pointer.
    public static class TreeNextPointerNode {
        int val;
        TreeNextPointerNode left, right, next;
        TreeNextPointerNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNextPointerNode root = new TreeNextPointerNode(1);
        new NextPointer().connect2(root);
    }

    //With stack
    public void connect1(TreeNextPointerNode root) {
        Queue<TreeNextPointerNode> queue = new LinkedList<TreeNextPointerNode>();
        
        if (root == null) return;
        
        queue.add(root);
        queue.add(null);
        
        while (false == queue.isEmpty()) {
            TreeNextPointerNode temp = queue.remove();
            
            if (temp == null) {
                if (false == queue.isEmpty()) {
                    queue.add(null);
                } else break;
                
                continue;
            }
            
            temp.next = queue.peek();
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    //With constant space.
    public void connect2(TreeNextPointerNode root) {
        TreeNextPointerNode p = root;

        while (p != null) {
            TreeNextPointerNode q = p;

            while (q != null) {
                if (q.left != null) {
                    if (q.right != null) {
                        q.left.next = q.right;
                    } else {
                        q.left.next = getNextLevelNextRight(q);
                    }
                }
                
                if (q.right != null) {
                    q.right.next =  getNextLevelNextRight(q);
                }
                
                q = q.next;
            }
            
            if (p.left != null) p = p.left;
            else if (p.right != null) p = p.right;
            else p = getNextLevelNextRight(p);
        }

     }
    
    private TreeNextPointerNode getNextLevelNextRight(TreeNextPointerNode p) {
        if (p == null) return null;
        
        p = p.next;
        while(p != null) {
            if (p.left != null) return p.left;
            if (p.right != null) return p.right;
            
            p = p.next;
        }
        
        return null;
    }
}

