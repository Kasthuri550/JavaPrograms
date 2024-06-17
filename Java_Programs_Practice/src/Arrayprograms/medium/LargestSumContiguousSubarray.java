package Arrayprograms.medium;

public class LargestSumContiguousSubarray {
	
	public static void main(String[] args) {
		
//		int arr[] = {1,2,3,-2,5};
		int arr[] = {-1,-2,-3,-4};
		
//		maximumSubarrayBrute(arr);
//		maximumSubarrayBetter(arr);
//		maximumSubarrayOptimal(arr);
		printMaximumSubarrayOptimal(arr);
			
	}

	private static void printMaximumSubarrayOptimal(int[] arr) {
		
		int n=arr.length,sum=0,max=Integer.MIN_VALUE,start=-1,ansStart=-1,ansEnd=-1;
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			
			if(sum==0)
				start=i;
			
			if(max<sum)
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
		
		System.out.println(max);
		System.out.println(ansStart+", "+ansEnd);
		
	}

	private static void maximumSubarrayOptimal(int[] arr) {
		
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

	private static void maximumSubarrayBetter(int[] arr) {
		
		int n=arr.length,max=Integer.MIN_VALUE,start=-1,end=-1;
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=arr[j];
				
				if(sum>max)
				{
					max=sum;
					start=i;
					end=j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(start+", "+end);
		
	}

	private static void maximumSubarrayBrute(int[] arr) {
		
		int n=arr.length,max=Integer.MIN_VALUE,start=-1,end=-1;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum+=arr[k];
				}
				
				if(max<sum)
				{
					max=sum;
					start=i;
					end=j;
				}
			}
		}
		System.out.println(start+", "+end);
		System.out.println(max);
		
	}
}
