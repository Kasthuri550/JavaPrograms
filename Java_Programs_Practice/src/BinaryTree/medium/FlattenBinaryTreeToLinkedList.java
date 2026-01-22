package BinaryTree.medium;

import java.util.Stack;

import BinaryTree.easy.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		//		flattenApproach1(root);
		//		flattenApproach2(root);
		flattenApproach3(root);
		printList(root);
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static void flattenApproach3(TreeNode root) {

		if(root==null)
			return;

		TreeNode curr=root;

		while(curr!=null)
		{
			if(curr.left!=null)
			{
				TreeNode prev=curr.left;

				while(prev.right!=null)
				{
					prev=prev.right;
				}

				prev.right=curr.right;

				curr.right=curr.left;
				curr.left=null;
			}

			curr=curr.right;
		}
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */	
	private static void flattenApproach2(TreeNode root) {

		if(root==null)
			return;

		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);

		while(!stack.isEmpty())
		{
			TreeNode curr=stack.pop();

			if(curr.right!=null)
				stack.push(curr.right);

			if(curr.left!=null)
				stack.push(curr.left);

			if(!stack.isEmpty())
				curr.right=stack.peek();

			curr.left=null;
		}
	}

	private static void printList(TreeNode root) {

		TreeNode temp=root;

		while(temp!=null)
		{
			System.out.println(temp.val+" ");
			temp=temp.right;
		}
	}


	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(h)
	 * */	
	static TreeNode prev=null;

	private static void flattenApproach1(TreeNode root) {

		if(root==null)
			return;

		flattenApproach1(root.right);
		flattenApproach1(root.left);

		root.right=prev;
		root.left=null;

		prev=root;
	}
}
