package BinarySearch.medium;

import java.util.ArrayList;

import Tree.medium.Node;

public class InorderPredecessor {

	public static void main(String[] args) {

		Node root=new Node(8);
		root.left=new Node(1);
		root.right=new Node(9);
		root.left.right=new Node(4);
		root.left.right.left=new Node(3);
		root.right.right=new Node(10);

		int key=8;

		Node inorderPredecessorBrute=inorderPredecessorBrute(root,key);
		System.out.println(inorderPredecessorBrute);
		Node inorderPredecessorBetter=inorderPredecessorBetter(root, key);
		System.out.println(inorderPredecessorBetter);
		Node inorderPredecessor = inorderPredecessorOptimal(root,key);
		System.out.println(inorderPredecessor);
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(h)
	 */
	private static Node inorderPredecessorBetter(Node root, int key) {

		Node prev[]=new Node[1];
		inorderTraversalBetter(root,key,prev);

		return predecessor;
	}

	static Node predecessor=null;

	private static void inorderTraversalBetter(Node root, int key, Node[] prev) {

		if(root==null) return;

		inorderTraversalBetter(root.left,key,prev);

		if(root.data==key)
		{
			predecessor=prev[0];
			return;
		}
		prev[0]=root;

		inorderTraversalBetter(root.right,key,prev);
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private static Node inorderPredecessorBrute(Node root, int key) {

		ArrayList<Node> nodes=new ArrayList<>();

		inorderTraversalBrute(root,key,nodes);

		for(int i=1;i<nodes.size();i++)
		{
			if(nodes.get(i).data==key)
			{
				return nodes.get(i-1);
			}
		}

		return null;
	}

	private static void inorderTraversalBrute(Node root, int key, ArrayList<Node> nodes) {

		if(root==null) return;

		inorderTraversalBrute(root.left, key, nodes);
		nodes.add(root);
		inorderTraversalBrute(root.right, key, nodes);

	}
	/*
	 * Time Complexity: O(h)
	 * Space Complexity: O(1)
	 */
	private static Node inorderPredecessorOptimal(Node root, int key) {

		Node predecessor=null;

		while(root!=null)
		{
			if(root.data>=key)
			{
				root=root.left;
			}
			else
			{
				predecessor=root;
				root=root.right;
			}
		}

		return predecessor;
	}
}
