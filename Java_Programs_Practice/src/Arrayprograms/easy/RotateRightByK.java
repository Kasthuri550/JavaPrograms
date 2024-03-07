package Arrayprograms.easy;

import java.util.Arrays;

public class RotateRightByK {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7};
		
//		rightRotateK(arr,2);
		rightRotateByK(arr,2);
	}

	private static void rightRotateByK(int[] arr, int k) {
		
		int n=arr.length;
		
		reverse(arr,0,n-k-1);
		reverse(arr,n-k,n-1);
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

	private static void rightRotateK(int[] arr,int k) {
		
		int n=arr.length;
		
		
		for(int i=0;i<k;i++)
		{
			int last=arr[n-1],j;
			for(j=n-1;j>0;j--)
			{
				arr[j]=arr[j-1];
			}
			arr[0]=last;
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

}
