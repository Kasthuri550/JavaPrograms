package Tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);
        
       System.out.println(verticalOrderTraversal(root));

	}

	private static List<List<Integer>> verticalOrderTraversal(Node root) {
		
		Map<Integer,Map<Integer,TreeSet<Integer>>> nodes=new TreeMap<>();
		
		Queue<Pair<Node,Pair<Integer,Integer>>> queue=new LinkedList<>();
		
		queue.add(new Pair<>(root,new Pair<>(0,0)));
		
		while(!queue.isEmpty())
		{
			Pair<Node,Pair<Integer,Integer>> pair=queue.poll();
			
			Node temp=pair.getKey();
			
			int x=pair.getValue().getKey();
			int y=pair.getValue().getValue();
			
			nodes.computeIfAbsent(x,k-> new TreeMap<>())
				 .computeIfAbsent(y,k->new TreeSet<>())
				 .add(temp.data);
			System.out.println(nodes);
			
			if(temp.left!=null)
			{
				queue.offer(new Pair<>(temp.left,new Pair<>(x-1,y+1)));
			}
			
			if(temp.right!=null)
			{
				queue.offer(new Pair<>(temp.right,new Pair<>(x+1,y+1)));
			}
		}
		
		List<List<Integer>> result=new ArrayList<>();
		
		for(Map<Integer,TreeSet<Integer>> node:nodes.values())
		{
			List<Integer> list=new ArrayList<>();
			
			for(TreeSet<Integer> set:node.values())
			{
				list.addAll(set);
			}
			
			result.add(list);
		}
		
		return result;
	}
}
