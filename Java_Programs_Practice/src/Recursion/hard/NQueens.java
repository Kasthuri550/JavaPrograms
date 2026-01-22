package Recursion.hard;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(N!*N)
 * Space Complexity: O(N^2+N)
 * */
public class NQueens {

	public static void main(String[] args) {

		int n = 4;

		System.out.println(solveNQueens(n));
	}

	private static List<List<String>> solveNQueens(int n) {

		List<List<String>> result=new ArrayList<>();
		char board[][]=new char[n][n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j]='.';
			}
		}

		backTrack(0,board,result,n);

		return result;
	}

	private static void backTrack(int row, char[][] board, List<List<String>> result, int n) {

		if(row==n)
		{
			result.add(constructBoard(board));
		}

		for(int col=0;col<n;col++)
		{
			if(isSafe(row,col,board,n))
			{
				board[row][col]='Q';
				backTrack(row+1, board, result, n);
				board[row][col]='.';
			}
		}
	}

	private static boolean isSafe(int row, int col, char[][] board, int n) {

		for(int i=0;i<row;i++)
		{
			if(board[i][col]=='Q')
				return false;
		}

		for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
		{
			if(board[i][j]=='Q')
				return false;
		}

		for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
		{
			if(board[i][j]=='Q')
				return false;
		}

		return true;
	}

	private static List<String> constructBoard(char[][] board) {

		List<String> list=new ArrayList<>();

		for(char row[]:board)
		{
			list.add(new String(row));
		}

		return list;
	}
}
