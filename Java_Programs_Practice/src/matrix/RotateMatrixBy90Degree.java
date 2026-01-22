package matrix;

import java.util.Arrays;

public class RotateMatrixBy90Degree {

	public static void main(String[] args) {

		int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		rotateMatrixBrute(arr);
		rotateMatrixOptimal(arr);
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static void rotateMatrixOptimal(int[][] arr) {

		int n=arr.length,m=arr[0].length;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<m;j++)
			{
				int temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}
		System.out.println("Transpose "+Arrays.deepToString(arr));
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				int temp=arr[i][j];
				arr[i][j]=arr[i][n-j-1];
				arr[i][n-j-1]=temp;
			}
		}

		System.out.println(Arrays.deepToString(arr));	
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n^2)
	 * */
	private static void rotateMatrixBrute(int[][] arr) {

		int n=arr.length,m=arr[0].length;

		int rotated[][]=new int[n][m];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				rotated[j][n-i-1]=arr[i][j];
			}
		}

		System.out.println(Arrays.deepToString(rotated));	
	}
}
