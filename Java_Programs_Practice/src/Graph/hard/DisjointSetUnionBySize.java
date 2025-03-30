package Graph.hard;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(alpha(N)) per operation, nearly O(1) for practical cases.
 * Space Complexity: O(N).
 * */
public class DisjointSetUnionBySize {
	
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
	
	public static void main(String[] args) 
	{
		DisjointSetUnionBySize disjointSetUnionBySize=new DisjointSetUnionBySize(5);
		
		disjointSetUnionBySize.unionBySize(0,1);
		disjointSetUnionBySize.unionBySize(1,2);
		
		System.out.println(disjointSetUnionBySize.findParent(2)==disjointSetUnionBySize.findParent(0));
		System.out.println(disjointSetUnionBySize.findParent(3)==disjointSetUnionBySize.findParent(0));
		
		disjointSetUnionBySize.unionBySize(3, 4);
		disjointSetUnionBySize.unionBySize(2,4);
		
		System.out.println(disjointSetUnionBySize.findParent(3)==disjointSetUnionBySize.findParent(0));
	}
}
