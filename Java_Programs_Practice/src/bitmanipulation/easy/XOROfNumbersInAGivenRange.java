package bitmanipulation.easy;

public class XOROfNumbersInAGivenRange {

	public static void main(String[] args) {

		int L = 4, R = 8;

		System.out.println(xOROfNumbersInAGivenRangeBrute(L,R));
		System.out.println(xOROfNumbersInAGivenRangeOptimal(L,R));
	}
	/*
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * */	
	private static int xOROfNumbersInAGivenRangeOptimal(int l, int r) {

		int result=xorOfNumbers(l-1)^xorOfNumbers(r);

		return result;
	}
	private static int xorOfNumbers(int n) {

		if(n%4==1)
			return 1;
		else if(n%4==2)
			return n+1;
		else if(n%4==3)
			return 0;
		else 
			return n;
	}
	/*
	 * Time Complexity: O(r-l+1)
	 * Space Complexity: O(1)
	 * */
	private static int xOROfNumbersInAGivenRangeBrute(int l, int r) {

		int xor=0;

		for(int i=l;i<=r;i++)
		{
			xor=xor^i;
		}

		return xor;		
	}
}
