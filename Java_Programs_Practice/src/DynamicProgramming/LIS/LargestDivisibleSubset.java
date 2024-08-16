package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		
		int n = 3,arr[] = {1,2,3};
		
		System.out.println(largestDivisibleSubset(n,arr));

	}

	private static ArrayList<Integer> largestDivisibleSubset(int n, int[] arr) {
		
		int dp[]=new int[n],hash[]=new int[n];
		
		Arrays.fill(dp,1);
		Arrays.fill(hash,1);
		
		Arrays.sort(arr);
		
		for(int index=0;index<n;index++)
		{
			hash[index]=index;
			
			for(int prevIndex=0;prevIndex<=index-1;prevIndex++)
			{
				if(arr[index]%arr[prevIndex]==0 && 1+dp[prevIndex]>dp[index])
				{
					dp[index]=1+dp[prevIndex];
					hash[index]=prevIndex;
				}
			}
		}
		
		int ans=-1,lastIndex=-1;
		
		for(int i=0;i<n;i++)
		{
			if(dp[i]>ans)
			{
				ans=dp[i];
				lastIndex=i;
			}
		}
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		resultList.add(arr[lastIndex]);
		
		while(hash[lastIndex]!=lastIndex)
		{
			lastIndex=hash[lastIndex];
			resultList.add(arr[lastIndex]);
		}
		
		return resultList;
	}
}
