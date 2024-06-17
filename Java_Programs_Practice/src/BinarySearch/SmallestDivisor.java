package BinarySearch;

public class SmallestDivisor {

	public static void main(String[] args) {
		
		int A[] = {1, 2, 5, 9},k=6;
		
		System.out.println(smallestDivisorBrute(A,k));
		System.out.println(smallestDivisorOptimal(A,k));

	}

	private static int smallestDivisorOptimal(int[] a, int k) {
		
		int n=a.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			max=Integer.max(max, a[i]);
		}
		
		int low=1,high=max;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(sumDivisor(a,mid)<=k)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		return low;
	}

	private static int sumDivisor(int[] a, int mid) {
		
		int sum=0;
		
		for(int i=0;i<a.length;i++)
		{
			sum+=Math.ceil((double)a[i]/(double)mid);
		}
		return sum;
	}

	private static int smallestDivisorBrute(int[] a, int k) {
		
		int n=a.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			max=Math.max(max,a[i]);
		}
		
		for(int d=1;d<max;d++)
		{
			int sum=0;
			for(int i=0;i<n;i++)
			{
				sum+=Math.ceil((double)(a[i])/(double)(d));
			}
			
			if(sum<=k)
			{
				return d;
			}
		}
		
		return -1;
	}
}
