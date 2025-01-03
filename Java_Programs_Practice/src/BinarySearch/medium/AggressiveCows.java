package BinarySearch.medium;

import java.util.Arrays;

public class AggressiveCows {

	public static void main(String[] args) {

		int stalls[] = {0, 3, 4, 7, 10, 9};
		int k = 4;

		System.out.println(aggressiveCowsBrute(stalls,k));
		System.out.println(aggressiveCowsOptimal(stalls,k));

	}

	/*
	 * Time Complexity: O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
	 * Space Complexity: O(1)
	 * 
	 */

	private static int aggressiveCowsOptimal(int[] stalls, int k) {

		int n=stalls.length;
		Arrays.sort(stalls);

		int low=1,high=stalls[n-1]-stalls[0];

		while(low<=high)
		{
			int mid=(low+high)/2;
			if(canWePlace(stalls, n,mid, k))
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}

		return high;
	}

	/*
	 * Time Complexity: O(NlogN) + O(N *(max(stalls[])-min(stalls[])))
	 * Space Complexity: O(1)
	 * 
	 */

	private static int aggressiveCowsBrute(int[] stalls, int k) {

		int n=stalls.length;
		Arrays.sort(stalls);

		int limit=stalls[n-1]-stalls[0];

		for(int i=1;i<=limit;i++)
		{
			if(!canWePlace(stalls,n,i,k))
			{
				return i-1;
			}
		}
		return limit;
	}

	private static boolean canWePlace(int[] stalls,int n,int dist, int k) {

		int last=stalls[0];
		int countCows=1;

		for(int i=1;i<n;i++)
		{
			if(stalls[i]-last>=dist)
			{
				countCows++;
				last=stalls[i];
			}

			if(countCows>=k)
				return true;
		}
		return false;
	}
}
