package Tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderInorderAndPostorderTraversalInOneTraversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println(preInPostInOneTraversal(root));
	}

	private static List<List<Integer>> preInPostInOneTraversal(TreeNode root) {
		
		List<Integer> pre=new ArrayList<Integer>();
		List<Integer> in=new ArrayList<Integer>();
		List<Integer> post=new ArrayList<>();
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		
		if(root==null) return result;
		
		Stack<Pair<TreeNode,Integer>> stack=new Stack<>();
		stack.push(new Pair<>(root,1));
		
		while(!stack.isEmpty())
		{
			Pair<TreeNode, Integer> pair = stack.pop();
			
			if(pair.getValue()==1)
			{
				pre.add(pair.getKey().val);
				pair.setValue(2);
				stack.push(pair);
				
				if(pair.getKey().left!=null)
				{
					stack.push(new Pair<>(pair.getKey().left,1));
				}
			}
			else if(pair.getValue()==2)
			{
				in.add(pair.getKey().val);
				pair.setValue(3);
				stack.push(pair);
				
				if(pair.getKey().right!=null)
				{
					stack.push(new Pair<>(pair.getKey().right,1));
				}
			}
			else
			{
				post.add(pair.getKey().val);
			}
		}
		
		result.add(pre);
		result.add(in);
		result.add(post);
		
		return result;
		
	}
}
