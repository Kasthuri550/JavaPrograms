package Graph.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Time Complexity: O(m+n)
 * Space Complexity: O(n)
 * */
public class NumberOfOperationsToMakeNetworkConnected {

	static class DisjointSet
	{
		List<Integer> rank=new ArrayList<>();
		List<Integer> parent=new ArrayList<>();
		
		public DisjointSet(int n) 
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
		
		public boolean unionByRank(int u,int v)
		{
			int ulp_u=findParent(u);
			int ulp_v=findParent(v);
			
			if(ulp_u==ulp_v) return false;
			
			if(rank.get(ulp_u)<rank.get(ulp_v))
			{
				parent.set(ulp_u,ulp_v);
			}
			else if(rank.get(ulp_u)>rank.get(ulp_v))
			{
				parent.set(ulp_v,ulp_u);
			}
			else
			{
				parent.set(ulp_v, ulp_u);
				rank.set(ulp_u, rank.get(ulp_u)+1);
			}
			
			return true;
		}
	}

	public static void main(String[] args) {

		int n = 4,m = 3,edges[][] = {{0, 1} , {0, 2} , {1, 2}};

		System.out.println(connectingToTheGraph(n,edges));
	}

	private static int connectingToTheGraph(int n, int[][] edges) {

		DisjointSet ds=new DisjointSet(n);
		
		int extraEdges=0,components=n;
		
		for(int edge[]:edges)
		{
			int u=edge[0],v=edge[1];
			if(!ds.unionByRank(u, v))
			{
				extraEdges++;
			}
		}
		
		Set<Integer> uniqueComponents=new HashSet<>();
		
		for(int i=0;i<n;i++)
		{
			uniqueComponents.add(ds.findParent(i));
		}
		
		components=uniqueComponents.size();
		int neededEdges=components-1;
		
		return extraEdges>=neededEdges?neededEdges:-1;
	}
}
