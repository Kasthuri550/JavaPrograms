package Graph.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(N*M*4)
 * Space Complexity: O(N*M)
 * */
public class NumberOfEnclaves {

	static class Pair
	{
		int row,col;

		Pair(int row,int col)
		{
			this.row=row;
			this.col=col;
		}
	}

	public static void main(String[] args) {

		int grid[][] = {{0, 0, 0, 0},
				{1, 0, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}};

		System.out.println(numberOfEnclaves(grid));
	}

	private static int numberOfEnclaves(int[][] grid) {

		int m=grid.length,n=grid[0].length;

		int visited[][]=new int[m][n];

		Queue<Pair> queue=new LinkedList<>();

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0 || j==0 || i==m-1 || j==n-1)
				{
					if(grid[i][j]==1)
					{
						queue.offer(new Pair(i,j));
						visited[i][j]=1;
					}
				}
			}
		}

		int delRow[]= {0,0,1,-1},delCol[]= {1,-1,0,0};

		while(!queue.isEmpty())
		{
			Pair pair=queue.poll();
			int row=pair.row,col=pair.col;

			for(int i=0;i<4;i++)
			{
				int nrow=row+delRow[i];
				int ncol=col+delCol[i];

				if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]==0 && grid[nrow][ncol]==1)
				{
					queue.offer(new Pair(nrow,ncol));
					visited[nrow][ncol]=1;
				}
			}
		}

		int count=0;

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(visited[i][j]==0 && grid[i][j]==1)
				{
					count++;
				}
			}
		}

		return count;
	}
}
