package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintingLongestIncreasingSubsequence {

	public static void main(String[] args) {

		int arr[] = {10,9,2,5,3,7,101,18};

		int n = arr.length;
		
		longestIncreasingSubsequence(arr,n);

	}

	private static void longestIncreasingSubsequence(int[] arr, int n) {
		
		int dp[]=new int[n];
		
		Arrays.fill(dp,1);
		
		int hash[]=new int[n];
		
		Arrays.fill(hash,1);

		for(int index=0;index<n;index++)
		{
			hash[index]=index;
			for(int prevIndex=0;prevIndex<index;prevIndex++)
			{
				if(arr[index]>arr[prevIndex] && 1+dp[prevIndex]>dp[index])
				{
					dp[index]=1+dp[prevIndex];
					hash[index]=prevIndex;
				}
			}
		}
		
		
		int lastIndex=-1,result=-1;
		
		for(int i=0;i<n;i++)
		{
			if(dp[i]>result)
			{
				result=dp[i];
				lastIndex=i;
			}
		}
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(arr[lastIndex]);
		
		while(hash[lastIndex]!=lastIndex)
		{
			lastIndex=hash[lastIndex];
			list.add(arr[lastIndex]);
		}
		
		Collections.reverse(list);
		
		System.out.println(list);
	}
}
