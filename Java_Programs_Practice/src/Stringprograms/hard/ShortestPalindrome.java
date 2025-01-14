package Stringprograms.hard;

public class ShortestPalindrome {

	public static void main(String[] args) {

		String s="aacecaaaa";

		System.out.println(shortestPalindromeBrute(s));
		System.out.println(shortestPalindromeOptimal(s));
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 */
	private static String shortestPalindromeBrute(String s) {

		int n=s.length();

		for(int i=n-1;i>=0;i--)
		{
			String prefix=s.substring(0,i);
			if(isPalindrome(prefix))
			{
				String suffix=s.substring(i);
				StringBuilder suffixReversed=new StringBuilder(suffix).reverse();
				return suffixReversed.append(s).toString();
			}
		}
		return s;
	}

	private static boolean isPalindrome(String prefix) {

		int left=0,right=prefix.length()-1;

		while(left<right)
		{
			if(prefix.charAt(left)!=prefix.charAt(right))
			{
				return false;
			}
			left++;
			right--;
		}

		return true;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private static String shortestPalindromeOptimal(String s) {

		String reversed=new StringBuilder(s).reverse().toString();
		String combined=s+"*"+reversed;

		int lps[]=new int[combined.length()];

		buildLPS(combined,lps);

		int addTo=s.length()-lps[combined.length()-1];

		String shortestPalindrome=reversed.substring(0,addTo)+s;

		return shortestPalindrome;
	}

	private static void buildLPS(String str,int lps[]) {

		int n=str.length(),i=0,j=1;

		while(j<n)
		{
			if(str.charAt(i)==str.charAt(j))
			{
				i++;
				lps[j]=i;
				j++;
			}
			else if(j<n && str.charAt(i)!=str.charAt(j))
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
