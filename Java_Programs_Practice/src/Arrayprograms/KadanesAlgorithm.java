package Arrayprograms;

import java.util.Arrays;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		
		int a[] = {1, 2, 5, -7, 2, 3};
		
		System.out.println(maximumSubarraySum1(a,a.length));
		System.out.println(maximumSubarraySum2(a,a.length));
		System.out.println(maximumSubarraySum3(a,a.length));
		System.out.println(Arrays.toString(maximumSubarraySum4(a,a.length)));
	}

	private static int[] maximumSubarraySum4(int[] a, int n) {
		
		int max=Integer.MIN_VALUE,sum=0,start=0,ansStart=-1,ansEnd=-1;
		for(int i=0;i<n;i++)
		{
			sum+=a[i];
			
			if(sum<0)
				sum=0;
			
			if(sum==0)
			{
				start=i;
			}
			if(max<sum)
			{
				max=sum;
				ansStart=start;
				ansEnd=i;
			}
		}
		return new int[] {ansStart,ansEnd};
	}

	private static int maximumSubarraySum3(int[] a, int n) {
		
		int sum=0,max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			sum+=a[i];
			
			if(sum<0)
				sum=0;
			
			if(max<sum)
			{
				max=sum;
			}
		}
		return max;
	}

	private static int maximumSubarraySum2(int[] a, int n) {
		
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=a[j];
				max=Math.max(max,sum);
			}
		}
		return max;
	}

	private static int maximumSubarraySum1(int[] a,int n) {
		
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<j;k++)
				{
					sum+=a[k];
				}
				max=Math.max(max,sum);
			}
		}
		
		return max;		
	}
}
