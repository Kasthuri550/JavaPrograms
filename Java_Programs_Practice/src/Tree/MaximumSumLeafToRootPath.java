package Tree;

class TreeNode
{
	int data;
	TreeNode left,right;
	
	TreeNode(int data)
	{
		this.data=data;
		left=right=null;
	}
}
public class MaximumSumLeafToRootPath {
	
	private static int maxSumPath(TreeNode root)
	{
		if(root==null) return 0;
		return maxSumLeafToRoot(root);
	}

	private static int maxSumLeafToRoot(TreeNode root) {
		
		if(root==null) return Integer.MIN_VALUE;
		
		if(root.left==null && root.right==null) return root.data;
		
		int leftSum=maxSumLeafToRoot(root.left);
		int rightSum=maxSumLeafToRoot(root.right);
		
		return root.data+Math.max(leftSum, rightSum);
	}

	public static void main(String[] args) {
		
		TreeNode treeNode1=new TreeNode(10);
		treeNode1.left=new TreeNode(-2);
		treeNode1.right=new TreeNode(7);
		treeNode1.left.left=new TreeNode(8);
		treeNode1.left.right=new TreeNode(-4);
		System.out.println(maxSumPath(treeNode1));
	}
}
