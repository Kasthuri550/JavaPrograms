package Streams;

import java.util.Arrays;

public class MaxElementArray {

	public static void main(String[] args) {
		
		int arr[]= {12,19,20,88,00,9};
		
		int max = Arrays.stream(arr).max().getAsInt();
		System.out.println(max);

	}
}
