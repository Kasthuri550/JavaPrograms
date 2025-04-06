package Graph.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 * */
public class MakingALargeIsland {
	
	static class DisjointSet
	{
		List<Integer> parent=new ArrayList<>();
		List<Integer> size=new ArrayList<>();
		
		DisjointSet(int n)
		{
			for(int i=0;i<n;i++)
			{
				parent.add(i);
				size.add(1);
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
				size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
			}
			else
			{
				parent.set(ulp_v,ulp_u);
				size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
			}
		}
	}

	public static void main(String[] args) {

		int grid[][] = {{1,0},{0,1}};
		
		System.out.println(makingALargeIsland(grid));
	}

	private static int makingALargeIsland(int[][] grid) {

		int n=grid.length;
		DisjointSet ds=new DisjointSet(n*n);
		
		int dr[]= {-1,1,0,0};
		int dc[]= {0,0,-1,1};
		
		for(int row=0;row<n;row++)
		{
			for(int col=0;col<n;col++)
			{
				if(grid[row][col]==0) continue;
				
				for(int ind=0;ind<4;ind++)
				{
					int newr=row+dr[ind];
					int newc=col+dc[ind];
					
					if(isValid(newr,newc,n) && grid[newr][newc]==1)
					{
						int node=row*n+col;
						int newNode=newr*n+newc;
						ds.unionBySize(node, newNode);
					}
				}
			}
		}
		
		int max=0;
		
		for(int row=0;row<n;row++)
		{
			for(int col=0;col<n;col++)
			{
				if(grid[row][col]==1) continue;
				
				HashSet<Integer> components=new HashSet<>();
				
				for(int ind=0;ind<4;ind++)
				{
					int newr=row+dr[ind];
					int newc=col+dc[ind];
					
					if(isValid(newr, newc,n) && grid[newr][newc]==1)
					{
						components.add(ds.findParent(newr*n+newc));
					}
				}
				
				int sizeTotal=0;
				
				for(int parent:components)
				{
					sizeTotal+=ds.size.get(parent);
				}
				
				max=Math.max(max,sizeTotal+1);
			}
		}
		
		for(int cellNo=0;cellNo<n*n;cellNo++)
		{
			max=Math.max(max,ds.size.get(ds.findParent(cellNo)));
		}
		
		return max;
	}

	private static boolean isValid(int newr, int newc,int n) {

		return newr>=0 && newr<n && newc>=0 && newc<n;
	}
}
