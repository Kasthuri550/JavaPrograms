package matrix;

import java.util.Arrays;

public class SetMatrix0s {

	public static void main(String[] args) {
		
		int matrix[][]= {{1, 1, 1},
						 {1, 0, 1},
						 {1, 1, 1}};
		int n=matrix.length,m=matrix[0].length;
//		matrix0s1(matrix,n,m);	
//		matrix0s2(matrix,n,m);
		matrix0s3(matrix,n,m);
	}

	private static void matrix0s3(int[][] matrix, int n, int m) {
		
//		matrix[0][]
//				matrix[][0]
		int col0=1;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(matrix[i][j]==0)
				{
					matrix[i][0]=0;
					
					if(j!=0)
					{
						matrix[0][j]=0;
					}
					else
					{
						col0=0;
					}
				}
			}
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<m;j++)
			{
				if(matrix[i][j]!=0)
				{
					if(matrix[0][j]==0||matrix[i][0]==0)
					{
						matrix[i][j]=0;
					}
				}
			}
		}
		
		if(matrix[0][0]==0)
		{
			for(int j=0;j<m;j++)
			{
				matrix[0][j]=0;
			}
		}
		
		if(col0==0)
		{
			for(int i=0;i<n;i++)
			{
				matrix[i][0]=0;
			}
		}
		
		System.out.println(Arrays.deepToString(matrix));
	}

	private static void matrix0s2(int[][] matrix, int n, int m) {
		
		int row[]=new int[n];
		int col[]=new int[m];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(matrix[i][j]==0)
				{
					row[i]=1;
					col[j]=1;
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++) 
			{
				if(row[i]==1 || col[j]==1)
				{
					matrix[i][j]=0;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(matrix));
	}

	private static void matrix0s1(int[][] matrix, int n, int m) {
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(matrix[i][j]==0)
				{
					markRow(matrix,i);
					markCol(matrix,j);
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(matrix[i][j]==-1)
				{
					matrix[i][j]=0;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(matrix));
	}

	private static void markCol(int[][] matrix, int j) {
		
		for(int i=0;i<matrix[0].length;i++)
		{
			if(matrix[i][j]!=0)
			{
				matrix[i][j]=-1;
			}
		}
	}

	private static void markRow(int[][] matrix, int i) {
		
		for(int j=0;j<matrix.length;j++)
		{
			if(matrix[i][j]!=0)
			{
				matrix[i][j]=-1;
			}
		}	
	}

}
