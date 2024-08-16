package DynamicProgramming;

public class LongestSubstringToFormAPalindrome {

	public static void main(String[] args) {
		
		String s = "vizfcfc";
		
//		System.out.println(longestSubstringToFormAPalindromeBrute(s));
//		System.out.println(longestSubstringToFormAPalindromeBetter(s));
		System.out.println(longestSubstringToFormAPalindromeOptimal(s));

	}

	private static int longestSubstringToFormAPalindromeOptimal(String s) {
		
		int n=s.length(),frequency[]=new int[26],oddCount=0,start=0,maxLength=0;
		
		for(int end=0;end<n;end++)
		{
			int endCharIndex=s.charAt(end)-'a';
			frequency[endCharIndex]++;
			
			if(frequency[endCharIndex]%2==1)
			{
				oddCount++;
			}
			else
			{
				oddCount--;
			}
			
			while(oddCount>1)
			{
				int startCharIndex=s.charAt(start)-'a';
				frequency[startCharIndex]--;
				
				if(frequency[startCharIndex]%2==1)
				{
					oddCount++;
				}
				else
				{
					oddCount--;
				}
				start++;
			}
			
			maxLength=Math.max(maxLength,end-start+1);
		}
		return maxLength;
	}

	private static int longestSubstringToFormAPalindromeBetter(String s) {
		
		int n=s.length(),maxLength=0;
		
		for(int i=0;i<n;i++)
		{
			int frequency[]=new int[26];
			for(int j=i;j<n;j++)
			{
				frequency[s.charAt(j)-'a']++;
				
				if(canFormPalindromeBetter(frequency))
				{
					maxLength=Math.max(maxLength,j-i+1);
				}
			}
		}
		return maxLength;
	}

	private static boolean canFormPalindromeBetter(int[] frequency) {
		
		int oddCount=0;
		
		for(int value:frequency)
		{
			if(value%2==1)
				oddCount++;
		}
		
		return oddCount<=1;
	}

	private static int longestSubstringToFormAPalindromeBrute(String s) {
		
		int n=s.length(),maxLength=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				if(canFormPalindrome(s.substring(i,j+1)))
				{
					maxLength=Math.max(maxLength, j-i+1);
				}
			}
		}
		
		return maxLength;
	}

	private static boolean canFormPalindrome(String str) {

		int freq[]=new int[26],oddCount=0;
		
		for(int i=0;i<str.length();i++)
		{
			freq[str.charAt(i)-'a']++;
		}
		
		for(int value:freq)
		{
			if(value%2==1)
			{
				oddCount++;
			}
		}
		return oddCount<=1;
	}
}
