package Basicmaths;

/*
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * */
public class PowerExponentiation {

	public static void main(String[] args) {

		System.out.println(myPow(2.00000,10));
	}

	public static double myPow(double x, int n) {

		long nn=n;

		if(nn<0)
		{
			x=1/x;
			nn=-nn;
		}

		double ans=1.0;

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

		return ans;       
	}

}
