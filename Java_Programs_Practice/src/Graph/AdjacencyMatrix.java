package Graph;

import java.util.Scanner;
/*
 * Time Complexity: O(E)
 * Space Complexity: O(V^2)
 */
public class AdjacencyMatrix {

	public static void main(String[] args) {

		adjacencyMatrixForUndirectedAndUnweightedGraph();
		adjacencyMatrixForUndirectedAndWeightedGraph();
		adjacencyMatrixForDirectedAndUnweightedGraph();
		adjacencyMatrixForDirectedAndWeightedGraph();

	}

	private static void adjacencyMatrixForDirectedAndUnweightedGraph() {

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the number of vertices: ");
		int vertices=sc.nextInt();

		System.out.println("Enter the number of edges: ");
		int edges=sc.nextInt();

		int adjacencyMatrix[][]=new int[vertices][vertices];

		final int INF=Integer.MAX_VALUE;

		System.out.println("Enter the edges: ");

		for(int i=0;i<edges;i++)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();

			adjacencyMatrix[u][v]=1;
		}

		displayAdjacencyMatrix(adjacencyMatrix, vertices);
	}

	private static void adjacencyMatrixForDirectedAndWeightedGraph() {

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the number of vertices: ");
		int vertices=sc.nextInt();

		System.out.println("Enter the number of edges: ");
		int edges=sc.nextInt();

		int adjacencyMatrix[][]=new int[vertices][vertices];

		final int INF=Integer.MAX_VALUE;

		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				adjacencyMatrix[i][j]=INF;
			}
		}

		System.out.println("Enter the edges: ");

		for(int i=0;i<edges;i++)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			int weight=sc.nextInt();

			adjacencyMatrix[u][v]=weight;
		}

		displayAdjacencyMatrix(adjacencyMatrix, vertices);
	}

	private static void adjacencyMatrixForUndirectedAndWeightedGraph() {

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the number of vertices: ");
		int vertices=sc.nextInt();

		System.out.println("Enter the number of edges: ");
		int edges=sc.nextInt();

		int adjacencyMatrix[][]=new int[vertices][vertices];

		final int INF=Integer.MAX_VALUE;

		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				if(i!=j)
				{
					adjacencyMatrix[i][j]=INF;
				}
			}
		}

		System.out.println("Enter the edges: ");

		for(int i=0;i<edges;i++)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			int weight=sc.nextInt();

			adjacencyMatrix[u][v]=weight;
			adjacencyMatrix[v][u]=weight;
		}

		displayAdjacencyMatrix(adjacencyMatrix, vertices);
	}

	private static void adjacencyMatrixForUndirectedAndUnweightedGraph() {

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter number of vertices: ");
		int vertices=sc.nextInt();

		System.out.println("Enter number of edges: ");
		int edges=sc.nextInt();

		int adjacencyMatrix[][]=new int[vertices][vertices];

		System.out.println("Enter the edges: ");

		for(int i=0;i<edges;i++)
		{
			int u=sc.nextInt();

			int v=sc.nextInt();

			adjacencyMatrix[u][v]=1;
			adjacencyMatrix[v][u]=1;
		}
		System.out.println("Adjacency Matrix: ");
		displayAdjacencyMatrix(adjacencyMatrix,vertices);
	}

	private static void displayAdjacencyMatrix(int[][] adjacencyMatrix,int vertices) {

		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				System.out.print(adjacencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
