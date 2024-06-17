package Arrayprograms.medium;

import java.util.Arrays;

public class NextPermutationI {

	public static void main(String[] args) {
		
		int arr[]= {2,3,1};
		
		npOptimal(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] npOptimal(int[] arr) {
		
		int n=arr.length,index=-1;
		
		for(int i=n-2;i>=0;i--)
		{
			if(arr[i]<arr[i+1])
			{
				index=i;
				break;
			}
		}
		
		if(index==-1)
		{
			reverse(arr,0,n-1);
			return arr;
		}
		
		for(int i=n-1;i>index;i--)
		{
			if(arr[i]>arr[index])
			{
				int temp=arr[i];
				arr[i]=arr[index];
				arr[index]=temp;
				break;
			}
		}
		
		reverse(arr,index+1,n-1);
		
		return arr;
		
	}

	private static void reverse(int[] arr, int start,int end) {
		
		
		while(start<end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
}
