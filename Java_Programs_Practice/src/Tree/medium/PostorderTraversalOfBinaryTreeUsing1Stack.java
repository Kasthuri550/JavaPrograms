package Tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversalOfBinaryTreeUsing1Stack {

	public static void main(String[] args) {
		
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.left.right.left=new TreeNode(6);
		root.left.right.right=new TreeNode(7);
		root.right=new TreeNode(3);
		root.right.right=new TreeNode(8);
		root.right.right.left=new TreeNode(9);
		
		System.out.println(postorderTraversalOfBinaryTree1Stack(root));
		
	}

	private static List<Integer> postorderTraversalOfBinaryTree1Stack(TreeNode root) {

		List<Integer> postOrder=new ArrayList<>();
		
		if(root==null) return postOrder;
		
		Stack<TreeNode> stack=new Stack<>();
		TreeNode current=root;
		
		while(current!=null || !stack.isEmpty())
		{
			if(current!=null)
			{
				stack.push(current);
				current=current.left;
			}
			else
			{
				TreeNode temp=stack.peek().right;
				
				if(temp==null)
				{
					temp=stack.pop();
					postOrder.add(temp.val);
					
					while(!stack.isEmpty() && temp==stack.peek().right)
					{
						temp=stack.pop();
						postOrder.add(temp.val);
					}
				}
				else
				{
					current=temp;
				}
			}
		}
		return postOrder;
	}
}
