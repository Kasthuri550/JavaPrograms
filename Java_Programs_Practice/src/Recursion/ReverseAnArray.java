package Recursion;

import java.util.Arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		
		int arr[]= {4,5,3,1,2};
		reverse(arr,0,arr.length);
		System.out.println(Arrays.toString(arr));

	}

	private static void reverse(int[] arr,int i,int n) {
		
		
		if(i>=n/2)
		{
			return;
		}
		swap(arr,i,n-i-1);
		
		reverse(arr,i+1,n);
		
	}

	private static void swap(int[] arr, int i, int j) {
		
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

}
