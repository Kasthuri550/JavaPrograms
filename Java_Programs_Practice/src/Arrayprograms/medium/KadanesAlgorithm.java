package Arrayprograms.medium;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		
		 int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
		 
		 maximumSubarraySumBrute(arr);
		 maximumSubarraySumBetter(arr);
		 maximumSubarraySumOptimal(arr);
		 printMaximumSubarraySum(arr);

	}

	private static void printMaximumSubarraySum(int[] arr) {
		
		int n=arr.length,sum=0,max=Integer.MIN_VALUE,start=0,ansStart=-1,ansEnd=-1;
		
		for(int i=0;i<n;i++)
		{
			if(sum==0)
			{
				start=i;
			}
			sum+=arr[i];
			
			if(sum>max)
			{
				max=sum;
				ansStart=start;
				ansEnd=i;
			}
			
			if(sum<0)
			{
				sum=0;
			}
		}
		
		System.out.println("["+ansStart+","+ansEnd+"]");
	}

	private static void maximumSubarraySumOptimal(int[] arr) {
		
		int n=arr.length,sum=0,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			
			if(sum>max)
			{
				max=sum;
			}
			
			if(sum<0)
			{
				sum=0;
			}
		}
		
		System.out.println(max);
	}

	private static void maximumSubarraySumBetter(int[] arr) {
		
		int n=arr.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=arr[j];
				max=Math.max(max, sum);
			}
		}
		
		System.out.println(max);
		
	}

	private static void maximumSubarraySumBrute(int[] arr) {
		
		int n=arr.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum+=arr[k];
				}
				max=Math.max(max, sum);
			}
		}
		
		System.out.println(max);
		
	}
}
