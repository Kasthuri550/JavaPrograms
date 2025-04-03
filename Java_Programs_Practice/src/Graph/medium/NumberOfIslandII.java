package Graph.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(K)
 * Space Complexity: O(rows*cols)
 * */
public class NumberOfIslandII {

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
				size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
			}
			else
			{
				parent.set(ulp_v,ulp_u);
				size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
			}
		}
	}

	public static void main(String[] args) {

		int n = 4,
				m = 5,
				A[][] = {{1,1},{0,1},{3,3},{3,4}};

		System.out.println(numberOfIslandII(n,m,A));
	}

	private static List<Integer> numberOfIslandII(int rows, int cols, int[][] operators) {

		int dR[]= {-1,1,0,0};
		int dC[]= {0,0,-1,1};

		DisjointSet ds=new DisjointSet(rows*cols);
		int visited[][]=new int[rows][cols];
		int count=0;		
		List<Integer> ans=new ArrayList<>();

		for(int operator[]:operators)
		{
			int row=operator[0];
			int col=operator[1];

			if(visited[row][col]==1)
			{
				ans.add(count);
				continue;
			}

			visited[row][col]=1;
			count++;
			for(int ind=0;ind<4;ind++)
			{
				int adjr=row+dR[ind];
				int adjc=col+dC[ind];

				if(isValid(adjr,adjc,rows,cols) && visited[adjr][adjc]==1)
				{
					int nodeNo=row*cols+col;
					int adjNodeNo=adjr*cols+adjc;

					if(ds.findParent(nodeNo)!=ds.findParent(adjNodeNo))
					{
						ds.unionBySize(nodeNo, adjNodeNo);
						count--;
					}
				}
			}

			ans.add(count);
		}

		return ans;
	}

	private static boolean isValid(int adjr, int adjc, int rows, int cols) {
		return adjr>=0 && adjr<rows && adjc>=0 && adjc<cols;
	}
}
