package BinarySearch;

public class Search2DMatrix {

	public static void main(String[] args) {
		
		int N = 3, M = 3;
		int	mat[][] = {{3, 30,38},
				       {44, 52, 54}, 
				       {57,60, 69}};
		int X = 69;
		
		System.out.println(searchMatrixBrute(mat,N,M,X));
		System.out.println(searchMatrixBetter(mat, N, M, X));
		System.out.println(searchMatrixOptimal(mat,N,M,X));

	}

	private static boolean searchMatrixOptimal(int[][] mat, int n, int m, int target) {
		
		int left=0,right=m-1;
		
		while(left<n && right>=0)
		{
			if(mat[left][right]==target)
				return true;
			else if(mat[left][right]<target)
				left++;
			else
				right--;				
		}
		
		return false;
	}

	private static boolean searchMatrixBetter(int[][] mat, int n, int m, int target) {
		
		for(int i=0;i<n;i++)
		{
			if(mat[i][0]<=target && target<=mat[i][m-1])
			{
				return binarySearch(mat[i],n,m,target);
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] mat, int n, int m, int target) {
		
		int low=0,high=n-1;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(mat[mid]==target)
				return true;
			else if(mat[mid]<target)
				low=mid+1;
			else
				high=mid-1;				
		}
		return false;
	}

	private static boolean searchMatrixBrute(int[][] mat, int n, int m, int x) {
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mat[i][j]==x) return true;
			}
		}
		return false;
	}
	
	
}
