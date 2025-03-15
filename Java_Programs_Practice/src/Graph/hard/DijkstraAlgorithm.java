package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class iPair
{
	int vertex,weight;

	iPair(int vertex,int weight)
	{
		this.vertex=vertex;
		this.weight=weight;
	}
}
public class DijkstraAlgorithm {

	public static void main(String[] args) {

		int src=0;

		ArrayList<ArrayList<iPair>> adj=new ArrayList<>();
		
		for(int i=0;i<2;i++)
		{
			adj.add(new ArrayList<>());
		}
		
			adj.get(0).add(new iPair(1, 9));
			adj.get(1).add(new iPair(0,9));
			
			ArrayList<Integer> list=dijkstra(adj,src);
			System.out.println(list);

	}
	
	private static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src)
	{
		int v=adj.size();
		PriorityQueue<iPair> pq=new PriorityQueue<iPair>((x,y)->x.vertex-y.vertex);
		
		ArrayList<Integer> dist=new ArrayList<>(Collections.nCopies(v,Integer.MAX_VALUE));
		
		dist.set(src,0);
		
		pq.offer(new iPair(src,0));
		
		while(!pq.isEmpty())
		{
			iPair pair=pq.poll();
			int vertex=pair.vertex;
			
			for(iPair neighbour:adj.get(vertex))
			{
				int node=neighbour.vertex;
				int weight=neighbour.weight;
				
				if(dist.get(vertex)+weight<dist.get(node))
				{
					dist.set(node,dist.get(vertex)+weight);
					pq.offer(new iPair(node, weight));
				}
			}
		}
		
		return dist;
	}
}
