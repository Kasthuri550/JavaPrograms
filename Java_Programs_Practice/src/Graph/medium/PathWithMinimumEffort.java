package Graph.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Time Complexity: O(N*M*log(N*M))
 * Space Complexity: O(N*M)
 * */
public class PathWithMinimumEffort {

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

		int rows = 3,columns = 3,heights[][] = {{1,2,2},{3,8,2},{5,3,5}};

		System.out.println(pathWithMinimumEffort(heights,rows,columns));
	}

	private static int pathWithMinimumEffort(int[][] heights, int rows, int columns) {

		PriorityQueue<Tuple> pq=new PriorityQueue<Tuple>((x,y)->x.first-y.first);

		int dist[][]=new int[rows][columns];

		for(int value[]:dist)
		{
			Arrays.fill(value,Integer.MAX_VALUE);
		}

		dist[0][0]=0;
		pq.offer(new Tuple(0,0,0));

		int delr[]= {-1,0,1,0};
		int delc[]= {0,1,0,-1};

		while(!pq.isEmpty())
		{
			Tuple tuple=pq.poll();
			int distance=tuple.first;
			int row=tuple.second;
			int col=tuple.third;

			if(row==rows-1 && col==columns-1) return distance;

			for(int i=0;i<4;i++)
			{
				int newr=row+delr[i];
				int newc=col+delc[i];

				if(newr>=0 && newc>=0 && newr<rows && newc<columns)
				{
					int newEfforts=Math.max(Math.abs(heights[row][col]-heights[newr][newc]),distance);
					if(newEfforts<dist[newr][newc])
					{
						dist[newr][newc]=newEfforts;
						pq.offer(new Tuple(newEfforts,newr,newc));
					}
				}
			}
		}

		return 0;
	}
}
