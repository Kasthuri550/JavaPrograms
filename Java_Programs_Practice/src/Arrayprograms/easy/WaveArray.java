package Arrayprograms.easy;

import java.util.Arrays;

public class WaveArray {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
		
		waveArray(arr);

	}

	private static void waveArray(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n-1;i+=2)
		{
			int temp=arr[i];
			arr[i]=arr[i+1];
			arr[i+1]=temp;
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
}
