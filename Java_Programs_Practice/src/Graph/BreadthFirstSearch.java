package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time Complexity: O(V+2E)
 * Space Complexity: O(V)+O(E)+O(V+2E)
 */
public class BreadthFirstSearch {

	public static void main(String[] args) {

		int vertices=5;

		int edges[][]= {{0,2},{0,1},{2,4},{0,3}};

		List<List<Integer>> adjacencyList=new ArrayList<>();


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

		breadthFirstSearch(vertices,adjacencyList);

	}

	private static void breadthFirstSearch(int v, List<List<Integer>> adjacencyList) {

		ArrayList<Integer> bfs=new ArrayList<>();
		Queue<Integer> queue=new LinkedList<>();
		boolean visited[]=new boolean[v];

		queue.add(0);
		visited[0]=true;

		while(!queue.isEmpty())
		{
			int currVertex=queue.poll();
			bfs.add(currVertex);

			for(int vertex:adjacencyList.get(currVertex))
			{
				if(!visited[vertex])
				{
					visited[vertex]=true;
					queue.add(vertex);
				}
			}		
		}

		System.out.println(bfs);
	}
}
