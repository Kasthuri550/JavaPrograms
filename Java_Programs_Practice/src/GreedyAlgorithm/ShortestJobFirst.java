package GreedyAlgorithm;

import java.util.Arrays;

public class ShortestJobFirst {

	public static void main(String[] args) {
		
		int n = 5,bt[] = {4,3,7,1,2};
		
		System.out.println(sjf(n,bt));

	}

	private static int sjf(int n, int[] bt) {
		
		Arrays.sort(bt);
		int waitingTime=0,totalTiming=0;
		
		for(int i=0;i<n;i++)
		{
			waitingTime+=totalTiming;
			totalTiming+=bt[i];
		}
		
		int averageWaitingTime=waitingTime/n;
		
		return averageWaitingTime;
	}
}
