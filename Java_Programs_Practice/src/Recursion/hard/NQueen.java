package Recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

	public static void main(String[] args) {
		
		int N=4;
		
		System.out.println(nQueenBetter(N));
		System.out.println(nQueenOptimal(N));

	}

	private static List<List<String>> nQueenOptimal(int n) {
		
		List<List<String>> ans=new ArrayList<List<String>>();
		char board[][]=new char[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j]='.';
			}
		}
		
		int leftRow[]=new int[n];
		int upperDiagonal[]=new int[2*n-1];
		int lowerDiagonal[]=new int[2*n-1];
		
		optimalSolver(0,board,ans,leftRow,upperDiagonal,lowerDiagonal,n);
		
		return ans;
	}

	private static void optimalSolver(int col, char[][] board, List<List<String>> ans, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal,
			int n) {

		if(col==n)
		{
			ans.add(optimalConstruct(board,n));
			return;
		}
		
		for(int row=0;row<n;row++)
		{
			if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0)
			{
				board[row][col]='Q';
				leftRow[row]=1;
				lowerDiagonal[row+col]=1;
				upperDiagonal[n-1+col-row]=1;
				optimalSolver(col+1, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);
				board[row][col]='.';
				leftRow[row]=0;
				lowerDiagonal[row+col]=0;
				upperDiagonal[n-1+col-row]=0;
			}
		}
	}

	private static List<String> optimalConstruct(char[][] board, int n) {

		List<String> res=new ArrayList<String>();
		
		for(int i=0;i<n;i++)
		{
			String row=new String(board[i]);
			res.add(row);
		}
		
		return res;
	}

	private static List<List<String>> nQueenBetter(int n) {
		
		List<List<String>> ans=new ArrayList<>();
		
		char board[][]=new char[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j]='.';
			}
		}
		
		solve(0,board,ans,n);		
		
		return ans;
	}

	private static void solve(int col, char[][] board, List<List<String>> ans, int n) {
		
		if(col==n)
		{
			ans.add(construct(n,board));
			return;
		}
		
		for(int row=0;row<n;row++)
		{
			if(isSafe(row,col,board,n))
			{
				board[row][col]='Q';
				solve(col+1, board, ans, n);
				board[row][col]='.';
			}
		}
		
	}

	private static boolean isSafe(int row, int col, char[][] board, int n) {
		
		int dupRow=row,dupCol=col;
		
		while(row>=0 && col>=0)
		{
			if(board[row][col]=='Q') return false;
			row--;
			col--;
		}
		
		row=dupRow;
		col=dupCol;
		
		while(col>=0)
		{
			if(board[row][col]=='Q') return false;
			col--;
		}
		
		row=dupRow;
		col=dupCol;
		
		while(row<n && col>=0)
		{
			if(board[row][col]=='Q') return false;
			row++;
			col--;
		}
		
		return true;
	}

	private static List<String> construct(int n, char[][] board) {

		List<String> res=new ArrayList<String>();
		
		for(int i=0;i<n;i++)
		{
			String row=new String(board[i]);
			res.add(row);
		}
		
		return res;
	}
}
