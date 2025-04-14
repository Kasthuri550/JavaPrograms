package Graph.hard;

import java.util.ArrayList;
import java.util.Stack;
/*
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E)
 * */
public class StronglyConnectedComponents {

	public static void main(String[] args) {

		int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);

       System.out.println(kosaraju(V, adj));
	}

	private static int kosaraju(int v, ArrayList<ArrayList<Integer>> adj) {

		int visited[]=new int[v];
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<v;i++)
		{
			if(visited[i]==0)
			{
				dfs1(i,visited,adj,stack);
			}
		}
		
		ArrayList<ArrayList<Integer>> adjT=new ArrayList<>();
		
		for(int i=0;i<v;i++)
		{
			adjT.add(new ArrayList<>());
		}
		
		for(int i=0;i<v;i++)
		{
			visited[i]=0;
			for(int it:adj.get(i))
			{
				adjT.get(it).add(i);
			}
		}
		
		int scc=0;
		while(!stack.isEmpty())
		{
			int node=stack.pop();
			
			if(visited[node]==0)
			{
				scc++;
				dfs2(node,visited,adjT);
			}
		}
		
		return scc;
	}

	private static void dfs2(int node, int[] visited, ArrayList<ArrayList<Integer>> adjT) {

		visited[node]=1;
		
		for(int it:adjT.get(node))
		{
			if(visited[it]==0)
			{
				dfs2(it, visited, adjT);
			}
		}
	}

	private static void dfs1(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {

		visited[node]=1;
		for(int it:adj.get(node))
		{
			if(visited[it]==0)
			{
				dfs1(it, visited, adj, stack);
			}
		}
		
		stack.push(node);
	}
}
