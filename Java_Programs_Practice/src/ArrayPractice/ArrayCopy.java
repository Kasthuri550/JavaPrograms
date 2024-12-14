package ArrayPractice;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		
		int arr[] = {1, 4, 45, 6, 10, 19};
		
		int a1[]=Arrays.copyOf(arr,3);
		int a2[]=Arrays.copyOfRange(arr,2,4);
				
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		
		int dest[]=new int[arr.length];
		
		System.arraycopy(arr,0, dest,0, arr.length);
		
		System.out.println(Arrays.toString(dest));
		int binarySearch = Arrays.binarySearch(arr,10);
		System.out.println(binarySearch);

	}
}
