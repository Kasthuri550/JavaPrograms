package Graph.hard;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(alpha(N)) per operation, nearly O(1) for practical cases.
 * Space Complexity: O(N).
 * */
public class DisjointSetUnionByRank {

	List<Integer> rank=new ArrayList<>();
	List<Integer> parent=new ArrayList<>();

	public DisjointSetUnionByRank(int n) 
	{
		for(int i=0;i<n;i++)
		{
			rank.add(0);
			parent.add(i);
		}
	}

	public int findParent(int node)
	{
		if(node == parent.get(node)) return node;

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
			parent.set(ulp_v, ulp_u);
		}
		else
		{
			parent.set(ulp_v,ulp_u);
			rank.set(ulp_u,rank.get(ulp_u)+1);
		}
	}

	public static void main(String[] args) {

		DisjointSetUnionByRank disjointSetUnionByRank=new DisjointSetUnionByRank(5);
		disjointSetUnionByRank.unionByRank(0, 1);
		disjointSetUnionByRank.unionByRank(1,2);

		System.out.println(disjointSetUnionByRank.findParent(2)==disjointSetUnionByRank.findParent(0));
		System.out.println(disjointSetUnionByRank.findParent(3)==disjointSetUnionByRank.findParent(0));
		disjointSetUnionByRank.unionByRank(3, 4);
		disjointSetUnionByRank.unionByRank(2, 4);

		System.out.println(disjointSetUnionByRank.findParent(3)==disjointSetUnionByRank.findParent(0));
	}
}
