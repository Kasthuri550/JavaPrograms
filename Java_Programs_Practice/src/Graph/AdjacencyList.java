package Graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(V+E)
 * Undirected Space Complexity: O(2E)
 * Directed Space Complexity: O(E)
 */
public class AdjacencyList {

	static class Edge
	{
		int destination,weight;

		Edge(int destination,int weight)
		{
			this.destination=destination;
			this.weight=weight;
		}
	}

	public static void main(String[] args) {

		int vertices = 5;

		int[][] edges = {
				{0, 1},
				{0, 4},
				{1, 2},
				{1, 3},
				{1, 4},
				{2, 3},
				{3, 4}
		};


		adjacencyListForUndirectedAndUnweightedGraph(vertices,edges);
		adjacencyListForUndirectedAndWeightedGraph(vertices);
		adjacencyListForDirectedAndUnweightedGraph(vertices,edges);
		adjacencyListForDirectedAndWeightedGraph(vertices);
	}

	private static void adjacencyListForDirectedAndWeightedGraph(int vertices) {

		int[][] edges = {
				{0, 1, 10},
				{0, 4, 20},
				{1, 2, 30},
				{1, 3, 40},
				{1, 4, 50},
				{2, 3, 60},
				{3, 4, 70}
		};

		List<List<Edge>> adjacencyList=new ArrayList<>();

		for(int i=0;i<vertices;i++)
		{
			adjacencyList.add(new ArrayList<Edge>());
		}

		for(int[] edge:edges)
		{
			int u=edge[0];
			int v=edge[1];
			int weight=edge[2];

			adjacencyList.get(u).add(new Edge(v,weight));
		}

		displayAdjacencyListForWeightedGraph(adjacencyList, vertices);
	}

	private static void adjacencyListForDirectedAndUnweightedGraph(int vertices,int edges[][]) {

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
		}

		displayAdjacencyList(adjacencyList, vertices);
	}

	private static void adjacencyListForUndirectedAndWeightedGraph(int vertices) 
	{
		int[][] edges = {
				{0, 1, 10},
				{0, 4, 20},
				{1, 2, 30},
				{1, 3, 40},
				{1, 4, 50},
				{2, 3, 60},
				{3, 4, 70}
		};

		List<List<Edge>> adjacencyList=new ArrayList<>();

		for(int i=0;i<vertices;i++)
		{
			adjacencyList.add(new ArrayList<Edge>());
		}

		for(int[] edge:edges)
		{
			int u=edge[0];
			int v=edge[1];
			int weight=edge[2];

			adjacencyList.get(u).add(new Edge(v,weight));
			adjacencyList.get(v).add(new Edge(u,weight));
		}		

		displayAdjacencyListForWeightedGraph(adjacencyList,vertices);
	}


	private static void displayAdjacencyListForWeightedGraph(List<List<Edge>> adjacencyList, int vertices) {

		for(int i=0;i<vertices;i++)
		{
			System.out.print(i+" ");
			for(Edge edge:adjacencyList.get(i))
			{
				System.out.print("-> ("+edge.destination+", Weight: "+edge.weight+")");
			}
			System.out.println();
		}
	}

	private static void adjacencyListForUndirectedAndUnweightedGraph(int vertices,int edges[][]) 
	{
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

		displayAdjacencyList(adjacencyList,vertices);

	}

	private static void displayAdjacencyList(List<List<Integer>> adjacencyList, int vertices) {

		for(int i=0;i<vertices;i++)
		{
			System.out.print(i+": ");
			for(int edge:adjacencyList.get(i))
			{
				System.out.print("-> "+edge);
			}
			System.out.println();
		}
	}
}
