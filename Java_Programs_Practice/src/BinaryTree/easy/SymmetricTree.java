package BinaryTree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		System.out.println(isSymmetricTreeRecursive(root));		
		System.out.println(isSymmetricTreeIterative(root));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static boolean isSymmetricTreeIterative(TreeNode root) {

		if(root==null)
			return true;

		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);

		while(!queue.isEmpty())
		{
			TreeNode t1=queue.poll();
			TreeNode t2=queue.poll();

			if(t1==null && t2==null)
				continue;

			if(t1==null || t2==null)
				return false;

			if(t1.val!=t2.val)
				return false;

			queue.add(t1.left);
			queue.add(t2.right);
			queue.add(t1.right);
			queue.add(t2.left);
		}

		return true;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(h)
	 * */	
	private static boolean isSymmetricTreeRecursive(TreeNode root) {

		if(root==null)
			return true;

		return isSymmetricTree(root.left,root.right);
	}

	private static boolean isSymmetricTree(TreeNode t1,TreeNode t2) {

		if(t1==null && t2==null)
			return true;

		if(t1==null || t2==null)
			return false;

		if(t1.val!=t2.val)
			return false;

		return isSymmetricTree(t1.left, t2.right) && isSymmetricTree(t1.right, t2.left);
	}
}
