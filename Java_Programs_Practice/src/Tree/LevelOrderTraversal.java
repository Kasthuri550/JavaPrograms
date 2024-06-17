package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		
		TreeNode treeNode=new TreeNode(1);
		treeNode.left=new TreeNode(3);
		treeNode.right=new TreeNode(2);
		
		System.out.println(bfs(treeNode));

	}

	private static List<List<Integer>> bfs(TreeNode treeNode) {
		
		List<List<Integer>> levelOrderList=new ArrayList<>();
		
		if(treeNode==null) return levelOrderList;
		
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(treeNode);
		
		while(!queue.isEmpty())
		{
			List<Integer> subList=new ArrayList<Integer>();
			for(int i=0;i<queue.size();i++)
			{
				TreeNode current=queue.poll();
				
				subList.add(current.data);
				
				if(current.left!=null) queue.add(current.left);
				
				if(current.right!=null) queue.add(current.right);
			
			}
			
			levelOrderList.add(subList);
		}
		
		return levelOrderList;
	}
}
