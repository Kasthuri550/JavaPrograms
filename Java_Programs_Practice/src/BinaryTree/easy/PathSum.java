package BinaryTree.easy;

public class PathSum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		int target=22;

		System.out.println(hasPathSum(root,target));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)(recursive stack)
	 * */	
	private static boolean hasPathSum(TreeNode root, int target) {

		if(root==null)
			return false;

		if(root.left==null && root.right==null)
			return root.val==target;

		int remainingSum=target-root.val;

		return hasPathSum(root.left, remainingSum) || hasPathSum(root.right,remainingSum);
	}
}
