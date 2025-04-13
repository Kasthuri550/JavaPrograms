package Graph.hard;

import java.util.ArrayList;

/*
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E)
 * */
public class BridgesInGraph {
	
	private static int timer;
	private static int visited[];
	private static int tin[];
	private static int low[];

	public static void main(String[] args) {

		int v = 4;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	    for (int i = 0; i < v; i++) {
	        adj.add(new ArrayList<>());
	    }

	    adj.get(0).add(1);
	    adj.get(1).add(0);

	    adj.get(1).add(2);
	    adj.get(2).add(1);

	    adj.get(2).add(0);
	    adj.get(0).add(2);

	    adj.get(1).add(3);
	    adj.get(3).add(1);
        
        ArrayList<ArrayList<Integer>> bridges=criticalConnections(v,adj);
        System.out.println(bridges);
	}

	private static ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {
		
		timer=1;
		visited=new int[v];
		tin=new int[v];
		low=new int[v];
		
		ArrayList<ArrayList<Integer>> bridges=new ArrayList<>();
		dfs(0,-1,adj,bridges);
		
		return bridges;
	}

	private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> bridges) {

		visited[node]=1;
		low[node]=tin[node]=timer++;
		
		for(int child:adj.get(node))
		{
			if(child==parent) continue;
			
			if(visited[child]!=1)
			{
				dfs(child,node,adj,bridges);
				low[node]=Math.min(low[node],low[child]);
				
				if(low[child]>tin[node])
				{
					ArrayList<Integer> bridge=new ArrayList<Integer>();
					bridge.add(Math.min(child,node));
					bridge.add(Math.max(child,node));
					bridges.add(bridge);
				}
			}
			else
			{
				low[node]=Math.min(low[node],low[child]);
			}
		}
	}
}
