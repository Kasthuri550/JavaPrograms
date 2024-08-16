package SlidingWindowTwoPointer;

public class NumberOfSubstringContainingAllThreeCharacters {

	public static void main(String[] args) {
		
		String s = "aaacb";
		
//		int count=countSubstringContainingAllThreeCharsBrute(s);
		
		int count=countSubstringContainingAllThreeCharsOptimal(s);
		
		System.out.println(count);

	}

	private static int countSubstringContainingAllThreeCharsOptimal(String s) {
		
		int n=s.length(),left=0,count=0;
		
		int freq[]=new int[3];
		
		for(int right=0;right<n;right++)
		{
			freq[s.charAt(right)-'a']++;
			
			while(freq[0]>0 && freq[1]>0 && freq[2]>0)
			{
				count+=n-right;
				
				freq[s.charAt(left)-'a']--;
				left++;				
			}
		}
		return count;
	}

	private static int countSubstringContainingAllThreeCharsBrute(String s) {
		
		int n=s.length(),count=0;
		
		for(int i=0;i<n;i++)
		{
			int freq[]=new int[3];
			
			for(int j=i;j<n;j++)
			{
				freq[s.charAt(j)-'a']++;
				
				if(freq[0]>0 && freq[1]>0 && freq[2]>0)
				{
					count+=n-j;
					break;
				}
			}
		}
		
		return count;
	}
}
