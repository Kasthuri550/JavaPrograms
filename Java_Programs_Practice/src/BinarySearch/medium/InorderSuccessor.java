package BinarySearch.medium;

import java.util.ArrayList;

import Tree.medium.Node;

public class InorderSuccessor {

	public static void main(String[] args) {

		Node root=new Node(8);
		root.left=new Node(1);
		root.right=new Node(9);
		root.left.right=new Node(4);
		root.left.right.left=new Node(3);
		root.right.right=new Node(10);

		int key=8;

		Node inorderSuccessorBrute = inorderSuccessorBrute(root,key);
		System.out.println(inorderSuccessorBrute);
		Node inorderSuccessorBetter = inorderSuccessorBetter(root,key);
		System.out.println(inorderSuccessorBetter);
		Node inorderSuccessorOptimal = inorderSuccessorOptimal(root,key);
		System.out.println(inorderSuccessorOptimal);

	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(h)
	 */
	private static Node inorderSuccessorBetter(Node root, int key) {

		Node prev[]=new Node[1];
		inorderTraversalBetter(root,key,prev);
		return successor;
	}

	static Node successor=null;

	private static void inorderTraversalBetter(Node root, int key, Node[] prev) {

		if(root==null) return;

		inorderTraversalBetter(root.left, key,prev);

		if(prev[0]!=null && prev[0].data==key)
		{
			successor=root;
			return;
		}
		prev[0]=root;
		inorderTraversalBetter(root.right, key,prev);		
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private static Node inorderSuccessorBrute(Node root, int key) {

		ArrayList<Node> nodes=new ArrayList<>();

		inorderTraversalBrute(root,nodes);

		for(int i=0;i<nodes.size()-1;i++)
		{
			if(nodes.get(i).data==key)
			{
				return nodes.get(i+1);
			}
		}

		return null;
	}

	private static void inorderTraversalBrute(Node root, ArrayList<Node> nodes) {

		if(root==null) return;

		inorderTraversalBrute(root.left, nodes);
		nodes.add(root);
		inorderTraversalBrute(root.right,nodes);
	}
	/*
	 * Time Complexity: O(h)
	 * Space Complexity: O(1)
	 */
	private static Node inorderSuccessorOptimal(Node root, int key) {

		Node successor=null;

		while(root!=null)
		{
			if(root.data<=key)
			{
				root=root.right;
			}
			else
			{
				successor=root;
				root=root.left;
			}
		}

		return successor;
	}
}
