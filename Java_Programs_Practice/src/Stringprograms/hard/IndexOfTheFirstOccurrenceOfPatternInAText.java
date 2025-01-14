package Stringprograms.hard;

public class IndexOfTheFirstOccurrenceOfPatternInAText {

	public static void main(String[] args) {
		
		String text = "gffgfg",pattern = "gfg";
		
		System.out.println(findMatchingBrute(text,pattern));
		System.out.println(findMatchingBetter(text, pattern));

	}

	private static int findMatchingBetter(String text, String pattern) {

		return text.indexOf(pattern);
	}

	private static int findMatchingBrute(String text, String pattern) {

		int n=text.length(),m=pattern.length();
		
		for(int i=0;i<=n-m;i++)
		{
			boolean match=true;
			for(int j=0;j<m;j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
				{
					match=false;
					break;
				}
			}
			
			if(match) return i;
		}
		
		return -1;
	}
}
