package Arrayprograms.easy;

import java.util.Arrays;

public class SortArrayQuick {

	public static void main(String[] args) {
		
		int arr[] = { 4, 1, 3, 9, 7};
		
		quickSort(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		
		if(low<high)
		{
			int partitionIndex=partition(arr,low,high);
			quickSort(arr, low, partitionIndex-1);
			quickSort(arr, partitionIndex+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		
		int i=low,j=high,pivot=arr[low];
		
		while(i<j)
		{
			while(arr[i]<=pivot && i<=high-1)
			{
				i++;
			}
			
			while(arr[j]>pivot && j>=low+1)
			{
				j--;
			}
			if(i<j)
			{
				swap(arr,i,j);
			}
		}
		swap(arr,low,j);
		
		return j;
	}

	private static void swap(int[] arr, int index1, int index2) {
		
		int temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
}
