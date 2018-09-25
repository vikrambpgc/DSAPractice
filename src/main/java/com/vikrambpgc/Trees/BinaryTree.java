package com.vikrambpgc.Trees;
import java.util.*;
public class BinaryTree {
	TreeNode root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	private static class Pointer<T> {
		T reference;
	}
	
	public static void main(String[] args) {
		ListNode headLL;
		TreeNode node;
		
		//BinaryTree btree = BinaryTreeInstances.getBalancedTree();
		//BinaryTree btree = BinaryTreeInstances.getUnbalancedTree();
		BinaryTree btree = BinaryTreeInstances.getUnbalancedBST();

	
		//btree.levelOrder(btree.root);
		//btree.printPathToLeavesMain(btree);
		
		//btree.btree2CDLLMain(btree.root);
		
		//System.out.println("Height of tree:" + btree.heightTree(btree.root));
		
		//printVerticalSum(btree.root);
		
		//printTreePostOrderIterative(btree.root);
		
		//System.out.println(myLCA(btree.root, 3, 6));
		
		//List<Integer> s = serializeTree(btree.root);
		//btree.root = deserialize(s);

		//ListNode head = createList(15, 8);
		//printLL(head);
		//btree.root = Dll2Btree(head);
		
		//node = floorInBST(btree.root, 14);
		//node = ceilInBST(btree.root, 50);
		//if (node != null) System.out.println(node.getData());
		//else System.out.println("No Floor/Ceil");
		
		//btree.levelOrder(btree.root);
		printInRangeBST(btree.root, 5, 10);
		btree.levelOrder(btree.root);
		
		//trimBST(btree.root, 5, 10);
		
		//inorderSuccBTree(btree.root, 4);
		//inorderSuccBTreeRec(btree.root, 4);
		
		//preorderSuccBTree(btree.root, 6);
		
		//btree.levelOrder(btree.root);
		//btree.printPathToLeavesMain(btree);
	}
	

	
	public static ListNode createList(int start, int count) {
		ListNode head, temp, prev;
		int i;
		
		temp = prev = head = new ListNode(start);
		
		for(i=1;i<count;i++) {
			temp = new ListNode(start+i);
			temp.next = null;
			prev.next = temp;
			prev = temp;
		}
		
		return head;
	}
	
	public static void printLL(ListNode node) {
		ListNode temp;
		
		for(temp = node; temp != null; temp = temp.next) {
			System.out.print(temp.data+"->");
		}
		System.out.println();
	}
	
	public void printPathToLeavesMain(BinaryTree btree) {
		int height;
		int[] aux;
		if (btree.root == null) {
			System.out.println("printPathToLeaves:Empty tree");
			return;
		}
		
		height = btree.heightTree(btree.root);
		aux = new int[height];
		printPathToLeaves(root, aux, 0);
	}
	
	private static void printPathToLeaves(TreeNode root, int[] aux, int index) {
		if (root == null) { //instead search for both left and right childs null.
			for(int i=0;i<index;i++) {
				System.out.print(aux[i]+"->");
			}
			System.out.println();
			return;
		}
		
		aux[index] = root.getData();
		printPathToLeaves(root.getLeft(), aux, index + 1);
		if (root.getRight() == null) return;
		printPathToLeaves(root.getRight(), aux, index + 1);
	}
	
	public void btree2CDLLMain(TreeNode root) {
		TreeNode head, temp = null;
		
		if (root == null) return;
		head = btree2CDLL(root);
		if (head == null) {
			System.out.println("Error converting Binary tree to CDLL");
			return;
		}
		System.out.print(head.getData()+"->");
		temp = head.getRight();
		while (temp != head) {
			System.out.print(temp.getData()+"->");
			temp = temp.getRight();
		}
	}
	
	private TreeNode btree2CDLL(TreeNode root) {
		TreeNode head1, head2, head;
		
		if (root == null) return null;
		head1 = btree2CDLL(root.getLeft());
		head2 = btree2CDLL(root.getRight());
		
		root.setLeft(root);
		root.setRight(root);
		
		head1 = btree2DLLAppend(head1, root);
	    head =  btree2DLLAppend(head1, head2);
		
		return head;
	}
	
	private TreeNode btree2DLLAppend(TreeNode a, TreeNode b) {
		TreeNode aTail, bTail;
		if (a == null && b == null) return null; //this both null case never comes remember
		else if (b == null) return a;
		else if (a == null) return b;	
		
		aTail = a.getLeft();
		bTail = b.getLeft();
		
		aTail.setRight(b);
		b.setLeft(aTail);
		
		bTail.setRight(a);
		a.setLeft(bTail);
		
		return a;
	}
	
	public static TreeNode Dll2Btree(ListNode node) {
		int count = 0;
		ListNode temp;
		for(temp = node;temp != null;temp=temp.next) count++;
		if (count == 0) return null;
		
		List<ListNode> listPointer = new ArrayList<ListNode>();
		listPointer.add(node);
		return Dll2BtreeUtil(listPointer, 0, count - 1);
	}
	
	public static TreeNode Dll2BtreeUtil(List<ListNode> listPointer, int start, int end) {
		int mid;
		TreeNode node, left;
		
		if (start > end) return null;
		mid =  start + (end - start) / 2;
		
		left = Dll2BtreeUtil(listPointer, start, mid - 1);
		
		node = new TreeNode(listPointer.get(0).data);
		node.setLeft(left);
		
		listPointer.set(0, listPointer.get(0).next);
		node.setRight(Dll2BtreeUtil(listPointer, mid + 1, end));
		
		return node;
	}
	
	public int heightTree(TreeNode node) {
		
        if (node == null) return 0;
        
        return (Math.max(heightTree(node.getLeft()),heightTree(node.getRight())) + 1);
	}
	
	public TreeNode insert(TreeNode root, TreeNode node) {
		TreeNode current;
		
		if (root == null) {
			root = node;
			
			return root;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while (!q.isEmpty()) {
			current = q.remove();
			
			if (current.getLeft() == null) {
				current.setLeft(node);
				break;
			} else {
				q.add(current.getLeft());
			}
			
			if (current.getRight() == null) {
				current.setRight(node);
				break;
			} else {
				q.add(current.getRight());
			}
		}
		
		return root;
	}
	
	public void levelOrder(TreeNode root) {
		TreeNode current;
		if (root == null) {
			System.out.println("Empty Tree");
			return;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			current = q.remove();
			
			if (current == null) {
				System.out.println();
				if (!q.isEmpty()) {
					q.add(null);
				}
			} else {
				System.out.print(current.getData());
				if (current.getLeft() != null) q.add(current.getLeft());
				if (current.getRight() != null) q.add(current.getRight());
			}
		}
	}
	
	public static void printVerticalSum(TreeNode root) {
		if (root == null) return;
		ListNode head = null, temp;
		ListNode node = new ListNode(0);
		printVerticalSumHelper(root, node);
		
		head = node;
		while (head != null && head.prev != null) {
			head = head.prev;
		}
		temp = head;
		System.out.println("Vertical sum:");
		while (temp != null) {
			System.out.print(temp.data+",");
			temp = temp.next;
		}
		System.out.println();
	}
	
	private static void printVerticalSumHelper(TreeNode root, ListNode node) {
		if (root == null || node == null) {
			return;
		}
		node.data += root.getData();
		if (node.prev == null) {
			node.prev = new ListNode(0);
			node.prev.next = node;
		}
		printVerticalSumHelper(root.getLeft(), node.prev);
		if(node.next == null) {
			node.next = new ListNode(0);
			node.next.prev = node;
		}
		printVerticalSumHelper(root.getRight(), node.next);
	}
		
	private static void printTreePostOrderIterative(TreeNode root) {
		System.out.println("Post Order Iterative print:");
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(true) {
			if (null != root) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.isEmpty() == true) {
					System.out.println("Stack is empty");
					return;
				}
				
				while(stack.isEmpty() == false && stack.peek().getRight() == root) {
					root = stack.pop();
					System.out.print(root.getData()+",");	
				}
				
				if (stack.isEmpty() == false) {
					root = stack.peek().getRight();
				} else {
					root = null;
				}
			}
		}
	}
	
	public static List<Integer> serializeTree(TreeNode root) {
		List<Integer> s = new ArrayList<Integer>();
		serializeTreeUtil(root, s);

		return s;
	}
	
	public static void serializeTreeUtil(TreeNode root, List<Integer> s) {
		if (root == null) {
			s.add(Integer.MAX_VALUE);
			return;
		}
		
		s.add(root.getData()+10);
		serializeTreeUtil(root.getLeft(), s);
		serializeTreeUtil(root.getRight(), s);
	}
	
	public static TreeNode deserialize(List<Integer> s) {
		TreeNode root = null;
		int[] index = {0};
		
		if ( s == null || s.get(0) == Integer.MAX_VALUE) return null;
		
		root = deserializeUtil(s, index);
		
		return root;
	}
	
	public static TreeNode deserializeUtil(List<Integer> s, int[] index) {
			TreeNode node = new TreeNode(s.get(index[0]));
			
			if(s.get(index[0]) == Integer.MAX_VALUE) return null;
			
			index[0]++;
			node.setLeft(deserializeUtil(s, index));
			
			index[0]++;
			node.setRight(deserializeUtil(s, index));
			
			return node;
	}
	
	public static boolean myLCA(TreeNode root, int a, int b){
	    boolean[] hasCommonParent = {false};
	    myLCAUtil(root, a, b, hasCommonParent);
	    
	    return hasCommonParent[0];   
	}
	private static boolean myLCAUtil(TreeNode root, int a, int b, boolean[] hasCommonParent){
		boolean left, right;
		
	    if (root == null) return false;
	    
	    if (root.getData() == a || root.getData() == b) return true;
	    
	    left =  myLCAUtil(root.getLeft(), a, b, hasCommonParent);
	    right = myLCAUtil(root.getRight(), a, b, hasCommonParent);
	    
	    if (left == true && right == true) {
	         hasCommonParent[0] = true;
	         return true;
	    } else if ((left == true || right == true) && hasCommonParent[0] == true) {
	        return true;
	    }
	    
	    return false;
	}
	
	public static TreeNode floorInBST(TreeNode node, int key) {
		TreeNode temp = null;
		if (node == null) return null;
		if (node.getData() == key) return node;
		
		if (node.getData() > key) return floorInBST(node.getLeft(), key);
		else {
			temp = floorInBST(node.getRight(), key);
			if (temp == null) return node;
		}
		
		return temp;	
	}
	
	public static TreeNode ceilInBST(TreeNode node, int key) {
		TreeNode temp = null;
		if (node == null) return null;
		if (node.getData() == key) return node;
		
		if (node.getData() < key) return ceilInBST(node.getRight(), key);
		else {
			temp = ceilInBST(node.getLeft(), key);
			if (temp == null) return node;
		}
		
		return temp;	
	}
	
	public static void printInRangeBST(TreeNode node, int k1, int k2) {
		if (node == null) return;
		
		if (k1 < node.getData()) {
			printInRangeBST(node.getLeft(), k1, k2);
		}
		
		if (node.getData() >= k1 && node.getData() <= k2) System.out.println(node.getData()+" ");
		
		if (k2 > node.getData()) {
			printInRangeBST(node.getRight(), k1, k2);
		}
	}
	
	public static TreeNode trimBST(TreeNode node, int k1, int k2) {
		if (node == null) return null;
		
		if (k1 <= node.getData()) {
			node.setLeft(trimBST(node.getLeft(), k1, k2));
		} else {
			return null;
		}
		
		if (node.getData() > k2) return null;
		
		node.setRight(trimBST(node.getRight(), k1, k2));
		
		return node;
	}
	
	//Also needs to write for BSTs in O(n)
	public static TreeNode inorderSuccBTree(TreeNode node, int data) {
		
		TreeNode prev = null, temp = null;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		while(true) {
			while(node != null) {
				s.push(node);
				node = node.getLeft();
			}
			
			if (!s.isEmpty()) temp = s.pop();
			else break;
			
			if (prev !=null && prev.getData() == data) System.out.println(temp.getData());
			
			prev = temp;
			node = temp.getRight();
		}
		
		return prev;
	}
	
	public static TreeNode preorderSuccBTree(TreeNode node, int data) {
		
		TreeNode prev = null, temp = null;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		while(true) {
			while(node != null) {				
				s.push(node);
				if (prev !=null && prev.getData() == data) System.out.println(node.getData());
				prev = node;
				node = node.getLeft();
			}
			
			if (!s.isEmpty()) temp = s.pop();
			else break;
			
			
			node = temp.getRight();
		}
		
		return prev;
	}
	
	public static void inorderSuccBTreeRec(TreeNode node, int data) {
		ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
		prev.add(null);
		inorderSuccBTreeRecUtil(node, prev, data);
		
		Pointer<TreeNode> prevNode = new Pointer<TreeNode>();
		prevNode.reference = null;
		inorderSuccBTreeRecUtilPointer(node, prevNode, data);
	}
	
	public static void inorderSuccBTreeRecUtil(TreeNode node, ArrayList<TreeNode> prev, int data) {
		if (node == null) return;
		
		inorderSuccBTreeRecUtil(node.getLeft(), prev, data);
		
		if (prev.get(0) != null && prev.get(0).getData() == data) {
			System.out.println(node.getData());
		}
		prev.set(0, node);
		
		inorderSuccBTreeRecUtil(node.getRight(), prev, data);
	}
	
	public static void inorderSuccBTreeRecUtilPointer(TreeNode node, Pointer<TreeNode> prevNode, int data) {
		if (node == null) return;
		
		inorderSuccBTreeRecUtilPointer(node.getLeft(), prevNode, data);
		
		if (prevNode.reference != null && prevNode.reference.getData() == data) {
			System.out.println(node.getData());
		}
		prevNode.reference = node;
		
		inorderSuccBTreeRecUtilPointer(node.getRight(), prevNode, data);
	}
}
