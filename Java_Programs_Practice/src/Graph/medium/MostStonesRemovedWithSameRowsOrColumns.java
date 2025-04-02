package Graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
public class MostStonesRemovedWithSameRowsOrColumns {

	static class DisjointSet
	{
		List<Integer> rank=new ArrayList<>();
		List<Integer> parent=new ArrayList<>();

		DisjointSet(int n)
		{
			for(int i=0;i<n;i++)
			{
				rank.add(0);
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

		public void unionByRank(int u,int v)
		{
			int ulp_u=findParent(u);
			int ulp_v=findParent(v);

			if(ulp_u==ulp_v) return;

			if(rank.get(ulp_u)<rank.get(ulp_v))
			{
				parent.set(ulp_u,ulp_v);
			}
			else if(rank.get(ulp_v)<rank.get(ulp_u))
			{
				parent.set(ulp_v,ulp_u);
			}
			else
			{
				parent.set(ulp_v,ulp_u);
				rank.set(ulp_u,rank.get(ulp_u)+1);
			}
		}
	}

	public static void main(String[] args) {

		int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};

		System.out.println(mostStonesRemovedWithSameRowsOrColumns(stones,stones.length));
	}

	private static int mostStonesRemovedWithSameRowsOrColumns(int[][] stones, int n) {

		int maxRow=0,maxCol=0;
		
		for(int i=0;i<n;i++)
		{
			maxRow=Math.max(maxRow,stones[i][0]);
			maxCol=Math.max(maxCol, stones[i][1]);
		}
		
		DisjointSet ds=new DisjointSet(maxRow+maxCol+2);
		HashMap<Integer,Integer> stoneNodes=new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			int nodeRow=stones[i][0];
			int nodeCol=stones[i][1]+maxRow+1;
			
			ds.unionByRank(nodeRow, nodeCol);
			stoneNodes.put(nodeRow,1);
			stoneNodes.put(nodeCol,1);	
		}
		
		int cnt=0;
		
		for(Map.Entry<Integer,Integer> entry:stoneNodes.entrySet())
		{
			if(entry.getKey()==ds.findParent(entry.getKey()))
			{
				cnt++;
			}
		}
		
		return n-cnt;
	}
}
