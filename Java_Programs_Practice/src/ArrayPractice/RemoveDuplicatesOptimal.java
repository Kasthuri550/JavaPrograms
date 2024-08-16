package ArrayPractice;

import java.util.Arrays;

public class RemoveDuplicatesOptimal {
	
	public static void main(String[] args) {
		
		int arr[]={1,1,2,2,2,3,3};
		
		int k=removeDuplicatesOptimal(arr);
		
		for(int i=k;i<arr.length;i++)
		{
			arr[i]=-1;
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static int removeDuplicatesOptimal(int[] arr) {
		
		int n=arr.length,i=0;
		
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
