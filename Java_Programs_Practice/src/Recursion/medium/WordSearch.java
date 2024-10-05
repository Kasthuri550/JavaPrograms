package Recursion.medium;

public class WordSearch {

	public static void main(String[] args) {

		char board[][] = {{'a','g','b','c'},{'q','e','e','l'},{'g','b','k','s'}};
		String word = "geeks";

		System.out.println(wordSearch(board,word));

	}

	private static boolean wordSearch(char[][] board, String word) {

		int rows=board.length,cols=board[0].length;

		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(word.charAt(0)== board[i][j])
				{
					if(dfs(board,word,i,j,0))
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	private static boolean dfs(char[][] board, String word, int i, int j, int index) {

		if(index==word.length())
		{
			return true;
		}

		if(i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(index)!=board[i][j])
		{
			return false;
		}

		char temp=board[i][j];
		board[i][j]='#';

		boolean found=dfs(board, word, i+1, j, index+1)||
				dfs(board, word, i-1, j, index+1)||
				dfs(board, word, i, j-1, index+1)||
				dfs(board, word, i, j+1, index+1);

		board[i][j]=temp;

		return found;
	}
}