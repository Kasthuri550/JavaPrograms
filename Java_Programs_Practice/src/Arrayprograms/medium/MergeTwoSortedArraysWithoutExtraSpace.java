package Arrayprograms.medium;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

	public static void main(String[] args) {
		
		long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        
//        mergeTwoSortedArraysBrute(arr1,arr2);
        mergeTwoSortedArraysOptimal(arr1, arr2);
	}

	private static void mergeTwoSortedArraysOptimal(long[] arr1, long[] arr2) {
		
		int n=arr1.length,m=arr2.length;
		
		int left=n-1,right=0;
		
		while(left>=0 && right<m)
		{
			if(arr1[left]>arr2[right])
			{
				long temp=arr1[left];
				arr1[left]=arr2[right];
				arr2[right]=temp;
				left--;
				right++;
			}
			else
			{
				break;
			}
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
	}

	private static void mergeTwoSortedArraysBrute(long[] arr1, long[] arr2) {
		
		int n=arr1.length,m=arr2.length;
		
		long arr3[]=new long[n+m];
		
		int left=0,right=0,index=0;
		
		while(left<n && right<m)
		{
			if(arr1[left]<=arr2[right])
			{
				arr3[index++]=arr1[left++];
			}
			else
			{
				arr3[index++]=arr2[right++];
			}
		}
		
		while(left < n)
		{
			arr3[index++]=arr1[left++];
		}
		
		while(right < m)
		{
			arr3[index++]=arr2[right++];
		}
		
		for(int i=0;i<n+m;i++)
		{
			if(i<n)
			{
				arr1[i]=arr3[i];
			}
			else
			{
				arr2[i-n]=arr3[i];
			}
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
	}
}
