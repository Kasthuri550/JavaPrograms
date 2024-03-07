package Arrayprograms;

import java.util.Arrays;

public class FirstHalfAscSecondHalfDesc {

	public static void main(String[] args) {
		
		int[] arr = {3, 2, 4, 1, 10, 30, 40, 20};
		
//		sort1(arr);
		sort2(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void sort2(int[] arr) {
		
		int n=arr.length;
		int newArray[]=new int[n];
		int index=0;
		
		Arrays.sort(arr);
		
		for(int i=0;i<n/2;i++)
		{
			newArray[index++]=arr[i];			
		}
		
		for(int j=n-1;j>=n/2;j--)
		{
			newArray[index++]=arr[j];			
		}
		
		index=0;
		for(int k=0;k<n;k++)
		{
			arr[index++]=newArray[k];
		}
	}

	private static void sort1(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
			for(int k=n/2;k<n-1;k++)
			{
				if(arr[k]<arr[k+1])
				{
					int temp=arr[k];
					arr[k]=arr[k+1];
					arr[k+1]=temp;
				}
			}
		}
		
	}

}
