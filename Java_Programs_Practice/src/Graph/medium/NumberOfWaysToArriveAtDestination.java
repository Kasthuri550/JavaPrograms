package Graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
		
	static class Pair
	{
		int first,second;
		
		Pair(int first,int second)
		{
			this.first=first;
			this.second=second;
		}
	}

	public static void main(String[] args) {
		
		int n=7;
		List<List<Integer>> edges=new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(0,6,7)),
				new ArrayList<>(Arrays.asList(0,1,2)),
				new ArrayList<>(Arrays.asList(1,2,3)),
				new ArrayList<>(Arrays.asList(1,3,3)),
				new ArrayList<>(Arrays.asList(6,3,3)),
				new ArrayList<>(Arrays.asList(3,5,1)),
				new ArrayList<>(Arrays.asList(6,5,1)),
				new ArrayList<>(Arrays.asList(2,5,1)),
				new ArrayList<>(Arrays.asList(0,4,5)),
				new ArrayList<>(Arrays.asList(4,6,2))));
		
		System.out.println(numberOfWaysToArriveAtDestination(n,edges));

	}

	private static int numberOfWaysToArriveAtDestination(int n, List<List<Integer>> edges) {

		ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());
        }
        int m = edges.size();
        for (int i = 0; i < m; i++) {
            adj.get(edges.get(i).get(0)).add(new Pair(edges.get(i).get(1), edges.get(i).get(2)));
            adj.get(edges.get(i).get(1)).add(new Pair(edges.get(i).get(0), edges.get(i).get(2)));
        }

        PriorityQueue < Pair > pq = new PriorityQueue < Pair > ((x, y) -> x.first - y.first);

        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        int mod = (int)(1e9 + 7);

        while (pq.size() != 0) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                } 

                    else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
       
        return ways[n - 1] % mod;
	}
}
