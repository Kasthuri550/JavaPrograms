package Graph.hard;

import java.util.Arrays;

/*
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 * */
public class CityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

	public static void main(String[] args) {

		int n = 4, m = 4,
				edges[][] = {{0, 1, 3},
						{1, 2, 1}, 
						{1, 3, 4},  
						{2, 3, 1}},
				distanceThreshold = 4;

		System.out.println(cityWithTheSmallestNumberOfNeighbour(n,m,edges,distanceThreshold));
	}

	private static int cityWithTheSmallestNumberOfNeighbour(int n, int m, int[][] edges, int distanceThreshold) {

		int dist[][]=new int[n][n];

		for(int i=0;i<n;i++)
		{
			Arrays.fill(dist[i],Integer.MAX_VALUE);
			dist[i][i]=0;
		}

		for(int edge[]:edges)
		{
			int u=edge[0],v=edge[1],w=edge[2];

			dist[u][v]=w;
			dist[v][u]=w;
		}

		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE && dist[i][k]+dist[k][j]<dist[i][j])
					{
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}

		int minCityCount=Integer.MAX_VALUE,bestCity=-1;
		
		for(int i=0;i<n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(dist[i][j]<=distanceThreshold)
				{
					count++;
				}
			}
			
			if(count<=minCityCount)
			{
				minCityCount=count;
				bestCity=i;
			}
		}
		
		return bestCity;
	}
}
