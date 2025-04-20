package bitmanipulation;

public class DecimalToBinary {

	public static void main(String[] args) {

		int n=13;

		System.out.println(decimalToBinary(n));
	}
	/*
	 * Time Complexity: O(logn)
	 * Space Complexity: O(logn)
	 * */
	private static String decimalToBinary(int n) {

		if(n==0) return "0";

		StringBuilder result=new StringBuilder();

		while(n>0)
		{
			result.append(n%2);

			n=n/2;
		}

		return result.reverse().toString();
	}
}
