package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * Time Complexity: O(N+M)
 * Space Complexity: O(N+M)
 * */
class Pair
{
	int first,second;
	Pair(int first,int second)
	{
		this.first=first;
		this.second=second;
	}
}

public class ShortestPathInDirectedAcyclicGraph {

	public static void main(String[] args) {

		int n = 6, m = 7;
		int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

		int[] result=shortestPathInDirectedAcyclicGraph(n,m,edge);
		System.out.println(Arrays.toString(result));
	}

	private static int[] shortestPathInDirectedAcyclicGraph(int n, int m, int[][] edge) 
	{
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<Pair>());
		}

		for(int i=0;i<m;i++)
		{
			adj.get(edge[i][0]).add(new Pair(edge[i][1],edge[i][2]));
		}

		int visited[]=new int[n];

		Stack<Integer> stack=new Stack<>();

		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
			{
				topoSort(i,adj,visited,stack);
			}
		}

		int[] dist = new int[n];
		Arrays.fill(dist, (int) 1e9);
		dist[0] = 0;

		while(!stack.isEmpty())
		{
			int node=stack.pop();

			if (dist[node] != (int) 1e9) {  
				for (Pair neighbor : adj.get(node)) {
					int vertex = neighbor.first;
					int weight = neighbor.second;

					if (dist[node] + weight < dist[vertex]) {
						dist[vertex] = dist[node] + weight;
					}
				}
			}
		}

		for(int i=0;i<n;i++)
		{
			if(dist[i]==(int)1e9)
			{
				dist[i]=-1;
			}
		}

		return dist;
	}

	private static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] visited, Stack<Integer> stack) {

		visited[node]=1;

		for (Pair neighbor : adj.get(node)) {
			int v = neighbor.first;
			if (visited[v] == 0) {
				topoSort(v, adj, visited, stack);
			}
		}

		stack.push(node);
	}
}
