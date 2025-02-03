package Graph.medium;

import java.util.Arrays;

/*
 * Time Complexity: O(N)+O(M)+O(N*M*4) ~ O(N*M)
 * Space Complexity: O(N*M)
 * */
public class SurroundedRegions {

	public static void main(String[] args) {

		char mat[][] = 
			{{'X', 'X', 'X', 'X'}, 
					{'X', 'O', 'X', 'X'}, 
					{'X', 'O', 'O', 'X'}, 
					{'X', 'O', 'X', 'X'}, 
					{'X', 'X', 'O', 'O'}};

		surroundedRegions(mat);

		printMatrix(mat);

	}

	private static void printMatrix(char[][] matrix) {

		for(char mat[]:matrix)
		{
			System.out.println(Arrays.toString(mat));
		}
	}

	private static void surroundedRegions(char[][] mat) {

		int m=mat.length,n=mat[0].length;
		int visited[][]=new int[m][n];

		int delRow[]= {0,0,1,-1};
		int delCol[]= {1,-1,0,0};

		for(int j=0;j<n;j++)
		{
			if(visited[0][j]==0 && mat[0][j]=='O')
			{
				dfs(0,j,visited,mat,m,n,delRow,delCol);
			}

			if(visited[m-1][j]==0 && mat[m-1][j]=='O')
			{
				dfs(m-1,j,visited,mat,m,n,delRow,delCol);
			}
		}

		for(int i=0;i<m;i++)
		{
			if(visited[i][0]==0 && mat[i][0]=='O')
			{
				dfs(i,0,visited,mat,m,n,delRow,delCol);
			}

			if(visited[i][n-1]==0 && mat[i][n-1]=='O')
			{
				dfs(i,n-1,visited,mat,m,n,delRow,delCol);
			}
		}

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(visited[i][j]==0 && mat[i][j]=='O')
				{
					mat[i][j]='X';
				}
			}
		}
	}

	private static void dfs(int row, int col, int[][] visited, char[][] mat,int m,int n,int[] delRow, int[] delCol) {

		visited[row][col]=1;

		for(int i=0;i<4;i++)
		{
			int nRow=row+delRow[i];
			int nCol=col+delCol[i];

			if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && visited[nRow][nCol]==0 && mat[nRow][nCol]=='O')
			{
				dfs(nRow,nCol,visited,mat,m,n,delRow,delCol);
			}
		}
	}
}
