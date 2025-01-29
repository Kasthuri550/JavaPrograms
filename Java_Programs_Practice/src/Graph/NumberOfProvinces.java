package Graph;

/*
 * Time Complexity: O(V)+O(V+E)
 * Space Complexity: O(V)+O(V)
 */
public class NumberOfProvinces {

	public static void main(String[] args) {

		int isConnected[][]= {{1, 0, 1},{0, 1, 0},{1, 0, 1}};

		System.out.println(numberOfProvinces(isConnected));
	}

	private static int numberOfProvinces(int[][] isConnected) {

		int v=isConnected.length,provinces=0;
		boolean visited[]=new boolean[v];

		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				provinces++;
				dfs(isConnected,visited,i,v);
			}
		}

		return provinces;
	}

	private static void dfs(int[][] isConnected, boolean[] visited, int currentVertex,int v) {

		visited[currentVertex]=true;

		for(int neighbour=0;neighbour<v;neighbour++)
		{
			if(isConnected[currentVertex][neighbour]==1 && !visited[neighbour])
			{
				visited[neighbour]=true;
				dfs(isConnected,visited,neighbour,v);
			}
		}
	}
}
