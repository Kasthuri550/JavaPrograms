package Graph.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(10^5 * n)
//Space Complexity: O(10^5)
public class MinimumMultiplicationsToReachEnd {
	
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
		
		int arr[] = {2, 5, 7},start = 3, end = 30;
		
		System.out.println(minimumMultiplicationsToReachEnd(arr,start,end));

	}

	private static int minimumMultiplicationsToReachEnd(int[] arr, int start, int end) {

		if(start==end) return 0;
		
		int MOD=(int)1e5;
		
		int dist[]=new int[MOD];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=1;
		
		Queue<Pair> queue=new LinkedList<>();
		queue.offer(new Pair(start,0));
		
		while(!queue.isEmpty())
		{
			Pair pair=queue.poll();
			int node=pair.first;
			int steps=pair.second;
			
			for(int num:arr)
			{
				int newNode=(num*node)%MOD;
				if(steps+1<dist[newNode])
				{
					dist[newNode]=steps+1;
					
					if(newNode==end) return steps+1;
					
					queue.offer(new Pair(newNode,steps+1));
				}
			}
		}
		
		return -1;
	}
}
