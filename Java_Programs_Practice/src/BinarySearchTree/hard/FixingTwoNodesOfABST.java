package BinarySearchTree.hard;

import java.util.ArrayList;
import java.util.Collections;

import Tree.medium.Node;

public class FixingTwoNodesOfABST {
	
	private static Node first;
	private static Node middle;
	private static Node last;
	private static Node prev;
	
	FixingTwoNodesOfABST()
	{
		first=null;
		middle=null;
		last=null;
		prev=new Node(Integer.MIN_VALUE);
	}

	public static void main(String[] args) {
		
		Node root=new Node(10);
		root.left=new Node(5);
		root.left.left=new Node(2);
		root.left.right=new Node(20);
		root.right=new Node(8);
		
//		fixingTwoNodesOfABSTBrute(root);
//		printInOrder(root);
//		fixingTwoNodesOfABSTBetter(root);
//		printInOrder(root);
		fixingTwoNodesOfABSTOptimal(root);
		printInOrder(root);

	}

	private static void fixingTwoNodesOfABSTOptimal(Node root) {

			
		inorderTraversalOptimal(root);
		
		if(first!=null && last!=null)
		{
			int temp=first.data;
			first.data=last.data;
			last.data=temp;
		}
		else if(first!=null && middle!=null)
		{
			int temp=first.data;
			first.data=middle.data;
			middle.data=temp;
		}				
		
	}

	private static void inorderTraversalOptimal(Node root) {

		if(root==null) return;
		
		inorderTraversalOptimal(root.left);
		
		if(prev!=null && prev.data>root.data)
		{
			if(first==null)
			{
				first=prev;
				middle=root;
			}
			else
			{
				last=root;
			}
		}
		
		prev=root;
		
		inorderTraversalOptimal(root.right);
	}

	private static void fixingTwoNodesOfABSTBetter(Node root) {

		ArrayList<Node> elements=new ArrayList<>();
		
		inorderTraversalBetter(root, elements);
		
		Node first=null,second=null;
		
		for(int i=0;i<elements.size()-1;i++)
		{
			if(elements.get(i).data>elements.get(i+1).data)
			{
				if(first==null)
					first=elements.get(i);
				
				second=elements.get(i+1);
			}
		}
		
		if(first!=null && second!=null)
		{
			int temp=first.data;
			first.data=second.data;
			second.data=temp;
		}
		
	}

	private static void inorderTraversalBetter(Node root, ArrayList<Node> elements) {

		if(root==null) return;
		
		inorderTraversalBetter(root.left, elements);
		elements.add(root);
		System.out.print(root.data+" ");
		inorderTraversalBetter(root.right, elements);
	}

	private static void printInOrder(Node root) {

		if(root==null) return;
			
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
	}

	private static void fixingTwoNodesOfABSTBrute(Node root) {

		ArrayList<Integer> elements=new ArrayList<>();
		
		inorderTraversal(root,elements);
		
		Collections.sort(elements);
		
		reconstructTree(root,elements,new int[] {0});
	}

	private static void reconstructTree(Node root, ArrayList<Integer> elements, int[] index) {

		if(root==null) return;
		
		reconstructTree(root.left, elements, index);
		root.data=elements.get(index[0]++);
		reconstructTree(root.right, elements, index);
	}

	private static void inorderTraversal(Node root, ArrayList<Integer> elements) {

		if(root==null) return;
		
		inorderTraversal(root.left, elements);
		elements.add(root.data);
		inorderTraversal(root.right, elements);
	}
}
