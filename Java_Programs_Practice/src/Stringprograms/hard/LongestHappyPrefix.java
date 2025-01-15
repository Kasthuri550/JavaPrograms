package Stringprograms.hard;

public class LongestHappyPrefix {

	public static void main(String[] args) {

		String s = "aabcdaabc";

		System.out.println(longestHappyPrefixBrute(s));
		System.out.println(longestHappyPrefixOptimal(s));

	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 */
	private static int longestHappyPrefixBrute(String s) {

		int n=s.length();

		for(int i=n-1;i>0;i--)
		{
			String s1=s.substring(0,i);
			String s2=s.substring(n-i);

			if(s1.equals(s2))
			{
				return s1.length();
			}
		}

		return -1;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private static int longestHappyPrefixOptimal(String s) {

		int n=s.length();

		int lps[]=new int[n];

		buildLPS(s,lps);

		System.out.println(s.substring(0,lps[n-1]));

		return lps[n-1];
	}

	private static void buildLPS(String s,int lps[]) 
	{
		int i=0,j=1,n=s.length();

		while(j<n)
		{
			if(s.charAt(i)==s.charAt(j))
			{
				i++;
				lps[j]=i;
				j++;
			}
			else
			{
				if(i!=0)
				{
					i=lps[i-1];
				}
				else
				{
					lps[j]=0;
					j++;
				}
			}
		}

	}
}
