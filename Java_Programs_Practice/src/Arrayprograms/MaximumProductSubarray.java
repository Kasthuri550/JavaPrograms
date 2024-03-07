package Arrayprograms;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		
		int arr[] = { 2,3,0,-2,4 };
		
//		approach1(arr);
//		approach2(arr);
		approach3(arr);

	}

	private static void approach3(int[] arr) {
		
		int n=arr.length;
		int prefix=1,suffix=1;
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			if(prefix==0)
			{
				prefix=1;
			}
			if(suffix==0)
			{
				suffix=1;
			}
			
			prefix=prefix*arr[i];
			suffix=suffix*arr[n-i-1];
			max=Math.max(max,Math.max(prefix, suffix));
		}
		
		System.out.println(max);
		
	}

	private static void approach2(int[] arr) {
		
		int n=arr.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int product=1;
			for(int j=i;j<n;j++)
			{
				product*=arr[j];
				max=Math.max(max,product);
			}
		}
		
		System.out.println(max);
		
	}

	private static void approach1(int[] arr) {
		
		int n=arr.length;
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int product=1;
				for(int k=i;k<=j;k++)
				{
					product*=arr[k];
				}
				max=Math.max(max, product);
			}
		}
		
		System.out.println(max);
		
	}

}
