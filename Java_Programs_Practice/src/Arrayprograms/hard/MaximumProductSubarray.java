package Arrayprograms.hard;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		
		int nums[] = {1,2,-3,0,-4,-5};
		int n=nums.length;
		
		maximumProductBrute(nums,n);
		maximumProductBetter(nums,n);
		maximumProductOptimal(nums,n);
	}

	private static void maximumProductOptimal(int[] nums, int n) {
		
		int prefix=1,suffix=1,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			if(prefix==0)  prefix=1;
		    if(suffix==0)  suffix=1;
		    
		    prefix=prefix*nums[i];
		    suffix=suffix*nums[n-i-1];
		    max=Math.max(max,Math.max(prefix, suffix));
		}
		
		System.out.println(max);
	}

	private static void maximumProductBetter(int[] nums, int n) {
		
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int product=1;
			
			for(int j=i;j<n;j++)
			{
				product=product*nums[j];
				max=Math.max(max,product);
			}
		}
		
		System.out.println(max);
	}

	private static void maximumProductBrute(int[] nums, int n) {
		
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int product=1;
				
				for(int k=i;k<=j;k++)
				{
					product=product*nums[k];
				}
				max=Math.max(max,product);
			}
		}
		
		System.out.println(max);
	}
}
