package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTreeTraversal {

	public static void main(String[] args) {
		
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		node.left.left=new TreeNode(4);
		node.left.right=new TreeNode(5);
		node.right.left=new TreeNode(6);
		node.right.right=new TreeNode(7);
		
		ArrayList<Integer> zigZagTraversalList = zigZagTraversal(node);
		System.out.println(zigZagTraversalList);

	}

	private static ArrayList<Integer> zigZagTraversal(TreeNode node) {
		
		ArrayList<Integer> zigZagList=new ArrayList<Integer>();
		
		if(node==null) return zigZagList;
		
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(node);
		
		boolean leftToRight=true;
		
		while(!queue.isEmpty())
		{
			int size=queue.size();
			
			ArrayList<Integer> row=new ArrayList<Integer>(size);
			
			for(int i=0;i<size;i++)
			{
				TreeNode current=queue.poll();
				if(leftToRight)
				{
					row.add(current.data);
				}
				else
				{
					row.add(0,current.data);
				}
				
				if(current.left!=null) queue.offer(current.left);
				
				if(current.right!=null) queue.offer(current.right);
				
				zigZagList.addAll(row);
				
				leftToRight=!leftToRight;
			}
		}
		return zigZagList;
	}
}
