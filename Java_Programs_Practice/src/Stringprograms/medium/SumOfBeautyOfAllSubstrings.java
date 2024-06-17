package Stringprograms.medium;

public class SumOfBeautyOfAllSubstrings {

	public static void main(String[] args) {
		
		String s = "aabcbaa";
		
		beautySubstring(s);

	}

	private static void beautySubstring(String s) {
		
		int n=s.length(),frequency[]=new int[26],beauty=0;
		
		for(int i=0;i<n;i++)
		{
			frequency=new int[26];
			
			for(int j=i;j<n;j++)
			{
				frequency[s.charAt(j)-'a']++;
				
				int maxFrequency=Integer.MIN_VALUE,minFrequency=Integer.MAX_VALUE;
				
				for(int freq:frequency)
				{
					if(freq>0)
					{
						maxFrequency=Math.max(maxFrequency,freq);
						minFrequency=Math.min(minFrequency, freq);
					}
				}
				
				beauty+=maxFrequency-minFrequency;
			}
		}
		
		System.out.println(beauty);
		
	}
}
