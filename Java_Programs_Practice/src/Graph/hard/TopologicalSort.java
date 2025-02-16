package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * Time Complexity: O(V+2E)+O(V)
 * Space Complexity: O(2N)+O(N)
 * */
public class TopologicalSort {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
		    adj.add(new ArrayList<>());
		}

		adj.get(1).add(3);
		adj.get(2).add(3);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(5).add(0);
		adj.get(5).add(2);

		
		int result[]=topologicalSort(adj);
		System.out.println(Arrays.toString(result));
	}

	private static int[] topologicalSort(ArrayList<ArrayList<Integer>> adj) {

		int v=adj.size();
		int visited[]=new int[v];
		
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<v;i++)
		{
			if(visited[i]==0)
			{
				dfs(i,visited,stack,adj);
			}
		}
		
		int result[]=new int[v],i=0;
		
		while(!stack.isEmpty())
		{
			result[i++]=stack.pop();
		}
		
		return result;
	}

	private static void dfs(int vertex, int[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) 
	{
		visited[vertex]=1;
		
		for(int v:adj.get(vertex))
		{
			if(visited[v]==0)
			{
				dfs(v,visited,stack,adj);
			}
		}
		
		stack.push(vertex);
	}
}
