package Tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PrintAllTheNodesAtADistanceOfKInABinaryTree {

	public static void main(String[] args) {

		Node root=new Node(20);
		root.left=new Node(8);
		root.right=new Node(22);
		root.left.left=new Node(4);
		root.left.right=new Node(12);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(14);
		Node target=root.left;
	    int K = 2;
	    
	    System.out.println(printAllNodesAtDistanceK(root,target,K));
	}

	private static ArrayList<Integer> printAllNodesAtDistanceK(Node root, Node target, int k) {

		Map<Node,Node> parentTrack=new HashMap<>();
		markParent(root,parentTrack,target);
		
		Queue<Node> queue=new LinkedList<>();
		Map<Node,Boolean> visited=new HashMap<>();
		
		queue.offer(target);
		visited.put(target,true);
		int curr_level=0;
		
		while(!queue.isEmpty())
		{
			int size=queue.size();
			if(curr_level==k) break;
			curr_level++;
			
			for(int i=0;i<size;i++)
			{
				Node current=queue.poll();
				if(current.left!=null && visited.get(current.left)==null)
				{
					queue.offer(current.left);
					visited.put(current.left,true);
				}
				
				if(current.right!=null && visited.get(current.right)==null)
				{
					queue.offer(current.right);
					visited.put(current.right,true);
				}
				
				if(parentTrack.get(current)!=null && visited.get(parentTrack.get(current))==null)
				{
					queue.offer(parentTrack.get(current));
					visited.put(parentTrack.get(current),true);
				}
			}
		}
		
		ArrayList<Integer> result=new ArrayList<>();
		
		while(!queue.isEmpty())
		{
			Node current=queue.poll();
			result.add(current.data);
		}
		
		return result;
	}

	private static void markParent(Node root, Map<Node, Node> parentTrack, Node target) {
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			Node current=queue.poll();
			
			if(current.left!=null)
			{
				queue.offer(current.left);
				parentTrack.put(current.left,current);
			}
			
			if(current.right!=null)
			{
				queue.offer(current.right);
				parentTrack.put(current.right,current);
			}
		}
		
	}
}
