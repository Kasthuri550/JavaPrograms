package BinarySearch;

public class RowWithMax1s {

	public static void main(String[] args) {
		
		int arr[][] = {{0, 1, 1, 1},
		           {0, 0, 1, 1},
		           {1, 1, 1, 1},
		           {0, 0, 0, 0}};
		
//		rowWithMax1sBrute(arr);
//		rowWithMax1sBetter(arr);
		rowWithMax1sOptimal(arr);
	}

	private static void rowWithMax1sOptimal(int[][] arr) {
		
		int n=arr.length,m=arr[0].length,i=0,j=m-1,index=-1;
		
		while(i<n && j>=0)
		{
			if(arr[i][j]==1)
			{
				index=i;
				j--;
			}
			else
			{
				i++;
			}
		}
		
		System.out.println(index);
		
	}

	private static void rowWithMax1sBetter(int[][] arr) {
		
		int n=arr.length,m=arr[0].length,countOnes=0,countOnesMax=0,index=-1;
		
		for(int i=0;i<n;i++)
		{
			countOnes=m-lowerBound(arr[i],m,1);
			
			if(countOnesMax<countOnes)
			{
				countOnesMax=countOnes;
				index=i;
			}
		}
		
		System.out.println(index);
		
	}

	private static int lowerBound(int[] arr, int m, int x) {
		
		int low=0,high=m-1,ans=m;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(arr[mid]>=x)
			{
				ans=mid;
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		
		return ans;
	}

	private static void rowWithMax1sBrute(int[][] arr) {
		
		int n=arr.length,m=arr[0].length,countOnesMax=0,index=-1;
		
		for(int i=0;i<n;i++)
		{
			int countOnes=0;
			for(int j=0;j<m;j++)
			{
				countOnes+=arr[i][j];
			}
			
			if(countOnes>countOnesMax)
			{
				countOnesMax=countOnes;
				index=i;
			}
		}
		
		System.out.println(index);
	}
}
