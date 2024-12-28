package stack.hard;

import java.util.Stack;

public class TheCelebrityProblem {

	public static void main(String[] args) {

		int mat[][] = {{0,1,0}, {0,0,0}, {0,1,0}};

		System.out.println(theCelebrityProblemBrute(mat));
		System.out.println(theCelebrityProblemBetter(mat));
		System.out.println(theCelebrityProblemOptimal(mat));
		System.out.println(theCelebrityProblemUsingStack(mat));

	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */	
	private static int theCelebrityProblemUsingStack(int[][] mat) {

		int n=mat.length;

		Stack<Integer> stack=new Stack<>();

		for(int i=0;i<n;i++)
		{
			stack.push(i);
		}

		while(stack.size()>1)
		{
			int a=stack.pop(),b=stack.pop();

			if(mat[a][b]==1)
			{
				stack.push(b);
			}
			else
			{
				stack.push(a);
			}
		}

		int candidate=stack.pop();

		for(int i=0;i<n;i++)
		{
			if(i!=candidate && (mat[candidate][i]==1 || mat[i][candidate]==0))
			{
				return -1;
			}
		}

		return candidate;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */	
	private static int theCelebrityProblemOptimal(int[][] mat) {

		int n=mat.length,candidate=0;

		for(int i=1;i<n;i++)
		{
			if(mat[candidate][i]==1)
			{
				candidate=i;
			}
		}

		for(int i=0;i<n;i++)
		{
			if(i!=candidate && (mat[candidate][i]==1 || mat[i][candidate]==0))
			{
				return -1;
			}
		}


		return candidate;
	}

	/*
	 * Time Complexity: O(n*n)
	 * Space Complexity: O(2n)
	 */
	private static int theCelebrityProblemBetter(int[][] mat) {

		int n=mat[0].length;

		int iKnow[]=new int[n];
		int knowMe[]=new int[n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(mat[i][j]==1)
				{
					iKnow[i]++;
					knowMe[j]++;
				}
			}
		}

		for(int i=0;i<n;i++)
		{
			if(iKnow[i]==0 && knowMe[i]==n-1)
			{
				return i;
			}
		}

		return -1;
	}

	/*
	 * Time Complexity: O(n*n)
	 * Space Complexity: O(1)
	 */	
	private static int theCelebrityProblemBrute(int[][] mat) {

		int m=mat.length,n=mat[0].length;

		for(int i=0;i<m;i++)
		{
			boolean isCelebrity=true;
			for(int j=0;j<n;j++)
			{
				if(i!=j)
				{
					if(mat[i][j]==1 || mat[j][i]==0)
					{
						isCelebrity=false;
						break;
					}
				}
			}

			if(isCelebrity) return i;
		}

		return -1;
	}
}
