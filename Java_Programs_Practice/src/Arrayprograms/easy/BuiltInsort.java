package Arrayprograms.easy;

import java.util.Arrays;

public class BuiltInsort {

	public static void main(String[] args) {
		
		int arr[] = {4, 1, 3, 9, 7};
		
		sort(arr);
	}

	private static void sort(int[] arr) {

//		Arrays.parallelSort(arr);
//		System.out.println(Arrays.toString(arr));
		
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		Integer[] array = {3, 1, 5, 2};
		Arrays.sort(array,(a,b)->b-a);
		System.out.println(Arrays.toString(array));
	}
}
