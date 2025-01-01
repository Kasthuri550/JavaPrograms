package SlidingWindowTwoPointer;

import java.util.Arrays;

public class MaximumPointYouCanObtainFromCards {

	public static void main(String[] args) {

		int cardPoints[] = {1, 2, 3, 4, 5, 6, 1}, k = 3,n=cardPoints.length;

		System.out.println(maximumPointYouCanObtainFromCardsBrute(cardPoints,k,0,n-1));
		System.out.println(maximumPointYouCanObtainFromCardsBetter(cardPoints, k,n));
		System.out.println(maximumPointYouCanObtainFromCardsOptimal(cardPoints, k,n));

	}
	/*
	 * Time Complexity: O(2k)
	 * Space Complexity: O(1)
	 */
	private static int maximumPointYouCanObtainFromCardsOptimal(int[] cardPoints, int k,int n) {

		int totalSum=0;

		for(int i=0;i<k;i++)
		{
			totalSum=totalSum+cardPoints[i];
		}

		int maxPoints=totalSum;
		for(int i=0;i<k;i++)
		{
			totalSum=totalSum-cardPoints[k-1-i]+cardPoints[n-i-1];
			maxPoints=Math.max(maxPoints, totalSum);
		}

		return maxPoints;
	}
	/*
	 * Time Complexity: O(k*n)
	 * Space Complexity: O(k)
	 */
	private static int maximumPointYouCanObtainFromCardsBetter(int[] cardPoints, int k, int n) {


		int memo[][]=new int[n][n];

		for(int row[]:memo)
		{
			Arrays.fill(row,-1);
		}


		return maximumPointYouCanObtainFromCardsMemo(cardPoints,k,0,n-1,memo);
	}

	private static int maximumPointYouCanObtainFromCardsMemo(int[] cardPoints, int k, int start, int end,int memo[][]) {

		if(k==0)
			return 0;

		if(memo[start][end]!=-1)
			return memo[start][end];

		int pickStart=cardPoints[start]+maximumPointYouCanObtainFromCardsMemo(cardPoints, k-1, start+1, end,memo);
		int pickEnd=cardPoints[end]+maximumPointYouCanObtainFromCardsMemo(cardPoints, k-1, start, end-1,memo);

		memo[start][end]=Math.max(pickStart,pickEnd);

		return memo[start][end];
	}
	/*
	 * Time Complexity: O(2^k)
	 * Space Complexity: O(k)
	 */
	private static int maximumPointYouCanObtainFromCardsBrute(int[] cardPoints, int k,int start,int end) {

		if(k==0)
			return 0;


		return Math.max(cardPoints[start]+maximumPointYouCanObtainFromCardsBrute(cardPoints, k-1, start+1, end),
				cardPoints[end]+maximumPointYouCanObtainFromCardsBrute(cardPoints, k-1, start, end-1));
	}
}
