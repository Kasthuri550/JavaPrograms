
public class MaximumProductSubarray {

	public static void main(String[] args) {
		
		int N = 5;
		long Arr[] = {6, -3, -10, 0, 2};
		
		approach1(Arr,N);
		approach2(Arr,N);
		approach3(Arr,N);
		approach4(Arr,N);

	}

	private static void approach1(long[] arr, int n) {
		
		long max=Long.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				long product=1;
				for(int k=i;k<=j;k++)
				{
					product*=arr[k];
				}
				
				max=Math.max(max,product);
			}
		}
		
		
		System.out.println(max);
		
	}

	private static void approach2(long[] arr, int n) {
		
		long max=Long.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			long product=1;
			for(int j=i;j<n;j++)
			{
				product*=arr[j];
				max=Math.max(max, product);
			}
		}
		
		System.out.println(max);
		
	}
	
	private static void approach3(long[] arr, int n) {
		
		long max=Long.MIN_VALUE;
		long product=1;
		
		for(int i=0;i<n;i++)
		{
			product*=arr[i];
			if(max<product)
			{
				max=product;
			}
			
		}
		
		System.out.println(max);
		
	}
	
	private static void approach4(long[] arr, int n) {
		
		long max=Long.MIN_VALUE;
		long prefix=1,suffix=1;
		
		for(int i=0;i<n;i++)
		{
			if(prefix==0)
				prefix=1;
			if(suffix==0)
				suffix=1;
			prefix=prefix*arr[i];
			suffix=suffix*arr[n-i-1];
			max=Math.max(max,Math.max(prefix,suffix));
		}
		
		System.out.println(max);
	}
}
