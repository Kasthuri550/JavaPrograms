package Recursion.hard;

/*
 * Time Complexity: O(N!)
 * Space Complexity: O(N)
 * */
public class NQueensII {

	public static void main(String[] args) {

		int n=4;

		System.out.println(NQueensIIOptimal(n));
	}

	private static int NQueensIIOptimal(int n) {

		boolean cols[]=new boolean[n];
		boolean diag1[]=new boolean[2*n];
		boolean diag2[]=new boolean[2*n];

		return backTrack(0,n,cols,diag1,diag2);
	}

	private static int backTrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {

		if(row==n)
			return 1;

		int count=0;

		for(int col=0;col<n;col++)
		{
			int d1=row-col+n;
			int d2=row+col;

			if(cols[col] || diag1[d1] || diag2[d2])
			{
				continue;
			}

			cols[col]=diag1[d1]=diag2[d2]=true;
			count+=backTrack(row+1, n, cols, diag1, diag2);
			cols[col]=diag1[d1]=diag2[d2]=false;
		}

		return count;
	}
}
