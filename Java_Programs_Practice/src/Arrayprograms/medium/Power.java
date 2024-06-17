package Arrayprograms.medium;

public class Power {

	public static void main(String[] args) {
		
		double x = 2.00000;
		int n = 10;
		
		System.out.println(powerXN(x,n));

	}

	private static double powerXN(double x, int n) {
		
		long nn=n;
		double ans=1.0;
		
		if(nn<0)
			nn=-1*nn;
		
		while(nn>0)
		{
			if(nn%2==1)
			{
				ans=ans*x;
				nn=nn-1;
			}
			else
			{
				x=x*x;
				nn=nn/2;
			}
		}
		
		if(n<0)
		{
			ans=(double)1.0/(double)ans;
		}
		
		return ans;
	}
}
