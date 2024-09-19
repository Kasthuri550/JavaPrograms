package GreedyAlgorithm;

import java.util.Arrays;

public class JobSequencingProblem {
	
	static class Job {
	    int id, profit, deadline;
	    Job(int x, int y, int z){
	        this.id = x;
	        this.deadline = y;
	        this.profit = z; 
	    }
	}

	public static void main(String[] args) {
		
		 Job[] jobs = {
	                new Job(1, 4, 20),
	                new Job(2, 1, 1),
	                new Job(3, 1, 40),
	                new Job(4, 1, 30)
	        };
		 
		 System.out.println(Arrays.toString(JobSequencingProblem(jobs)));

	}

	private static int[] JobSequencingProblem(Job[] jobs) {
		
		Arrays.sort(jobs,(a,b)->b.profit-a.profit);
		
		int maxDeadLine=0;
		
		for(Job job:jobs)
		{
			if(job.deadline>maxDeadLine)
			{
				maxDeadLine=job.deadline;
			}
		}
		
		int timeSlot[]=new int[maxDeadLine+1],n=jobs.length,jobCount=0,totalProfit=0;
		
		Arrays.fill(timeSlot,-1);
		
		for(Job job:jobs)
		{
			for(int i=job.deadline;i>0;i--)
			{
				if(timeSlot[i]==-1)
				{
					timeSlot[i]=job.id;
					totalProfit+=job.profit;
					jobCount++;
					break;
				}
			}
		}
		
		return new int[] {jobCount,totalProfit};
	}
}
