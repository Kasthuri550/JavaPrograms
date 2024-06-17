package Arrayprograms.easy;

import java.util.HashSet;

public class PairWithGivenSumSortedArray {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4, 5, 6, 7},k=8;
		
		pairGivenSumBrute(arr,k);
		pairGivenSumBetter(arr, k);
		pairGivenSumOptimal(arr, k);

	}

	private static void pairGivenSumOptimal(int[] arr, int k) {
		
		int n=arr.length,left=0,right=n-1,count=0;
		
		while(left<right)
		{
			int sum=arr[left]+arr[right];
			
			if(sum==k)
			{
				count++;
				left++;
				right--;
			}
			else if(sum<k)
			{
				left++;
			}
			else
			{
				right--;
			}
		}
		
		System.out.println(count);	
	}

	private static void pairGivenSumBetter(int[] arr, int k) {
		
		int n=arr.length,count=0;
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		for(int i=0;i<n;i++)
		{
			if(hashSet.contains(k-arr[i]))
			{
				count++;
			}
			hashSet.add(arr[i]);
		}
		
		System.out.println(count);
		
	}

	private static void pairGivenSumBrute(int[] arr,int k) {
		
		int n=arr.length,count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]+arr[j]==k)
				{
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
}
