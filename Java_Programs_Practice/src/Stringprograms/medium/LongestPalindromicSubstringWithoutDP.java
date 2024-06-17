package Stringprograms.medium;

public class LongestPalindromicSubstringWithoutDP {

	public static void main(String[] args) {
		
		String s="abaccabe";
		
		String longestPalindromicSubstring = longestPalindromicSubstring(s);
		System.out.println(longestPalindromicSubstring);

	}

	private static String longestPalindromicSubstring(String s) {
		
		if(s==null || s.length()<=0) return s;
		
		int start=0,end=0;
		
		for(int i=0;i<s.length();i++)
		{
			int oddLength=expandCenterOddEven(s,i,i);
			int evenLength=expandCenterOddEven(s,i,i+1);
			
			int maxLength=Math.max(oddLength, evenLength);
			
			if(maxLength>end-start)
			{
				start=i-(maxLength-1)/2;
				end=i+maxLength/2;
			}
		}
		return s.substring(start,end+1);
	}

	private static int expandCenterOddEven(String s, int left, int right) {
		
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
		{
			left--;
			right++;
		}
		return right-left-1;
	}
}
