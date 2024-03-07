package Arrayprograms;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		
		int array[] = {1, 2, 2, 4};
		int N = array.length;
		
		removeDuplicates(array,N);
	}

	private static int removeDuplicates(int[] arr, int n) {
		
		if (n == 0 || n == 1)
            return n;

        // To store index of next unique element
        int j = 0;

        // Traverse the array
        for (int i = 0; i < n - 1; i++) {
            // If current element is not equal to next element
            if (arr[i] != arr[i + 1]) {
                // Store the current element
                arr[j++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        // Store the last element if it's different from the previous one
        if (arr[n - 2] != arr[n - 1]) {
            arr[j++] = arr[n - 1];
        }
        System.out.println(Arrays.toString(arr));
        // Update the array size to the index of the last unique element
        return j;
	}

}
