package Tree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfABinaryTree {
	
	static class Pair<K,V>
	{
		K node;
		V num;
		
		Pair()
		{
			
		}
		
		Pair(K node,V num)
		{
			this.node=node;
			this.num=num;
		}

	}

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
		
		System.out.println(maximumWidth(root));

	}

	private static int maximumWidth(Node root) {
		
		if(root==null) return 0;
		
		Queue<Pair<Node,Integer>> queue=new LinkedList<>();
		
		queue.offer(new Pair<>(root,0));
		
		int max=0;
		
		while(!queue.isEmpty())
		{
			int size=queue.size();
			int min=queue.peek().num;
			int first=0,last=0;
			
			for(int i=0;i<size;i++)
			{
				int curr_id=queue.peek().num-min;
				Node node=queue.peek().node;
				queue.poll();
				
				if(i==0) first=curr_id;
				
				if(i==size-1) last=curr_id;
				
				if(node.left!=null)
				{
					queue.offer(new Pair<>(node.left,2*curr_id+1));
				}
				
				if(node.right!=null)
				{
					queue.offer(new Pair<>(node.right,2*curr_id+2));
				}
			}
			
			max=Math.max(max,last-first+1);
		}
		
		return max;
	}
}
