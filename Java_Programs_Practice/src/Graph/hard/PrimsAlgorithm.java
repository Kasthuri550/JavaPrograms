package Graph.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Time Complexity: O(E log V)
 * Space Complexity: O(V + E)
 */
public class PrimsAlgorithm {

	static class Pair
	{
		int node,weight;

		Pair(int node,int weight)
		{
			this.node=node;
			this.weight=weight;
		}
	}

	public static void main(String[] args) {

		int V=3,E=3;

		List<List<int[]>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(new int[]{1, 5});
		adj.get(1).add(new int[]{0, 5});

		adj.get(1).add(new int[]{2, 3});
		adj.get(2).add(new int[]{1, 3});

		adj.get(0).add(new int[]{2, 1});
		adj.get(2).add(new int[]{0, 1});

		printAdj(V,adj);
		System.out.println(primsAlgorithm(V,E,adj));
	}

	private static void printAdj(int V,List<List<int[]>> adj) {

		for (int i = 0; i < V; i++) {
			System.out.print(i + " -> ");
			for (int[] edge : adj.get(i)) {
				System.out.print("(" + edge[0] + "," + edge[1] + ") ");
			}
			System.out.println();
		}
	}

	private static int primsAlgorithm(int v, int e, List<List<int[]>> adj) {

		PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(arr->arr[0]));
		pq.offer(new int[] {0,0});

		boolean visited[]=new boolean[v];

		int mstWeight=0;

		while(!pq.isEmpty())
		{
			int current[]=pq.poll();
			int w=current[0];
			int u=current[1];

			if(visited[u]) continue;

			visited[u]=true;
			mstWeight+=w;

			for(int neighbour[]:adj.get(u))
			{
				int edgeWeight=neighbour[1];
				int next=neighbour[0];

				if(!visited[next])
				{
					pq.offer(new int[] {edgeWeight,next});
				}
			}
		}

		return mstWeight;
	}
}
