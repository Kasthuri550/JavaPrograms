package Tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
/*
 Time Complexity (TC): O(N log N)
 Space Complexity (SC): O(N)
 */
public class BottomViewOfBinaryTree {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println(topView(root));

	}

	private static ArrayList<Integer> topView(Node root) {

		ArrayList<Integer> result=new ArrayList<Integer>();

		if(root==null) return result;

		Queue<Pair<Node,Integer>> queue=new LinkedList<>();

		Map<Integer,Integer> map=new TreeMap<>();

		queue.offer(new Pair<>(root,0));

		while(!queue.isEmpty())
		{
			Pair<Node,Integer> temp=queue.poll();
			Node node=temp.key;
			int vertical=temp.value;


			map.put(vertical,node.data);


			if(node.left!=null)
			{
				queue.offer(new Pair<>(node.left,vertical-1));
			}

			if(node.right!=null)
			{
				queue.offer(new Pair<>(node.right,vertical+1));
			}
		}

		for(int value:map.values())
		{
			result.add(value);
		}

		return result;
	}
}
