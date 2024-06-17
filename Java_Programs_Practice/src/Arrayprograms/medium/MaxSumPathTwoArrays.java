package Arrayprograms.medium;

public class MaxSumPathTwoArrays {

	public static void main(String[] args) {
		
		int M = 5, N = 4;
		int A[] = {2,3,7,10,12},B[] = {1,5,7,8};
		
		maxSumPath(A,B,M,N);
	}

	private static void maxSumPath(int[] a, int[] b, int m, int n) {
		
		int i=0,j=0,sumA=0,sumB=0,result=0;
		
		while(i<m && j<n)
		{
			if(a[i]<b[j])
			{
				sumA+=a[i];
				i++;
			}
			else if(a[i]>b[j])
			{
				sumB+=b[j];
				j++;
			}
			else
			{
				result+=Math.max(sumA, sumB)+a[i];
				sumA=0;
				sumB=0;
				i++;
				j++;
			}
		}
		
		while(i<m)
		{
			sumA+=a[i];
			i++;
		}
		
		while(j<n)
		{
			sumB+=b[j];
			j++;
		}
		
		result+=Math.max(sumA, sumB);
		
		System.out.println(result);
	}
}
