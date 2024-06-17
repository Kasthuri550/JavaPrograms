package Stringprograms.medium;

public class SumBeautySubstrings {

	public static void main(String[] args) {
		
		String s = "aabcb";
		
		sumBeauty(s);

	}

	private static void sumBeauty(String s) {
		
		int n=s.length();
		int frequency[],beauty=0;
		
		for(int i=0;i<n;i++)
		{
			frequency=new int[26];
			
			for(int j=i;j<n;j++)
			{
				frequency[s.charAt(j)-'a']++;
				
				int minFrequency=Integer.MAX_VALUE,maxFrequency=Integer.MIN_VALUE;
				
				for(int freqChar:frequency)
				{
					if(freqChar>0)
					{
						minFrequency=Math.min(minFrequency, freqChar);
						maxFrequency=Math.max(maxFrequency, freqChar);
					}
				}
				
				beauty+=maxFrequency-minFrequency;				
			}
		}
		
		System.out.println(beauty);
		
	}
}
