package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DijkstraUsingSet {

	static class Node implements Comparable<Node>
	{
		int vertex,weight;

		Node(int vertex,int weight)
		{
			this.vertex=vertex;
			this.weight=weight;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.weight,other.weight);
		}

	}

	public static void main(String[] args) {

		int V = 5;
		Map<Integer, List<Node>> graph = new HashMap<>();

		// Graph edges
		graph.put(0, Arrays.asList(new Node(1, 10), new Node(4, 3)));
		graph.put(1, Arrays.asList(new Node(2, 2)));
		graph.put(2, Arrays.asList(new Node(3, 9)));
		graph.put(3, new ArrayList<>());
		graph.put(4, Arrays.asList(new Node(1, 4), new Node(2, 8)));

		int result[]=dijkstra(graph, 0, V);
		System.out.println(Arrays.toString(result));
	}

	private static int[] dijkstra(Map<Integer, List<Node>> graph, int source, int V) {

		int dist[]=new int[V];

		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[source]=0;

		TreeSet<Node> set=new TreeSet<>();
		set.add(new Node(source,0));

		while(!set.isEmpty())
		{
			Node current=set.pollFirst();
			int u=current.vertex;

			for(Node neighbour:graph.getOrDefault(u,new ArrayList<>()))
			{
				int v=neighbour.vertex;
				int weight=neighbour.weight;

				if(dist[u]+weight<dist[v])
				{
					set.remove(new Node(v,dist[v]));
					dist[v]=dist[u]+weight;
					set.add(new Node(v,dist[v]));
				}
			}
		}

		return dist;
	}
}
