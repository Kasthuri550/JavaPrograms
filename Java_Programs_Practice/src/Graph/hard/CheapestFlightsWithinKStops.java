package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
 * Time Complexity: O(m*k)
 * Space Complexity: O(n*k)
 * */
public class CheapestFlightsWithinKStops {

	static class Pair
	{
		int first,second;

		Pair(int first,int second)
		{
			this.first=first;
			this.second=second;
		}
	}

	static class Tuple
	{
		int first,second,third;

		Tuple(int first,int second,int third)
		{
			this.first=first;
			this.second=second;
			this.third=third;
		}
	}

	public static void main(String[] args) {

		int n = 4,flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int src = 0,dst = 3,k = 1;

		System.out.println(cheapestFlightsWithinKStops(n,flights,src,dst,k));
	}

	private static int cheapestFlightsWithinKStops(int n, int[][] flights, int src, int dst, int k) {

		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}

		int m=flights.length;

		for(int i=0;i<m;i++)
		{
			adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
		}

		Queue<Tuple> queue=new LinkedList<>();
		int dist[]=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);

		dist[src]=0;
		queue.offer(new Tuple(0,src,0));

		while(!queue.isEmpty())
		{
			Tuple tuple=queue.poll();
			int steps=tuple.first;
			int node=tuple.second;
			int distance=tuple.third;

			if(steps>k) continue;

			for(Pair neighbour:adj.get(node))
			{
				int adjNode=neighbour.first;
				int edist=neighbour.second;

				if(distance+edist<dist[adjNode] && steps<=k)
				{
					dist[adjNode]=distance+edist;
					queue.offer(new Tuple(steps+1,adjNode,distance+edist));
				}
			}
		}

		return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
	}
}
