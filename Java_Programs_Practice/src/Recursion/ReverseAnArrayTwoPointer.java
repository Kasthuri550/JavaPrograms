package Recursion;

import java.util.Arrays;

public class ReverseAnArrayTwoPointer {

	public static void main(String[] args) {
		
		int arr[]= {1,4,5,2,3};
		
		reverse(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void reverse(int[] arr,int l,int r) {
		
		
		if(l>=r)
		{
			return;
		}
		
		swap(arr,l,r);
		
		reverse(arr,l+1,r-1);
		
	}

	private static void swap(int[] arr, int l, int r) {
		
		int temp=arr[l];
		arr[l]=arr[r];
		arr[r]=temp;
		
	}

}
