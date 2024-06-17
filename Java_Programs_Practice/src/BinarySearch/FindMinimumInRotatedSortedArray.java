package BinarySearch;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		
		int arr[] = {2,3,4,5,6,7,8,9,10,1};
		
		System.out.println(minRotatedSortedArray(arr));

	}

	private static int minRotatedSortedArray(int[] arr) {
		
		int n=arr.length;
		
		int low=0,high=n-1,result=Integer.MAX_VALUE;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(arr[low]<=arr[high])
			{
				result=Math.min(result, arr[low]);
				break;
			}
			
			if(arr[low]<=arr[mid])
			{
				result=Math.min(result,arr[low]);
				low=mid+1;
			}
			else
			{
				result=Math.min(result,arr[mid]);
				high=mid-1;
			}
		}
		return result;
	}
}
