package BinaryTree.easy;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * */
public class InvertBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);

		TreeNode invertedTree=mirrorTree(root);

		levelOrderTraversal(invertedTree);
	}

	private static void levelOrderTraversal(TreeNode root) {

		if(root==null)
			return;

		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty())
		{
			TreeNode curr=queue.poll();
			System.out.print(curr.val+" ");

			if(curr.left!=null)
			{
				queue.add(curr.left);
			}

			if(curr.right!=null)
			{
				queue.add(curr.right);
			}
		}
	}

	private static TreeNode mirrorTree(TreeNode root) {

		if(root==null)
			return null;

		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;

		mirrorTree(root.left);
		mirrorTree(root.right);		

		return root;
	}
}
