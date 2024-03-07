import java.util.Arrays;

public class DeleteElementSortedArray {

	public static void main(String[] args) {

		int arr[] = { 10, 50, 30, 40, 20 };

		Arrays.parallelSort(arr);
		int element = 20;

		int arrayLength = deleteElementArray(arr, arr.length, element);

		for (int j = 0; j < arrayLength; j++) {
			System.out.print(arr[j] + " ");
		}

	}

	private static int deleteElementArray(int[] arr, int length, int element) {
		int pos=binarySearch(arr,0,length-1,element);
		if(pos==-1)
		{
			System.out.println("Element not found");
			return length;
		}
		
		for(int i=pos;i<length-1;i++)
		{
			arr[i]=arr[i+1];
		}
		
		return length-1;
	}

	private static int binarySearch(int[] arr, int low, int high, int element) {
		
		if(low>high)
		  return -1;
		
		int mid=(low+high)/2;
		
		if(arr[mid]==element)
			return mid;
		if(arr[mid]>element)
			return binarySearch(arr, low,(mid-1), element);
		
		return binarySearch(arr, (mid+1), high, element);
	}

}
