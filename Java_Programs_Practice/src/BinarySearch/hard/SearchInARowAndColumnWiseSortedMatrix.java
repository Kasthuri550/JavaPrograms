package BinarySearch.hard;

public class SearchInARowAndColumnWiseSortedMatrix {

	public static void main(String[] args) {

		int mat[][] = {{3, 4, 9},{2, 5, 6},{9, 25, 27}}, x = 9;

		System.out.println(searchInARowAndColumnWiseSortedMatrixBrute(mat,x));
		System.out.println(searchInARowAndColumnWiseSortedMatrixBetter(mat, x));
		System.out.println(searchInARowAndColumnWiseSortedMatrixOptimal(mat, x));

	}

	/*
	 * Time Complexity: O(n+m)
	 * Space Complexity: O(1)
	 * 
	 */	

	private static boolean searchInARowAndColumnWiseSortedMatrixOptimal(int[][] mat, int x) {

		int n=mat.length,m=mat[0].length;

		int row=0,col=m-1;

		while(row<n && col>=0)
		{
			if(mat[row][col]==x)
				return true;

			if(mat[row][col]<x)
				row++;
			else
				col--;
		}

		return false;
	}


	/*
	 * Time Complexity: O(n*log m)
	 * Space Complexity: O(1)
	 * 
	 */	

	private static boolean searchInARowAndColumnWiseSortedMatrixBetter(int[][] mat, int x) {

		int n=mat.length,m=mat[0].length;

		for(int i=0;i<n;i++)
		{
			boolean flag=binarySearch(mat[i],m,x);
			if(flag)
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
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}

		return false;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * 
	 */

	private static boolean searchInARowAndColumnWiseSortedMatrixBrute(int[][] mat, int x) {

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
