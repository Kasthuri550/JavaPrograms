package BinarySearch.medium;

public class BookAllocation {

	public static void main(String[] args) {

		int arr[] = {12, 34, 67, 90}, k = 2;

		System.out.println(bookAllocationBrute(arr,k));
		System.out.println(bookAllocationOptimal(arr, k));

	}

	/*
	 * Time Complexity: O(n*log(high-low+1))
	 * Space Complexity: O(1) 
	 * 
	 */

	private static int bookAllocationOptimal(int[] arr, int k) {

		int n=arr.length,low=Integer.MIN_VALUE,high=0;

		if(k>n) return -1;	

		for(int i=0;i<n;i++)
		{
			low=Math.max(low,arr[i]);
			high=high+arr[i];
		}

		while(low<=high)
		{
			int mid=(low+high)/2;
			int students=countPages(arr, n,mid);

			if(students>k)
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


	/*
	 * Time Complexity: O(n*(max-sum+1))
	 * Space Complexity: O(1) 
	 * 
	 */

	private static int bookAllocationBrute(int[] arr, int k) {

		int n=arr.length,max=Integer.MIN_VALUE,sum=0;

		if(k>n) return -1;

		for(int i=0;i<n;i++)
		{
			max=Math.max(max,arr[i]);
			sum=sum+arr[i];
		}

		for(int pages=max;pages<=sum;pages++)
		{
			if(countPages(arr,n,pages)==k)
			{
				return pages;
			}
		}

		return max;
	}

	private static int countPages(int[] arr,int n,int pages) {

		int pagesCount=0,student=1;

		for(int i=0;i<n;i++)
		{
			if(pagesCount+arr[i]<=pages)
			{
				pagesCount=pagesCount+arr[i];
			}
			else
			{
				student++;
				pagesCount=arr[i];
			}
		}

		return student;
	}
}
