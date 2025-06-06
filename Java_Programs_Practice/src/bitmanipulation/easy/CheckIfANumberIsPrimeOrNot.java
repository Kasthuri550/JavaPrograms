package bitmanipulation.easy;

public class CheckIfANumberIsPrimeOrNot {

	public static void main(String[] args) {

		int n=10;

		System.out.println(checkIfANumberIsPrimeOrNotApproach1(n));
		System.out.println(checkIfANumberIsPrimeOrNotApproach2(n));
		System.out.println(checkIfANumberIsPrimeOrNotApproach3(n));
	}
	/*
	 * Time Complexity: O(sqrt(n))
	 * Space Complexity: O(1)
	 * */
	private static boolean checkIfANumberIsPrimeOrNotApproach3(int n) {

		if(n<=1)
			return false;

		int count=0;

		for(int i=1;i*i<=n;i++)
		{
			if(n%i==0)
			{
				count++;

				if(n/i!=i)
					count++;
			}

			if(count>2)
				break;
		}

		return count==2;
	}
	/*
	 * Time Complexity: O(sqrt(n))
	 * Space Complexity: O(1)
	 * */
	private static boolean checkIfANumberIsPrimeOrNotApproach2(int n) {

		if(n<=1)
			return false;

		int count=0;

		for(int i=1;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				count++;

				if(n/i!=i)
					count++;
			}

			if(count>2)
				break;
		}

		return count==2;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static boolean checkIfANumberIsPrimeOrNotApproach1(int n) {

		if(n<=1)
			return false;

		int count=0;

		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				count++;
			}
		}

		return count==2;
	}
}
