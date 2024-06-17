package Arrayprograms.medium;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		
		int arr[]= {2, 1, 5, 4, 3, 0, 0};
		
		System.out.println(Arrays.toString(next_permutation(arr)));

	}

	private static int[] next_permutation(int[] arr) {
		
		int n=arr.length,ind=-1;
		
		for(int i=n-2;i>=0;i--)
		{
			if(arr[i]<arr[i+1])
			{
				ind=i;
				break;
			}
		}
		
		if(ind==-1)
		{
			reverse(arr,0,n-1);
			return arr;
		}
		
		for(int i=n-1;i>ind;i--)
		{
			if(arr[i]>arr[ind])
			{
				int temp=arr[i];
				arr[i]=arr[ind];
				arr[ind]=temp;
				break;
			}
		}
		
		reverse(arr,ind+1,n-1);
		return arr;
		
	}

	private static void reverse(int[] arr, int start, int end) {
		
		 while (start < end) {
		        int temp = arr[start];
		        arr[start] = arr[end];
		        arr[end] = temp;
		        start++;
		        end--;
		    }
		
	}
}
