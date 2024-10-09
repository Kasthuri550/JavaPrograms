package Tree.medium;

public class MaximumPathSum {

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(-25);
		root.left.left = new Node(20);
		root.left.right = new Node(1);
		root.right.left = new Node(3);
		root.right.right = new Node(4);
		
		int maxValue[]=new int[1];
		
		maxValue[0]=Integer.MIN_VALUE;
		
		maxPathDown(root,maxValue);
		
		System.out.println(maxValue[0]);
		
	}

	private static int maxPathDown(Node root, int[] maxValue) {

		if(root==null) return 0;
		
		int leftSum=Math.max(0, maxPathDown(root.left, maxValue));
		int rightSum=Math.max(0, maxPathDown(root.right, maxValue));
		
		maxValue[0]=Math.max(maxValue[0],leftSum+rightSum+root.data);
		
		return root.data+Math.max(leftSum, rightSum);
	}
}
