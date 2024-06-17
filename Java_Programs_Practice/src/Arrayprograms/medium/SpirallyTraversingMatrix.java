package Arrayprograms.medium;

import java.util.ArrayList;

public class SpirallyTraversingMatrix {

	public static void main(String[] args) {

		int matrix[][] = {{1, 2, 3, 4},
		           {5, 6, 7, 8},
		           {9, 10, 11, 12},
		           {13, 14, 15,16}};
		
		spiralTraversingMatrix(matrix);
	}

	private static void spiralTraversingMatrix(int[][] matrix) {
		
		int n=matrix.length,m=matrix[0].length,top=0,bottom=n-1,left=0,right=m-1;
		
		ArrayList<Integer> resultList=new ArrayList<>();
		
		while(top<=bottom && left<=right)
		{
			for(int i=left;i<=right;i++)
			{
				resultList.add(matrix[top][i]);
			}
			top++;
			
			for(int i=top;i<=bottom;i++)
			{
				resultList.add(matrix[i][right]);
			}
			right--;
			if(top<=bottom)
			{
				for(int i=right;i>=left;i--)
				{
					resultList.add(matrix[bottom][i]);
				}
				
				bottom--;
			}
			
			for(int i=bottom;i>=top;i--)
			{
				resultList.add(matrix[i][left]);
			}
			left++;
		}
		
		System.out.println(resultList);
		
	}
}
