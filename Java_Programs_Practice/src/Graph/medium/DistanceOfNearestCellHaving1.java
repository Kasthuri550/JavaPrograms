package Graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(N*M)+O(N*M*4)
 * Space Complexity: O(N*M)+O(N*M)+O(N*M) ~ O(N*M)
 * */
public class DistanceOfNearestCellHaving1 {
	
	static class Node
	{
		int row,col,steps;
		
		Node(int row,int col,int steps)
		{
			this.row=row;
			this.col=col;
			this.steps=steps;
		}
	}

	public static void main(String[] args) {
		
	   int grid[][]= {{1,0,1},{1,1,0},{1,0,0}};
		
		
	   printMatrix(zeroByOneMatrix(grid));

	}

	private static void printMatrix(int[][] matrix) {

		for(int mat[]:matrix)
		{
			System.out.println(Arrays.toString(mat));
		}
	}

	private static int[][] zeroByOneMatrix(int[][] grid) 
	{
		int m=grid.length,n=grid[0].length;
		
		Queue<Node> queue=new LinkedList<>();
		
		int visited[][]=new int[m][n];
		int dist[][]=new int[m][n];
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(grid[i][j]==1)
				{
					queue.offer(new Node(i,j,0));
					visited[i][j]=1;
				}
			}
		}
		
		int drow[]= {0,0,1,-1};
		int dcol[]= {1,-1,0,0};
		
		while(!queue.isEmpty())
		{
			Node node=queue.poll();
			
			int row=node.row,col=node.col,steps=node.steps;
			
			dist[row][col]=steps;
			
			for(int i=0;i<4;i++)
			{
				int nrow=row+drow[i];
				int ncol=col+dcol[i];
				
				if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]==0)
				{
					visited[nrow][ncol]=1;
					queue.offer(new Node(nrow,ncol,steps+1));
				}
			}
			
		}
		
		return dist;		
	}
}
