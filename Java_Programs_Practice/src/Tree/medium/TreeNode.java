package Tree.medium;

public class TreeNode {
	
	public int val;
	public TreeNode left,right;
	
	public TreeNode() {
		super();
	}

	public TreeNode(int val) {
		super();
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
}
