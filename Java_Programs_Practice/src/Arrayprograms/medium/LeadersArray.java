package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersArray {

	public static void main(String[] args) {
		
		int arr[]=  {10, 22, 12, 3, 0, 6};
		
		printLeadersBruteForce(arr);
		printLeadersOptimal(arr);

	}

	private static void printLeadersOptimal(int[] arr) {
		
		int n=arr.length;
		ArrayList<Integer> leadersList=new ArrayList<>();
		
		int max=arr[n-1];
		leadersList.add(arr[n-1]);
		
		for(int i=n-2;i>=0;i--)
		{
			if(arr[i]>max)
			{
				leadersList.add(arr[i]);
				max=arr[i];
			}
		}
		
		Collections.sort(leadersList,Collections.reverseOrder());
		System.out.println(leadersList);
		
	}

	private static void printLeadersBruteForce(int[] arr) {
		
		int n=arr.length;
		
		ArrayList<Integer> leadersList=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			boolean leader=true;
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]<arr[j])
				{
					leader=false;
					break;
				}
			}
			
			if(leader)
			{
				leadersList.add(arr[i]);
			}
		}
		
		System.out.println(leadersList);
		
	}
}
