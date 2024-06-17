package Streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlattenMap {

	public static void main(String[] args) {
		
		int arr[][]= new int[][]{{3,4},{6,7}};
		
		int[] array = Arrays.stream(arr).flatMapToInt(map->Arrays.stream(map)).toArray();
		
		System.out.println(Arrays.toString(array));

	}
}
