package bitmanipulation.medium;

public class MinimumBitFlipsToConvertNumber {

	public static void main(String[] args) {

		int a = 10, b = 20;


		System.out.println(minimumBitFlipsToConvertNumberApproach1(a,b));
		System.out.println(minimumBitFlipsToConvertNumberApproach2(a,b));
		System.out.println(minimumBitFlipsToConvertNumberApproach3(a, b));
	}
	/*
	 * Time Complexity: O(log (a^b))
	 * Space Complexity: O(1)
	 * */
	private static int minimumBitFlipsToConvertNumberApproach3(int a, int b) {

		int xor=a^b;

		int count=0;

		while(xor!=0)
		{
			xor&=(xor-1);

			count++;
		}

		return count;
	}
	/*
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * */
	private static int minimumBitFlipsToConvertNumberApproach2(int a, int b) {

		return Integer.bitCount(a^b);
	}

	/*
	 * Time Complexity: O(31)
	 * Space Complexity: O(1)
	 * */	
	private static int minimumBitFlipsToConvertNumberApproach1(int a,int b) {

		int count=0;

		int ans=a^b;

		for(int i=0;i<31;i++)
		{
			if((ans & (1<<i)) != 0)
			{
				count++;
			}
		}

		return count;
	}
}
