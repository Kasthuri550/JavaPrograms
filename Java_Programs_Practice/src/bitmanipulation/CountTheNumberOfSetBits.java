package bitmanipulation;

public class CountTheNumberOfSetBits {

	public static void main(String[] args) {

		int n=13;

		System.out.println(countTheNumberOfSetBitsBrute1(n));
		System.out.println(countTheNumberOfSetBitsBrute2(n));
		System.out.println(countTheNumberOfSetBitsOptimal(n));
	}
	/*
	 * Time Complexity: O(k)
	 * Space Complexity: O(1)
	 * */
	private static int countTheNumberOfSetBitsOptimal(int n) {

		int count=0;

		while(n!=0)
		{
			n=n&(n-1);
			count++;
		}

		return count;
	}
	/*
	 * Time Complexity: O(log n)
	 * Space Complexity: O(1)
	 * */
	private static int countTheNumberOfSetBitsBrute2(int n) {

		int count=0;

		while(n>1)
		{
			if((n & 1) == 1)
				count++;

			n=n>>1;
		}

		if(n==1)
			count++;

		return count;
	}
	/*
	 * Time Complexity: O(log n)
	 * Space Complexity: O(1)
	 * */
	private static int countTheNumberOfSetBitsBrute1(int n) {

		int count=0;

		while(n>1)
		{
			if(n%2==1)
				count++;

			n=n/2;
		}

		if(n==1)
			count++;

		return count;
	}
}
