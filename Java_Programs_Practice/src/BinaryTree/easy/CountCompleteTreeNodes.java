package BinaryTree.easy;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		System.out.println(countNodes(root));
	}

	/*
	 * Time Complexity: O(log^2 n)
	 * Space Complexity: O(log n)
	 * */
	private static int countNodes(TreeNode root) {

		if(root==null)
			return 0;

		int leftHeight=getLeftHeight(root);
		int rightHeight=getRightHeight(root);

		if(leftHeight==rightHeight)
			return (1<<leftHeight)-1;

		return 1+countNodes(root.left)+countNodes(root.right);
	}

	private static int getRightHeight(TreeNode root) {

		TreeNode temp=root;
		int count=0;

		while(temp!=null)
		{
			count++;
			temp=temp.right;
		}

		return count;
	}

	private static int getLeftHeight(TreeNode root) {

		TreeNode temp=root;
		int count=0;

		while(temp!=null)
		{
			count++;
			temp=temp.left;
		}

		return count;
	}
}
