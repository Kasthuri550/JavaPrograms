package BinarySearchTree.medium;

import Tree.medium.Node;

public class DeleteANodeInBinarySearchTree {

	public static void main(String[] args) {

		Node root=new Node(2);
		root.left=new Node(1);
		root.right=new Node(3);
		
		int key=3;
		
		System.out.println(deleteNode(root,key));
		
	}

	private static Node deleteNode(Node root, int key) {
		
		if(root==null) return null;
		
		if(root.data==key) return helper(root);
		
		Node dummy=root;
		
		while(root!=null)
		{
			if(root.data>key)
			{
				if(root.left!=null && root.left.data==key)
				{
					root.left=helper(root.left);
					break;
				}
				else
				{
					root=root.left;
				}
			}
			else
			{
				if(root.right!=null && root.right.data==key)
				{
					root.right=helper(root.right);
					break;
				}
				else
				{
					root=root.right;
				}
			}
		}
		
		return dummy;
	}

	private static Node helper(Node root) {
		
		if(root.left==null)
			return root.right;
		
		if(root.right==null)
			return root.left;
		
		Node rightChild=root.right;
		Node lastRight=findRight(root.left);
		lastRight.right=rightChild;
		
		return root.left;
	}

	private static Node findRight(Node root) {

		if(root.right==null)
			return root;
		
		return findRight(root.right);
	}
}
