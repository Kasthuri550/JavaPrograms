package matrix;

public class RowWithMax1s {

	public static void main(String[] args) {

		int N = 4 , M = 4;
		int Arr[][] = {{0, 1, 1, 1},
						{0, 0, 1, 1},
						{1, 1, 1, 1},
						{0, 0, 0, 0}};
		System.out.println(max1s(Arr,N,M));
	}

	private static int max1s(int[][] arr, int n, int m) {
		
		int i=0,j=m-1;
		int max=-1;
		
		while(i<n && j>=0)
		{
			if(arr[i][j]==1)
			{
				max=i;
				j--;
			}
			else
			{
				i++;
			}
		}
		
		return max;
		
	}

}
