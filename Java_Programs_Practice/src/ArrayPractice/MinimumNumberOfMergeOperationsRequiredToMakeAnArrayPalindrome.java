package ArrayPractice;

public class MinimumNumberOfMergeOperationsRequiredToMakeAnArrayPalindrome {

	public static void main(String[] args) {
		
		 int arr[] = new int[]{1, 4, 5, 9, 1} ;
		 
		System.out.println( minOperations(arr));

	}

	private static int minOperations(int[] arr) {
		
		int left=0,right=arr.length-1,mergedCount=0;
		
		while(left < right)
		{
			if(arr[left]==arr[right])
			{
				left++;
				right--;
			}
			else if(arr[left]<arr[right])
			{
				arr[left+1]+=arr[left];
				left++;
				mergedCount++;
			}
			else
			{
				arr[right-1]+=arr[right];
				right--;
				mergedCount++;
			}
		}
			
		return mergedCount;
		
	}
}
