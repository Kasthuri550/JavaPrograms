package BinarySearch.hard;

import java.util.Arrays;

public class SearchInARowWiseSortedMatrix {

	public static void main(String[] args) {

		int mat[][] = {{3, 4, 9},{2, 5, 6},{9, 25, 27}}, x = 9;

		System.out.println(searchInARowWiseSortedMatrixBrute(mat,x));
		System.out.println(searchInARowWiseSortedMatrixBetter(mat, x));
		System.out.println(searchInARowWiseSortedMatrixOptimal(mat, x));

	}
	/*
	 * Time Complexity: O(n*log m)
	 * Space Complexity: O(1)
	 * 
	 */
	private static boolean searchInARowWiseSortedMatrixOptimal(int[][] mat, int x) {

		if (mat == null || mat.length == 0 || mat[0].length == 0) {
			return false;
		}

		for(int row[]:mat)
		{
			if(Arrays.binarySearch(row,x)>=0)
				return true;
		}

		return false;
	}
	/*
	 * Time Complexity: O(n*log m)
	 * Space Complexity: O(1)
	 */
	private static boolean searchInARowWiseSortedMatrixBetter(int[][] mat, int x) {

		int n=mat.length,m=mat[0].length;

		for(int i=0;i<n;i++)
		{
			if(binarySearch(mat[i],m,x))
				return true;
		}

		return false;
	}

	private static boolean binarySearch(int[] mat, int m, int x) {

		int low=0,high=m;

		while(low<=high)
		{
			int mid=(low+high)/2;

			if(mat[mid]==x)
				return true;

			if(mat[mid]<x)
				low=mid+1;
			else
				high=mid-1;
		}
		return false;
	}
	/*
	 * Time Complexity: O(n*m)
	 * Space Complexity: O(1)
	 */
	private static boolean searchInARowWiseSortedMatrixBrute(int[][] mat, int x) {

		int n=mat.length,m=mat[0].length;

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mat[i][j]==x)
					return true;
			}
		}

		return false;
	}
}
