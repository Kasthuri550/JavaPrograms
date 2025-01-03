package BinarySearchTree.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Tree.medium.Node;

public class ConstructBSTFromPreorderTraversal {

	public static void main(String[] args) {

		int pre[]  = {40,30,35,80,100},size=5;

		//		Node root=constructBSTFromPreorderTraversalBrute(pre,size);

		Node root=constructBSTFromPreorderTraversalBetter(pre, size);

		//		Node root=constructBSTFromPreorderTraversalOptimal(pre, size);
		traverse(root);

	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(h)
	 */
	private static Node constructBSTFromPreorderTraversalOptimal(int[] pre, int size) {


		return bstFromPreorder(pre,Integer.MAX_VALUE,new int[] {0});
	}

	private static Node bstFromPreorder(int[] pre, int bound, int[] i) {

		if(i[0]==pre.length || pre[i[0]]>bound) return null;

		Node root=new Node(pre[i[0]++]);

		root.left=bstFromPreorder(pre,root.data, i);
		root.right=bstFromPreorder(pre, bound, i);

		return root;
	}
	/*
	 * Time Complexity: O(nlogn)+O(n)+O(n) ~ O(nlogn)
	 * Space Complexity: O(n)+O(n)+(h) ~ O(n)
	 */
	private static Node constructBSTFromPreorderTraversalBetter(int[] preorder, int size) {

		int[] inorder = Arrays.copyOf(preorder, preorder.length);
		Arrays.sort(inorder);

		return constructTree(preorder, inorder,size);

	}

	private static Node constructTree(int[] preorder, int[] inorder, int n) {

		Map<Integer,Integer> inMap=new HashMap<>();

		for(int i=0;i<n;i++)
		{
			inMap.put(inorder[i],i);
		}

		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
	}

	private static Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {

		if(preStart>preEnd || inStart>inEnd) return null;

		Node root=new Node(preorder[preStart]);
		int inRoot=inMap.get(root.data);
		int numsLeft=inRoot-inStart;

		root.left=buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
		root.right=buildTree(preorder, preStart+numsLeft+1, preEnd, inorder,inRoot+1,inEnd,inMap);

		return root;
	}

	private static void traverse(Node root) {

		if (root == null) return;
		traverse(root.left);
		traverse(root.right);
		System.out.print(root.data + " ");
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(h)
	 */
	private static Node constructBSTFromPreorderTraversalBrute(int[] pre, int size) {

		Node root=null;

		for(int value:pre)
		{
			root=insertIntoBST(root,value);
		}

		return root;
	}

	private static Node insertIntoBST(Node root, int value) {

		if(root==null) return new Node(value);


		if(value<root.data)
		{
			root.left=insertIntoBST(root.left, value);
		}
		else
		{
			root.right=insertIntoBST(root.right, value);
		}

		return root;
	}
}
