package BinarySearch;

public class Sqrt {

	public static void main(String[] args) {
		
		int x=5;
		
		sqrtBrute(x);
		sqrtOptimalI(x);
		sqrtOptimalII(x);

	}

	private static void sqrtOptimalII(int x) {
		
		int low=1,high=x;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(mid*mid<=x)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}

		}

		System.out.println(high);
	}

	private static void sqrtOptimalI(int x) {
		
		System.out.println((int)Math.sqrt(x));
		
	}

	private static void sqrtBrute(int x) {
		
		int ans=0;
		
		for(int i=1;i<=x;i++)
		{
			if(i*i<=x)
			{
				ans=i;
			}
			else
			{
				break;
			}
		}
		
		System.out.println(ans);
		
	}
}
