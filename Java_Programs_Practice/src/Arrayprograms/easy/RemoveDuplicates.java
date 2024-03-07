package Arrayprograms.easy;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		int arr[]= {3,4,5,9,2,1,1,2};
		
//		int length=approach1(arr);
		int length=approach2(arr);
		
		for(int i=0;i<length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
	}

	private static int approach2(int[] arr) {
		
		Arrays.parallelSort(arr);
		int i=0;
		for(int j=1;j<arr.length;j++)
		{
			if(arr[i]!=arr[j])
			{
				i++;
				arr[i]=arr[j];
			}
		}
		return i+1;
	}

	private static int approach1(int[] arr) {
		
		int n=arr.length;
		
		if(n==0||n==1)
		{
			return n;
		}
		
		Arrays.parallelSort(arr);
		
		int temp[]=new int[n];
		int j=0;
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]!=arr[i+1])
			{
				temp[j++]=arr[i];
			}
		}
		
		temp[j++]=arr[n-1];
		
		
		for(int i=0;i<j;i++)
		{
			arr[i]=temp[i];
		}
		System.out.println(Arrays.toString(temp)+" "+j);
		
		
		return j;
	}

}
