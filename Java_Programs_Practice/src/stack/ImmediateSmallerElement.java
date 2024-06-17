package stack;

import java.util.Arrays;

public class ImmediateSmallerElement {

	public static void main(String[] args) {
		
		int arr[] = {4, 2, 1, 5, 3};
		
		nextSmallerElement(arr);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void nextSmallerElement(int[] arr) {
		
		int n=arr.length;
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				arr[i]=arr[i+1];
			}
			else if(arr[i]<=arr[i+1])
			{
				arr[i]=-1;
			}
		}
		
		arr[n-1]=-1;
		
	}

}
