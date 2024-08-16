package ArrayPractice;

import java.util.Arrays;

public class RightRotateByOnePlace {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5};
		
//		rightRotateByOnePlaceBrute(arr);
		rightRotateByOnePlaceOptimal(arr);

	}

	private static void rightRotateByOnePlaceOptimal(int[] arr) {
		
		int n=arr.length;
		int temp=arr[n-1];
		for(int i=n-2;i>=0;i--)
		{
			arr[i+1]=arr[i];
		}
		
		arr[0]=temp;
		
		System.out.println(Arrays.toString(arr));
	}

	private static void rightRotateByOnePlaceBrute(int[] arr) {
		
		int n=arr.length;
		int temp[]=new int[n];
		
		for(int i=0;i<n-1;i++)
		{
			temp[i+1]=arr[i];
		}
		
		temp[0]=arr[n-1];
		
		System.out.println(Arrays.toString(temp));
	}
}
