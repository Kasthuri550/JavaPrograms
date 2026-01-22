package Arrayprograms;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {

		int arr[]={2, 1, 5, 4, 3, 0, 0};
		int[] nextGreater = nextGreater(arr,arr.length);
		System.out.println(Arrays.toString(nextGreater));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */	
	private static int[] nextGreater(int[] arr, int n) {

		int index=-1;

		for(int i=n-2;i>=0;i--)
		{
			if(arr[i] < arr[i+1])
			{
				index=i;
				break;
			}
		}

		if(index == -1)
		{
			swap(arr,0,n-1);
			return arr;
		}

		for(int j=n-1;j>index;j--)
		{
			if(arr[j]>arr[index])
			{
				int temp=arr[j];
				arr[j]=arr[index];
				arr[index]=temp;
				break;
			}
		}

		swap(arr,index+1,n-1);

		return arr;	

	}

	private static void swap(int[] arr, int start, int end) {

		while(start < end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
}
