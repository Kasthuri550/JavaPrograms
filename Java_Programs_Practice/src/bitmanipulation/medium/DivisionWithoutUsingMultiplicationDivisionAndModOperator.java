package bitmanipulation.medium;

public class DivisionWithoutUsingMultiplicationDivisionAndModOperator {

	public static void main(String[] args) {

		int dividend = 10, divisor= 3;

		System.out.println(divisionWithoutUsingMultiplicationDivisionAndModOperatorBrute(dividend,divisor));
		System.out.println(divisionWithoutUsingMultiplicationDivisionAndModOperatorOptimal(dividend,divisor));
	}
	/*
	 * Time Complexity: O(log n)^2
	 * Space Complexity: O(1)
	 * */
	private static long divisionWithoutUsingMultiplicationDivisionAndModOperatorOptimal(int dividend, int divisor) {

		if(dividend==divisor)
			return 1;

		boolean sign=true;

		if(dividend>=0 && divisor<0)
			sign=false;

		if(dividend<0 && divisor>=0)
			sign=false;

		long n=Math.abs(dividend),d=Math.abs(divisor),quotient=0;

		while(n>=d)
		{
			int count=0;

			while(n>=(d<<(count+1)))
			{
				count++;
			}

			quotient+=1<<count;
			n=n-(d<<count);
		}

		quotient=sign?quotient:-quotient;

		if(quotient<Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		if(quotient>Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		return quotient;
	}
	/*
	 * Time Complexity: O(dividend)
	 * Space Complexity: O(1)
	 * */
	private static int divisionWithoutUsingMultiplicationDivisionAndModOperatorBrute(int dividend, int divisor) {

		int sum=0,count=0;

		while(sum+divisor<=dividend)
		{
			count++;
			sum=sum+divisor;
		}


		return count;
	}
}
