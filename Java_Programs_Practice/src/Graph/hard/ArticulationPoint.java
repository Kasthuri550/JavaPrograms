package Graph.hard;

import java.util.ArrayList;

/*
 * Time Complexity: O(V+E)
 * Space Complexity: O(V)
 * */
public class ArticulationPoint {
	
	private static int timer=1;

	public static void main(String[] args) {

		int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);
        
        ArrayList<Integer> result=articulationPoint(v,adj);
        System.out.println(result);
	}

	private static ArrayList<Integer> articulationPoint(int v, ArrayList<ArrayList<Integer>> adj) {

		int low[]=new int[v];
		int tin[]=new int[v];
		int visited[]=new int[v];
		int mark[]=new int[v];
		
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<v;i++)
		{
			if(visited[i]==0)
			{
				dfs(i,-1,adj,low,tin,visited,mark);
			}
		}
		
		for(int i=0;i<v;i++)
		{
			if(mark[i]==1)
			{
				ans.add(i);
			}
		}
		
		if(ans.size()==0)
		{
			ans.add(-1);
		}
		
		return ans;
	}

	private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] low, int[] tin, int[] visited, int[] mark) 
	{
		visited[node]=1;
		low[node]=tin[node]=timer;
		timer++;
		
		int child=0;
		
		for(int it:adj.get(node))
		{
			if(it==parent) continue;
			
			if(visited[it]==0)
			{
				dfs(it,node, adj, low, tin, visited, mark);
				
				low[node]=Math.min(low[node],low[it]);
				
				if(low[it]>=tin[node] && parent!=-1)
				{
					mark[node]=1;
				}
				
				child++;
			}
			else
			{
				low[node]=Math.min(low[node],tin[it]);
			}
		}
		
		if(child>1 && parent==-1)
		{
			mark[node]=1;
		}
	}
}
