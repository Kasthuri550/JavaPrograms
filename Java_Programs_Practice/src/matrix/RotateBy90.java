package matrix;

public class RotateBy90 {

	public static void main(String[] args) {

		int N = 3;
		int matrix[][] = {{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};
//		rotation1(matrix,N);
		rotation2(matrix,N);
	}

	private static void rotation2(int[][] matrix, int n) {

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<n;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-i-1][j];
				matrix[n-i-1][j]=temp;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void rotation1(int[][] matrix, int n) {

		int arr[][]=new int[n][n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				arr[i][j]=matrix[j][n-i-1];
			}
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				matrix[i][j]=arr[i][j];
			}
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

	}
}
