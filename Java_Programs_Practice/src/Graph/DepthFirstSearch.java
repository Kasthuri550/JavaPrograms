package Graph;

import java.util.ArrayList;
/*
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E)
 */
public class DepthFirstSearch {

	public static void main(String[] args) {

		int vertices=5;

		int edges[][]= {{0,2},{0,3},{0,1},{2,4}};

		ArrayList<ArrayList<Integer>> adjacencyList=new ArrayList<>();

		for(int i=0;i<vertices;i++)
		{
			adjacencyList.add(new ArrayList<Integer>());
		}

		for(int edge[]:edges)
		{
			int u=edge[0];
			int v=edge[1];

			adjacencyList.get(u).add(v);
			adjacencyList.get(v).add(u);
		}

		System.out.println(depthFirstSearch(vertices,adjacencyList));

	}

	private static ArrayList<Integer> depthFirstSearch(int vertices,ArrayList<ArrayList<Integer>> adjacencyList) 
	{
		ArrayList<Integer> dfs=new ArrayList<>();

		boolean visited[]=new boolean[vertices+1];

		visited[0]=true;

		dfs(0,visited,dfs,adjacencyList);

		return dfs;

	}

	private static void dfs(int vertex, boolean[] visited, ArrayList<Integer> dfs,
			ArrayList<ArrayList<Integer>> adjacencyList) {

		visited[vertex]=true;
		dfs.add(vertex);

		for(int node:adjacencyList.get(vertex))
		{
			if(!visited[node])
				dfs(node,visited,dfs,adjacencyList);
		}
	}


}
