package BinarySearchTree.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import Tree.medium.Node;

class BSTIterator
{
	Stack<Node> stack;
	boolean reverse;
	BSTIterator(Node root,boolean reverse)
	{
		stack=new Stack<>();
		this.reverse=reverse;
		pushAll(root);
	}

	public boolean hasNext()
	{
		return !stack.isEmpty();
	}

	public int next()
	{
		Node node=stack.pop();
		if(reverse)
			pushAll(node.left);
		else
			pushAll(node.right);

		return node.data;
	}

	public void pushAll(Node root) {

		while(root!=null)
		{
			stack.push(root);
			if(reverse)
			{
				root=root.right;
			}
			else
			{
				root=root.left;
			}
		}
	}
}
public class TwoSumInBST {

	public static void main(String[] args) {

		Node root = new Node(2);
		root.left=new Node(1);
		root.right=new Node(3);


		int k=5;

		System.out.println(twoSumBrute(root,k));
		System.out.println(twoSumBetter(root,k));
		System.out.println(twoSumOptimalI(root,k));
		System.out.println(twoSumOptimalII(root, k));

	}
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(2H)
	 */
	private static boolean twoSumOptimalII(Node root, int k) {

		if(root==null) return false;

		BSTIterator l=new BSTIterator(root,false);
		BSTIterator r=new BSTIterator(root,true);

		int i=l.next(),j=r.next();

		while(i<j)
		{
			int sum=i+j;
			if(sum==k)
				return true;
			else if(sum<k)
				i=l.next();
			else
				j=r.next();
		}

		return false;
	}
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(H)
	 */
	private static boolean twoSumOptimalI(Node root, int k) {

		HashSet<Integer> set=new HashSet<>();
		return findPair(root,k,set);
	}

	private static boolean findPair(Node root, int k, HashSet<Integer> set) {

		if(root==null) return false;

		if(set.contains(k-root.data))
		{
			return true;
		}

		set.add(root.data);

		return findPair(root.left, k, set) || findPair(root.right, k, set);
	}
	/*
	 * Time Complexity: O(N)
	 * Space Complexity: O(N)
	 */
	private static boolean twoSumBetter(Node root, int k) {

		ArrayList<Integer> elements=new ArrayList<Integer>();

		inorderTraversal(root,elements);

		int n=elements.size();
		int left=0,right=n-1;

		while(left<=right)
		{
			if(elements.get(left)+elements.get(right)==k)
			{
				return true;
			}
			else if(elements.get(left)<elements.get(right))
			{
				left++;
			}
			else
			{
				right--;
			}
		}

		return false;
	}
	/*
	 * Time Complexity: O(N^2)
	 * Space Complexity: O(N)
	 */
	private static boolean twoSumBrute(Node root, int k) {

		ArrayList<Integer> elements=new ArrayList<>();

		inorderTraversal(root,elements);

		int n=elements.size();

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if((elements.get(i)+elements.get(j))==k)
				{
					return true;
				}
			}
		}

		return false;
	}

	private static void inorderTraversal(Node root, ArrayList<Integer> elements) {

		if(root==null) return;

		inorderTraversal(root.left, elements);
		elements.add(root.data);
		inorderTraversal(root.right, elements);
	}
}
