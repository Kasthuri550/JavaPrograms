package Graph.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(N^2)+O(N^2*9) ~ O(N^2)
 * Space Complexity: O(N^2)+O(N^2) ~ O(N^2)
 * */
class Pair
{
	int row,col;
	Pair(int row,int col)
	{
		this.row=row;
		this.col=col;
	}
}
public class NumberOfIslands {

	public static void main(String[] args) {
		
		char grid[][] = {{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
		
		System.out.println(numberOfIslands(grid));

	}

	private static int numberOfIslands(char[][] grid) {

		int m=grid.length,n=grid[0].length,count=0;
		
		int visited[][]=new int[m][n];
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(visited[i][j]==0 && grid[i][j]=='1')
				{
					count++;
					bfs(i,j,m,n,visited,grid);
				}
			}
		}
		
		return count;
	}

	private static void bfs(int ro, int co,int rows,int cols,int[][] visited, char[][] grid) {

		visited[ro][co]=1;
		
		Queue<Pair> queue=new LinkedList<>();
		queue.offer(new Pair(ro,co));
		
		while(!queue.isEmpty())
		{
			Pair pair=queue.poll();
			int row=pair.row;
			int col=pair.col;
			
			for(int delRow=-1;delRow<=1;delRow++)
			{
				for(int delCol=-1;delCol<=1;delCol++)
				{
					int nRow=row+delRow;
					int nCol=col+delCol;
					
					if(nRow>=0 && nRow<rows && nCol>=0 && nCol<cols && grid[nRow][nCol]=='1' && visited[nRow][nCol]==0)
					{
						visited[nRow][nCol]=1;
						queue.offer(new Pair(nRow,nCol));
					}
				}
			}
		}
		
	}
}
