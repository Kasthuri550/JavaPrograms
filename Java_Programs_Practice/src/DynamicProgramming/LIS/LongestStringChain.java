package DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestStringChain {

	public static void main(String[] args) {

		int n = 6;
		String words[] = {"a","b","ba","bca","bda","bdca"};

		System.out.println(longestStringChain(n,words));

	}
	/*
	 * Time Complexity: O(n^2 * L)
	 * Space Complexity: O(n)
	 * */
	private static int longestStringChain(int n, String[] words) {

		int dp[]=new int[n],max=1;

		Arrays.fill(dp,1);

		Arrays.sort(words,(s1,s2)-> s1.length()-s2.length());
		
		System.out.println(Arrays.toString(words));

		for(int index=0;index<n;index++)
		{
			for(int prevIndex=0;prevIndex<index;prevIndex++)
			{
				if(checkPossible(words[index],words[prevIndex]) && 1+dp[prevIndex]>dp[index])
				{
					dp[index]=1+dp[prevIndex];
				}
			}

			if (dp[index] > max) {

				max = dp[index];

			}
		}

		return max;
	}

	private static boolean checkPossible(String string1, String string2) {

		if(string1.length()!=string2.length()+1) return false;

		int first=0,second=0;

		while(first<string1.length())
		{
			if(second < string2.length() && string1.charAt(first)==string2.charAt(second))
			{
				first++;
				second++;
			}
			else
			{
				first++;
			}
		}

		return first==string1.length() && second==string2.length();
	}
}
