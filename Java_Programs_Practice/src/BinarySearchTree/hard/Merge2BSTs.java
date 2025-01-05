package BinarySearchTree.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.medium.Node;

class BSTIterator
{
	private Stack<Node> stack;
	BSTIterator(Node root)
	{
		stack=new Stack<>();
		pushLeftNodes(root);
	}

	public void pushLeftNodes(Node root)
	{
		while(root!=null)
		{
			stack.push(root);
			root=root.left;
		}
	}

	public int next()
	{
		Node node=stack.pop();

		if(node.right!=null)
		{
			pushLeftNodes(node.right);
		}

		return node.data;
	}

	public boolean hasNext()
	{
		return !stack.isEmpty();
	}

}

public class Merge2BSTs {

	public static void main(String[] args) {

		Node root1=new Node(5);
		root1.left=new Node(3);
		root1.left.left=new Node(2);
		root1.left.right=new Node(4);
		root1.right=new Node(6);

		Node root2=new Node(2);
		root2.left=new Node(1);
		root2.right=new Node(3);
		root2.right.right=new Node(7);
		root2.right.right.left=new Node(6);

		Node newTree1=merge2BSTBrute(root1,root2);
		traverse(newTree1);
		ArrayList<Integer> newTree2=merge2BSTBetter(root1,root2);
		System.out.println(newTree2);
		ArrayList<Integer> result = merge2BSTOptimal(root1,root2);
		System.out.println(result);
	}
	/*
	 * Time Complexity: O(n1+n2)
	 * Space Complexity: O(h1+h2+n1+n2)
	 */
	 private static ArrayList<Integer> merge2BSTOptimal(Node root1, Node root2) {

		 BSTIterator bstIterator1=new BSTIterator(root1);
		 BSTIterator bstIterator2=new BSTIterator(root2);

		 ArrayList<Integer> list=new ArrayList<>();

		 int val1=bstIterator1.hasNext()?bstIterator1.next():Integer.MAX_VALUE;
		 int val2=bstIterator2.hasNext()?bstIterator2.next():Integer.MAX_VALUE;

		 while(bstIterator1.hasNext() || bstIterator2.hasNext() || val1!=Integer.MAX_VALUE || val2!=Integer.MAX_VALUE)
		 {
			 if(val1<=val2)
			 {
				 list.add(val1);
				 val1=bstIterator1.hasNext()?bstIterator1.next():Integer.MAX_VALUE;
			 }
			 else
			 {
				 list.add(val2);
				 val2=bstIterator2.hasNext()?bstIterator2.next():Integer.MAX_VALUE;
			 }
		 }

		 return list;
	 }
	 /*
	  * Time Complexity: O(n1+n2)
	  * Space Complexity: O(h1+h2)
	  */
	 private static ArrayList<Integer> merge2BSTBetter(Node root1, Node root2) {

		 Stack<Node> stack1=new Stack<>();
		 Stack<Node> stack2=new Stack<>();

		 pushLeftNodes(root1,stack1);
		 pushLeftNodes(root2, stack2);

		 ArrayList<Integer> list=new ArrayList<Integer>();

		 while(!stack1.isEmpty() && !stack2.isEmpty())
		 {
			 if(stack1.peek().data<stack2.peek().data)
			 {
				 Node node=stack1.pop();
				 list.add(node.data);
				 pushLeftNodes(node.right, stack1);
			 }
			 else
			 {
				 Node node=stack2.pop();
				 list.add(node.data);
				 pushLeftNodes(node.right, stack2);
			 }
		 }

		 while(!stack1.isEmpty())
		 {
			 Node node=stack1.pop();
			 list.add(node.data);
			 pushLeftNodes(node.right, stack1);
		 }

		 while(!stack2.isEmpty())
		 {
			 Node node=stack2.pop();
			 list.add(node.data);
			 pushLeftNodes(node.right, stack2);
		 }

		 return list;
	 }

	 private static void pushLeftNodes(Node root, Stack<Node> stack) {

		 while(root!=null)
		 {
			 stack.push(root);
			 root=root.left;
		 }
	 }

	 private static void traverse(Node root) {

		 if(root==null) return;

		 traverse(root.left);
		 System.out.print(root.data+" ");
		 traverse(root.right);

	 }
	 /*
	  * Time Complexity: O(n1+n2)
	  * Space Complexity: O(n1+n2)
	  */
	 private static Node merge2BSTBrute(Node root1, Node root2) {

		 List<Integer> list1=new ArrayList<>();
		 List<Integer> list2=new ArrayList<>();

		 inorderTraversal(root1,list1);
		 inorderTraversal(root2,list2);

		 List<Integer> merged=mergedBST(list1,list2);

		 return buildBST(merged,0,merged.size()-1);
	 }

	 private static Node buildBST(List<Integer> merged, int start, int end) {

		 if(start>end) return null;

		 int mid=(start+end)/2;

		 Node root=new Node(merged.get(mid));
		 root.left=buildBST(merged, start, mid-1);
		 root.right=buildBST(merged,mid+1, end);

		 return root;		
	 }

	 private static List<Integer> mergedBST(List<Integer> list1, List<Integer> list2) {

		 List<Integer> merged=new ArrayList<Integer>();
		 int i=0,j=0;

		 while(i<list1.size() && j<list2.size())
		 {
			 if(list1.get(i)<list2.get(j))
			 {
				 merged.add(list1.get(i++));
			 }
			 else
			 {
				 merged.add(list2.get(j++));
			 }
		 }

		 while(i<list1.size())
		 {
			 merged.add(list1.get(i++));
		 }

		 while(j<list2.size())
		 {
			 merged.add(list2.get(j++));
		 }

		 return merged;
	 }

	 private static void inorderTraversal(Node root, List<Integer> list) {

		 if(root==null) return;

		 inorderTraversal(root.left, list);
		 list.add(root.data);
		 inorderTraversal(root.right, list);
	 }
}
