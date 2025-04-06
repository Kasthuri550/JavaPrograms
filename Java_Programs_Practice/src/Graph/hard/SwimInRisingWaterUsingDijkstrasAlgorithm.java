package Graph.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWaterUsingDijkstrasAlgorithm {
	
	static class Cell
	{
		int row,col,time;
		
		Cell(int row,int col,int time)
		{
			this.row=row;
			this.col=col;
			this.time=time;
			
		}
	}

	public static void main(String[] args) {

		int grid[][] = {{0,2},{1,3}};
		
		System.out.println(swimInRisingWater(grid));
	}

	private static int swimInRisingWater(int[][] grid) {

		int n=grid.length;
		PriorityQueue<Cell> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.time));
		pq.offer(new Cell(0,0,grid[0][0]));
		
		int dr[]= {-1,1,0,0};
		int dc[]= {0,0,-1,1};
		
		boolean visited[][]=new boolean[n][n];
		
		while(!pq.isEmpty())
		{
			Cell cell=pq.poll();
			int row=cell.row;
			int col=cell.col;
			int time=cell.time;
			
			if(row==n-1 && col==n-1)
				return time;
			
			if(visited[row][col]) continue;
			
			visited[row][col]=true;
			
			for(int ind=0;ind<4;ind++)
			{
				int newr=row+dr[ind];
				int newc=col+dc[ind];
				
				if(newr>=0 && newr<n && newc>=0 && newc<n && !visited[newr][newc])
				{
					int newTime=Math.max(time,grid[newr][newc]);
					pq.offer(new Cell(newr,newc,newTime));
				}
			}
		}
		
		return -1;
	}
}
