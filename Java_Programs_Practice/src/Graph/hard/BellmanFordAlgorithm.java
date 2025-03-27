package Graph.hard;

import java.util.Arrays;

/*
 * Time Complexity: O(V*E)
 * Space Complexity: O(V)
 * */ 
public class BellmanFordAlgorithm {

	public static void main(String[] args) {
		
		int edges[][] = {{0,1,9}}, src = 0,v=2;
		
		int result[]=bellmanFord(v,edges,src);
		
		
		System.out.println(Arrays.toString(result));
	}

	private static int[] bellmanFord(int V, int[][] edges, int src) {
		
		int INF=(int)1e8;
		int dist[]=new int[V];
		Arrays.fill(dist,INF);
		
		dist[src]=0;
		
		for(int i=0;i<V-1;i++)
		{
			for(int edge[]:edges)
			{
				int u=edge[0],v=edge[1],wt=edge[2];
				
				if(dist[u]!=INF && dist[u]+wt<dist[v])
				{
					dist[v]=dist[u]+wt;
				}
			}
		}
		
		for(int edge[]:edges)
		{
			int u=edge[0],v=edge[1],wt=edge[2];
			
			if(dist[u]!=INF && dist[u]+wt<dist[v])
			{
				return new int[] {-1};
			}
		}
		
		return dist;
	}
}
