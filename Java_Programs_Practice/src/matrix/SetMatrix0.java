package matrix;

import java.util.Arrays;

public class SetMatrix0 {

	public static void main(String[] args) {
		
		int matrix[][]= {{1, 1, 1},
				 {1, 0, 1},
				 {1, 1, 1}};
		
//		setMatrix0Brute(matrix);
//		setMatrix0Better(matrix);
		setMatrix0Optimal(matrix);

	}

	private static void setMatrix0Optimal(int[][] matrix) {
		
		int n=matrix.length,m=matrix[0].length,col0=1;
		
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
				if(matrix[0][j]==0 || matrix[i][0]==0)
				{
					matrix[i][j]=0;
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

	private static void setMatrix0Better(int[][] matrix) {
		
		int n=matrix.length,m=matrix[0].length;
		
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
				if(row[i]==1|| col[j]==1)
				{
					matrix[i][j]=0;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(matrix));
	}

	private static void setMatrix0Brute(int[][] matrix) {
		
		int n=matrix.length,m=matrix[0].length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(matrix[i][j]==0)
				{
					markRow(matrix,m,i);
					markCol(matrix,n,j);
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

	private static void markCol(int[][] matrix, int n, int j) {
		
		for(int i=0;i<n;i++)
		{
			if(matrix[i][j]!=0)
			{
				matrix[i][j]=-1;
			}
		}
		
	}

	private static void markRow(int[][] matrix, int m, int i) {
		
		for(int j=0;j<m;j++)
		{
			if(matrix[i][j]!=0)
			{
				matrix[i][j]=-1;
			}
		}
	}
}
