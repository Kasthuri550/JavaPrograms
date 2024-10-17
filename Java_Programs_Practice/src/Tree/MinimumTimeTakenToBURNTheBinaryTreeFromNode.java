package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumTimeTakenToBURNTheBinaryTreeFromNode {

	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);
        
        int target=8;
        
        System.out.println(minTime(root,target));

	}

	private static int minTime(Node root, int target) {
		
		if(root==null) return 0;
		
		Map<Node,Node> parentTrack=new HashMap<>();
		
		Node targetNode=mapParents(root,parentTrack,target);
		
		if(targetNode==null) return 0;
		
		return burnTree(targetNode,parentTrack);
		
	}

	private static int burnTree(Node targetNode, Map<Node, Node> parentTrack) {

		Map<Node,Boolean> visited=new HashMap<Node, Boolean>();
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(targetNode);
		
		visited.put(targetNode,true);
		
		int timeToBurn=0;
		
		while(!queue.isEmpty())
		{
			int size=queue.size();
			
			boolean anyFireSpread=false;
			
			for(int i=0;i<size;i++)
			{
				Node current=queue.poll();
				
				if(current.left!=null && visited.get(current.left)==null)
				{
					anyFireSpread=true;
					queue.offer(current.left);
					visited.put(current.left,true);
				}
				
				if(current.right!=null && visited.get(current.right)==null)
				{
					anyFireSpread=true;
					queue.offer(current.right);
					visited.put(current.right,true);
				}
				
				if(parentTrack.get(current)!=null && visited.get(parentTrack.get(current))==null)
				{
					anyFireSpread=true;
					queue.offer(parentTrack.get(current));
					visited.put(parentTrack.get(current),true);
				}
			}
			
			if(anyFireSpread)
			{
				timeToBurn++;
			}		
		}
		
		return timeToBurn;
	}

	private static Node mapParents(Node root, Map<Node, Node> parentTrack, int target) {

		Queue<Node> queue=new LinkedList<>();
		
		queue.offer(root);
		
		Node targetNode=null;
		
		while(!queue.isEmpty())
		{
			Node current=queue.poll();
			
			if(current.data==target)
			{
				targetNode=current;
			}
			
			if(current.left!=null)
			{
				parentTrack.put(current.left,current);
				queue.offer(current.left);
			}
			
			if(current.right!=null)
			{
				parentTrack.put(current.right,current);
				queue.offer(current.right);
			}
			
		}
		
		
		return targetNode;
	}
}
