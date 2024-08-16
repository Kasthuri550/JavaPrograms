package SlidingWindowTwoPointer;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		
		String S = "ABBA";
		int K = 2;
		
//		int maxLength=characterReplacementBrute(S,K);
		int maxLength=characterReplacementOptimal(S,K);
		System.out.println(maxLength);
	}

	private static int characterReplacementOptimal(String s, int k) {
		
		int left=0,maxCount=0,maxLength=0;
		int count[]=new int[26];
		
		for(int right=0;right<s.length();right++)
		{
			count[s.charAt(right)-'A']++;
			maxCount=Math.max(maxCount,count[s.charAt(right)-'A']);
			
			if((right-left+1)-maxCount > k)
			{
				count[s.charAt(left)-'A']--;
				left++;
			}
			maxLength=Math.max(maxLength,right-left+1);
		}
		return maxLength;
	}

	private static int characterReplacementBrute(String s, int k) {
		
		int n=s.length(),maxLength=0;
		
		
		for(int i=0;i<n;i++)
		{
			int count[]=new int[26],maxCount=0;
			for(int j=i;j<n;j++)
			{
				count[s.charAt(j)-'A']++;
				maxCount=Math.max(maxCount,count[s.charAt(j)-'A']);
				
				if((j-i+1)- maxCount <= k)
				{
					maxLength=Math.max(maxLength,j-i+1);
				}
			}
		}
		return maxLength;
	}
}
