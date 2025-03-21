package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {

	public static void main(String[] args) {

		int N = 4;
		int M = 3;
		ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			prerequisites.add(i, new ArrayList<>());
		}


		prerequisites.get(0).add(0);
		prerequisites.get(0).add(1);

		prerequisites.get(1).add(1);
		prerequisites.get(1).add(2);

		prerequisites.get(2).add(2);
		prerequisites.get(2).add(3);

		System.out.println(prerequisites);

		int result[]=findOrder(N, M, prerequisites);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {

		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++)
		{
			adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
		}
		
		int indegree[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			for(int it:adj.get(i))
			{
				indegree[it]++;
			}
		}
		
		Queue<Integer> queue=new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			if(indegree[i]==0)
			{
				queue.add(i);
			}
		}
		
		int topo[]=new int[n],ind=0;
		
		while(!queue.isEmpty())
		{
			int node=queue.poll();
			
			topo[ind++]=node;
			
			for(int it:adj.get(node))
			{
				indegree[it]--;
				
				if(indegree[it]==0)
				{
					queue.add(it);
				}
			}
		}
		
		
		if(ind==n) return topo;
		
		return new int[] {};
	}
}
