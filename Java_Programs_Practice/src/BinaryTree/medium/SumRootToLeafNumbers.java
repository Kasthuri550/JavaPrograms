package BinaryTree.medium;

import BinaryTree.easy.TreeNode;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {

		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(9);
		root2.right = new TreeNode(0);
		root2.left.left = new TreeNode(5);
		root2.left.right = new TreeNode(1);

		System.out.println(sumRootToLeaf(root2,0));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(h)
	 * */	
	private static int sumRootToLeaf(TreeNode root,int current) {

		if(root==null)
			return 0;

		current=current*10+root.val;

		if(root.left==null && root.right==null)
			return current;

		return sumRootToLeaf(root.left,current)+sumRootToLeaf(root.right,current);
	}
}
