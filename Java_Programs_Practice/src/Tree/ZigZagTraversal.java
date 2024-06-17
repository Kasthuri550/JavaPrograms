package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {

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
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		if(node==null)
			return resultList;
		Queue<TreeNode> nodeQueues=new LinkedList<TreeNode>();
		nodeQueues.offer(node);
		boolean leftToRight=true;
		while(!nodeQueues.isEmpty())
		{
			int size=nodeQueues.size();
			ArrayList<Integer> row=new ArrayList<Integer>();
			for(int i=0;i<size;i++)
			{
				TreeNode root=nodeQueues.poll();
				if(leftToRight)
				{
					row.add(root.data);
				}
				else
				{
					row.add(0,root.data);
				}
				if(root.left!=null) nodeQueues.offer(root.left);
				if(root.right!=null) nodeQueues.offer(root.right);
			}
			
			resultList.addAll(row);
			leftToRight=!leftToRight;			
		}
		
		return resultList;
	}

}
