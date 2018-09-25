package com.vikrambpgc.Trees.V2;
import java.util.ArrayList;
import java.util.Stack;

public class Traversals {
	
	private Traversals() {}

    private static class SingletonHelper {
        private static final Traversals INSTANCE = new Traversals();
    }
    
	public static Traversals getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public ArrayList<Integer> preorderTraversal(TreeNode a) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		while(true) {
			while(null != a) {
				array.add(a.val);
				s.add(a);
				a = a.left;
			}
			
			if (s.isEmpty()) break;
			else a = s.pop().right;
		}

		return array;	
	}
}
