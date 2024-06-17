package Stringprograms.medium;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		
		String s = "babad";
		
		System.out.println(longestPalindromic(s));

	}

	private static String longestPalindromic(String s) {
		
		int n=s.length(),start=0,end=0;
		
		for(int i=0;i<n-1;i++)
		{
			int oddLengthString=expandAroundCenter(s,i,i);
			int evenLengthString=expandAroundCenter(s,i,i+1);
			
			int len=Math.max(oddLengthString, evenLengthString);
			
			if(len>end-start+1)
			{
				start=i-(len-1)/2;
				end=i+len/2;
			}
		}
		
		return s.substring(start,end+1);
		
	}

	private static int expandAroundCenter(String s, int left, int right) {
		
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
		{
			left--;
			right++;
		}
		return right-left-1;
	}
}
