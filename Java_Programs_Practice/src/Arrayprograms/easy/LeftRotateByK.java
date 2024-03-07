package Arrayprograms.easy;

import java.util.Arrays;

public class LeftRotateByK {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		
//		leftRotateByK(arr,2);
		leftRotate(arr,2);
	}

	private static void leftRotate(int[] arr, int k) {
		
		int n=arr.length;
		reverse(arr,0,k-1);
		reverse(arr,k,n-1);
		reverse(arr,0,n-1);
		
		System.out.println(Arrays.toString(arr));
	}

	private static void reverse(int[] arr, int start, int end) {
		
		while(start<=end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}

	private static void leftRotateByK(int[] arr,int k) {
		
		int n=arr.length;
		
		for(int i=0;i<k;i++)
		{
			int first=arr[0],j;
			for(j=0;j<n-1;j++)
			{
				arr[j]=arr[j+1];
			}
			
			arr[j]=first;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
