package searching;

public class BinarySearch {

	public static void main(String[] args) {

		int  arr[]= {1, 2, 3, 4, 5}, searchElement = 3;
		
//		System.out.println(binarySearchIterative(arr,searchElement));
		System.out.println(binarySearchRecursive(arr,0,arr.length-1,searchElement));
	}

	private static int binarySearchRecursive(int[] arr, int left, int right, int searchElement) {
		
		if(left<=right)
		{
			int mid=left+(right-left)/2;
			
			if(arr[mid]==searchElement)
			{
				return mid;
			}
			if(arr[mid]<searchElement)
			{
				return binarySearchRecursive(arr, mid+1, right, searchElement);
			}
			else
			{
				return binarySearchRecursive(arr, left, mid-1, searchElement);
			}
		}
		
		return -1;		
	}

	private static int binarySearchIterative(int[] arr, int searchElement) {
		
		int left=0,right=arr.length-1;
		
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			
			if(arr[mid]==searchElement)
			{
				return mid;
			}
			if(arr[mid]<searchElement)
			{
				left=mid+1;
			}
			else
			{
				right=mid-1;
			}
		}
		
		return -1;
		
	}

}
