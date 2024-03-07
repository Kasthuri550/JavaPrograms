package Arrayprograms;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		
		int arr[]= {10,20,30,40,50};
//		reverseArray1(arr);
//		reverseArray2(arr);
		reverseArray3(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
			
	}

	private static void reverseArray3(int[] arr, int start, int end) {
		
		if(start>end)
		{
			return;
		}
		
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
		
		reverseArray3(arr,start+1,end-1);
	}

	private static void reverseArray2(int[] arr) {
		
		int n=arr.length;
		int start=0,end=n-1;
		
		while(start<end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
		
	}

	private static void reverseArray1(int[] arr) {
		
		int n=arr.length;
		int newArray[]=new int[n];
		int index=0;
		
		for(int i=n-1;i>=0;i--)
		{
			newArray[index++]=arr[i];
		}
		
		index=0;
		for(int j=0;j<n;j++)
		{
			arr[index++]=newArray[j];
		}
				
	}

}
