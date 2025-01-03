package BinarySearch.hard;

import java.util.Arrays;

public class FindPeakElementII {

	public static void main(String[] args) {
		
		int mat[][] = {{10,20,15},{21,30,14},{7,16,32}};
		
		System.out.println(Arrays.toString(findPeakElementIIBrute(mat)));
		System.out.println(Arrays.toString(findPeakElementIIBetter(mat)));
		System.out.println(Arrays.toString(findPeakElementIIOptimal(mat)));

	}

	/*
	 * Time Complexity: O(m * log n)
	 * Space Complexity: O(1)
	 */	
	private static int[] findPeakElementIIOptimal(int[][] mat) {
		
		int m=mat.length,n=mat[0].length;
		int low=0,high=n-1;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			int maxRow=findMaxElement(mat,m,n,mid);
			int left=mid>0?mat[maxRow][mid-1]:Integer.MIN_VALUE;
			int right=mid<n-1?mat[maxRow][mid+1]:Integer.MIN_VALUE;
			
			if(mat[maxRow][mid]>left && mat[maxRow][mid]>right)
				return new int[] {maxRow,mid};
			else if(mat[maxRow][mid]<left)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		
		return new int[] {-1,-1};
	}

	private static int findMaxElement(int[][] mat, int m, int n, int mid) {

		int maxIndex=0,maxValue=-1;
		for(int i=0;i<m;i++)
		{
			if(mat[i][mid] > maxValue)
			{
				maxValue=mat[i][mid];
				maxIndex=i;
			}
		}
		
		return maxIndex;
	}

	/*
	 * Time Complexity: O(n*m)
	 * Space Complexity: O(1)
	 */	
	private static int[] findPeakElementIIBetter(int[][] mat) {

		int m=mat.length,n=mat[0].length;
		
		for(int i=0;i<m;i++)
		{
			int maxCol=findMaxIndex(mat[i]);
			if(isPeakElement(mat,i,maxCol))
			{
				return new int[] {i,maxCol};
			}
		}
		
		return new int[] {-1,-1};
	}

	private static boolean isPeakElement(int[][] mat, int i, int j) {

		int m=mat.length,n=mat[0].length;
		
		int top=(i>0)?mat[i-1][j]:Integer.MIN_VALUE;
		int bottom=(i<m-1)?mat[i+1][j]:Integer.MIN_VALUE;
		int left=(j>0)?mat[i][j-1]:Integer.MIN_VALUE;
		int right=(j<n-1)?mat[i][j+1]:Integer.MIN_VALUE;
		
		return mat[i][j]>=top && mat[i][j]>=bottom && mat[i][j]>=left && mat[i][j]>=right;
	}

	private static int findMaxIndex(int[] mat) {

		int maxIndex=0,m=mat.length;
		
		for(int i=1;i<m;i++)
		{
			if(mat[i]>mat[maxIndex])
			{
				maxIndex=i;
			}
		}
		return maxIndex;
	}

/*
 * Time Complexity: O(n*m)
 * Space Complexity: O(1)
 */	
	private static int[] findPeakElementIIBrute(int[][] mat) {

		int m=mat.length,n=mat[0].length;
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(isPeak(mat,i,j))
				{
					return new int[] {i,j};
				}
			}
		}
		
		return new int[] {-1,-1};
	}

	private static boolean isPeak(int[][] mat, int i, int j) {

		int m=mat.length,n=mat[0].length;
		
		int top=(i>0)?mat[i-1][j]:Integer.MIN_VALUE;
		int bottom=(i<m-1)?mat[i+1][j]:Integer.MIN_VALUE;
		int left=(j>0)?mat[i][j-1]:Integer.MIN_VALUE;
		int right=(j<n-1)?mat[i][j+1]:Integer.MIN_VALUE;
		
		return mat[i][j]>=top && mat[i][j]>=bottom && mat[i][j]>=left && mat[i][j]>=right;
	}

}
