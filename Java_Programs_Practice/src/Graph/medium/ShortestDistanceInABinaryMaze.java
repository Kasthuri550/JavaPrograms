package Graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(N*M)
 * Space Complexity: O(N*M)
 * */
class Tuple
{
	int first,second,third;

	Tuple(int first,int second,int third)
	{
		this.first=first;
		this.second=second;
		this.third=third;
	}
}

public class ShortestDistanceInABinaryMaze {

	public static void main(String[] args) {

		int grid[][] = {{1, 1, 1, 1},
				{1, 1, 0, 1},
				{1, 1, 1, 1},
				{1, 1, 0, 0},
				{1, 0, 0, 1}};
		int source[] = {0, 1};
		int destination[] = {2, 2};


		System.out.println(shortestDistanceInABinaryMaze(grid,source,destination));
	}

	private static int shortestDistanceInABinaryMaze(int[][] grid, int[] source, int[] destination) {

		if (source[0] == destination[0] && source[1] == destination[1]) 
            return 0;
		
		Queue<Tuple> queue=new LinkedList<>();
		int n=grid.length,m=grid[0].length;

		int dist[][]=new int[n][m];

		for(int i=0;i<n;i++)
		{
			Arrays.fill(dist[i],Integer.MAX_VALUE);
		}

		dist[source[0]][source[1]]=0;
		queue.offer(new Tuple(0,source[0],source[1]));

		int delr[]= {-1,0,1,0};
		int delc[]= {0,1,0,-1};

		while(!queue.isEmpty())
		{
			Tuple tuple=queue.poll();

			int distance=tuple.first;
			int row=tuple.second;
			int col=tuple.third;

			for(int i=0;i<4;i++)
			{
				int newr=row+delr[i];
				int newc=col+delc[i];

				if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1 && distance+1<dist[newr][newc])
				{
					dist[newr][newc]=distance+1;

					if(newr==destination[0] && newc==destination[1]) return distance+1;

					queue.offer(new Tuple(distance+1,newr,newc));
				}
			}

		}

		return -1;
	}
}
