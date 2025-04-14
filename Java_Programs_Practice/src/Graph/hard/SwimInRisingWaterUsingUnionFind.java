package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Time Complexity: O(N^2 log N)
 * Space Complexity: O(N^2)
 * */
public class SwimInRisingWaterUsingUnionFind {

	static class DisjointSetUnionBySize {

		List<Integer> size=new ArrayList<>();
		List<Integer> parent=new ArrayList<>();

		public DisjointSetUnionBySize(int n)
		{
			for(int i=0;i<n;i++)
			{
				size.add(1);
				parent.add(i);
			}
		}

		public int findParent(int node)
		{
			if(node==parent.get(node)) return node;

			int ulp=findParent(parent.get(node));
			parent.set(node,ulp);
			return parent.get(node);
		}

		public void unionBySize(int u,int v)
		{
			int ulp_u=findParent(u);
			int ulp_v=findParent(v);

			if(ulp_u==ulp_v) return;

			if(size.get(ulp_u)<size.get(ulp_v))
			{
				parent.set(ulp_u,ulp_v);
				size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
			}
			else
			{
				parent.set(ulp_v,ulp_u);
				size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
			}
		}
		
		public boolean isConnected(int u,int v)
		{
			return findParent(u)==findParent(v);
		}
	}
	public static void main(String[] args) {

		int  grid[][] = {{0,1,2,3,4},
				{24,23,22,21,5},
				{12,13,14,15,16},
				{11,17,18,19,20},
				{10,9,8,7,6}};

		System.out.println(swimInRisingWater(grid));


	}

	private static int swimInRisingWater(int[][] grid) {

		int n=grid.length;
		int totalCells=n*n;
		DisjointSetUnionBySize disjointSetUnionBySize=new DisjointSetUnionBySize(totalCells);
		int positions[][]=new int[totalCells][3];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				positions[i*n+j]=new int[] {grid[i][j],i,j};
			}
		}
		
		Arrays.sort(positions,Comparator.comparingInt(a->a[0]));
		boolean visited[][]=new boolean[n][n];
		int dx[]= {1,-1,0,0};
		int dy[]= {0,0,1,-1};

		for(int pos[]:positions)
		{
			int time=pos[0];
			int row=pos[1];
			int col=pos[2];
			
			visited[row][col]=true;
			
			int node=row*n+col;
			
			for(int ind=0;ind<4;ind++)
			{
				int newRow=row+dx[ind];
				int newCol=col+dy[ind];
				
				if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && visited[newRow][newCol])
				{
					int newNode=newRow*n+newCol;
					disjointSetUnionBySize.unionBySize(node,newNode);
					
				}
			}
			
			if(disjointSetUnionBySize.isConnected(0,totalCells-1))
			{
				return time;
			}
		}
		
		return -1;
	}
}
