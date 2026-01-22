package BinaryTree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {

		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);

		System.out.println(maximumDepth(root));
		System.out.println(maximumDepthLevelOrderBFSIterative(root));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int maximumDepthLevelOrderBFSIterative(TreeNode root) {

		if(root==null)
			return 0;

		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);

		int depth=0;

		while(!queue.isEmpty())
		{
			int size=queue.size();
			depth++;

			for(int i=0;i<size;i++)
			{
				TreeNode node=queue.poll();

				if(node.left!=null)
				{
					queue.add(node.left);
				}

				if(node.right!=null)
				{
					queue.add(node.right);
				}
			}
		}

		return depth;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(h)
	 * */
	private static int maximumDepth(TreeNode root) {

		if(root==null)
			return 0;

		int leftDepth=maximumDepth(root.left);
		int rightDepth=maximumDepth(root.right);

		return 1+Math.max(leftDepth, rightDepth);
	}
}
