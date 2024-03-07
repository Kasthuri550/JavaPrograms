package matrix;

public class SearchElement {

	public static void main(String[] args) {

		int N = 3, M = 3;
		int	mat[][] = {{3,30,38},
				{44,52,54},
				{57,60,69}};
		int X = 38;

		System.out.println(search1(mat,N,M,X));
		System.out.println(search2(mat,N,M,X));
		System.out.println(search3(mat,N,M,X));
	}

	private static int search3(int[][] mat, int N, int M, int X) {
		
		int i=0,j=M-1,flag=0;
		
		while(i<N && j>=0)
		{
			if(mat[i][j]==X)
			{
				flag=1;
				break;
			}
			else if(mat[i][j]<X)
			{
				i++;
			}
			else
			{
				j--;
			}
		}
		
		return flag;
	}

	//	O(nlogn)
	private static int search2(int[][] mat, int N, int M, int X) {

		int flag=0;

		for(int i=0;i<N;i++)
		{
			int low=0,high=M-1;
			while(low<=high)
			{
				int mid=low+(high-low)/2;

				if(mat[i][mid]==X)
				{
					flag=1;
					break;
				}
				else if(mat[i][mid]<X)
				{
					low=mid+1;
				}
				else
				{
					high=mid-1;
				}
			}
		}

		return flag;
	}

	//	O(n^2)
	private static int search1(int[][] mat, int N, int M, int X) {

		int flag=0;

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(mat[i][j]==X)
				{
					flag=1;
					break;
				}
			}
		}	

		return flag;
	}
}
