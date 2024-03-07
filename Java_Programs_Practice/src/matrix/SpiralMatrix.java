package matrix;

import java.util.Arrays;

public class SpiralMatrix {

	public static void main(String[] args) {
		
		int matrix[][] = { { 1, 2, 3, 4 },
			      { 5, 6, 7, 8 },
			      { 9, 10, 11, 12 },
		              { 13, 14, 15, 16 } };
		int n=matrix.length,m=matrix[0].length;
		
		int left=0,right=m-1,top=0,bottom=n-1;
		
		spiral(matrix,left,right,top,bottom,n,m);
	}

	private static void spiral(int[][] matrix, int left, int right, int top, int bottom, int n, int m) {
		
		int resultMatrix[]=new int[n*m],index=0;
		
		while(left<=right && top<=bottom)
		{
			for(int i=left;i<=right;i++)
			{
				resultMatrix[index++]=matrix[top][i];
			}
			top++;
			for(int i=top;i<=bottom;i++)
			{
				resultMatrix[index++]=matrix[i][right];
			}
			right--;
			
			if(top<=bottom)
			{
				for(int i=right;i>=left;i--)
				{
					resultMatrix[index++]=matrix[bottom][i];
				}
				
				bottom--;
			}
			
			if(left<=bottom)
			{
				for(int i=bottom;i>=top;i--)
				{
					resultMatrix[index++]=matrix[i][left];
				}
				left++;	
			}
		}
		
		System.out.println(Arrays.toString(resultMatrix));
		
	}

}
