package Recursion.hard;

/*
 * Time Complexity  : O(9^E)
 * Space Complexity : O(E)
 * 
 * Where E = number of empty cells.
 * */
public class SudokuSolver {

	public static void main(String[] args) {

		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};


		System.out.println(sudokuSolver(board));
	}

	private static boolean sudokuSolver(char[][] board) {

		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if(board[i][j]=='.')
				{
					for(char c='1';c<='9';c++)
					{
						if(isValidSudoKu(board,i,j,c))
						{
							board[i][j]=c;

							if(sudokuSolver(board))
							{
								return true;
							}
							else
							{
								board[i][j]='.';
							}
						}
					}

					return false;
				}

			}
		}

		return true;
	}

	private static boolean isValidSudoKu(char[][] board, int row, int col,char c) {

		for(char i=0;i<9;i++)
		{
			if(board[i][col]==c)
				return false;

			if(board[row][i]==c)
				return false;

			if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
				return false;
		}

		return true;
	}
}
