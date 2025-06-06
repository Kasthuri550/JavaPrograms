package bitmanipulation.medium;

public class PowerExponentiation {

	public static void main(String[] args) {

		double b = 3.00000;
		int e = 5;

		System.out.println(powerExponentiationBrute(b,e));
		System.out.println(powerExponentiationOptimal(b, e));
	}
	/*
	 * Time Complexity: O(log n)
	 * Space Complexity: O(1)
	 * */
	private static double powerExponentiationOptimal(double x, int n) {

		double result=1.0;
		int nn=n;

		if(nn<0)
		{
			nn=-nn;
		}

		while(nn>0)
		{
			if(nn%2==1)
			{
				result=result*x;
				nn=nn-1;
			}
			else
			{
				nn=nn/2;
				x=x*x;
			}
		}

		if(n<0)
		{
			return 1.0/result;
		}

		return result;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static double powerExponentiationBrute(double b, int e) {

		double result=1;

		for(int i=0;i<e;i++)
		{
			result=result*b;
		}

		return result;
	}
}
