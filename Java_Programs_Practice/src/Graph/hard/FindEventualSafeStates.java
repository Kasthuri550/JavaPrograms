package Graph.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time Complexity: O(V+E)+O(N*log N)
 * Space Complexity: O(N)+O(N)+O(N) ~ O(3N)
 * */

public class FindEventualSafeStates {

	public static void main(String[] args) {

		int V = 12;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(2).add(4);
		adj.get(3).add(4);
		adj.get(3).add(5);
		adj.get(4).add(6);
		adj.get(5).add(6);
		adj.get(6).add(7);
		adj.get(8).add(1);
		adj.get(8).add(9);
		adj.get(9).add(10);
		adj.get(10).add(8);
		adj.get(11).add(9);


		List<Integer> eventualSafeStates = eventualSafeStates(V,adj);
		System.out.println(eventualSafeStates);
	}

	private static List<Integer> eventualSafeStates(int v, List<List<Integer>> adj) {

		List<List<Integer>> adjRev=new ArrayList<>();
		
		for(int i=0;i<v;i++)
		{
			adjRev.add(new ArrayList<Integer>());
		}
		
		int indegree[]=new int[v];
		
		for(int i=0;i<v;i++)
		{
			for(int it:adj.get(i))
			{
				adjRev.get(it).add(i);
				indegree[i]++;
			}
		}
		
		Queue<Integer> queue=new LinkedList<>();
		
		for(int i=0;i<v;i++)
		{
			if(indegree[i]==0)
			{
				queue.offer(i);
			}
		}
		
		List<Integer> safeNodes=new ArrayList<>();
		
		while(!queue.isEmpty())
		{
			int node=queue.poll();
			safeNodes.add(node);
			
			for(int it:adjRev.get(node))
			{
				indegree[it]--;
				
				if(indegree[it]==0)
				{
					queue.offer(it);
				}
			}
		}
		
		Collections.sort(safeNodes);
		
		return safeNodes;
	}
}
