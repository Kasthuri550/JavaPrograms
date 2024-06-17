package Streams;

import java.util.Arrays;

public class SortArrayThenConvertToStream {

	public static void main(String[] args) {
		
		int arr[] = { 99, 55, 203, 99, 4, 91 };
		
		Arrays.parallelSort(arr);
		
		Arrays.stream(arr).forEach(ele->System.out.print(ele+" "));

	}
}
