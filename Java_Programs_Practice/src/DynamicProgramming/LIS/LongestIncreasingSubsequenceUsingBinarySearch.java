package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubsequenceUsingBinarySearch {

	public static void main(String[] args) {

		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		int n = arr.length;

		longestIncreasingSubsequence(arr,n);
	}
	/*
	 * Time Complexity: O(n*log n)
	 * Space Complexity: O(n)
	 * */
	private static void longestIncreasingSubsequence(int[] arr, int n) {

		ArrayList<Integer> temp=new ArrayList<>();
		temp.add(arr[0]);

		int length=1;

		for(int i=0;i<n;i++)
		{
			if(arr[i]>temp.get(temp.size()-1))
			{
				temp.add(arr[i]);
				length++;
			}
			else
			{
				int index=Collections.binarySearch(temp,arr[i]);

				if(index<0)
				{
					index=-index-1;
				}

				temp.set(index,arr[i]);
			}
		}

		System.out.println(length);
	}
}
