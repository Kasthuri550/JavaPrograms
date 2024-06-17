package Stringprograms.medium;

public class LargestOddNumberString {

	public static void main(String[] args) {
		
		String num = "52";
		
		System.out.println(largestOddNumberBrute(num));
		System.out.println(largestOddNumberOptimal(num));

	}

	private static String largestOddNumberOptimal(String num) {
		
		for(int i=num.length()-1;i>=0;i--)
		{
			if((num.charAt(i)&1)==1)
			{
				return num.substring(0,i+1);
			}
		}
		return "";
	}

	private static String largestOddNumberBrute(String num) {
		
		int n=num.length();
		String largestSubstring="";
		
		for(int i=0;i<n;i++)
		{
			char c=num.charAt(i);
			if((c-'0')%2!=0)
			{
				int j=i;
				
				while(j<n && (num.charAt(j)-'0')%2!=0) j++;
				
				String oddSubstring=num.substring(i,j);
				
				if(oddSubstring.length()>largestSubstring.length())
				{
					largestSubstring=oddSubstring;
				}
					
			}
		}
		
		return largestSubstring;
		
	}
}
