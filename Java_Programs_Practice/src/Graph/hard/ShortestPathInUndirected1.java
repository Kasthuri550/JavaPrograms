package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E)
 * */
public class ShortestPathInUndirected1 {

	public static void main(String[] args) {

		int n = 9; 
		int src = 0;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();  // O(V + E).

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).addAll(Arrays.asList(1, 3));
		adj.get(1).addAll(Arrays.asList(0, 2));
		adj.get(2).addAll(Arrays.asList(1, 6));
		adj.get(3).addAll(Arrays.asList(0, 4));
		adj.get(4).addAll(Arrays.asList(3, 5));
		adj.get(5).addAll(Arrays.asList(4, 6));
		adj.get(6).addAll(Arrays.asList(2, 5, 7, 8));
		adj.get(7).addAll(Arrays.asList(6, 8));
		adj.get(8).addAll(Arrays.asList(7, 6));

		System.out.println("Adjacency List Representation:");
		for (int i = 0; i < n; i++) {
			System.out.println(i + " -> " + adj.get(i));
		}

		int result[]=shortestPathInUndirected(adj,src);
		System.out.println(Arrays.toString(result));

	}

	private static int[] shortestPathInUndirected(ArrayList<ArrayList<Integer>> adj, int src) {

		int n=adj.size();

		int dist[]=new int[n]; //O(V)

		Arrays.fill(dist,Integer.MAX_VALUE);

		Queue<Integer> queue=new LinkedList<>(); //O(V)
		queue.add(src);
		dist[src]=0;

		while(!queue.isEmpty())
		{
			int node=queue.poll();

			for(int neighbour:adj.get(node))
			{
				if(dist[node]+1<dist[neighbour])
				{
					dist[neighbour]=dist[node]+1;
					queue.offer(neighbour);
				}
			}
		}

		for(int i=0;i<n;i++)
		{
			if(dist[i]==Integer.MAX_VALUE)
			{
				dist[i]=-1;
			}
		}

		return dist;
	}
}
