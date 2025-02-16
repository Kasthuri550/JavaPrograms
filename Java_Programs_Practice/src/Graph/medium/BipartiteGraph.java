package Graph.medium;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Time Complexity: O(V+2E)
 * Space Complexity: O(3V) ~ O(V)
 * */
public class BipartiteGraph {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
				Arrays.asList(
						new ArrayList<>(Arrays.asList(1)), 
						new ArrayList<>(Arrays.asList(0, 2)), 
						new ArrayList<>(Arrays.asList(1))
						)
				);

		System.out.println(bipartiteGraph(adj));

	}

	private static boolean bipartiteGraph(ArrayList<ArrayList<Integer>> adj) {

		int v=adj.size();
		int color[]=new int[v];

		for(int i=0;i<v;i++)
		{
			color[i]=-1;
		}

		for(int i=0;i<v;i++)
		{
			if(color[i]==-1)
			{
				if(!dfs(i,0,color,adj))
				{
					return false;
				}
			}
		}

		return true;
	}

	private static boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {

		color[node]=col;

		for(int vertex:adj.get(node))
		{
			if(color[vertex]==-1)
			{
				if(!dfs(vertex,1-col,color,adj))
				{
					return false;
				}
			}
			else if(color[vertex]==col)
			{
				return false;
			}
		}

		return true;
	}

}
