package Arrayprograms.easy;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		
		 int arr[] = {1,1,2,2,2,3,3},n=arr.length;
		 
		 int count=removeDuplicatesBrute(arr,n);
		 
		 for(int i=0;i<n;i++)
		 {
			 if(count<=i)
			 {
				 arr[i]=-1;
			 }
		 }
		 
		 System.out.println(Arrays.toString(arr));
	}

	private static int removeDuplicatesBrute(int[] arr,int n) {
		
		int i=0;
		
		for(int j=1;j<n;j++)
		{
			if(arr[i]!=arr[j])
			{
				i++;
				arr[i]=arr[j];
			}
		}
		
		return i+1;
	}
}
