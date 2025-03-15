package Graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * Time Complexity: O((V+E)*logV)
 * Space Complexity: O(V+E)
 * */
public class NetworkDelayTime {
	
	static class Pair
	{
		int node,weight;
		Pair(int node,int weight)
		{
			this.node=node;
			this.weight=weight;
		}
	}

	public static void main(String[] args) 
	{
		int times[][] = {{2,1,1},{2,3,1},{3,4,1}}, n = 4, k = 2;
		
		System.out.println(networkDelayTime(times,n,k));
	}

	private static int networkDelayTime(int[][] times, int n, int k) {

		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		
		for(int i=0;i<=n;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int time[]:times)
		{
			adj.get(time[0]).add(new Pair(time[1],time[2]));
		}
		
		PriorityQueue<Pair> queue=new PriorityQueue<>(Comparator.comparingInt(p->p.weight));
		queue.offer(new Pair(k,0));
		
		int dist[]=new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[k]=0;
		
		while(!queue.isEmpty())
		{
			Pair pair=queue.poll();
			int node=pair.node;
			int weight=pair.weight;
			for(Pair neighbour:adj.get(node))
			{
				int nextNode=neighbour.node;
				int nextWeight=neighbour.weight;
				
				if(weight+nextWeight<dist[nextNode])
				{
					dist[nextNode]=weight+nextWeight;
					queue.offer(new Pair(nextNode,dist[nextNode]));
				}
			}
		}
		
		
		int maxTime=0;
		for(int i=1;i<=n;i++)
		{
			if(dist[i]==Integer.MAX_VALUE) return -1;
			
			maxTime=Math.max(maxTime,dist[i]);
		}
		
		return maxTime;
	}
}
