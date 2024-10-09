package Tree.easy;

import Tree.medium.Node;

/*
Time Complexity (TC): O(N)
Space Complexity (SC): O(H)
*/
public class BinaryTreeSymmetry {

	public static void main(String[] args) {
		
		Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(2);
        root.right.right = new Node(2);
        
       System.out.println(isSymmetryOrNot(root));

	}

	private static boolean isSymmetryOrNot(Node root) {
		
		if(root==null) return true;
		
		return isMirror(root.left,root.right);	
	}

	private static boolean isMirror(Node left, Node right) {
		
		if(left==null && right==null) return true;
		
		if(left==null || right==null) return false;
		
		return (left.data==right.data) && isMirror(left.left, right.right) &&
				isMirror(left.right, right.left);
	}
}
