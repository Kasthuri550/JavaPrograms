package Graph.hard;

import java.util.Arrays;

//Time Complexity: O(V³)
//Space Complexity: O(V²)
public class FloydWarshalAlgorithm {

	public static void main(String[] args) {

		int mat[][] = {{0, 1, 43},{1, 0, 6},{1, -1, 0}};

		floydWarshal(mat);

	}

	private static void floydWarshal(int[][] mat) {

		int n=mat.length;

		final int INF=(int)1e9;

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(mat[i][j]==-1)
				{
					mat[i][j]=INF;
				}

				if(i==j)
				{
					mat[i][j]=0;
				}
			}
		}

		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
				}
			}
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(mat[i][j]==INF)
				{
					mat[i][j]=-1;
				}
			}
		}

		System.out.println(Arrays.deepToString(mat));
	}
}
