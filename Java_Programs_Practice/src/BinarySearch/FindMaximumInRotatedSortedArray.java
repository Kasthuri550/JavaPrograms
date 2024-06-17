package BinarySearch;

public class FindMaximumInRotatedSortedArray {

	public static void main(String[] args) {

		int arr[] = {2,3,4,5,6,7,8,9,10,1};

		System.out.println(maxRotatedSortedArray(arr));

	}

	private static int maxRotatedSortedArray(int[] arr) {
		
		int n=arr.length,low=0,high=n-1,result=Integer.MIN_VALUE;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(arr[low]<=arr[high])
			{
				result=Math.max(result,arr[high]);
				break;
			}
			
			if(arr[low]<=arr[mid])
			{
				result=Math.max(result, arr[mid]);
				low=mid+1;
			}
			else
			{
				result=Math.max(result, arr[low]);
				high=mid-1;
			}
		}
		return result;
	}
}
