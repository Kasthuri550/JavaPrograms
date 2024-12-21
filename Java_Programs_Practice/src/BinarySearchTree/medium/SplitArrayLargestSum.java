package BinarySearchTree.medium;

public class SplitArrayLargestSum {

	public static void main(String[] args) {

		int N = 4, K = 3,arr[] = {1, 2, 3, 4};

		System.out.println(splitArrayLargestSumBrute(arr,N,K));
		System.out.println(splitArrayLargestSumOptimal(arr,N,K));

	}

	/*
	 * Time Complexity: O(n*log(high-low+1))
	 * Space Complexity: O(1) 
	 * 
	 */
	
	private static int splitArrayLargestSumOptimal(int[] arr, int N, int K) {

		int low=Integer.MIN_VALUE,high=0;


		for(int i=0;i<N;i++)
		{
			low=Math.max(low,arr[i]);
			high=high+arr[i];
		}

		while(low<=high)
		{
			int mid=(low+high)/2;
			int subarrayCount=possibleSubarray(arr,N,mid);

			if(subarrayCount>K)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}

		return low;
	}

	private static int possibleSubarray(int arr[],int n,int totalSubarray)
	{
		int subarraySum=0,subarrayCount=1;

		for(int i=0;i<n;i++)
		{
			if(subarraySum+arr[i]<=totalSubarray)
			{
				subarraySum=subarraySum+arr[i];
			}
			else
			{
				subarrayCount++;
				subarraySum=arr[i];
			}
		}

		return subarrayCount;
	}

	/*
	 * Time Complexity: O(n*(max-sum+1))
	 * Space Complexity: O(1) 
	 * 
	 */
	
	private static int splitArrayLargestSumBrute(int[] arr, int N, int K) {

		int max=Integer.MIN_VALUE,sum=0;
				
		for(int i=0;i<N;i++)
		{
			max=Math.max(max, arr[i]);
			sum=sum+arr[i];
		}
		
		for(int i=max;i<=sum;i++)
		{
			if(possibleSubarray(arr,N,i)==K)
			{
				return i;
			}
		}
		
		return max;
	}
}
