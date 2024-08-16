package ArrayPractice;

import java.util.Arrays;

public class LeftRotateByKElements {

	public static void main(String[] args) {
		
		 int[] arr = {1,2,3,4,5,6,7};
		 
//		 leftRotateBrute(arr,arr.length,2);
		 leftRotateOptimal(arr,arr.length,2);
	}

	private static void leftRotateOptimal(int[] arr, int n, int k) {
		
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

	private static void leftRotateBrute(int[] arr, int n,int k) {
		
		int temp[]=new int[k];
		
		for(int i=0;i<k;i++)
		{
			temp[i]=arr[i];
		}
		
		for(int i=0;i<n-k;i++)
		{
			arr[i]=arr[i+k];
		}
		
		for(int i=n-k;i<n;i++)
		{
			arr[i]=temp[i-n+k];
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
