package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E)
 * */
public class ShortestPathInUndirected2 {

	public static void main(String[] args) {

		int n=9, m=10;
		int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};

		int result[]=shortestPathInUndirected2(n,m,edge,0);
		System.out.println(Arrays.toString(result));
	}

	private static int[] shortestPathInUndirected2(int n, int m, int[][] edge,int src) {

		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}

		for(int i=0;i<m;i++)
		{
			adj.get(edge[i][0]).add(edge[i][1]);
			adj.get(edge[i][1]).add(edge[i][0]);
		}

		int dist[]=new int[n];

		Arrays.fill(dist,Integer.MAX_VALUE);

		Queue<Integer> queue=new LinkedList<>();
		queue.offer(src);

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
