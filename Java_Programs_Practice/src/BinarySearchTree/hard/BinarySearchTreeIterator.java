package BinarySearchTree.hard;

import java.util.ArrayList;
import java.util.Stack;

import Tree.medium.TreeNode;

class BinaryIteratorBrute
{
	private ArrayList<Integer> nodes;
	private int index;
	BinaryIteratorBrute(TreeNode root)
	{
		nodes=new ArrayList<>();
		index=0;
		inorderTraversal(root);
	}
	private void inorderTraversal(TreeNode root) {

		if(root==null) return;

		inorderTraversal(root.left);
		nodes.add(root.val);
		inorderTraversal(root.right);
	}

	public int next()
	{
		return nodes.get(index++);
	}

	public boolean hasNext()
	{
		return index<nodes.size();
	}

}

class BinaryIteratorBetter
{
	private Stack<TreeNode> stack;
	BinaryIteratorBetter(TreeNode root)
	{
		stack=new Stack<>();
		pushAllLeft(root);
	}

	private void pushAllLeft(TreeNode root) {

		while(root!=null)
		{
			stack.push(root);
			root=root.left;
		}

	}

	public int next()
	{
		TreeNode treeNode=stack.pop();

		if(treeNode.right!=null)
		{
			pushAllLeft(treeNode.right);
		}
		return treeNode.val;
	}

	public boolean hasNext()
	{
		return !stack.isEmpty();
	}
}

public class BinarySearchTreeIterator {

	public static void main(String[] args) {

		TreeNode root=new TreeNode(7);
		root.left=new TreeNode(3);
		root.right=new TreeNode(15);
		root.right.left=new TreeNode(9);
		root.right.right=new TreeNode(20);

		binarySearchTreeIteratorBrute(root);
		binarySearchTreeIteratorBetter(root);


	}
	//	Overall Time Complexity: O(1)(per operation) and O(N) for all operations combined.
	//	Space Complexity: O(H)
	private static void binarySearchTreeIteratorBetter(TreeNode root) {

		BinaryIteratorBetter binaryIteratorBetter=new BinaryIteratorBetter(root);

		while(binaryIteratorBetter.hasNext())
		{
			System.out.print(binaryIteratorBetter.next()+" ");
		}
	}
	//	Overall Time Complexity: O(N)(for constructor)+O(1)(per operation)
	//	Space Complexity: O(N)
	private static void binarySearchTreeIteratorBrute(TreeNode root) {

		BinaryIteratorBrute binaryIteratorBrute=new BinaryIteratorBrute(root);

		while(binaryIteratorBrute.hasNext())
		{
			System.out.print(binaryIteratorBrute.next()+" ");
		}

	}
}


