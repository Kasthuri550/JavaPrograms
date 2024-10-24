package Tree.medium;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	
	static Node prev=null;

	public static void main(String[] args) {

		Node root=new Node(1);
		root.left=new Node(2);
		root.left.left=new Node(3);
		root.left.right=new Node(4);
		root.right=new Node(5);
		root.right.right=new Node(6);
		
//		flattenBT1(root);
//		flattenBT2(root);
		flattenBT3(root);
		
		System.out.println(root);
		
	}

	private static void flattenBT3(Node root) {
		
		Node curr=root;
		
		while(curr!=null)
		{
			if(curr.left!=null)
			{
				Node prev=curr.left;
				
				while(prev.right!=null)
				{
					prev=prev.right;
				}
				
				prev.right=curr.right;
				curr.right=curr.left;
				curr.left=null;
			}
			
			curr=curr.right;
		}
		
	}

	private static void flattenBT2(Node root) {
		
		Stack<Node> stack=new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			Node curr=stack.pop();
			
			if(curr.right!=null)
				stack.push(curr.right);
				
			if(curr.left!=null)
				stack.push(curr.left);
			
			if(!stack.isEmpty())
				curr.right=stack.peek();
			
			curr.left=null;
		}
		
	}

	private static void flattenBT1(Node root) {

		if(root==null) return;
		
		flattenBT1(root.right);
		flattenBT1(root.left);
		
		root.right=prev;
		root.left=null;
		
		prev=root;		
		
	}
}
