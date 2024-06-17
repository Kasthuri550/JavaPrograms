package Arrayprograms.medium;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		
		int arr[] = {6, -3, -10, 0, 2};
		maximumProductSubarrayBrute(arr);
		maximumProductSubarrayBetter(arr);
		maximumProductSubarrayOptimal(arr);
	}

	private static void maximumProductSubarrayOptimal(int[] arr) {
		
		int n=arr.length,prefix=1,suffix=1,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			if(prefix==0)
				prefix=1;
			
			if(suffix==0)
				suffix=1;
				
			prefix*=arr[i];
			suffix*=arr[n-i-1];
			max=Math.max(max,Math.max(prefix, suffix));
		}
		
		System.out.println(max);
		
	}

	private static void maximumProductSubarrayBetter(int[] arr) {
		
		int n=arr.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int prod=1;
			
			for(int j=i;j<n;j++)
			{
				prod=prod*arr[j];
				
				if(max<prod)
				{
					max=prod;
				}
			}
		}
		
		System.out.println(max);
		
	}

	private static void maximumProductSubarrayBrute(int[] arr) {
		
		int n=arr.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int prod=1;
				for(int k=i;k<=j;k++)
				{
					prod=prod*arr[k];
				}
				
				if(prod > max)
				{
					max=prod;
				}
			}
		}
		
		System.out.println(max);
		
	}
}
