package BinarySearch;

public class NthRoot {

	public static void main(String[] args) {
		
		int n=3,m=27;
		
		approachI(n, m);
		System.out.println(approachII(n,m));

	}

	private static int approachII(int n, int m) {
		
		int low=1,high=m;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			int result=multiply(mid,n,m);
			
			if(result==1)
			{
				return mid;
			}
			else if(result==0)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		
		return -1;		
	}

	private static int multiply(int mid, int n, int m) {
		
		int result=1;
		
		for(int i=1;i<=n;i++)
		{
			result=result*mid;
			
			if(result>m) return 2;
		}
		if(result==m) return 1;
		return 0;
	}

	private static void approachI(int n, int m) {
		System.out.println((int)Math.pow(m, 1.0/n));
	}
}
