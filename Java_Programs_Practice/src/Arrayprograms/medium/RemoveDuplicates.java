package Arrayprograms.medium;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		 int arr[] = {3, 1, 2, 3, 2, 4, 5, 1},n=arr.length;
		 
		 int index= duplicateRemoval(arr, n);
		 
		 for(int i=0;i<n;i++)
		 {
			 if(index<=i)
			 {
				 arr[i]=-1;
			 }
		 }
		 
		 System.out.println(Arrays.toString(arr));
	}

	private static int duplicateRemoval(int[] arr, int n) {
		
		int index=0;
		
		Arrays.sort(arr);
		 
		 for(int i=1;i<n;i++)
		 {
			 if(arr[i]!=arr[index])
			 {
				 index++;
				 arr[index]=arr[i];
			 }
		 }
		 
		 return index+1;
	}
}
