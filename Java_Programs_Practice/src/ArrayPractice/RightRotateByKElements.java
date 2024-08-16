package ArrayPractice;

import java.util.Arrays;

public class RightRotateByKElements {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		
//		rightRotateBrute(arr,arr.length,2);
		
		rightRotateOptimal(arr,arr.length,2);

	}

	private static void rightRotateOptimal(int[] arr, int n, int k) {
		
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

	private static void rightRotateBrute(int[] arr, int n, int k) {
		
		int temp[]=new int[k];
		
		for(int i=n-k;i<n;i++)
		{
			temp[i-n+k]=arr[i];
		}
		
		for(int i=n-k-1;i>=0;i--)
		{
			arr[i+k]=arr[i];
		}
		
		for(int i=0;i<k;i++)
		{
			arr[i]=temp[i];
		}
		
		System.out.println(Arrays.toString(arr));
	}

}

