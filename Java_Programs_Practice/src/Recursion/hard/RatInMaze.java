package Recursion.hard;

import java.util.ArrayList;

public class RatInMaze {

	public static void main(String[] args) {

		int mat[][] = {{1, 0, 0, 0},
		                {1, 1, 0, 1}, 
		                {1, 1, 0, 0},
		                {0, 1, 1, 1}};
		
		System.out.println(ratInMazeBetter(mat));
		System.out.println(ratInMazeOptimal(mat));
	}

	private static ArrayList<String> ratInMazeOptimal(int[][] mat) {

		ArrayList<String> result=new ArrayList<String>();
		int n=mat.length;
		int visited[][]=new int[n][n];
		
		if(mat[0][0]==0 || mat[n-1][n-1]==0) return result;
		
		int di[]=new int[] {1,0,0,-1};
		int dj[]=new int[] {0,-1,1,0};
		
		solveOptimal(0,0,mat,n,result,"",visited,di,dj);
		
		return result;
	}

	private static void solveOptimal(int i, int j, int[][] mat, int n, ArrayList<String> result, String move,
			int[][] visited, int[] di, int[] dj) {

		if(i==n-1 && j==n-1)
		{
			result.add(move);
			return;
		}
		
		String dir="DLRU";
		
		for(int index=0;index<4;index++)
		{
			int nexti=i+di[index];
			int nextj=j+dj[index];
			
			if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && 
					visited[nexti][nextj]==0 && mat[nexti][nextj]==1)
			{
				visited[i][j]=1;
				solveOptimal(nexti,nextj, mat,n, result, move+dir.charAt(index), visited, di, dj);
				visited[i][j]=0;
			}
		}
		
	}

	private static ArrayList<String> ratInMazeBetter(int[][] mat) {
		
		ArrayList<String> result =new ArrayList<String>();
		int n=mat.length;
		int visited[][]=new int[n][n];
		
		if(mat[0][0]==0 || mat[n-1][n-1]==0) return result;
		
		solveBetter(0,0,mat,n,result,"",visited);		
		
		return result;
	}

	private static void solveBetter(int i, int j, int[][] mat, int n, ArrayList<String> result, String move,
			int[][] visited) {
		
		if(i==n-1 && j==n-1)
		{
			result.add(move);
			return;
		}
		
		visited[i][j]=1;

		if(i+1<n && visited[i+1][j]==0 && mat[i+1][j]==1)
		{
			solveBetter(i+1, j, mat, n, result,move+"D" , visited);
		}
		
		if(j-1>=0 && visited[i][j-1]==0 && mat[i][j-1]==1)
		{
			solveBetter(i, j-1, mat, n, result, move+"L", visited);
		}
		
		if(j+1<n && visited[i][j+1]==0 && mat[i][j+1]==1)
		{
			solveBetter(i, j+1, mat, n, result, move+"R", visited);
		}
		
		if(i-1>=0 && visited[i-1][j]==0 && mat[i-1][j]==1)
		{
			solveBetter(i-1, j, mat, n, result, move+"U", visited);
		}
		
		visited[i][j]=0;
	}
}
