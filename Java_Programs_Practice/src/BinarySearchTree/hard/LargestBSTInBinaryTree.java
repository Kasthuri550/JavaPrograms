package BinarySearchTree.hard;

import Tree.medium.Node;

public class LargestBSTInBinaryTree {

	static class NodeValue
	{
		public int size;
		public int min;
		public int max;

		NodeValue(int size,int maxNode,int minNode)
		{
			this.size=size;
			this.min=minNode;
			this.max=maxNode;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(1);
		root.left.right = new Node(8);
		root.right.right = new Node(7);

		System.out.println(largestBSTBrute(root));
		NodeValue node = largestBSTOptimal(root);
		System.out.println(node.size);
	}
	/*
	 * Time Complexity: O(N^2)
	 * Space Complexity: O(H)
	 */
	private static int largestBSTBrute(Node root) {

		if(root==null) return 0;

		if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
		{
			return size(root);
		}


		return Math.max(largestBSTBrute(root.left),largestBSTBrute(root.right));
	}

	private static int size(Node root) {

		if(root==null) return 0;

		return 1+size(root.left)+size(root.right);
	}

	private static boolean isBST(Node root, int minValue, int maxValue) {

		if(root==null) return true;

		if(root.data<=minValue || root.data>=maxValue) return false;

		return isBST(root.left, minValue,root.data) && isBST(root.right,root.data, maxValue);
	}
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(H)
	 */
	private static NodeValue largestBSTOptimal(Node root) {

		if(root==null){
			return new NodeValue(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
		}
		NodeValue leftInfo=largestBSTOptimal(root.left);
		NodeValue rightInfo=largestBSTOptimal(root.right);
		if(root.data>leftInfo.max && root.data<rightInfo.min){
			int currSize = leftInfo.size+rightInfo.size+1;
			int max=Math.max(root.data,rightInfo.max);
			int min=Math.min(root.data,leftInfo.min);
			return new NodeValue(currSize,min,max);
		}
		return new NodeValue(Math.max(leftInfo.size,rightInfo.size),Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
}
