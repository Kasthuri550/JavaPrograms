package BinarySearchTree.hard;

public class MinimumDaysToMakeMBouquets {

	public static void main(String[] args) {

		int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
		int k = 3;
		int m = 2;

		System.out.println(minimumDaysToMakeMBouquetsBrute(arr,m,k));
		System.out.println(minimumDaysToMakeMBouquetsOptimal(arr, m, k));
	}

//	Time Complexity: O(n* log(max-min+1))
//	Space Complexity: O(1)
	private static int minimumDaysToMakeMBouquetsOptimal(int[] arr, int m, int k) {
		
		int n=arr.length,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		long val=(long)m*k;
		
		if(val>n)
			return -1;
		
		for(int i=0;i<n;i++)
		{
			min=Math.min(min,arr[i]);
			max=Math.max(max,arr[i]);
		}
		
		int low=min,high=max;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(isPossible(arr,n,mid,m,k))
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		
		return low;
	}

//	Time Complexity: O(n* (max-min+1))
//	Space Complexity: O(1)
	private static int minimumDaysToMakeMBouquetsBrute(int[] arr, int m, int k) {

		int n=arr.length;
		long val=(long)m*k;
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;

		if(val>n) return -1;

		for(int i=0;i<n;i++)
		{
			max=Math.max(max,arr[i]);
			min=Math.min(min,arr[i]);
		}

		for(int i=min;i<=max;i++)
		{
			if(isPossible(arr,n,i,m,k))
			{
				return i;
			}
		}

		return -1;		
	}

	private static boolean isPossible(int[] arr,int n,int day, int m, int k) {

		int count=0,noOfBouquets=0;

		for(int i=0;i<n;i++)
		{
			if(arr[i]<=day)
			{
				count++;
			}
			else
			{
				noOfBouquets+=count/k;
				count=0;
			}
		}

		noOfBouquets+=count/k;

		return noOfBouquets>=m;
	}

}
