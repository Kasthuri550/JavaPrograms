import java.math.BigInteger;
import java.util.Arrays;

public class Closest3Sum {

	public static void main(String[] args) {
		
		int N = 6;
		int	A[] = {-1, 0, 1, 2, -1,-4};
		int	X = 4;
		int sum3closest = approach1(A,N,X);
		System.out.println(sum3closest);

	}

	private static int approach1(int[] a, int n, int x) {

		int sum,min=Integer.MAX_VALUE,threeSum = 0;
		Arrays.parallelSort(a);
		for(int i=0;i<n;i++)
		{
			int left=i+1;
			int right=n-1;
			
			while(left<right)
			{
				sum=a[i]+a[left]+a[right];
				
				if(sum<x)
				{
					left++;
				}
				else if(sum>x)
				{
					right--;
				}
				else
				{
					return sum;
				}
				if(Math.abs(x-sum)<min)
				{
					min=Math.abs(x-sum);
					threeSum=sum;
				}
			}
		}
		
		return threeSum;
		
	}

}
