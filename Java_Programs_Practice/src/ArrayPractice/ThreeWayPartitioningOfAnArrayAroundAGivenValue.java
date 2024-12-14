package ArrayPractice;

import java.util.Arrays;

public class ThreeWayPartitioningOfAnArrayAroundAGivenValue {

	public static void main(String[] args) {

		int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};

		threeWayPartition(arr, 10, 20);
	}

	private static void threeWayPartition(int[] arr, int low, int high) {
		
		int start=0,mid=0,end=arr.length-1;
		
		while(mid<=end)
		{
			if(arr[mid]<low)
			{
				swap(arr,start,mid);
				mid++;
				start++;
			}
			else if(arr[mid]>high)
			{
				swap(arr,mid,end);
				end--;
			}
			else
			{
				mid++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void swap(int arr[], int i, int j) {
		
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

}
