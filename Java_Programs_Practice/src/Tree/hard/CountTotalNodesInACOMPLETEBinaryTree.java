package Tree.hard;

import Tree.medium.Node;

public class CountTotalNodesInACOMPLETEBinaryTree {

	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        
        System.out.println(countTotalNodes(root));

	}

	private static int countTotalNodes(Node root) {
		
		if(root==null) return 0;
		
		int left=findLeftHeight(root);
		int right=findRightHeight(root);
		
		if(left==right) 
			return (2<<left)-1;
		else
			return countTotalNodes(root.left)+countTotalNodes(root.right)+1;			
	}

	private static int findRightHeight(Node root) {

		int count=0;
		
		while(root.right!=null)
		{
			count++;
			root=root.right;
		}
		
		return count;
	}

	private static int findLeftHeight(Node root) {

		int count=0;
		
		while(root.left!=null)
		{
			count++;
			root=root.left;
		}
		
		return count;
	}
}
