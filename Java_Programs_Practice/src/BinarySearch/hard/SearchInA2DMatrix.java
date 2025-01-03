package BinarySearch.hard;

public class SearchInA2DMatrix {

	public static void main(String[] args) {

		int mat[][] = {{1, 5, 9}, {14, 20, 21}, {30, 34, 43}}, x = 14;

		System.out.println(searchInA2DMatrixBrute(mat,x));
		System.out.println(searchInA2DMatrixBetter(mat,x));
		System.out.println(searchInA2DMatrixOptimal1(mat,x));
		System.out.println(searchInA2DMatrixOptimal2(mat,x));

	}

	/*
	 * Time Complexity: O(n+m)
	 * Space Complexity: O(1)
	 */	
	private static boolean searchInA2DMatrixOptimal2(int[][] mat, int x) {

		int n=mat.length,m=mat[0].length;
		int l=0,r=m-1;

		while(l<=n && 0<=r)
		{
			if(mat[l][r]==x)
			{
				return true;
			}
			if(mat[l][r]<x)
			{
				l++;
			}
			else
			{
				r--;
			}
		}

		return false;
	}

	/*
	 * Time Complexity: O(log(n*m))
	 * Space Complexity: O(1)
	 */	
	private static boolean searchInA2DMatrixOptimal1(int[][] mat, int target) {

		int n=mat.length,m=mat[0].length;
		int low=0,high=n*m-1;

		while(low<=high)
		{
			int mid=(low+high)/2;
			int row=mid/m,col=mid%m;

			if(mat[row][col]==target)
			{
				return true;
			}

			if(mat[row][col]<target)
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
	 * Time Complexity: O(n*log m)'
	 * Space Complexity: O(1)
	 * 
	 */
	private static boolean searchInA2DMatrixBetter(int[][] mat, int target) {

		int n=mat.length,m=mat[0].length;

		for(int i=0;i<n;i++)
		{
			if(mat[i][0]<=target && target<=mat[i][m-1])
				return binarySearch(mat[i],target);
		}

		return false;
	}

	private static boolean binarySearch(int[] mat, int target) {

		int low=0,high=mat.length;

		while(low<=high)
		{
			int mid=(low+high)/2;

			if(mat[mid]==target)
				return true;

			if(mat[mid]<target)
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
	 */	
	private static boolean searchInA2DMatrixBrute(int[][] mat, int target) {

		int n=mat.length,m=mat[0].length;

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mat[i][j]==target)
				{
					return true;
				}
			}
		}

		return false;
	}
}
