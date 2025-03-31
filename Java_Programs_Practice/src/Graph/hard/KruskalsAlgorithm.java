package Graph.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Time Complexity: O(ElogE)
 * Space Complexity: O(E+V)
 * */
public class KruskalsAlgorithm {
	
	static class Edge implements Comparable<Edge>
	{
		int src,dest,weight;
		
		Edge(int src,int dest,int weight)
		{
			this.src=src;
			this.dest=dest;
			this.weight=weight;
		}
		
		public int compareTo(Edge other)
		{
			return this.weight-other.weight;
		}
	}
	
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
			else if(rank.get(ulp_u)>rank.get(ulp_v))
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

		int V=3,E=3;

		List<List<int[]>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(new int[]{1, 5});
		adj.get(1).add(new int[]{0, 5});

		adj.get(1).add(new int[]{2, 3});
		adj.get(2).add(new int[]{1, 3});

		adj.get(0).add(new int[]{2, 1});
		adj.get(2).add(new int[]{0, 1});

		printAdj(V,adj);
		System.out.println(kruskalsAlgorithm(V,E,adj));
	}
	
	private static int kruskalsAlgorithm(int V, int E, List<List<int[]>> adj) {
		
		List<Edge> edges=new ArrayList<>();
		
		for(int i=0;i<V;i++)
		{
			for(int neighbour[]:adj.get(i))
			{
				int v=neighbour[0],wt=neighbour[1];
				edges.add(new Edge(i,v,wt));
			}
		}
		
		Collections.sort(edges);
		
		DisjointSet ds=new DisjointSet(V);
		
		int mstWeight=0,mstEdges=0;
		
		for(Edge edge:edges)
		{
			if(ds.findParent(edge.src)!=ds.findParent(edge.dest))
			{
				ds.unionByRank(edge.src,edge.dest);
				mstWeight+=edge.weight;
				mstEdges++;
				if(mstEdges==V-1) break;
			}
		}

		return mstWeight;
	}

	private static void printAdj(int V,List<List<int[]>> adj) {

		for (int i = 0; i < V; i++) {
			System.out.print(i + " -> ");
			for (int[] edge : adj.get(i)) {
				System.out.print("(" + edge[0] + "," + edge[1] + ") ");
			}
			System.out.println();
		}
	}
}
