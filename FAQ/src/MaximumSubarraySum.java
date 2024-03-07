
public class MaximumSubarraySum {

	public static void main(String[] args) {
		
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
//		System.out.println("Maximum contiguous sum is "
//                + maxSubArraySum1(a));
//		System.out.println("Maximum contiguous sum is "
//                + maxSubArraySum2(a));
//		System.out.println("Maximum contiguous sum is "
//                + maxSubArraySum3(a));
		System.out.println("Maximum contiguous sum is "
                + maxSubArraySum4(a));
	}


	//brute force - TC -O(N^3) AND SC - O(1)
	private static int maxSubArraySum1(int[] a) {
		
		int n=a.length,max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum+=a[k];
				}
				
				max=Math.max(sum,max);
			}
		}
		return max;
		
	}

	//better solution -  TC -O(N^2) AND SC - O(1)
	private static int maxSubArraySum2(int[] a) {
		
		int n=a.length,max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=a[j];
				max=Math.max(sum,max);
			}
		}
		return max;
	}
	
//	optimal kadane's algorithm TC- O(n) and SC - o(1)
	private static long maxSubArraySum3(int[] a) {
		
		int n=a.length,sum=0;
		long max=Long.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			sum+=a[i];
			
			if(max<sum)
			{
				max=sum;
			}
			
			if(sum<0)
			{
				sum=0;
			}
		}
		return max<0 ? 0:max;
	}
	
	private static long maxSubArraySum4(int[] a) {
		
		int n=a.length,start = 0,ansStart = 0,ansEnd = 0;
		long sum=0,max=Long.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			if(sum==0)
				start=i;
			
			sum+=a[i];
			
			if(sum>max)
			{
				max=sum;
			    ansStart = start;
				ansEnd=i;
			}
			
			if(sum<0)
			{
				sum=0;
			}
						
		}
		System.out.println("Starting index: "+ansStart);
		System.out.println("Ending index: "+ansEnd);
		
		return max;
	}
}
